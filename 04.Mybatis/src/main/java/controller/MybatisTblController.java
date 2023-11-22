package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.MybatisTblDAO;
import mybatis.MybatisTblVO;

@WebServlet("*.mytbl")
public class MybatisTblController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MybatisTblDAO dao = new MybatisTblDAO();
		MybatisTblVO vo = new MybatisTblVO();
		String path = req.getServletPath();
		if(path.equals("/insert.mytbl")) {
			vo.setCol1(req.getParameter("col1"));
			vo.setCol2(req.getParameter("col2"));
			vo.setCol3(req.getParameter("col3"));
			System.out.println(dao.insert(vo)); 
			resp.sendRedirect("select.mytbl");
		} else if (path.equals("/update.mytbl")) {
			
			vo.setCol1(req.getParameter("col1"));
			vo.setCol2(req.getParameter("col2"));
			vo.setCol3(req.getParameter("col3"));
			System.out.println(dao.update(vo));
			resp.sendRedirect("select.mytbl");
		}else if (path.equals("/delete.mytbl")) {
			vo.setCol1(req.getParameter("col1"));
			vo.setCol2(req.getParameter("col2"));
			vo.setCol3(req.getParameter("col3"));
			System.out.println(dao.delete(vo));
			resp.sendRedirect("select.mytbl");
		}else if (path.equals("/select.mytbl")) {
			List<MybatisTblVO> list = dao.select();
			System.out.println(list.size());
			RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
			req.setAttribute("list", list);
			rd.forward(req, resp);
			
		}
	}
}
