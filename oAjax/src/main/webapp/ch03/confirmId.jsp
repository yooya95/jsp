<%@page import="oAjax.MemberDao"%>
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
    // parameter Value(1001)       parameter 명
    String id        =           request.getParameter("id");
    System.out.println("id->"+id);
    MemberDao memberDao = MemberDao.getInstance();
    
    // member1  Read 
    // id 존재  --> return 1
    // id 존재X --> return 0

    int result = memberDao.confirm(id); 
	if (result == 0) {
		out.println("사용할 수 있는 ID입니다");
	} else {   // 1
	    out.println("이미 있는 아이디니 다른 것을 사용하세요");
	}



%>
</body>
</html>