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



import dto.Order1;

public class OrderDao {

	private static OrderDao instance;
	private OrderDao() {}
	public static OrderDao getinstance() {
		if(instance == null) {
			instance = new OrderDao();
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
	public int insert(Order1 order) throws SQLException {
		int result=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into order1 values (sysdate,?,?,?,?)";
		
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, order.getCustcode());
			pstmt.setString(2, order.getOrder_desc());
			pstmt.setInt(3, order.getSabun());
			pstmt.setString(4, order.getOrder_state());
	
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null)  conn.close();
		}
		return result;
	}
	
	
	public List<Order1> orderList() throws SQLException {
	
		List<Order1> orderList = new ArrayList<Order1>();
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs = null;
		String sql = "SELECT o.order_date, o.order_desc, o.order_state, o.custcode, c.custname, o.sabun, s.sawon_name " +
	             	  "FROM order1 o " +
	             	  "INNER JOIN custom c ON o.custcode = c.custcode " +
	                  "INNER JOIN sawon s ON o.sabun = s.sabun";
		
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
			    Order1 order = new Order1();
			    order.setOrder_date(rs.getString("order_date"));
			    order.setOrder_desc(rs.getString("order_desc"));
			    order.setOrder_state(rs.getString("order_state"));
			    order.setCustcode(rs.getInt("custcode"));
			    order.setSabun(rs.getInt("sabun"));
			    order.setCustname(rs.getString("custname"));
			    order.setSawon_name(rs.getString("sawon_name")); 
			    orderList.add(order);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs!=null) rs.close();
			if (stmt!=null) rs.close();
			if (conn !=null)  conn.close();
		}
		
		
		
		
		return orderList;
	}
	
	public Order1 select(int custcode,String order_date) throws SQLException {
		
		Order1 order = new Order1();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/* String sql = "select * from order1 where custcode="+custcode; */
		String sql = "SELECT o.order_date, o.order_desc, o.custcode, "
					+ "c.custname, s.sawon_name, o.order_state " +
					"FROM order1 o, custom c, sawon s " +
					"WHERE o.custcode=? and o.order_date=?"+
					"AND  o.custcode = c.custcode " +
					"AND  o.sabun = s.sabun";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custcode);
			pstmt.setString(2, order_date);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				order.setOrder_date(rs.getString("order_date"));
				order.setOrder_desc(rs.getString("order_desc"));
				order.setCustcode(rs.getInt("custcode"));
				order.setCustname(rs.getString("custname"));
				order.setSawon_name(rs.getString("sawon_name"));
				order.setOrder_state(rs.getString("order_state"));
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if (rs!=null) rs.close();
			if (pstmt!=null) rs.close();
			if (conn !=null)  conn.close();
		}
		
		
	
		return order;
	}	
	
	
}
