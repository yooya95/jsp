<%@page import="och11.MemberDao"%>
<%@page import="och11.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="dbError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String chk = "";
	String agree = request.getParameter("agree");
	
	if (agree.equals("y")) {
		// 세션데이터를 가져옴
		String id = (String)session.getAttribute("id");
		String password = (String)session.getAttribute("password");
		String name = (String)session.getAttribute("name");
	
		System.out.println("Subscribe id->"+id);
		System.out.println("Subscribe password->"+password);
		System.out.println("Subscribe name->"+name);
		
		// Member1 TBL Insert  dto는 데이터 객체! getter와 setter메서드만 가진 클래스! , 데이터 교환을 위해 사용되는 객체
		MemberDto member = new MemberDto();
		member.setId(id);  
		member.setName(name); 
		member.setPassword(password);
		
		//dao 의 역할은 실제 db의 데이터에 접근하여 데이터를 삽입, 조회, 수정,삭제 등의 crud 기능을 수행한다. (서비스와 데이터베이스를 연결하는 고리역할)
		MemberDao md = new MemberDao();
		int result = md.insert(member);
		
		if (result > 0) chk = "success";
		else chk = "fail";
		
	} else chk = "fail";
	
	session.invalidate();
	out.print("invalidate() 적용후에도 "+session.getId()+"<br>");
	response.sendRedirect("result.jsp?chk="+chk);

%>
</body>
</html>