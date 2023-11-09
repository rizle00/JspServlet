package pack01._url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03")
public class Ex03_Servlet extends HttpServlet {
	//Request (요청), Response(응답)
	//요청: 크롬창에 어떤 URL을 넣어놓고 Enter Key, Form 태그가 제출(submit) 또는 a태그가 href로 url을 바꿀때 등...
	//HttpServeletRequest :요청정보 모두 있음
	// 응답 : response를 이용해서 어떤 문자열을 html형태로 출력하거나 응답처리
	//HttpServeletResponse : 응답 관련 기능.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청이 들어옴. Request");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("id"));
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1> Hello Get!! </h1>");
		writer.println("</body>");
		writer.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if("admin".equals(request.getParameter("id")) && "admin1234".equals(request.getParameter("pw"))) {
			//null.equals 널 포인터익셉션
			// "".equals -> 오류발생 x
			
			
			System.out.println("로그인 성공");
		}else {
			System.out.println("fail");
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.getParameterValues("id");
//		request.getParameterValues("pw");
	}

}
