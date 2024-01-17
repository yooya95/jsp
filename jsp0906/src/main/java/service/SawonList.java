package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;

public class SawonList implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 전체 사원을 조회
		
		System.out.println("SawonList -->SawonList.jsp ");
		SawonDao sw = SawonDao.getInstance();
		
		try {
			
	        List<Sawon> sawonList = sw.sawonList(); 
			
			request.setAttribute("sawonList", sawonList);  
			} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "sawonSelect.jsp";

	}





}
