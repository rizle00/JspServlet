package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usertbl.UserTblDAO;
import usertbl.UserTblDTO;


// name, urlpatterns ... 추천  x
//*.user, *.do, ... 주의 : /를 빼야함.
@WebServlet(name = "usertbl", urlPatterns = {"/list", "/detail", "/update"})
public class UserTblController extends HttpServlet {
	RequestDispatcher rd;
	UserTblDAO dao = new UserTblDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		System.out.println(req.getServletPath());
//		System.out.println(req.getRequestURI());
		
		if(req.getServletPath().equals("/list")) {
			
//			dao.openConnection()
//			System.out.println(dao.selectList().size());
			ArrayList<UserTblDTO> list =  dao.selectList();
			req.setAttribute("list", list);//${akakak}
			
			 rd = req.getRequestDispatcher("usertbl/list.jsp");
			
		} else if (req.getServletPath().equals("/detail")) {
			UserTblDTO dto = dao.selectOne(req.getParameter("name"));
			req.setAttribute("dto", dto);
			rd = req.getRequestDispatcher("usertbl/detail.jsp");
//			System.out.println(dto.getUsername());
//			System.out.println(req.getParameter("name"));
//			rd = req.getRequestDispatcher("usertbl/detail.jsp");
//			rd.forward(req, resp);
		} else if (req.getServletPath().equals("/update")) {
			
			UserTblDTO dto = new UserTblDTO();
			dto.setUsername(req.getParameter("username"));
			dto.setAddress(req.getParameter("address"));
			dto.setBirthday(Integer.parseInt(req.getParameter("birthday")));
			dto.setMobile(req.getParameter("mobile"));
			dao.update(dto.getUsername(), dto.getAddress(), dto.getBirthday(), dto.getMobile());
			
		}
		rd.forward(req, resp);

		
	}
}
