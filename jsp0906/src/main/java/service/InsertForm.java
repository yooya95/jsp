package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertForm implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("InsertForm start....");
	
		try {
			// 신규로 사원을 등록하는 작업을 수행해야함.
			int sabun=0 ;
			String sawon_name=null;
			int sal=0 ;
			String handphone=null;
			
			/* 
			 * int sabun = Integer.parseInt(request.getParameter("sabun")); String
			 * sawon_name = request.getParameter("sawon_name"); int sal =
			 * Integer.parseInt(request.getParameter("sal")); String handphone =
			 * request.getParameter("handphone");
			 */
			
			request.setAttribute("sabun", sabun);
			request.setAttribute("sawon_name", sawon_name);
			request.setAttribute("sal", sal);
			request.setAttribute("handphone", handphone);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "insertform2.jsp";
	}

}
