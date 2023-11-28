package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerVO;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath().replace("/", "");// 슬러시 제외
		CustomerDAO dao = new CustomerDAO();
 		if(path.equals("list.cu")) {
		rd = req.getRequestDispatcher("customer/list.jsp");
//		List<CustomerVO> list = dao.select();
		req.setAttribute("list", dao.select());
		System.out.println(dao.select().size());
		rd.forward(req, resp);
		} else if(path.equals("delete.cu")) {
			int customer_id = Integer.parseInt(req.getParameter("customer_id"));
			dao.delete(customer_id);
			resp.sendRedirect("list.cu");
		} else if(path.equals("insert.cu")) {
			CustomerVO vo = new CustomerVO();
			vo.setName(req.getParameter("name"));
			vo.setEmail(req.getParameter("email"));
			vo.setGender(req.getParameter("gender"));
			vo.setPhone(req.getParameter("phone"));
			dao.insert(vo);
			resp.sendRedirect("list.cu");
		}else if(path.equals("update.cu")) {
			CustomerVO vo = new CustomerVO();
			vo.setCustomer_id(Integer.parseInt(req.getParameter("customer_id")));
			vo.setName(req.getParameter("name"));
			vo.setEmail(req.getParameter("email"));
			vo.setGender(req.getParameter("gender"));
			vo.setPhone(req.getParameter("phone"));
			dao.insert(vo);
			resp.sendRedirect("list.cu");
		}
	}

}
