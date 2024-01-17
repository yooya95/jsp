package och12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//singleton + DBCP ㅇ
public class MemberDao {
	private static MemberDao instance;
	private MemberDao() {
	}
	public  static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		
		return instance;
	}
	// ㅇ
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	//ㅇ
	public int check(String id, String passwd) throws SQLException {
		int result  = 0;  				
		Connection conn = null;
		String sql  = "select passwd from member2 where id=?"; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// id OK
			if (rs.next()) {
				String dbPasswd = rs.getString(1);
				if (dbPasswd.equals(passwd)) result = 1;
				else result = 0;
			} else   result = -1;
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}

	// PreparedStatement , 날짜 System Date , 나머지는 -> member , IMG_PATH --> No Image ㅇ
	public int insert(Member  member) throws SQLException {
		int result = 0;  				
        Connection conn = null;
		String sql = "Insert Into member2 values(?,?,?,?,?,sysdate,'no Image')"; 
		PreparedStatement pstmt = null; 
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getTel());
			result = pstmt.executeUpdate();
		} catch(Exception e) { System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	//ㅇ
	public List<Member> list() throws SQLException {
		List<Member> list = new ArrayList<Member>();
		Connection conn = null;
		String sql = "select * from member2"; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					Member member = new Member();
					member.setId(rs.getString(1));
					member.setPasswd(rs.getString(2));
					member.setName(rs.getString(3));
					member.setAddress(rs.getString(4));
					member.setTel(rs.getString(5));
					member.setReg_date(rs.getDate(6));
					list.add(member);
				} while(rs.next());
			} 
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return list;
	}
	// 수정시 확인
	public Member select(String id) throws SQLException {
		Member member = new Member();	
		Connection conn = null;
		String sql  = "select * from member2 where id=?"; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setTel(rs.getString(5));
				member.setReg_date(rs.getDate(6));
				member.setImg_path(rs.getString(7));
			} 
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return member;
	}
	//ㅇ수정
	public int update(Member member) throws SQLException {
		int result = 0;  				
		Connection conn = null;
		System.out.println("getId->"+member.getId());
		System.out.println("getName->"+member.getName());
		System.out.println("getAddress->"+member.getAddress());
		String sql = "update member2 set passwd=?,name=?,address=?, tel=? "
				   + "where id=?"; 
		System.out.println("sql->"+sql);
		PreparedStatement pstmt = null; 
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getId());
			result = pstmt.executeUpdate();
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}

	//ㅇ
	public int confirm(String id) throws SQLException {
		int result  = 0;  				
        Connection conn = null;
		String sql  = "select id from member2 where id=?"; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) result = 1;
			else result = 0;
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	
	public int delete(String id, String passwd) throws SQLException {
		int result  = 0;  				
		Connection conn = null;
		
		result = check(id, passwd);
		if (result != 1)  return result;
		String sql  = "delete from member2 where id=?"; 
		PreparedStatement pstmt = null; 				
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}

	
}
