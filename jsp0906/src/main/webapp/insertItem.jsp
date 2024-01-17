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
			alert("신제품 등록이 정상적으로 처리되었습니다");
			location.href="main.do?item_name=${item.item_name}";
		</script>
	</c:if>
	<c:if test="${result==0 }">
		<script type="text/javascript">
			alert("신제품 등록시 오류가 발생하였습니다");	
			location.href="itemInsertFormAction.do?item_name=${item.item_name}";
		</script>
	
	</c:if>
</body>
</html>