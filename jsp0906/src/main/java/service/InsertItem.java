package service;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ItemDao;
import dto.Item;

public class InsertItem implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("insertItem start...");
		
		request.setCharacterEncoding("utf-8"); 
		//새제품 등록 창에서 입력받은 값을 insert 시켜야함 
		try {
			// item객체에 입력받은 값들을 저장함
			Item item = new Item();
			
			
			/* item.setItem_code(Integer.parseInt(request.getParameter("item_code"))); */
			item.setItem_name(request.getParameter("item_name"));
			item.setItem_price(Integer.parseInt(request.getParameter("item_price")));
			item.setItem_kind(request.getParameter("item_kind"));
			item.setItem_desc(request.getParameter("item_desc"));
		
			// 위의 값들을 id객체에 저장함
			ItemDao id = ItemDao.getinstance();
			
			// 저장한 값들을 insert해야함
			
			int result= id.insert(item);
			
			/* request.setAttribute("item_code", item.getItem_code()); */
			request.setAttribute("item_name", item.getItem_name());
			request.setAttribute("item_price", item.getItem_price());
			request.setAttribute("item_kind", item.getItem_kind());
			request.setAttribute("item_desc", item.getItem_desc());
			request.setAttribute("result", result);
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		return "insertItem.jsp";
	}

}
