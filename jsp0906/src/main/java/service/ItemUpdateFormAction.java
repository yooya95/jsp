package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class ItemUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("itemUpdateFormAction start....");
		
		//제품코드를 넘겨받아서 제품코드에 해당하는 제품정보를 form jsp에  조회시켜야 함
		
		int item_code = Integer.parseInt(request.getParameter("item_code"));
		
		try {
		
			ItemDao id = ItemDao.getinstance();
			
			Item item = id.select(item_code);
			
			request.setAttribute("item", item);
			request.setAttribute("item_code", item_code);
			
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		
		
		return "itemUpdateForm.jsp";
	}

}
