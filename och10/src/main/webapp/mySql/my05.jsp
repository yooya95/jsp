<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="och10.Professor"%>
<%@page import="java.util.ArrayList"%>
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

  // select profno,name,position,sal from Professor
  // Multi Row --> al
  // my05Result1.jsp   --> Model1
  // my05Result2.jsp   --> Model2
	String driver = "com.mysql.cj.jdbc.Driver" ;
	String url    = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
	String sql = "select profno,name,position,sal from Professor";
 	//      여러Row의 Professor 가지고 다님 
	ArrayList<Professor> alProf = new ArrayList<Professor>();
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,"root","mysql80");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	//9901	김도훈	교수	500
	//9902	이재우	조교수	320
	//9903	성연희	조교수	360
	//9904	염일웅	전임강사	240
	//9905	권혁일	교수	450
	//9906	이만식	부교수	420
	//9907	전은지	전임강사	210
	//9908	남은혁	부교수	400
	if (rs.next()) {
		do {
			Professor p = new Professor();
			p.setProfno(rs.getInt(1));    
			p.setName(rs.getString(2));
			p.setPosition(rs.getString(3)); 
			p.setSal(rs.getInt(4));
			alProf.add(p);
		}while(rs.next());
		request.setAttribute("listProfessor", alProf);
		rs.close();  
		stmt.close();  
		conn.close();
		// RequestDispatcher rd=request.getRequestDispatcher("my05Result1.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("my05Result2.jsp");
		rd.forward(request, response);
	} else { 
		out.println("데이터가 없습니당");
		stmt.close();  
		conn.close();	
	} 
	






%>
</body>
</html>