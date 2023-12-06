package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeController extends HttpServlet {
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			RequestScope(요청 범위)
//			URL로 어떤 맵핑을 요청받음 -> JSP페이지 요청시 데이터를 전달 (setAttribute, getAttribute)
//		Controller -> reqScope -> JSP
//		 Model을 통해서 데이터를 페이지에 보내주기 위함.
		req.setAttribute("request", "REQ_DATA");
		
//		Session Scope(세션 범위)
//		HttpSession 객체를 이용, 세션이 시작되고 브라우저가 종료될 때 까지 데이터가 유지가 되는 범위
//		전역적인 상태정보(로그인 정보)
		HttpSession session = req.getSession();
		session.setAttribute("session", "SESSION_DATA");
		rd = req.getRequestDispatcher("scope/list.jsp");
		rd.forward(req, resp);
//		ApplicationScope(애플리케이션 범위)
//		웹 애플리케이션 실행되는 동안에 데이터가 유지
//		모든 사용자 및 세션에 걸쳐 데이터를 공유해야할 때.(버전정보, 로그인)
	}
	
}
