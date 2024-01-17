package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;

public class DeleteSawon implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("deleteSawon start....");
		
		request.setCharacterEncoding("utf-8"); 
		
		try {
			Sawon sawon = new Sawon();
			int sabun= Integer.parseInt(request.getParameter("sabun"));
			String sawon_name= request.getParameter("sawon_name");
			
			SawonDao sw = SawonDao.getInstance();
			int result = sw.delete(sabun, sawon_name);
			
			request.setAttribute("result", result);
			request.setAttribute("sabun", sawon.getSabun());
			request.setAttribute("sawon name", sawon.getSawon_name());
	
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "deleteSawon.jsp";
	}

}
