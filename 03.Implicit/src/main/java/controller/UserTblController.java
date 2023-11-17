package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usertbl.UserTblDAO;
import usertbl.UserTblDTO;


// name, urlpatterns ... 추천  x
//*.user, *.do, ... 주의 : /를 빼야함.
@WebServlet (name = "usertbl", urlPatterns = {"/list", "/detail", "/update", "/delete", "/newpage", "/resister"})
public class UserTblController extends HttpServlet {
	RequestDispatcher rd;
	UserTblDAO dao = new UserTblDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		Request (Forward) : Servlet이 받은 요청을 다시 다른 (Servlet, Jsp...등)에 전달
//		실제로는 새로운 요청을 하지 않고, 원래 요청에 대한 처리를 받은 서블릿이나 Jsp등에서 새로운 자원으로 제어를 넘김.(setAttribute)
//		웹 브라우저는 이 전환을 인지하지 못하여, URL이 바뀌지 않음(실제 파일 경로가 안보임)
		
//		Response (Redirect) : 웹 브라우저에게 새로운 URL로 이동하라는 명령을 전달
//		웹 브라우저는 새로운 URL로 새로운 요청(Request)을 보내고, 서버는 이 요청에 응답함.
//		사용자가 실제로 다른 페이지로 이동하여, "주소표시줄의 URL이 변경됨"
//		System.out.println(req.getServletPath());
//		System.out.println(req.getRequestURI());
		
		if(req.getServletPath().equals("/list")) {
			
//			dao.openConnection()
//			System.out.println(dao.selectList().size());
			ArrayList<UserTblDTO> list =  dao.selectList();
			req.setAttribute("list", list);//${akakak}
			
			 rd = req.getRequestDispatcher("usertbl/list.jsp");
			
		} else if (req.getServletPath().equals("/detail")) {
			rd = req.getRequestDispatcher("usertbl/detail.jsp");
			UserTblDTO dto = dao.selectOne(req.getParameter("name"));
			req.setAttribute("dto", dto);
//			System.out.println(dto.getUsername());
//			System.out.println(req.getParameter("name"));
//			rd = req.getRequestDispatcher("usertbl/detail.jsp");
//			rd.forward(req, resp);
		} else if (req.getServletPath().equals("/update")) {
			rd = req.getRequestDispatcher("usertbl/update.jsp");
			UserTblDTO dto = new UserTblDTO();
			dto.setUsername(req.getParameter("username"));
			dto.setAddress(req.getParameter("address"));
			dto.setBirthday(Integer.parseInt(req.getParameter("birthyear")));
			dto.setMobile(req.getParameter("mobile"));
			dao.update(dto.getUsername(), dto.getAddress(), dto.getBirthday(), dto.getMobile());
			
//			resp.sendRedirect("detail?username="+dto.getUsername());
			resp.sendRedirect("list");
			return;
//			요청에 대한 처리가 끝나고 코드가 있다면 오류가 발생함.
			
		} else if(req.getServletPath().equals("/delete")) {
			String username = req.getParameter("username");
			dao.delete(username);
			resp.sendRedirect("list");
			return;
		} else if(req.getServletPath().equals("/newpage")) {
			rd = req.getRequestDispatcher("usertbl/newpage.jsp");
//			resp.sendRedirect("newpage");
			
			
		} else if(req.getServletPath().equals("/resister")) {
			UserTblDTO dto = new UserTblDTO();
			dto.setUsername(req.getParameter("username"));
			dto.setAddress(req.getParameter("address"));
			dto.setBirthday(Integer.parseInt(req.getParameter("birthyear")));
			dto.setMobile(req.getParameter("mobile"));
			dao.insert(dto);
			resp.sendRedirect("list");
			return;
		}
		rd.forward(req, resp);

		
	}
}
