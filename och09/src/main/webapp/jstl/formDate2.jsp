<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="date" value="<%=new Date() %>"></c:set>
<body>
	<h2>현재 날자와 시간</h2>
    <fmt:formatDate value="${date }" type="both" dateStyle="short"  timeStyle="short"  /><p>
    <fmt:formatDate value="${date }" type="both" dateStyle="medium" timeStyle="medium" /><p>
    <fmt:formatDate value="${date }" type="both" dateStyle="long"   timeStyle="long"/><p>
    <fmt:formatDate value="${date }" type="both" dateStyle="full"   timeStyle="full"/><p>
</body>
</html>