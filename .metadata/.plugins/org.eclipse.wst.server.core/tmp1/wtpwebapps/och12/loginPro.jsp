<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id     = request.getParameter("id");
	String passwd = request.getParameter("passwd");
    MemberDao md = MemberDao.getInstance();
    int result    = md.check(id, passwd);    

	// 존재하는 User   ---> PreparedStatement 사용
	if (result == 1) { 
		session.setAttribute("id",id);
		response.sendRedirect("main.jsp");
	// Password X
	} else if (result == 0) { 
%>
	
	<script type="text/javascript">
		alert("패스워드가 일치하지 않습니다.");	
		history.go(-1);
	</script>

<% 
   // result == -1
   } else {
%>
	<script type="text/javascript">
		alert("아이디가 일치하지 않습니다.");	
		history.go(-1);
	</script>
	
<% } %>    




</body>
</html>