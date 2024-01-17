package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dto.Order1;


public class OrderListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("orderListAction start..");
		
		try {
			OrderDao od = OrderDao.getinstance();
			//전체 주문내역 조회
			List<Order1> orderList = od.orderList();
			request.setAttribute("orderList", orderList);
			
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		
		
		
		return "orderListActionForm.jsp";
	}

}
