<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here333</title>
</head>
<body>
<%
	GregorianCalendar gc = new GregorianCalendar();
    String date = String.format("%TF %TT<br>",gc, gc);
%>
<%=date %>
</body>
</html>