package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import customer.CustomerDAO;
import customer.CustomerVO;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		common. config.xml 
//				mapper.xml
//				DAO <- MybatisConnection
//		MVC(WEB) : Request.setAttribute -> jsp
		
		CustomerDAO dao =  new CustomerDAO();
		if(req.getServletPath().equals("/select.cu")) {
			
			String query = req.getParameter("query");
			
			List<CustomerVO> list = dao.select(query);
			
			resp.getWriter().print(new Gson().toJson(list));
			
		} else if(req.getServletPath().equals("/delete.cu")) {
			int cus_id = Integer.parseInt(req.getParameter("customer_id"));
			System.out.println(cus_id);
			dao.delete(cus_id);
		}  else if(req.getServletPath().equals("/update.cu")) {
			System.out.println(req.getParameter("vo"));
			CustomerVO vo = new Gson().fromJson(req.getParameter("vo"), CustomerVO.class);
			resp.getWriter().print(dao.update(vo));
		}
		
	}
	
}
