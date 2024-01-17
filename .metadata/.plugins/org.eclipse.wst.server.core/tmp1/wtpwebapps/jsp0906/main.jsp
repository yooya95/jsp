<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		    <a class="navbar-brand" href="main.do" >YYA</a>
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
		            <li><a class="dropdown-item" href="insertForm.do">사원등록</a></li>
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
		            <li><a class="dropdown-item" href="customSelectAction.do">거래처조회</a></li>
		            <li><a class="dropdown-item" href="customInsertFormAction.do">거래처등록</a></li>
		          </ul>
		        </li>

		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            주문관리
		          </a>
		         <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="#">주문조회</a></li>
		            <li><a class="dropdown-item" href="orderInsertFormAction.do">주문등록</a></li>
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

	
<div id="content">  
	 <section class="py-5 text-center container">
    	<div class="row py-lg-5">
    	</div>
  	</section> 

  <div class="album py-5 bg-body-tertiary">
    <div class="container">

  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-4">
        <div class="col">
          <div class="card  shadow-sm">
          	 <img src="images/sawon.png" width="100%" height="250" class="card-img-top" alt="사원등록">
            <div class="card-body">
              <p class="card-text"> 전체 사원리스트 조회, 수정, 삭제, 등록메뉴</p>
              <div class="d-flex justify-content-between align-items-center">
                  <a class="btn btn-primary btn-lg" href="sawonList.do" role="button">사원조회</a>
           		  <a class="btn btn-primary btn-lg" href="insertForm.do" role="button">사원등록</a>
                
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card mb-3shadow-sm">
            	 <img src="images/clothes.png" width="100%" height="300" class="card-img-top" alt="제품등록">
              <p class="card-text">제품리스트 조회, 수정, 삭제 등록 메뉴</p>
              <div class="d-flex justify-content-between align-items-center">
                   <a class="btn btn-primary btn-lg" href="itemSelectAction.do" role="button">제품조회</a>
                   <a class="btn btn-primary btn-lg" href="itemInsertFormAction.do" role="button">제품등록</a>
                  
              </div>
            </div>
          </div>
        
         <div class="col">
          <div class="card shadow-sm">
         	 <img src="images/company.png" width="100%" height="250" class="card-img-top" alt="거래처등록">
            <div class="card-body">
              <p class="card-text">거래처리스트 조회, 수정, 삭제, 등록 메뉴 </p>
              <div class="d-flex justify-content-between align-items-center">
                
                  <a class="btn btn-primary btn-lg" href="customSelectAction.do" role="button">거래처조회</a>
                      <a class="btn btn-primary btn-lg" href="customInsertFormAction.do" role="button">거래처등록</a>
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
           	 <img src="images/order.png" width="100%" height="250" class="card-img-top" alt="주문등록">
            <div class="card-body">
              <p class="card-text">거래처 주문내역 조회,수정, 삭제, 등록 메뉴</p>
              <div class="d-flex justify-content-between align-items-center">
               
  				  <a class="btn btn-primary btn-lg" href="orderListAction.do" role="button">주문조회</a>
                  <a class="btn btn-primary btn-lg" href="orderInsertFormAction.do" role="button">주문등록</a>
               
              </div>
            </div>
          </div>
        </div>
        
   </div>  
       
	   
	<!-- <img alt="회원이미지" src="images/fashion.jpg" width="1800" height="500"> -->
	</div>
	<footer class="py-5 text-center text-body-secondary bg-body-tertiary">
  <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
  <p class="mb-0">
    <a href="#">Back to top</a>
  </p>
</footer>
<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</body>
</html>