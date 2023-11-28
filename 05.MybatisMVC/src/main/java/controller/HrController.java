package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.HrDAO;

@WebServlet("*.hr")
public class HrController extends HttpServlet {
	RequestDispatcher rd;
	HrDAO dao = new HrDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath().replace("/", "");
		
		if(path.equals("list.hr")) {
			rd = req.getRequestDispatcher("hr/list.jsp");
			req.setAttribute("list", dao.select());
			rd.forward(req, resp);
		}
		
	}
}
