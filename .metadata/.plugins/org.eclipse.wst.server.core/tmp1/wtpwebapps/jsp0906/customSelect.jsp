<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   table { width: 80%; }
</style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<body>
<jsp:include page="navHeader.jsp"></jsp:include>
  <div class="album py-5 bg-body-tertiary">
  <h3 align="center">거래처조회</h3>
<form action="main.jsp">
<table class="table table-striped">
	<tr>
		<th>거래처코드</th><th>거래처명</th><th>거래처tel</th><th>거래처구분</th><th>거래처대표</th><th>거래처삭제</th><th>거래처수정</th>
	</tr>
	<c:forEach var="custom" items="${customList}">
	<tr>
		<td>${custom.custcode}</td>
		<td>${custom.custname}</td>
		<td>${custom.cust_tel}</td>
		<td>${custom.cust_gubun}</td>
		<td>${custom.cust_ceo}</td>
	  <td><input type="button" value="삭제"
       onclick="location.href='customDeleteForm.do?custcode=${custom.custcode}&custname=${custom.custname}'"></td>
       <td><input type="button" value="수정"
       onclick="location.href='custUpdateForm.do?custcode=${custom.custcode}&custname=${custom.custname}'"></td>
	  </tr>
	
	</c:forEach>


</table>
 <div class="col-md-6 offset-md-5">                        
	<button type="submit" class="btn btn-primary" value="메인메뉴 이동">메인메뉴 이동</button>
</div>

</form>
</div>


</body>
</html>