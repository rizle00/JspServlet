<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Bootstrap 5 404 page with image</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="d-flex align-items-center justify-content-center vh-100">
            <div class="text-center row">
                <div class=" col-md-6">
                    <img src="https://cdn.pixabay.com/photo/2017/03/09/12/31/error-2129569__340.jpg" alt=""
                        class="img-fluid">
                </div>
                <div class=" col-md-6 mt-5">
                    <p class="fs-3"> <span class="text-danger">올퓨!</span> P페이지를 찾을 수 없습니다다.</p>
                    <p class="lead">
                        경로를 확인하거나 홈에서 다시 접근해주세요
                    </p>
                     <!--a태그 href에 / 는 root를 의미함 
                     	/home
                      c:url 서버 측에서 URL을 상대적으로 동적으로 구성할 수 있도록 해주는 태그 -->
                    <a href='<c:url value="/"/>' class="btn btn-primary">Go Home</a>
                </div>
				
            </div>
        </div>
    </body>

</html>