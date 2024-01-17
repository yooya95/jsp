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
		<td>주문일자</td><td>거래처명</td><td>주문내용</td><td>접수사원</td><td>접수상태</td>
		</tr>
		
		<tr><td>${order.order_date}</td>
		<td>${order.custname}</td>
		<td>${order.order_desc}</td>
		<td>${order.sawon_name}</td>
		<td>${order.order_state}</td></tr>
		
		</table>
	
<br><br><br>		
<h3>주문 상세 추가 입력</h3>
	<form action="orderDetailInsert.do?">
	<input type="hidden" name="order_date" value="${order.order_date}"> 
	<input type="hidden" name="custcode" value="${order.custcode }">
	<table class="table table-striped">
		<tr>
		<td>제품</td><td>제품주문내용</td><td>제품수량</td><td>상세추가입력</td>
		</tr>
		<tr>
		<td>
			<select name="item" > 
				<c:forEach var="item" items="${itemList}">
					<option value="${item.item_code}">${item.item_code}${item.item_name}</option>
				</c:forEach>
			</select>
		</td>
		<td><input type="text" name="item_order_desc" value="${order_detail1.item_order_desc }"> </td>
		<td><input type="text" name="item_count" value="${order_detail1.item_count}"> </td>
		<td><input type="submit" value="거래처제품 추가등록">
		<%-- onclick="location.href='orderDetailInsert.do?order_date=${order.order_date}&item_code=${item.item_code}'" --%>
		
		</td>
		
		</tr>	
	</table>
	</form>
<br><br><br>

<h3>주문 상세 리스트</h3>
	<table class="table table-striped">
		<tr>
		<td>제품코드</td><td>제품명</td><td>제품주문내용</td><td>제품수량</td>
		</tr>
		<c:forEach var="order_detail1" items="${detailList}">
		<tr>
		<td>${order_detail1.item_code}</td>
		<td>${order_detail1.item_name}</td>
		<td>${order_detail1.item_order_desc}</td>
		<td>${order_detail1.item_count}</td>
		</tr>
		</c:forEach>
	</table>	
</div>
</body>
</html>