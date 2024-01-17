package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class CustUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("custupdateformaction start...");
		
		// 거래처코드 값을 넘겨받아서 거래처 정보 수정시 기존 데이터 값을 불러오는 작업 진행 후 수정 form으로 넘어감
		int custcode = Integer.parseInt(request.getParameter("custcode"));
		
		try {
			CustomDao cd = CustomDao.getinstance();
			
			Custom custom = cd.select(custcode);
			
			request.setAttribute("custom", custom);
			request.setAttribute("custcode", custcode);
			
				
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		
		return "customUpdateForm.jsp";
	}

}
