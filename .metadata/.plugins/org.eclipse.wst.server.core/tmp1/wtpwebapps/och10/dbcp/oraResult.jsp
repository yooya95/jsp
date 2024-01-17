<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2> 사원정보 </h2>
 사번 : ${emp.empno }
 이름 : ${emp.ename }
급여 :  <fmt:formatNumber  value="${emp.sal }"       groupingUsed="true"/><p>
입사일 : <fmt:formatDate    value="${emp.hiredate }"  pattern="yyyy/MM/dd"/>
</body>
</html>