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
    // Data 가공
	String name = request.getParameter("name") +"님";
	String gender = request.getParameter("gender");
	int age = Integer.parseInt(request.getParameter("age")) ;
    age = age +5;
%>
	<jsp:useBean id="person" class="och08.Person" scope="request"/>
	
	<jsp:setProperty property="name"   name="person" value="<%=name %>" />
	<jsp:setProperty property="gender" name="person" value="<%=gender %>"/>
	<jsp:setProperty property="age"    name="person" value="<%=age %>"/>
	
	<jsp:forward page="personResult.jsp"></jsp:forward>

</body>
</html>