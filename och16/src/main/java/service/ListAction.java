package service;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class ListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ListAction Start...");
		
		request.setAttribute("totCnt", "30");

	

	//CommandProcess를 상속받아 requestPro 메소드를 오버라이딩 한다. --> httpServletRequest,httpServletResponse
	//HttpServletRequest 의 객체 속성 설정, totCnt = key값, 30은 value값
	//HttpServletRequest 객체에 totCnt라는 이름의 속성을 객체에 추가하고, 그 속성의 값으로 30이라는 문자열을 설정

	
	BoardDao bd = BoardDao.getInstance();
	try {
		// 게시판 총 갯수를 가져옴
		int totCnt =bd.getTotalCnt();   // 38
		
		String pageNum = request.getParameter("pageNum");	
		if (pageNum==null || pageNum.equals("")) {	pageNum = "1";	}
		int currentPage = Integer.parseInt(pageNum);	  //   1        
		int pageSize  = 10, blockSize = 10;
		int startRow = (currentPage - 1) * pageSize + 1;  // 1     11    21    31 순으로 설정이 됨 왜냐면 pageSize가 10이기 때문
		int endRow   = startRow + pageSize - 1;           // 10    20 
		int startNum = totCnt - startRow + 1;             // 

		// Board 조회                              1     10
		List<Board> boardList = bd.boardList(startRow,endRow); 
		System.out.println("ListAction boardList.size()->"+boardList.size());
		int pageCnt = (int)Math.ceil((double)totCnt/pageSize);  // 4

		int startPage = (int)(currentPage-1)/blockSize*blockSize + 1;  // 1    
		int endPage = startPage + blockSize -1;	                       // 10   
		// 공갈 Page 방지   10  >  4
		if (endPage > pageCnt) endPage = pageCnt;	                   // 4

		
		request.setAttribute("boardList", boardList);   // ***
		request.setAttribute("totCnt", totCnt);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startNum", startNum);
		request.setAttribute("blockSize", blockSize);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
	} catch (Exception e) {
		System.out.println("ListAction e.getMessage()->"+e.getMessage());
	}
	
    //      View 명칭  
	return "list.jsp"; 
	/* return "listMakeup.jsp"; */
}

}
