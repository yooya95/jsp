<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
// 1. dno이용 division TBL 조회 
// 2. 각각 column명 그대로 request 저장 
// 3.  myResult.jsp로 Page 이동
//   3-1.   <h2>부서 정보 수정</h2>
//   3-2.  부서코드 -> 그냥 조회만  & hidden(dno)
//   3-3.  부서명 -> dname(value->EL)
//   3-4.  전화번호-> phone(value->EL)
//   3-5.  근무지-> position(value->EL)

	String driver= "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scottdb?characterEncoding=UTF-8&serverTimezone=UTC";
	String dno = request.getParameter("dno");
	String sql = "select * from division where dno="+dno;
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,"root","mysql80");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	if (rs.next()) {
		request.setAttribute("dno", dno);
		request.setAttribute("dname", rs.getString(2));
		request.setAttribute("phone", rs.getString(3));
		request.setAttribute("position", rs.getString(4));
		rs.close();  
		stmt.close();  
		conn.close();
		RequestDispatcher rd=request.getRequestDispatcher("myResult.jsp");
		rd.forward(request, response);
	}
	stmt.close();  
	conn.close();
%>
<script type="text/javascript">
	alert("헐~ 없는 부서야");	
    location.href = "myUpdate.html";
</script>

</body>
</html>