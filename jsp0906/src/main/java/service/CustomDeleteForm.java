package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class CustomDeleteForm implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("customdeleteform start...");
		
		// 거래처 삭제시 거래처코드와, 거래처 이름을 가지고감 데이터 정보를 조회하여 삭제폼으로 이동시킴
		
		request.setCharacterEncoding("utf-8"); 
		
		try {
			
			int custcode = Integer.parseInt(request.getParameter("custcode"));
			String custname = request.getParameter("custname");
			
			CustomDao cd = CustomDao.getinstance();
			
			
			
			Custom custom = cd.select(custcode);
			
			request.setAttribute("custom", custom);
			// 이 작업을 하면 거래처 코드 칸에 거래처 코드를 보여줌
			request.setAttribute("custcode", custcode);
			request.setAttribute("custname", custname);
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
		
		return "customDeleteForm.jsp";
	}

}
