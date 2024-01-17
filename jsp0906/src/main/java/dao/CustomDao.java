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

import dto.Custom;

public class CustomDao {

	private static CustomDao instance;
	private CustomDao() {}
	public static CustomDao getinstance() {
		if(instance == null) {
			instance = new CustomDao();
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
	public List<Custom> customList() throws SQLException {
		List<Custom> customList = new ArrayList<Custom>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from custom";
		
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				Custom custom = new Custom();
				custom.setCustcode(rs.getInt(1));
				custom.setCustname(rs.getString(2));
				custom.setCust_tel(rs.getString(3));
				custom.setCust_gubun(rs.getString(4));
				custom.setCust_ceo(rs.getString(5));
				customList.add(custom);
				
				
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
			if (rs  != null)  rs.close();
			if (stmt != null) stmt.close();
			if (conn !=null)  conn.close();
		}
	
		return customList;
	}
	public int insert(Custom custom) throws SQLException {
		
		int result=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO custom VALUES (custom_code_seq.NEXTVAL, ?, ?, ?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custom.getCustname());
			pstmt.setString(2, custom.getCust_tel());
			pstmt.setString(3, custom.getCust_gubun());
			pstmt.setString(4, custom.getCust_ceo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null)  conn.close();
			
		}
		
		
		return result;
	}
	public Custom select(int custcode) throws SQLException {
		
		Custom custom = new Custom();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql= "Select * from custom where custcode="+custcode;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			
			if( rs.next()) {
				custom.setCustcode(rs.getInt("custcode"));
				custom.setCustname(rs.getString("custname"));
				custom.setCust_tel(rs.getString("cust_tel"));
				custom.setCust_gubun(rs.getString("cust_gubun"));
				custom.setCust_ceo(rs.getString("cust_ceo"));
				
			}
			
			
			
		} catch (Exception e) {
			
			
		} finally {
			if (rs  != null)  rs.close();
			if (stmt != null) stmt.close();
			if (conn !=null)  conn.close();
			
		}
		
		
		return custom;
	}
	public int update(Custom custom) throws SQLException {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update custom set custname=?, cust_tel=?, "
					  + "cust_gubun=?, cust_ceo=? where custcode=?";	
		
		try {
		
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custom.getCustname());
			pstmt.setString(2, custom.getCust_tel());
			pstmt.setString(3, custom.getCust_gubun());
			pstmt.setString(4, custom.getCust_ceo());
			pstmt.setInt(5, custom.getCustcode());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null)  conn.close();	
		}
		
		return result;
	}
	
	public int delete(int custcode, String custname) throws SQLException {
		
		int result=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from custom where custcode=? and custname=?";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setInt(1, custcode);
			pstmt.setString(2, custname);
			
	
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			

			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
			
		}
		
	
		return result;
	}
	
	
	
	
}
