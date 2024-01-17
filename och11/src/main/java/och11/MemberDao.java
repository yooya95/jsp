package och11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// DB CRUD 관련된 DML 처리 Logic 
public class MemberDao {
	
	//NULL로 초기화 하는 이유는 어느 지점에서든 변수에 접근하더라도 예외가 발생하지 않도록 하는게 목적이다.
	Connection conn = null;

   // DBCP  GETCONNECTION 데이터베이스의 연결을  획득하는 역할 수행, 커넥션 풀을 사용하여 연결 관리 
   private Connection getConnection() throws SQLException {
	   
	  try {
		  // InitialContext를 사용하여 초기 컨텍스트 객체 를 생성하여 변수 CTX에 할당
		  // InitialContext는 JNDI레지스트리 내의 리소스에 접근하고 검색할 수 있음
		   Context ctx = new InitialContext();
		   DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
		   conn = ds.getConnection();
		   
	  } catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	  }
	   
	  return conn;
   }
	
   //회원 정보를 데이터베이스에 추가하는 메서드 설정 
   //memberdto타입의 memeber(dto)라는 이름의 파라미터를 받아들인다.
   public int insert(MemberDto member) throws SQLException {
		int result = 0; 
		
		// Connection conn = null;		 
		//변수선언
		PreparedStatement pstmt = null;
		String sql = "insert into member1 values(?,?,?,sysdate)";
		try { 
			
			//데이터베이스 연결 획득
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			
			//SQL문 실행 및 결과 처리
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) { 
			System.out.println(e.getMessage()); 
		}finally{ 
			//리소스 해제
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;		
   }
	
}
