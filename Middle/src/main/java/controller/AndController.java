package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet("*.and")
public class AndController extends HttpServlet {
	
//	기존 : 요청(크롬) -> request.forward ( 페이지 응답 ) -> View(크롬 jsp)
//	현 : 요청(안드, 크롬, 플랫폼) ->"데이터"로 컨트롤러가 바로 응답처리 (resp)
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("안드에서 요청을 했는지??");
		System.out.println(req.getParameter("andParam"));
		
		MiddleVO vo = new Gson().fromJson(req.getParameter("andParam"), MiddleVO.class);
		
		System.out.println(vo.getDoubleF()+vo.getIntF()+vo.getStr());
		resp.getWriter().println("응답 처리 : jsonData.....");
		
	}
}
