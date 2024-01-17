package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Order_detailDao;
import dto.Order_detail1;

public class OrderDetailInsert implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("orderDetailInsert start...");
		request.setCharacterEncoding("utf-8"); 
		
		//제품, 제품주문내용, 제품수량, 상세추가입력 입력값을 넘겨야함
		String order_date = request.getParameter("order_date");
		int item_code=Integer.parseInt(request.getParameter("item"));
		String item_order_desc = request.getParameter("item_order_desc");
		int item_count = Integer.parseInt(request.getParameter("item_count"));
		int custcode = Integer.parseInt(request.getParameter("custcode"));
	
		try {
			System.out.println("order_detail set");
			Order_detail1 order_detail = new Order_detail1();
			order_detail.setOrder_date(order_date);
			/* order_detail.setItem_name(item_name); */
			order_detail.setItem_code(item_code);	
			order_detail.setItem_order_desc(item_order_desc);	
			order_detail.setItem_count(item_count);
			order_detail.setCustcode(custcode);
			
			
			Order_detailDao odetail = Order_detailDao.getinstance();
			int result = odetail.insert(order_detail);
			
			//결과값 설정
			request.setAttribute("result", result);
			request.setAttribute("order_Date", order_detail.getOrder_date());
			/* request.setAttribute("item_name", order_detail.getItem_name()); */
			request.setAttribute("item_code", order_detail.getItem_code());
			request.setAttribute("item_order_desc", order_detail.getItem_order_desc());
			request.setAttribute("item_count", order_detail.getItem_count());
			request.setAttribute("custcode", custcode);
			
		} catch (Exception e) {
			e.getStackTrace();
		}

		return "insertOrderDetail.jsp";
	}

}
