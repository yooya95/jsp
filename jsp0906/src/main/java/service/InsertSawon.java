package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;

public class InsertSawon implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("InsertSawon start...");
		
		try {
			request.setCharacterEncoding("utf-8"); 
			
			Sawon sawon = new Sawon();
			
			sawon.setSabun(Integer.parseInt(request.getParameter("sabun")));
			sawon.setSawon_name(request.getParameter("sawon_name"));
			sawon.setSal(Integer.parseInt(request.getParameter("sal")));
			sawon.setHandphone(request.getParameter("handphone"));  
			
			SawonDao sw = SawonDao.getInstance();
			
			int result = sw.insert(sawon);
			request.setAttribute("sabun", sawon.getSabun());
			request.setAttribute("sawon_name", sawon.getSawon_name());
			request.setAttribute("sal", sawon.getSal());
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "insertSawon.jsp";
	}

}
