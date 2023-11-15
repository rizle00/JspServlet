package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02")
public class Ex02_Req extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ex02 까지 옮");
		//DAO, JDBC 이용 로그인 확인 => Model
		//req ( form 태그 , a 태그 등으로 들어오는 파라메터를 가지고 있다 ) getParameter <- String
		
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		if("admin".equals(email)&&"admin1234".equals(pw)) {
			rd = req.getRequestDispatcher("request/ex03req.jsp");
//			rd.forward(req, resp);
		}else {
			 rd = req.getRequestDispatcher("request/ex02req.jsp");
			
		}
		ArrayList<String> list =  new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		req.setAttribute("list", list);
		 req.setAttribute("key", "data");
		rd.forward(req, resp);
	}
}
