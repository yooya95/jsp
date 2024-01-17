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
<jsp:include page="navHeader.jsp"></jsp:include>
<c:if test="${result >0 }">
	<script type="text/javascript">
		alert("삭제완료");
		location.href = "main.do?custcode=${custom.custcode}&custname=${custom.custname}";
	</script>
</c:if>
<c:if test="${result ==0 }">
	<script type="text/javascript">
		alert("삭제실패");
		location.href="customDeleteForm.do?=${custom.custcode}$custname=${custom.custname}";
	</script>

</c:if>

</body>
</html>