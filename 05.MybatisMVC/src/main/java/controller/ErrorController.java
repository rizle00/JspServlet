package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorController
 */
@WebServlet("*.er")
public class ErrorController extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("에러");
		//Integer code =(Integer) req.getAttribute("javax.servlet.error.status_code");
		//System.out.println(code); ->현재 페이지 분기를 "web.xml"을 이용해서 처리하면 좋음
		
		if(req.getServletPath().equals("/404.er")) {
			rd = req.getRequestDispatcher("error/404.jsp");
			
		} else if(req.getServletPath().equals("/500.er")) {
			rd = req.getRequestDispatcher("error/500.jsp");
		}
		rd.forward(req, resp);
		
	}
}
