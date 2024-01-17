<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<body>
<jsp:include page="navHeader.jsp"></jsp:include>
<div class="album py-5 bg-body-tertiary">
	<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-6 ">
                    <div class="card">
                        <div class="card-header">사원정보를 삭제하려면 사번과 이름을 확인하세요</div>
                        <div class="card-body">
                         <form action="deleteSawon.do" method="post" >
                                
		     			<div class="form-group row">
                                  <label for=" sabun" class="col-md-3 col-form-label text-md-right">사번</label>
                                  <div class="col-md-6">
                                      <input type="text" id=" sabun"class="form-control" name="sabun" value="${sabun}" required="required">
                                  </div>
                         </div>

                         <div class="form-group row">
                                   <label for=" sabun" class="col-md-3 col-form-label text-md-right">이름</label>
                                   <div class="col-md-6">
                                        <input type="text" id=" sawon_name" class="form-control" name="sawon_name" value="${sawon_name}" required="required">
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
    </div>
</main>
</div>
		
</body>
</html>