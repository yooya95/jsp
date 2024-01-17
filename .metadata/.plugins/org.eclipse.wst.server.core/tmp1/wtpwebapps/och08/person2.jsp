<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- Bean 선언 person -->
  <!-- 1. Person person = new Person(); -->
  <jsp:useBean id="person" class="och08.Person" scope="request"  />

  <!-- Bean 값 저장 -->
 <%--  <jsp:setProperty property="*" name="person"/> --%>
   <jsp:setProperty property="age"    name="person"/>
   <jsp:setProperty property="gender" name="person"/>
   <jsp:setProperty property="name"   name="person"/>
   <!-- 2. person.setName("홍길동"); -->
   
  <!-- Bean 값 가져오기 -->
 
  <!-- Bean Page 이동 personResult.jsp -->
  <jsp:forward page="personResult.jsp"/>

</body>
</html>