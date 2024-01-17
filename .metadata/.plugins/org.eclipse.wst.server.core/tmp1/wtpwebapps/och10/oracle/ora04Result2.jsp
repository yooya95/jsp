<%@page import="och10.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Expression 부서정보</h2>
<%
	//Dept dept	 	 = (Dept)request.getAttribute("dept");
	Dept deptObj 	 = (Dept)request.getAttribute("dept");
%>
	부서코드1	: <%=deptObj.getDeptno() %><p>
	부서명   	: <%=deptObj.getDname() %><p>
	근무지 	: <%=deptObj.getLoc() %><p>
 <%--    부서코드2 	: <%=deptObj.deptno %><p> 	X 구문 에러 : Dept.deptno is not visible --%>
<%--  부서코드3 	: <%=dept.deptno %><p> 		X 구문 에러 : dept cannot be resolved to a visible --%>
	<p>
	
	<h2>EL 표기법 부서정보</h2>
	부서코드4	: ${dept.deptno }<p>
	부서명 	: ${dept.dname }<p>
	근무지 	: ${dept.loc }<p>
	부서코드5 	: ${dept.getDeptno() }<p> 	<!-- O : 값 가져옴 -->
	부서코드6 	: ${deptObj.getDeptno() }<p><!-- X : 구문 에러는 아니나 값 못 가져옴 -->
</body>
</html>