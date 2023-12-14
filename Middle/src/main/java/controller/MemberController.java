package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberService;
import member.MemberVO;
@WebServlet("*.me")
public class MemberController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberService service = new MemberDAO();
	if(req.getServletPath().equals("/login.me")) {
		System.out.println(req.getParameter("user_id"));
		System.out.println(req.getParameter("user_pw"));
		MemberVO vo = new MemberVO();
		vo.setUser_id(req.getParameter("user_id"));
		vo.setUser_pw(req.getParameter("user_pw"));
		vo = service.member_login(vo);


		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pw());
		System.out.println(vo.getName());
	}
	}
}
