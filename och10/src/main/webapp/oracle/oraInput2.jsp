<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	
	request.setCharacterEncoding("utf-8");
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	String dname  = request.getParameter("dname");
	String loc    = request.getParameter("loc");
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String sql = "INSERT into dept VALUES (?,?,?)";
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,"scott","tiger");
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, deptno);	
	pstmt.setString(2, dname); 
	pstmt.setString(3, loc);
	int result = pstmt.executeUpdate();
	if (result > 0) out.println("입력 성공 ㅋㅋ");
	else out.println("입력 실패 흑유흑유");
	pstmt.close(); 
	conn.close();
%>

</body>
</html>