<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<h3>주문 거래처내용</h3>
	<table class="table table-striped" >
		
		<tr>
			<td>주문일자</td>
			<td>${order.order_date}</td>
		</tr>
		<tr>
			<td>거래처명</td>
			<td>${order.custname}</td>
		</tr>
		<tr>
			<td>주문내용</td>
			<td>${order.order_desc}</td>
		</tr>
		<tr>
			<td>접수사원</td>
			<td>${order.sawon_name}</td>
		</tr>
		<tr>
			<td>접수상태</td>
			<td>${order.order_state}</td>
		</tr>
	</table>
	
		<!-- 주문 상태가 0일 때만 버튼을 활성화 -->
		<c:if test="${order.order_state == 0}">
		  <input type="button" value="제품추가" 
    onclick="location.href='orderUpdateForm2.do?custcode=${order.custcode}&amp;order_date=${order.order_date}'">   
		</c:if>
		
		<input type="button" value="제품목록"
		onclick="location.href='orderListAction.do?custcode=${order.custcode}&order_date=${order.order_date}'">
		

</div>
</body>
</html>