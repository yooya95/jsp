package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;


import dto.Order_detail1;

public class Order_detailDao {
	
	private static Order_detailDao instance;
	private int item_code;
	private Order_detailDao() {}
	public static Order_detailDao getinstance() {
		if(instance == null) {
			instance = new Order_detailDao();
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
	
	public int insert(Order_detail1 order_detail) throws SQLException {
		int result=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//제품코드, 제품, 제품주문내용, 제품수량
		String sql="INSERT into order_detail1 values( ?,?,?,?,0,?)";
		
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_detail.getOrder_date());
			pstmt.setInt(2, order_detail.getCustcode());
			pstmt.setInt(3, order_detail.getItem_code());
			pstmt.setString(4, order_detail.getItem_order_desc());
			pstmt.setInt(5, order_detail.getItem_count());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null)  conn.close();
		}
		
		
		return result;
	}
	public List<Order_detail1> detailList(String order_date, int custcode) throws SQLException {
		
		List<Order_detail1>detailList = new ArrayList<Order_detail1>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT  o.order_date , o.custcode , o.item_order_desc , o.item_code ,o.item_count "
				+    "        ,c.custname   , i.item_name          "
				+    " FROM   order_detail1 o, custom c, item i    "
				+    " WHERE  o.order_date  = ?                    "
				+    " AND    o.custcode  = ?                      "
				+    " AND    o.custcode  = c.custcode             "
				+    " AND    o.item_code = i.item_code(+)         ";
		
		System.out.println("Order1DetailDao orderDetailList sql->"+sql);
		
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, order_date);
			pstmt.setInt(2, custcode);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Order_detail1 order_detail = new Order_detail1();
				order_detail.setOrder_date(rs.getString("order_date"));
				order_detail.setCustcode(rs.getInt("custcode"));
				order_detail.setCustname(rs.getString("custname"));
				order_detail.setItem_order_desc(rs.getString("item_order_desc"));
				order_detail.setItem_code(rs.getInt("item_code"));
				order_detail.setItem_name(rs.getString("item_name"));
				order_detail.setItem_count(rs.getInt("item_count"));
				detailList.add(order_detail);

			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		
		return detailList;
	}



}
