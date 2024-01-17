package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dto.Order1;

public class OrderUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("orderUpdateFormAction start...");

		// updateform에 order정보 담기
		String order_date = request.getParameter("order_date"); 
		int custcode = Integer.parseInt(request.getParameter("custcode"));
		String sawon_name = request.getParameter("sawon_name");
		String custname = request.getParameter("custname");
		
		try {

			
		 	OrderDao od = OrderDao.getinstance();
			Order1 order = od.select(custcode, order_date);
			
			
		    request.setAttribute("order", order);  
		    request.setAttribute("order_date", order_date);
			request.setAttribute("custname", custname);
			request.setAttribute("custcode", custcode);
			request.setAttribute("sawon_name", sawon_name);

		} catch (Exception e) {
			e.getStackTrace();
		}

		return "orderUpdateForm.jsp";
	}

}
