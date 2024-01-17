<%@page import="och10.Dept"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
<!--  DTO : Data Transfer Object  DAO : Data Access   Object -->
<%
	String deptno = request.getParameter("deptno");
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String sql = "select * from dept where deptno="+deptno;
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,"scott","tiger");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	// 1. DTO 선언
	Dept dept = new Dept();
	if (rs.next()) {
		String dname = rs.getString("dname");  // rs.getString(2);
		String loc = rs.getString(3);          // 숫자는 조회되는 컬럼 순서
		out.println("부서코드 : " + deptno +"<p>");
		out.println("부서명 : " + dname +"<p>");
		out.println("근무지 : " + loc +"<p>");	
		
		int deptnoInt = rs.getInt(1);  // deptno
		// 2. 각각이 아닌 종합하여 전달 --> DTO Setting 
		dept.setDeptno(deptnoInt);
		dept.setDname(dname);
		dept.setLoc(loc);
		
		// 3. Dept(DTO) 로 저장 
		request.setAttribute("dept", dept);
		
	} else out.println("그게 무슨 부서야 없는데");
	rs.close();	
	stmt.close();	
	conn.close();
	
	// ora04Result.jsp -->EL
	//RequestDispatcher rd = request.getRequestDispatcher("ora04Result.jsp");
	RequestDispatcher rd = request.getRequestDispatcher("ora04Result2.jsp");
	rd.forward(request, response);
%>
</body>
</html>