package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberService;
import member.MemberVO;

@WebServlet("*.me")
public class MemberController extends HttpServlet {
	RequestDispatcher rd;
	MemberService service;
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			if(req.getServletPath().equals("/loginpage.me")) {
				rd = req.getRequestDispatcher("member/login.jsp");
				rd.forward(req, resp);
			} else if (req.getServletPath().equals("/login.me")) {
//				"1","success" -> login.jsp
//				jacksonDatabinding (true) Spring
				
				service = new MemberDAO();// A 개발자
				MemberVO vo = new MemberVO();
				vo.setUser_id(req.getParameter("user_id"));
				vo.setUser_pw(req.getParameter("user_pw"));
				
				vo = service.member_login(vo);
				req.getSession().setAttribute("logininfo", vo);
				
				String result = req.getSession().getAttribute("logininfo") == null ? "-1" : "1";
				
				resp.getWriter().print(result);
				
//				resp.getWriter().print("response!!"+vo.getUser_id()+ " "+ vo.getEmail() ); // 응답 로그인으로 값을 다시 보냄
			} else if (req.getServletPath().equals("/logout.me")) {
				
				req.getSession().removeAttribute("logininfo");
				resp.sendRedirect("/mvc");
			} else if (req.getServletPath().equals("/joinpage.me")) {
				rd = req.getRequestDispatcher("member/join.jsp");
				rd.forward(req, resp);
			}
			
			
		}
}
