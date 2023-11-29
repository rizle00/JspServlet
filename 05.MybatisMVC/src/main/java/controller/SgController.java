package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.SgDAO;
import sg.SgVO;

@WebServlet("*.sg")
public class SgController extends HttpServlet {
	SgDAO dao = new SgDAO();
	
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath().replace("/","");
		if(path.equals("list.sg")) {
			rd = req.getRequestDispatcher("sg/list.jsp");
			req.setAttribute("list", dao.select());
			rd.forward(req, resp);
		} else if(path.equals("insert.sg")) {
			SgVO vo = new SgVO();
			vo.setName(req.getParameter("name"));
			vo.setEmail(req.getParameter("email"));
			vo.setSalary(Integer.parseInt(req.getParameter("salary")));
			vo.setCommission_pct(Integer.parseInt(req.getParameter("commission_pct")));
			vo.setDepartment_id(Integer.parseInt(req.getParameter("department_id")));
			vo.setDepartment_name(req.getParameter("department_name"));
			vo.setManager_id(Integer.parseInt(req.getParameter("manager_id")));
			resp.sendRedirect("list.sg");
		}
		
	}
}
