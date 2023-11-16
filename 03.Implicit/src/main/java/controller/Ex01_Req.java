package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01_req")
public class Ex01_Req extends HttpServlet {
	//doGet && doPost : 각각 get요청과 post요청을 처리하기 위한 메소드
	//doGet + dpPost : 모든 요청의 처리를 함 (메소드 상관x)
	//Controller : 요청에 대한 통제 (페이지로 재요청 후 응답, 데이터로 할지 등등을 ) : 종업원
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("request/ex01req.jsp");
		
		rd.forward(req, resp);
		System.out.println("Service까지 옮");
	}
}
