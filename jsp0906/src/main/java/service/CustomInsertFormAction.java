package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CustomInsertFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("customInsertFormAction start...");
		
		try {
			
			//새로운 입력값을 받는 작업 진행
			/* int custcode = 0; */
			String custname = null;
			String cust_tel = null;
			String cust_gubun = null;
			String cust_ceo = null;
			
			/* request.setAttribute("custcode", custcode); */
			request.setAttribute("custname", custname);
			request.setAttribute("cust_tel", cust_tel);
			request.setAttribute("cust_gubun",cust_gubun);
			request.setAttribute("cust_ceo", cust_ceo);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		
		
		return "customInsertForm.jsp";
	}

}
