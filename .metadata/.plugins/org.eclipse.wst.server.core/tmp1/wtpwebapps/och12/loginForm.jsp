
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table {
  	    background-color: pink;
    	border-collapse: collapse;
  }
  tr {
  	 font-size: 14px;
  	 text-align: left;
  	  }

</style>


</head>
<body>
  <h3></h3>
  <form action="loginPro.jsp" method="post">
  	<h3> Login (Manager) </h3>
	<table border="1">
		<tr><td>id</td><td>      <input        type="text"     name="id"      required="required"></td></tr>
		<tr><td>password</td><td><input       type="password"       name="passwd"  required="required"></td></tr>
		<tr>
		    <td><input type="submit" value="login"></td>
			<td><input type="reset" value="reset" ></td>
		</tr>	
	</table>
	
  </form><p>

</body>
</html>