package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;


	public class UpdateForm implements CommandProcess {

		@Override
		public String requestPro(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 사원 정보 수정
			
			System.out.println("updateForm->  updateForm.jsp ");
			
			int sabun =  Integer.parseInt( request.getParameter("sabun") );
			
			try {
		

				SawonDao sw = SawonDao.getInstance();
				
				Sawon sawon = sw.select(sabun);

				request.setAttribute("sawon", sawon);
			}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
			return "updateForm2.jsp";
	
		}
}
