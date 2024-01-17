<%@page import="org.eclipse.jdt.internal.compiler.ast.WhileStatement"%>
<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="och10.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../dbError.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Emp> alEmp = new ArrayList<Emp>();
   
    Context ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
	Connection conn = ds.getConnection();
	
	String sql = "select empno, ename from emp";
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	while (rs.next()) {
		
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt(1));
		emp.setEname(rs.getString(2));
		alEmp.add(emp);	
	}
	request.setAttribute("empList", alEmp);	
	rs.close();
	stmt.close();
	conn.close();
	
%>
	 <h2>보고싶은 사원 번호를 선택하세요</h2>
	 <form action="oraCallEmpInfo.jsp">
	<select name="empno">
		<c:forEach var="emp" items="${empList }"> 
		<option value="${emp.empno }">${emp.empno } ${emp.ename } </option>
		</c:forEach>
	</select>
	<input type="submit" value="선택완료">
	</form>
</body>
</html>