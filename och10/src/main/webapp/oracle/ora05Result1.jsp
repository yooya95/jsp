<%@page import="och10.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   tr:hover {
	  background-color: red;
   }
</style>
</head>
<body>
    <h2>Model 1  View</h2>
    <% 
        ArrayList<Emp> al = (ArrayList<Emp>)request.getAttribute("al");
    %> 
<!--    
    empno   ename     job       sal 
0   1100	강한빛	PRESIDENT	3630
1	1000	강준우	CLERK	    3300
2	1300	강한나		        3300
	5002	del2		
	8111	김태현	MANAGER	    3200
	7935	곽나희	MANAGER	    3000
	1400	곽승현	MANAGER	    3000
	3000	김용빈		        3500
	3100	김찬하		        3500 
	Model 1
-->
    <table width="100%" bgcolor="yellow" border="1">
		<tr><th>사번</th><th>이름</th><th>업무</th><th>급여</th></tr>
		<%
			for(int i = 0; i < al.size(); i++) {
				out.println("<tr><td>"+al.get(i).getEmpno()+"</td>");
				out.println("<td>"+al.get(i).getEname()+"</td>");
				out.println("<td>"+al.get(i).getJob()+"</td>");
				out.println("<td>"+al.get(i).getSal()+"</td></tr>");
			}
		%>
    
    </table>
</body>
</html>