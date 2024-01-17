package service;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class ItemSelectAaction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("itemSelectAction start ");
		ItemDao id = ItemDao.getinstance();
		
		try {
			List<Item> itemList =id.itemList();
			
			request.setAttribute("itemList",itemList);
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		
		
		return "itemSelect.jsp";
	}

}
