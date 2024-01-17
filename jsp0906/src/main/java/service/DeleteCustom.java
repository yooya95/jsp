package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class DeleteCustom implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("deleteCustom start...");
		request.setCharacterEncoding("utf-8"); 
		
		//(custcode를 입력값으로) 삭제시켜주는 작업 시행 
		int custcode = Integer.parseInt(request.getParameter("custcode"));
		String custname = request.getParameter("custname");
		
		try {
		
			CustomDao cd = CustomDao.getinstance();
			Custom custom = new Custom();
			
			int result = cd.delete(custcode,custname);
			request.setAttribute("custcode", custom.getCustcode());
			request.setAttribute("custname",custom.getCustname());
			
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		return "deleteCustom.jsp";
	}

}
