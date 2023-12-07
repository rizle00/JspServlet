<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>aaa</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap Icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
   <body id="page-top">

        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container px-4 px-lg-5">
            	<a class="navbar-brand" href="#page-top">MybatisMVC</a>
            	
           
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link" href="list.cu">고객관리</a></li>
                        <li class="nav-item"><a class="nav-link" href="list.hr">HR조회</a></li>
                        <li class="nav-item"><a class="nav-link" href="list.jstl">JSTL연습</a></li>
                        <li class="nav-item"><a class="nav-link" href="list.sg">혼자 해보기</a></li>
                        
                         <c:if test="${empty logininfo }">
                    
                    
                        <li class="nav-item"><a class="nav-info m-3" href="loginpage.me">로그인</a></li>
                        <li class="nav-item"><a class="nav-info" href="joinpage.me">회원가입</a></li>
                        
                        </c:if>
                        
                        <c:if test="${not empty logininfo }">
                        <li class="nav-item"><span class="nav-link">${logininfo.name}님 환영합니다.</span></li>
                        <li class="nav-item"><a class="nav-info" href="logout.me">로그아웃</a></li>
                        </c:if>
                    </ul>
                    
                   
                    
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead position-relative">
         
          <div class="w-100 h-100 bg-black"
        style="position: absolute; top: 0px; left: 0px;  z-index: -2;"
        ></div>
        
           <video class="w-100 h-100" src="assets/img/visual.mp4" autoplay muted loop 
        style="position: absolute; top: 0px; left: 0px; opacity: 0.3; object-fit: cover; z-index: -1;"
        ></video>
        
            <div class="container px-4 px-lg-5 h-100">
                <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
                    <div class="col-lg-8 align-self-end">
                        <h1 class="text-white font-weight-bold">201 Mybatis MVC</h1>
                        <hr class="divider" />
                    </div>
                    <div class="col-lg-8 align-self-baseline">
                        <p class="text-white-75 mb-5">Mybatis MVC Master</p>
                        <a class="btn btn-primary btn-xl" href="#about">Find Out More</a>
                    </div>
                </div>
            </div>
        </header>