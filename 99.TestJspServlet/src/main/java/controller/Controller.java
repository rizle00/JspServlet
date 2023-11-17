package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kmj.DAO;
import kmj.DTO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name = "kmj", urlPatterns = {"/list", "/update", "/insert", "/newpage", "/delete", "/updatefail","/detail"} )
public class Controller extends HttpServlet {
	DAO dao = new DAO();
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if(req.getServletPath().equals("/list")) {
			ArrayList<DTO> list =  dao.selectList();
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher("kmj/list.jsp");
			
		} else if(req.getServletPath().equals("/insert")) {
			
			rd = req.getRequestDispatcher("kmj/insert.jsp");
			
		} else if(req.getServletPath().equals("/newpage")) {
			DTO dto = new DTO();
			dto.setUsername(req.getParameter("username"));
			dto.setAddress(req.getParameter("address"));
			dto.setBirthyear(Integer.parseInt(req.getParameter("birthyear")));
			dto.setMobile(req.getParameter("mobile"));
			dao.insert(dto);
			resp.sendRedirect("list");
			return;
			
		} else if(req.getServletPath().equals("/detail")) {
			
			DTO dto = dao.selectOne(req.getParameter("username"),req.getParameter("key"));
			 req.setAttribute("dto", dto);
			 if(dto.getUsername()==null) {
				 rd = req.getRequestDispatcher("kmj/updatefail.jsp");
			 } else {
				 rd = req.getRequestDispatcher("kmj/detail.jsp");
			 }
		}
		
		else if(req.getServletPath().equals("/update")) {
				DTO dto = new DTO();
				 System.out.println(req.getParameter("idx"));
				 	dto.setIdx(Integer.parseInt(req.getParameter("idx")));
				 	dto.setUsername(req.getParameter("username"));
					dto.setAddress(req.getParameter("address"));
					dto.setBirthyear(Integer.parseInt(req.getParameter("birthyear")));
					dto.setMobile(req.getParameter("mobile"));
				dao.update(dto);
				resp.sendRedirect("list");
				return;
		}
		
		else if(req.getServletPath().equals("/delete")) {
			ArrayList<DTO> list =  dao.selectList();
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher("kmj/delete.jsp");
			if(0<dao.delete(req.getParameter("username"))) {
				
				resp.sendRedirect("list");
				return;
			}
			
		}
		rd.forward(req, resp);
		
	}
}
