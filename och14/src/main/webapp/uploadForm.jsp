<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
<h2>jsp 파일 업로드</h2>
<form action="upload.jsp" method="post" enctype="multipart/form-data">
	<label for="name">작성자</label> :
		 <input type="text" name="name" id="id" required="required"><p> 
	제목:  <input type="text" name="title"        required="required"><p>
	파일명: <input type="file" name="uploadFile"   required="required"><p>
	<input type="submit" value="확인">
</form>
</body>
</html>