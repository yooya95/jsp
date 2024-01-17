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
<style type="text/css">
	tr:HOVER { background-color: red; }
</style>
<body>
 <!--  Model 1 View -->
<%
	ArrayList<Professor> listProfessor = (ArrayList<Professor>)request.getAttribute("listProfessor");
%>
<h1>Model1 교수님</h1>
<table width="100%" bgcolor="yellow" border="1">
<tr><th>사번</th><th>이름</th><th>업무</th><th>급여</th></tr>
<%
 	
	for(int i = 0; i < listProfessor.size(); i++) {
	 	out.println("<tr><td>"+listProfessor.get(i).getProfno()+"</td>");
		out.println("<td>"+listProfessor.get(i).getName()+"</td>");
		out.println("<td>"+listProfessor.get(i).getPosition()+"</td>");
		out.println("<td>"+listProfessor.get(i).getSal()+"</td></tr>"); 
	} 
%>


</body>
</html>