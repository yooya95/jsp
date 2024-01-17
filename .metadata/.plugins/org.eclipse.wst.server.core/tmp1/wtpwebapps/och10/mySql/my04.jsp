<%@page import="och10.Division"%>
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
<%
	
	String dno = request.getParameter("dno");
	String driver = "com.mysql.cj.jdbc.Driver";
	String url    = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
	String sql    = "select * from division where dno="+dno;
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,"root","mysql80");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	// 1. Division DTO 선언
    Division divi = new Division();
	if (rs.next()) {
		String dname = rs.getString("dname");  // rs.getString(2);
		String phone = rs.getString(3); 
		String position = rs.getString(4);
		// 2. Division DTO setting --> request저장
   	    divi.setDno(rs.getInt(1));
    	divi.setDname(dname);
    	divi.setPhone(rs.getString(3));
    	divi.setPosition(rs.getString(4));
    	request.setAttribute("division1",divi);
	// my04Result.jsp 이동 --> EL표기 
	} else out.println("그게 무슨 부서야 없는데");
	rs.close();	
	stmt.close();	
	conn.close();
	RequestDispatcher rd=request.getRequestDispatcher("my04Result.jsp");
	rd.forward(request, response);


%>
</body>
</html>