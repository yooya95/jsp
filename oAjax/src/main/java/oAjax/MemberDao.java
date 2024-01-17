package oAjax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// Singleton + DBCP

public class MemberDao {
	//싱글톤 만들기
	private static MemberDao instance;
	private MemberDao() {	
	}
	
	public static MemberDao getInstance() {
		if(instance== null) {
			instance = new MemberDao();
		}
		return instance;
	
	}
	//데이터베이스 연결
	 private Connection getConnection() throws SQLException {
		 Connection conn = null;
		 try {
			 	Context ctx = new InitialContext();
			 	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			 	conn = ds.getConnection();
			 	
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return conn;
	 
	 }
	
	//id를 찾아 조회하는 메서드 
	 public int confirm(String id) throws SQLException {
	 
	 int result = 1;
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
	 String sql="select id from member1 where id=?";

			 
	 try { 
		 conn = getConnection();
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, id);
		 rs = pstmt.executeQuery();
		 
		 if(rs.next()) result=1;
		 else          result=0;
		 	
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	
	} finally {
		if(rs !=null)   rs.close();
		if(pstmt !=null)pstmt.close();
		if(conn !=null) conn.close();
		
	}
	return result;
	 
	}
	 
}
