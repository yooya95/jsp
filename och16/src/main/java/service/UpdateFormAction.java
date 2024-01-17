package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class UpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UpdateFormAction start..");
		
		// 1. num , pageNum  GET
		// 사용자가 수정하려는 게시글번호를 http요청에서 가져옴
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		try {
			// 2. BoardDao bd Instance
			//  boarddao를 가져오는 이유는 수정하려는 게시글의 내용을 수정 폼에 미리 채워놓으려구
			// boarddao클래스 생성
			
			BoardDao bd = BoardDao.getInstance();
			
			// 4. Board board = bd.select(num);
			Board  board = bd.select(num);
		
			// 5. request 객체에 pageNum , board jsp 파일에 넘겨줌
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "updateForm.jsp";
	}

}
