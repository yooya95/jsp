<%@page import="java.util.Enumeration"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

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
    //인코딩 설정
	request.setCharacterEncoding("utf-8");
	//    업로드할 수 있는 파일최대 크기 5MB 설정
	int maxSize = 5 *1024 *1024;
	// 업로드된 파일이 저장될 경로
	String fileSave = "/fileSave";
	//Meta Data , 상대 경로를 절대 경로로 변환하여 실제 저장 경로를 구함
	String realPath = getServletContext().getRealPath(fileSave);
	System.out.println("realPath->" + realPath); 
	
	//업로드된 파일을 처리하기 위해 MultipartRequest 객체를 생성
	// 이 객체를 생성하면 업로드된 파일이 지정한 경로에 저장되며, 여러 메서드를 통해 업로드된 파일의 정보를 가져올 수 있음
	MultipartRequest multi =
		 new MultipartRequest(
								 request,   // HttpServletRequest 객체
								 realPath,  // 파일 저장 경로
								 maxSize,    // 최대 업로드 파일 크기
								 "utf-8",   // 인코딩 타입
								  new DefaultFileRenamePolicy() // 파일 이름 중복 시 이름 변경 정책
							  );
	
	//업로드된 파일들의 파라미터 이름을 열거형으로 가져오고 파일에 대한 정보를 출력
	//각 파일마다 파라미터 이름을 가지고 있으며, 이 이름을 이용하여 업로드된 파일의 정보를 가져올 수 있습니다.
	Enumeration en = multi.getFileNames();
	while (en.hasMoreElements()) {
		//input 태그의 속성이 file인 태그의 name 속성값 : 파라미터 이름
		String parameterName = (String)en.nextElement();
		//서버에 저장된 파일 이름
		String serverSaveFilename = multi.getFilesystemName(parameterName);
		//전송전 원래의 파일 이름
		String original = multi.getOriginalFileName(parameterName);
		//전송된 파일 내용 타입
		String type = multi.getContentType(parameterName);
		//전송된 파일속성이 file인 태그의 name 속성값을 이용해 파일 객체 생성
		File file = multi.getFile(parameterName);
		
		//파일 정보를 출력
		out.println("real Path : " + realPath + "<br>");
		out.println("파라미터 이름 : " + parameterName + "<br>");
		out.println("실제 파일 이름 : " + original + "<br>");
		out.println("저장된 파일 이름 : " + serverSaveFilename + "<br>");
		out.println("파일 타입: " + realPath + "<br>");
		if (file !=null) {
			out.println("크기 : " +file.length()+"<br>");
		}
	}
	// 사용자가 입력한 이름과 제목을 가져온다.
	                     //request 아님
	String name = multi.getParameter("name");
	String title = multi.getParameter("title");

	//Dto Setting
	//DML -->DAO
	
	
	
%>


</body>
</html>