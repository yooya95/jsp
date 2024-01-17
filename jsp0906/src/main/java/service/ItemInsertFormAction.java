package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ItemInsertFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("itemInsertFormAction start....");
		
		try {
			
			// 신규로 새제품 등록!
			/* int item_code = 0; */
			String item_name = null;
			int item_price = 0;
			String item_kind = null;
			String item_desc = null;
			/* Date item_birth = null; */
			
			
			/* request.setAttribute("item_code", item_code); */
			request.setAttribute("item_name", item_name);
			request.setAttribute("item_price", item_price);
			request.setAttribute("item_kind", item_kind);
			request.setAttribute("item_desc", item_desc);
			/* request.setAttribute("item_birth", item_birth); */
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		
		
		
		return "ItemInsertForm.jsp";
	}

}
