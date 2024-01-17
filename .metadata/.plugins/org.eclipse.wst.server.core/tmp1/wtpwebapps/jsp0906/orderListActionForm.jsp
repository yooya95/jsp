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

<div class="album py-5 bg-body-tertiary">
  <h3 align="center">주문조회</h3>
<form action="main.jsp">
<table class="table table-striped">
	<tr>
	<th>주문일자</th><th>거래처명</th><th>거래처요청사항</th><th>담당사원</th><th>주문상태</th><th>주문추가 및 상세조회</th>
	</tr>
	<c:forEach var="order1" items="${orderList}">
	
	<tr>
	<td>${order1.order_date }</td>
	<td>${order1.custcode } ${order1.custname}</td>
	<td>${order1.order_desc }</td>
	<td>${order1.sabun } ${order1.sawon_name}</td>
	<td>${order1.order_state }</td>
	<td>
	<input type="button" value="주문 추가 및 상세조회"
	onclick="location.href='orderUpdateForm.do?custcode=${order1.custcode}&order_date=${order1.order_date}'">
	</td>
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