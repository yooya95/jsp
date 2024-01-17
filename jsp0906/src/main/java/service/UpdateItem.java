package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class UpdateItem implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("updateItem start...");
		
		request.setCharacterEncoding("utf-8"); 
		
		//불러온 제품 정보를 수정한 값을 updateitem jsp로 전달 
		try {
			
			Item item = new Item();
			
			item.setItem_code(Integer.parseInt(request.getParameter("item_code")));
			item.setItem_name(request.getParameter("item_name"));
			item.setItem_price(Integer.parseInt(request.getParameter("item_price")));
			item.setItem_kind(request.getParameter("item_kind"));
			item.setItem_desc(request.getParameter("item_desc"));
			
			ItemDao id = ItemDao.getinstance();
			
			int result = id.update(item);
			
			request.setAttribute("result",result);
			request.setAttribute("item_code", item.getItem_code());
			request.setAttribute("item_name", item.getItem_name());
			request.setAttribute("item_price", item.getItem_price());
			request.setAttribute("item_kind", item.getItem_kind());
			request.setAttribute("item_desc", item.getItem_desc());
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	
		return "updateItem.jsp";
	}

}
