package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dao.OrderDao;
import dao.Order_detailDao;
import dto.Item;
import dto.Order1;
import dto.Order_detail1;


public class OrderUpdateForm2Action implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("orderUpdateForm2 start...");
		
		int custcode= Integer.parseInt(request.getParameter("custcode"));
		String order_date= request.getParameter("order_date");
		
		String sawon_name = request.getParameter("sawon_name"); 
		String custname = request.getParameter("custname");
		
	
		try {
			// 클릭한 거래처 값을 그대로 보여줘야함
			OrderDao od = OrderDao.getinstance();
			Order1 order = od.select(custcode, order_date);
			
			request.setAttribute("order", order);
			request.setAttribute("order_date", order_date);
			request.setAttribute("custname", custname);
			request.setAttribute("custcode", custcode);
			request.setAttribute("sawon_name", sawon_name);
			
			// 제품 리스트를 보여줘야함 (제품코드 외래키)
			ItemDao id = ItemDao.getinstance();
			List<Item> itemList = id.itemList();
			request.setAttribute("itemList", itemList);
			
			Order_detailDao orderdetail = Order_detailDao.getinstance();
			List<Order_detail1> detailList = orderdetail.detailList(order_date, custcode);
			
			request.setAttribute("detailList", detailList);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		return "orderUpdateForm2.jsp";
	}

}
