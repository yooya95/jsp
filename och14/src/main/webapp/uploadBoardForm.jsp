<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="uploadBoard3" method="post" enctype="multipart/form-data">
	<h1>server upload sample (uploadBoard3)</h1>
	<label for="name">작성자</label>:
		<input type="text" name="name" id="name"     required="required"><p>
	제목   : <input type="text" name="title" 		     required="required"><p>
	파일명1 : <input type="file" name="uploadFile" 	 required="required"><p>
	파일명2 : <input type="file" name="uploadFile2"    required="required"><p>
	<input type="submit" value="확인">
</form>

</body>
</html>