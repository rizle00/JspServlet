package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.jstl")
public class JstlController extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath().replace("/","");
		if(path.equals("list.jstl")) {
			rd = req.getRequestDispatcher("jstl/list.jsp");
			rd.forward(req, resp);
		}
		
	}
}
