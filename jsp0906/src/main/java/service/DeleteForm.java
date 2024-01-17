package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;

public class DeleteForm implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("deleteForm start..");
		
		
		int sabun = Integer.parseInt(request.getParameter("sabun"));
		String sawon_name = request.getParameter("sawon_name");
		System.out.println("sabun: " + sabun); // 디버그 메시지 추가
		System.out.println("sawon_name: " + sawon_name); // 디버그 메시지 추가
		
		
		try {
			
			SawonDao sw = SawonDao.getInstance();
			
			Sawon sawon=sw.select(sabun);
			request.setAttribute("sawon", sawon);
			request.setAttribute("sabun",sabun);
			request.setAttribute("sawon_name", sawon_name);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		
		return "deleteForm2.jsp";
	}

}
