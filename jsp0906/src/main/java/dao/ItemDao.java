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

import dto.Item;

public class ItemDao {

		private static ItemDao instance ;
		private ItemDao() {}
		public static ItemDao getinstance() {
			if (instance == null) {
				instance = new ItemDao();
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
		
		// 전체 아이템 목록을 조회함
		public List<Item> itemList() throws SQLException {
			List<Item> itemList = new ArrayList<Item>(); 
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select * from item";
			
			try {
				conn= getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Item id = new Item();
					id.setItem_code(rs.getInt(1));
					id.setItem_name(rs.getString(2));
					id.setItem_price(rs.getInt(3));
					id.setItem_kind(rs.getString(4));
					id.setItem_desc(rs.getString(5));
					id.setItem_birth(rs.getDate(6));
					itemList.add(id);		
				}
				
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				
				
				if (rs  != null)  rs.close();
				if (stmt != null) stmt.close();
				if (conn !=null)  conn.close();
			}
		
			
			return itemList;
		}
		
		//시퀸스를 활용하여 item_code값 1씩 증가시키기
		public int insert(Item item) throws SQLException {
			int result=0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO item VALUES (item_code_seq.NEXTVAL, ?, ?, ?,?, SYSDATE)";
		
			try {
				conn= getConnection();
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, item.getItem_name());
				pstmt.setInt(2, item.getItem_price());
				pstmt.setString(3, item.getItem_kind());
				pstmt.setString(4, item.getItem_desc());
				
				
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				
				
				
				if (pstmt != null) pstmt.close();
				if (conn !=null)  conn.close();
			}
		
			
			
			return result;
		}
		
		
		// 아이템 수정시 기존 정보를 불러올 수 있도록 조회함
		public Item select(int item_code) throws SQLException {
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select * from item where item_code="+item_code;
			
			Item item = new Item();
			
			
			try {
				conn= getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					item.setItem_code(rs.getInt("item_code"));
					item.setItem_name(rs.getString("item_name"));
					item.setItem_price(rs.getInt("item_price"));
					item.setItem_kind(rs.getString("item_kind"));
					item.setItem_desc(rs.getString("item_desc"));
					item.setItem_birth(rs.getDate("item_birth"));
					
				}
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				

				if (rs  != null)  rs.close();
				if (stmt != null) stmt.close();
				if (conn !=null)  conn.close();
			}
			
			
			
			return item;
		}
		public int update(Item item) throws SQLException {
			
			int result=0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update item set item_name=?, item_price=?, item_kind=?, "
					      + "item_desc=? where item_code=?";
			
			
			try {
				conn = getConnection();	
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, item.getItem_name());
				pstmt.setInt(2, item.getItem_price());
				pstmt.setString(3, item.getItem_kind());
				pstmt.setString(4, item.getItem_desc());
				pstmt.setInt(5, item.getItem_code());
				
				
				result= pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				if (pstmt != null) pstmt.close();
				if (conn !=null)  conn.close();	
				
			}
			
			
			
			return result;
		}
		public int delete(int item_code, String item_name) throws SQLException {
			
			int result=0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql="delete from item where item_code=? and item_name=?";
		
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, item_code);
				pstmt.setString(2, item_name);
				
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				

				if (pstmt != null) pstmt.close();
				if (conn !=null) conn.close();
				
			}
			
			
			
			return result;
		}
		
		
		
		
		


}

	