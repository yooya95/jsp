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
<div class="album py-5 bg-body-tertiary">
	
<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-6 ">
                    <div class="card">
                        <div class="card-header">거래처를 삭제하려면 거래처코드와 거래처명을 입력하세요</div>
                        <div class="card-body">
                            <form action="deleteCustom.do" method="post" >
		   						<div class="form-group row">
                                    <label for="custcode" class="col-md-3 col-form-label text-md-right">거래처코드</label>
                                    <div class="col-md-6">
                                        <input type="text" id="custcode"class="form-control" name="custcode" value="${custcode}" required="required">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="custname" class="col-md-3 col-form-label text-md-right">거래처명</label>
                                    <div class="col-md-6">
                                        <input type="text" id="custname" class="form-control" name="custname" value="${custname}" required="required">
                                    </div>
                                </div>
						  
                         </div>
                                 <div class="col-md-8 offset-md-5">
                                      <button type="submit" class="btn btn-primary" value="삭제완료">
                                        삭제완료
                                      </button>
                                </div>
                      	 </form>       
                      </div>
             </div>
         </div>
     </div>
</main>
</div>

		


</body>
</html>