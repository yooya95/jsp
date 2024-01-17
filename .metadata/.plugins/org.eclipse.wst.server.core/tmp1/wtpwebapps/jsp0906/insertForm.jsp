<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<body>
<jsp:include page="navHeader.jsp"></jsp:include>

 <section class="py-3 text-center container">
<div class="col-lg-15 col-md-15 mx-auto">
 </div>
</section> 
  <div class="album py-5 bg-body-tertiary">
 
	<form action="insertSawon.do">
	<legend>사원 신규 등록</legend>
	<table>
		<tr>
			<td>사   번 : </td><td><input type="text" name="sabun" value="${sabun}" required="required"></td>
		</tr>
		<tr>
			<td>이   름 : </td><td><input type="text" name="sawon_name" value="${sawon_name}" required="required"></td>
		</tr>
		<tr>
			<td>급   여 : </td><td><input type="text" name="sal" value="${sal}" required="required"></td>
		</tr>
		<tr>
			<td>전화번호 : </td><td><input type="text" name="handphone" value="${handphone}" required="required"></td>
		</tr>	
	
	</table>
	<input type="submit" value="입력완료">	
	<input type="reset" value="입력취소">	
	</form>


</body>
</html>