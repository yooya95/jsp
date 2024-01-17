package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class UpdateCustom implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("updateCustom start...");
		request.setCharacterEncoding("utf-8"); 
		
		// 수정된 정보를 update 하는 작업 진행
		try {
			
			Custom custom = new Custom();
			custom.setCustcode(Integer.parseInt(request.getParameter("custcode")) );
			custom.setCustname(request.getParameter("custname"));
			custom.setCust_tel(request.getParameter("cust_tel"));
			custom.setCust_gubun(request.getParameter("cust_gubun"));
			custom.setCust_ceo(request.getParameter("cust_ceo"));
			
			CustomDao cd = CustomDao.getinstance();
			
			int result = cd.update(custom);
			
			request.setAttribute("result", result);
			request.setAttribute("custom", custom);
		
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		
		
		return "updateCustom.jsp";
		
	}

}
