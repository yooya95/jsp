<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>연산결과 오류시 error Page이동</h2>
  <%
	  try {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			out.println(num1 + " + " + num2 + " = " + (num1+num2)+"<p>");
			out.println(num1 + " - " + num2 + " = " + (num1-num2)+"<p>");
			out.println(num1 + " * " + num2 + " = " + (num1*num2)+"<p>");
			out.println(num1 + " / " + num2 + " = " + (num1/num2)+"<p>");
	  } catch (Exception e) {
			// Page 이동 -> error 처리 
			// 1. Error Page 선언
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			// 2. Error Page 이동
			rd.forward(request, response);
	  } 
	  
  
  %>
  
  
  
  
</body>
</html>