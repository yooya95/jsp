package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class WriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("WriteFormAction Start...");
		
		try {
			// 신규글 작성, 게시글 번호, 참조, 답글레벨, 답글 스텝 을 0 으로 하여 입력값을 받음
			int num = 0, ref = 0, re_level = 0, re_step = 0;
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) pageNum = "1";
			// 초기값을 0으로 설정하고, 나중에 클라이언트로부터 받은 데이터로 업데이트 된다.
			//pageNum 변수는 페이지 번호를 저장하며, 클라이언트가 요청에서 페이지 번호를 전달하지 않았을 경우 1로 초기화 된다. 
			

			// 댓글 작성 
			if (request.getParameter("num")!=null) {
				num=Integer.parseInt(request.getParameter("num"));
				BoardDao bd = BoardDao.getInstance();
				//게시글 번호 num을 기반으로 데이터베이스에서 해당 게시글을 조회
				Board board = bd.select(num);
				//조회한 게시글의 정보 중에서 ref 값을 가지는 게시글은 동일한 주제의 글을 의미, re_level은 계층구조 re_step은 댓글 순서를 나타낸다. 
				ref = board.getRef();
				re_level = board.getRe_level();
				re_step = board.getRe_step();
			}
			
			
			
			//jsp 페이지에서 사용할 수있또록 변수를 저장함  ,고
			request.setAttribute("num", num);
			request.setAttribute("ref", ref);
			request.setAttribute("re_level", re_level);
			request.setAttribute("re_step", re_step);
			request.setAttribute("pageNum", pageNum);		

		} catch (Exception e) {
			System.out.println("WriteFormAction Exception->"+e.getMessage());
		}
		

		return  "writeForm.jsp";
	}

}
