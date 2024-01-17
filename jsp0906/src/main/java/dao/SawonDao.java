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
import dto.Sawon;

public class SawonDao {

		private static SawonDao instance;
		private SawonDao() {}
		public static SawonDao getInstance() {
			if (instance == null) {	
				instance = new SawonDao();		
			}
			return instance;
		}

		private Connection getConnection() {
			Connection conn = null;
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)
					ctx.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
			}catch(Exception e) { 
				System.out.println(e.getMessage());	
			}
			return conn;
		
		}
		
		public List<Sawon> sawonList() throws SQLException {
			List<Sawon> sawonList = new ArrayList<Sawon>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select * from sawon";
			
			
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Sawon sw = new Sawon();
					sw.setSabun(rs.getInt(1));
					sw.setSawon_name(rs.getString(2));
					sw.setSal(rs.getInt(3));
					sw.setHandphone(rs.getString(4));	
					sawonList.add(sw);
				}
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
		
			}finally {
			
			if (rs  != null)  rs.close();
			if (stmt != null) stmt.close();
			if (conn !=null)  conn.close();
			
			} return sawonList;
		}
		
		public Sawon select(int sabun) throws SQLException {
			Connection conn = null;
			Statement stmt= null;
			ResultSet rs = null;
			String sql = "select * from sawon where sabun="+sabun;
			Sawon sawon = new Sawon();
			try {
			 
				conn= getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					sawon.setSabun(rs.getInt("sabun"));
					sawon.setSawon_name(rs.getString("sawon_name"));
					sawon.setSal(rs.getInt("sal"));
					sawon.setHandphone(rs.getString("handphone"));
					
					
				}
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				
				if (rs  != null)  rs.close();
				if (stmt != null) stmt.close();
				if (conn !=null)  conn.close();
			}
			return sawon;
			
			
		} 
		
		
		//사원을 조회한 후 정보를 수정하는 메서드
		
		public int update(Sawon sawon ) throws SQLException {
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			int result=0;
			String sql="update sawon set sawon_name=?, sal=? ,handphone=? where sabun=?";
					
			try {
				conn=getConnection();
				pstmt= conn.prepareStatement(sql);
	
				pstmt.setString(1, sawon.getSawon_name());
				pstmt.setInt(2, sawon.getSal());
				pstmt.setString(3, sawon.getHandphone());
				pstmt.setInt(4, sawon.getSabun());
				
				result= pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println();
			}finally {
				
				if (pstmt != null) pstmt.close();
				if (conn !=null)  conn.close();		
				
				
				
				
			}
			
			return result;
	
		}
		
		
		public int insert(Sawon sawon) throws SQLException {
			
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "Insert into sawon values(?,?,?,?)";
			
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sawon.getSabun());
			pstmt.setString(2, sawon.getSawon_name());
			pstmt.setInt(3, sawon.getSal());
			pstmt.setString(4, sawon.getHandphone());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
			
		}
		return result;	
			
		}
		
		public int delete(int sabun, String sawon_name) throws SQLException {
			
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "delete from sawon where sabun=? and sawon_name=?";
			
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, sabun);
				pstmt.setString(2, sawon_name);
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			
			} finally {

				if (pstmt != null) pstmt.close();
				if (conn !=null) conn.close();
			
			}return result;
		

			
		}
		
		
}
