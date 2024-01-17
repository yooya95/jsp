<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
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
   <h2>EL표기법 + JSTL   Model 2  View --> forEach</h2>
   <table width="100%" bgcolor="yellow" border="1">
		<tr bgcolor="pink">
			<th>사번</th><th>이름</th><th>업무</th><th>급여</th>
		</tr>
<!--    
    empno   ename     job       sal 
0   1100	강한빛	PRESIDENT	3630
1	1000	강준우	CLERK	    3300
2	1300	강한나		        3300
	Model 2
-->
		<c:forEach var="emp" items="${al }">
			<tr><td>${emp.empno }</td><td>${emp.ename }</td>
				<td>${emp.job }</td><td>${emp.sal }</td></tr>
		</c:forEach>
	</table>

</body>
</html>