package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//정확한 구분자를 통해 해당 구분자로 끝나는 모든 요청을 받게 만드는게 가능함.
//String 으로 하나의 문자열을 url 맵핑으로 쓰는 경우 "/list"
//String 배열을 이용하여 .. @WebServlet (name = "usertbl", "urlPatterns = {"/list","...",....}
//"/"를 제외하고 -> *.te
//insert.te , list.te, update.te, .....
@WebServlet("*.kmj")
public class TestController extends HttpServlet {
	
//	1.@WebServlet( 프로젝트 내에서 어떤 주소값(문자열)로 페이지 처리를 분기하기위한것 url 맵핑 )
//	ex)a태그 또는 폼태그 등으로 프로젝트경로 뒤에 문자열이 바뀌면 요청을 받기위함.
//
//	2.RequestDispatcher 서블릿에서 다른 페이지 등으로 요청을 넘기기 위한 객체. ( forward )
//	※ rd = req.getRequestDispatcher("다음파일경로"); , url이 안바뀜 
//
//	request.setAttribte , getAttribute vs getparameter
//	attribute는 서블릿에서 다른 페이지로 요청을 넘길 때 필요한 데이터가 있다면 담기 위한 그릇
//	jsp에서는 getAttribute로 서블릿이 준 데이터를 받아서 표현함 ( EL , jstl ) -> EL ( ${EL} , jstl + foreach..)
//	getparameter는 url로 요청 시 페이지에서 폼이나 url로 (a) get or post로 서블릿에 데이터를 담아주는것
//
//	sendRedirect : url을 바꿔서 다시 servlet에서 응답을 하기 위한 메소드
	
	RequestDispatcher rd;// 서블릿에서 다시 페이지로 요청을 넘길 때 사용됨.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("여기까지 Servlet");
		if(req.getServletPath().equals("/list.kmj")) {
			rd = req.getRequestDispatcher("kmj/list.jsp");
			req.setAttribute("data", "servletData");
			req.setAttribute("data2", "1234");
		}else if(req.getServletPath().equals("/new.kmj")) {
			rd = req.getRequestDispatcher("test/list.jsp");
		} else	if(req.getServletPath().equals("/insert.kmj")) {
				 System.out.println(req.getParameter("num1"));
				 System.out.println(req.getParameter("num2"));
				 System.out.println("인서트 처리 "+ req.getParameter("id"));
				 req.setAttribute("id", req.getParameter("num1")+1);
				 req.setAttribute("pw", req.getParameter("pw"));
				 rd = req.getRequestDispatcher("test/update.jsp");
				} else	if(req.getServletPath().equals("/delete.kmj")) {
					System.out.println("여기까지"+req.getParameter("deleteid"));
					resp.sendRedirect("list.kmj");
					return;
				} else{
			resp.getWriter().println("오류");
		}
		
		rd.forward(req, resp);
	}
}
