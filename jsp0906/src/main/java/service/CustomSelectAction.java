package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class CustomSelectAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CustomSelectAction start...");
		
		CustomDao cd = CustomDao.getinstance();
		
		try {
			// 거래처의 전체 리스트를 보여줌
			List<Custom> customlist = cd.customList();
			request.setAttribute("customList", customlist);
		
		
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		
		
		
		
		return "customSelect.jsp";
	}

}
