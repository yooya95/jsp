<%@page import="com.mysql.cj.conf.ConnectionUrl.Type"%>
<%@page import="java.sql.Types"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../dBError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 	//데이터 연결
 	Context ctx = new InitialContext();
 	DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
 	Connection conn = ds.getConnection();
	
 	//sql문 작성 및 프로시저 호출 후 sql 실행 	
 	int empno = Integer.parseInt(request.getParameter("empno"));
 	String sql = "{call Emp_Info3(?,?)}";
 	CallableStatement cs = conn.prepareCall(sql);
 	
 	cs.registerOutParameter(2, Types.DOUBLE);
 	cs.setInt(1, empno);
 	cs.execute();
 	out.println("급여 :" + cs.getDouble(2));
 	
 	cs.close();
 	conn.close();
 	
 %>
</body>
</html>