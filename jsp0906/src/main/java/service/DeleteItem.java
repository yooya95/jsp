package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class DeleteItem implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("deleteItem start...");
		// 데이터를 삭제작업 실행
		request.setCharacterEncoding("utf-8"); 
		
		int item_code = Integer.parseInt(request.getParameter("item_code"));
		String item_name = request.getParameter("item_name");
		
		try {
			Item item = new Item();
			
			ItemDao id = ItemDao.getinstance();
			
			int result = id.delete(item_code, item_name);
			request.setAttribute("item_code", item.getItem_code());
			request.setAttribute("item_name", item.getItem_name());
		
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return "deleteItem.jsp";
	}

}
