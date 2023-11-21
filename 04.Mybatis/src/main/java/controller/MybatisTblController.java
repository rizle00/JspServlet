package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MybatisTblController")
public class MybatisTblController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if(path.equals("/insert.mytbl")) {
			
		} else if (path.equals("/update.mytbl")) {
			
		}else if (path.equals("/delete.mytbl")) {
			
		}else if (path.equals("/select.mytbl")) {
			
		}
	}
}
