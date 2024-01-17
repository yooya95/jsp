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
<body>
<jsp:include page="navHeader.jsp"></jsp:include>

<div class="album py-5 bg-body-tertiary">	
<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-6 ">
                  <div class="card">
                      <div class="card-header">신규 주문등록</div>
                      <div class="card-body">
                         <form action="insertOrder.do" method="post" >
                         <div class="form-group row">
                         		<input type="hidden"  name="order_state" value="${order_state}">
                           		 <label for="order_date" class="col-md-3 col-form-label text-md-right">등록일자</label>
                                    <div class="col-md-6">
                                    <input type="text" id="order_date"class="form-control" name="order_date" value="${order_date}" required="required">         
                                    </div>
                            </div>
		   					<div class="form-group row">
                           		 <label for="custcode" class="col-md-3 col-form-label text-md-right">거래처명</label>
                                    <div class="col-md-6">
                                    	<select name="custom"  class="form-control">
                                    		<c:forEach  var="custom" items="${customList}">
                                    			<option value="${custom.custcode}"> "${custom.custname}"</option>	
                                    		</c:forEach>                                  
                                    	</select>
                                    	
                                        <%-- <input type="text" id="custcode"class="form-control" name="custcode" value="${custcode}" required="required"> --%>
                                    </div>
                            </div>

                            <div class="form-group row">
                                 <label for="custcode" class="col-md-3 col-form-label text-md-right">거래처요청내역</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="order_desc" value="${order_desc}" required="required">
                                    </div>
                            </div>
                            
                            <div class="form-group row">
                           		 <label for="custcode" class="col-md-3 col-form-label text-md-right">담당직원선택</label>
                                    <div class="col-md-6">
                                    	<select  name="sawon"  class="form-control" >
                                    		<c:forEach  var="sawon" items="${sawonList}">
                                    			<option value="${sawon.sabun}"> "${sawon.sabun} ${sawon.sawon_name}"</option>	
                                    		</c:forEach>      	
                                   		</select>     
                                    </div>
                            </div>
                            

					
                                 <div class="col-md-8 offset-md-5">
                                      <button type="submit" class="btn btn-primary" value="신규등록">
                                       신규등록
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