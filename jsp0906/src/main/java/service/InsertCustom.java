package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dao.SawonDao;
import dto.Custom;

public class InsertCustom implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("insertCustom start...");
		
		try {
			
			// 새로 입력받은 값을 insert 해주는 작업
			
			Custom custom = new Custom();
			// 새로 입력받은 값을 custom 객체에 셋팅
			custom.setCustname(request.getParameter("custname"));
			custom.setCust_tel(request.getParameter("cust_tel"));
			custom.setCust_gubun(request.getParameter("cust_gubun"));
			custom.setCust_ceo(request.getParameter("cust_ceo"));
			
			
			
			CustomDao cd = CustomDao.getinstance();
			
			
			int result = cd.insert(custom);
			
			request.setAttribute("result", result);
			request.setAttribute("custname", custom.getCustname());
			request.setAttribute("cust_tel", custom.getCust_tel());
			request.setAttribute("cust_gubun", custom.getCust_gubun());
			request.setAttribute("cust_ceo", custom.getCust_ceo());
			
			
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		return "insertCustom.jsp";
	}

}
