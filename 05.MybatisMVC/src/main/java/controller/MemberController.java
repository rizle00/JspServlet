package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberVO;

@WebServlet("*.me")
public class MemberController extends HttpServlet {
	RequestDispatcher rd;
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			if(req.getServletPath().equals("/loginpage.me")) {
				rd = req.getRequestDispatcher("member/login.jsp");
				rd.forward(req, resp);
			} else if (req.getServletPath().equals("/login.me")) {
				MemberVO vo = new MemberVO();
				vo.setUser_id(req.getParameter("user_id"));
				vo.setUser_pw(req.getParameter("user_pw"));
				resp.getWriter().print("response!!"+vo.getUser_id()+ " "+ vo.getUser_pw() );
			}
			
			
		}
}
