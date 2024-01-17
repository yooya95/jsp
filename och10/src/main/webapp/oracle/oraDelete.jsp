<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../dbError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>스크릿틀릿 + Statement  삭제 Hw1 </h2>
<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String deptno = request.getParameter("deptno");
	System.out.println("deptno->"+deptno);

	String sql = "delete from dept where deptno="+deptno;
	System.out.println("sql->"+sql);
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,"scott","tiger");
	Statement stmt = conn.createStatement();
	int result = stmt.executeUpdate(sql);
	if (result > 0) out.println("삭제 성공 ㅎㅎ");
	else out.println("삭제실패 ㅠㅠ");
	stmt.close();	
	conn.close();

%>
</body>
</html>