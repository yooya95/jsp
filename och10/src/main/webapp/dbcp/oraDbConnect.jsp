<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>DBCP 연결</h2>
  <%
  	 Context    cxt = new InitialContext();
     DataSource ds  = (DataSource)cxt.lookup("java:comp/env/jdbc/OracleDB");
     Connection conn = ds.getConnection();
     if(conn != null)  out.println("연결 성공");
     else              out.println("헐 ~ ㅠㅠ");
     conn.close();

  
  %>
</body>
</html>