<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result>0 }">
		<script type="text/javascript">
			alert("제품 추가등록 완료");
			location.href="main.do?custcode=${custcode}&order_date=${order_date}";
		</script>
	</c:if>
	<c:if test="${result==0 }">
		<script type="text/javascript">
			alert("제퓸 추가등록 실패");	
			location.href="orderUpdateForm2.do?custcode=${custcode}&order_date=${order_date}";
		</script>
	
	</c:if>
</body>
</html>