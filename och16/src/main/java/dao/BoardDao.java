package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DBCP + Singleton
public class BoardDao {
	private static BoardDao instance;
	private BoardDao() {}
	public static BoardDao getInstance() {
		if (instance == null) {	
			instance = new BoardDao();		
		}
		return instance;
	}

	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		}catch(Exception e) { 
			System.out.println(e.getMessage());	
		}
		return conn;
	}

	//  게시판의 총 개수를 얻는 메서드 실행 (ListAction)
	public int getTotalCnt() throws SQLException {
		
		int tot=0;
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="select count(*) from board";
		
		try {
			conn= getConnection();
			stmt= conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) tot=rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return tot;
		
	
	}
	

	//게시판의 전체를 조회할 수 잇는 메서드 실행 list 활용 (ListAction)
	public List<Board> boardList(int startRow, int endRow) throws SQLException {
		
		List<Board> boardList = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT *  "
	 	    	+ "FROM (Select rownum rn ,a.*  "
	 		    + "      From 	 (select * from board order by ref desc,re_step) a ) " //ref 열을 기준으로 내림차순으로 정렬하고 동일한 ref 값 내에서 오름차순으로 정렬
	 		    + "WHERE rn BETWEEN ? AND ? " ;
		
		try {	conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs= pstmt.executeQuery();
				
			  while(rs.next()) {
				  Board board = new Board();
					board.setNum(rs.getInt("num"));
					board.setWriter(rs.getString("writer"));
					board.setSubject(rs.getString("subject"));
					board.setEmail(rs.getString("email"));
					board.setReadcount(rs.getInt("readcount"));
					board.setIp(rs.getString("ip"));
					board.setRef(rs.getInt("ref"));
					board.setRe_level(rs.getInt("re_level"));
					board.setRe_step(rs.getInt("re_step"));
					board.setReg_date(rs.getDate("reg_date"));
					boardList.add(board);
			  }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return boardList;
		
		
	}
	
	// 게시물 클릭시 조회수 증가 
	public void readCount(int num) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set readcount=readcount+1 where num=?";
		
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(conn!=null)conn.close();
		}
		
				
		
	}
	
	// 게시글의 num 값을 통해서 해당 게시물 상세내역 조회
	public Board select(int num) throws SQLException {
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board where num=+?";
		Board  board  = new Board();
		
		try {
			
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				board.setReg_date(rs.getDate("reg_date"));
				board.setRef(rs.getInt("ref"));
				board.setRe_level(rs.getInt("re_level"));
				board.setRe_step(rs.getInt("re_step"));							
			}
			
			
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		
		}
		return board;
		
		
		
	}
	

	public int insert(Board board) throws SQLException {
		// 1. board Setting 값들을 board TBL안에 Insert
		//    1-1 num -> MAX로 Setting(PK)
		//    1-2 PreparedStatement
		//    1-3 ref  -> num Setting
		//    1-4 rerutn DML 결과값 
		
		int num = board.getNum();		
		Connection conn = null;	
		PreparedStatement pstmt= null; 
		int result = 0;			
		ResultSet rs = null;
		//게시글 테이블에서 최대 게시글 번호를 가져오는 sql1문
		String sql1 = "select nvl(max(num),0) from board";
		//게시글을 삽입하는 sql문
		String sql="insert into board values(?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		//댓글 작성 시 댓글의 순서를 조정하기 위한 ㄴsql문
		String sql2 = "update board set re_step+1 where ref=? and re_step > ?";
		try {			
			//  데이터베이스 연결
			conn = getConnection();
			// 최대 게시글 번호 조회
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			// key인 num 1씩 증가, mysql auto_increment 또는 oracle sequence
			// sequence를 사용 : values(시퀀스명(board_seq).nextval,?,?...)
			
			//최대 게시글 번호 +1
			int number = rs.getInt(1) + 1;  
			rs.close();   
			pstmt.close();
			
			// 댓글 작서 여부 확인
			if (num!=0) {
				System.out.println("BoardDAO insert 댓글 sql2->"+sql2);
				System.out.println("BoardDAO insert 댓글 board.getRef()->"+board.getRef());
				System.out.println("BoardDAO insert 댓글 board.getRe_step()->"+board.getRe_step());
			
				//댓글 순서 조정
				pstmt = conn.prepareStatement(sql2);
				// 댓글이 속하는 게시글의 ref (그룹) 값을 가져옴
				pstmt.setInt(1, board.getRef());
				// 현재 댓글의  순서
				pstmt.setInt(2, board.getRe_step());
				pstmt.executeUpdate();
				pstmt.close();
				
				//댓글 관련 정보 업데이트
				board.setRe_step(board.getRe_step()+1);
				board.setRe_level(board.getRe_level()+1);
			
			
			// re step(댓글의 순서) 숫자가 커질수록 나중에 작성된 댓글을 의미  re_level 답글의 계층 구조 
			
			
			}
			
				
			// 신규 글  게시글번호가 0일때 최대 게시글 번호를 답변글끼리의 그룹인 ref로 설정한다. 
			if (num == 0) board.setRef(number);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getEmail());
			pstmt.setInt(6, board.getReadcount());
			pstmt.setString(7, board.getPasswd());
			pstmt.setInt(8, board.getRef());
			pstmt.setInt(9, board.getRe_step());
			pstmt.setInt(10, board.getRe_level());
			pstmt.setString(11, board.getIp());
			result = pstmt.executeUpdate(); 
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return result;		
	}
	
	public int update(Board board) throws SQLException {
		Connection conn = null;	
		PreparedStatement pstmt= null; 
		int result = 0;			
		String sql="update board set subject=?,writer=?,email=?,"
				+ "passwd=?,content=?,ip=? where num=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getPasswd());
			pstmt.setString(5, board.getContent());
			pstmt.setString(6, board.getIp());
			pstmt.setInt(7, board.getNum());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null)   conn.close();
		}
		return result;
	}
}

