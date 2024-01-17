package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dao.SawonDao;
import dto.Custom;
import dto.Sawon;

public class OrderInsertFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("orderInsertFormAction start....");
		
		//custom의 custname과 sawon의 sabun , sawon_name을 가져와야 함. --> listdao 
		//신규로 입력한 정보를 insertform으로 넘겨야함
		
		
		request.setCharacterEncoding("utf-8"); 
		String order_desc= null;
		int custcode = 0;
		int sabun = 0;
		String order_date = null;
		String order_state = "0";
		
		try {
			
			CustomDao cd = CustomDao.getinstance();
			List<Custom> customlist = cd.customList();
			request.setAttribute("customList", customlist);	
			request.setAttribute("custcode", custcode);
		
			
			request.setAttribute("order_desc", order_desc);
			request.setAttribute("order_state", order_state);
			
			SawonDao sw = SawonDao.getInstance();
			List<Sawon> sawonlist = sw.sawonList();
			request.setAttribute("sawonList", sawonlist);
			request.setAttribute("sabun", sabun);
			request.setAttribute("order_date", order_date);
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return "orderInsertForm.jsp";
	}

}
