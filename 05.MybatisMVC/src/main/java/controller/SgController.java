package controller;

import java.io.IOException;
import java.util.HashMap;

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
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath().replace("/","");
		if(path.equals("list.sg")) {
			rd = req.getRequestDispatcher("sg/list.jsp");
			HashMap<String, String> map = new HashMap<>();
			map.put("option", req.getParameter("option"));
			map.put("keyword", req.getParameter("keyword"));
			req.setAttribute("option", map.get("option"));
			req.setAttribute("keyword", map.get("keyword"));
			req.setAttribute("list", dao.select(map));
			req.setAttribute("depart", dao.depart());
			rd.forward(req, resp);
			
		} else if(path.equals("insert.sg")) {
			
			SgVO vo = new SgVO();
			vo.setName(req.getParameter("name"));
			vo.setEmail(req.getParameter("email"));
			vo.setSalary(dao.parse(req.getParameter("salary")));
			vo.setCommission_pct(dao.parseD(req.getParameter("commission_pct")));
			vo.setDepartment_id(dao.parse(req.getParameter("department_id")));
			vo.setDepartment_name(req.getParameter("department_name"));
			dao.insert(vo);
			resp.sendRedirect("list.sg");
			
		} else if(path.equals("delete.sg")) {
			
			int employee_id = Integer.parseInt(req.getParameter("employee_id"));
			dao.delete(employee_id);
			resp.sendRedirect("list.sg");
			
		} else if(path.equals("update.sg")) {
			
			SgVO vo = new SgVO();
			vo.setEmployee_id(Integer.parseInt(req.getParameter("employee_id")));
			vo.setName(req.getParameter("name"));
			vo.setEmail(req.getParameter("email"));
			vo.setSalary(dao.parse(req.getParameter("salary")));
			vo.setCommission_pct(dao.parseD(req.getParameter("commission_pct")));
			vo.setDepartment_id(dao.parse(req.getParameter("department_id")));
			dao.update(vo);
			resp.sendRedirect("list.sg");
			
		}
		
	}
}
