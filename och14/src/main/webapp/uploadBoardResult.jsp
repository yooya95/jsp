
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String context = request.getContextPath();
	System.out.println("conetext->"+context);

%>
	<h2>파일 업로드 전송결과 upLoadFilename</h2>
	<h2>Title ---> ${title }</h2>
	upLoad          사진2 : <img src="<%=context%>/${filename }"><p>
	upLoadFilename  사진3 : <img src="${upLoadFilename }"><p>
	upLoadFilename  사진4 : <img src="${realPath }/${upLoadFilename }"><p>
	
</body>
</html>