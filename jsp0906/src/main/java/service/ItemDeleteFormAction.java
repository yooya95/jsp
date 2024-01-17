package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class ItemDeleteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("itemDeleteFormAction start...");
		
		
		request.setCharacterEncoding("utf-8"); 
		
		//기존의 데이터값을 가지고 데이터 삭제폼으로 이동시킴,
		try {
			
			int item_code = Integer.parseInt(request.getParameter("item_code"));
			String item_name = request.getParameter("item_name");
			
			ItemDao id = ItemDao.getinstance();
			Item item = id.select(item_code);
			
			request.setAttribute("item", item);
			request.setAttribute( "item_code",item_code);
			
			request.setAttribute("item_name", item_name);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return "itemDeleteForm.jsp";
	}

}
