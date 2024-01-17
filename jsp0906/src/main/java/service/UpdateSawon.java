package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;

public class UpdateSawon implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("updateSawon start...");
		
		request.setCharacterEncoding("utf-8"); 
     
		
     
		try {
			Sawon sawon = new Sawon();
			sawon.setSabun(Integer.parseInt(request.getParameter("sabun")));
			sawon.setSawon_name(request.getParameter("sawon_name"));
			sawon.setSal(Integer.parseInt(request.getParameter("sal")));
			sawon.setHandphone(request.getParameter("handphone"));
			SawonDao sw = SawonDao.getInstance();
			int result = sw.update(sawon);
			
			request.setAttribute("result", result);
			/* request.setAttribute("sawon", sawon); */
			request.setAttribute("sabun", sawon.getSabun());
			request.setAttribute("sawon_name", sawon.getSawon_name());
			request.setAttribute("sal", sawon.getSal());
			request.setAttribute("handphone", sawon.getHandphone());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "updateSawon.jsp";
	}

}
