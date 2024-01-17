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
<div id="header">
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		  <div class="container-fluid">
		    <a class="navbar-brand"href="main.do" >YYA</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		 
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" color = "black">
		            사원관리
		          </a>
		          <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="sawonList.do" >사원조회</a></li>
		            <li><a class="dropdown-item" href="insertSawon.do">사원등록</a></li>
		          </ul>
		        </li>

		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            제품관리
		          </a>
		          <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="itemSelectAction.do">제품조회</a></li>
		            <li><a class="dropdown-item" href="itemInsertFormAction.do">제품등록</a></li>
		          </ul>
		        </li>

		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            거래처관리
		          </a>
		           <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="#">거래처조회</a></li>
		            <li><a class="dropdown-item" href="#">거래처등록</a></li>
		          </ul>
		        </li>

		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            주문관리
		          </a>
		         <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="#">주문조회</a></li>
		            <li><a class="dropdown-item" href="#">주문등록</a></li>
		          </ul>
		        </li>
		        

		      </ul>
		      <form class="d-flex">
		        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
		        <button class="btn btn-outline-success" type="submit">Search</button>
		      </form>
		    </div>
		  </div>
		</nav>   
	</div>
	
 <section class="py-3 text-center container">
<div class="col-lg-15 col-md-15 mx-auto">
 </div>
</section> 
  <div class="album py-5 bg-body-tertiary">
	
	<form action="updateItem.do" method="post">
	<input type="hidden" name="item_code" value="${item.item_code}">
	<%-- <input type="hidden" name="item_birth" value="${item.item_birth}"> --%>
	<fieldset>
	<legend>제품정보변경</legend>
	<table>
	<tr>
		<td>제품코드:</td> <td>${item.item_code}</td> 
   </tr>
    <tr>
    <td>제품명:</td> <td> <input type="text" name="item_name" value="${item.item_name}" required="required"></td>  
    </tr>
    <tr>
    <td>제품가격:</td> <td>  <input type="text" name="item_price" value="${item.item_price}" required="required"></td>  
     </tr>
    <tr> 
    <td>제품단위: </td> <td> <input type="text" name="item_kind" value="${item.item_kind}" required="required"></td>  
    </tr>
     <tr> 
    <td>제품내용: </td> <td> <input type="text" name="item_desc" value="${item.item_desc}" required="required"></td>  
    </tr>
     <tr> 
    <td>제품출시: </td> <td> <input type="text" name="item_birth" value="${item.item_birth}" required="required"></td>  
    </tr>
    </table>
   
    <input type="submit" value="수정완료"> 
    
     
</fieldset>
</form>
</div>
		
</body>
</html>