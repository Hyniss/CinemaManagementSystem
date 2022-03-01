<%-- 
    Document   : Recruitment_detail
    Created on : 12-Feb-2022, 22:15:27
    Author     : Bảo Châu Bống
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Amazing Cinema</title>
        <!--CSS-->
        <!-- CSS -->

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/homepage.css" />
        <link href="assets/css/AboutCinema.css" rel="stylesheet" type="text/css"/> 
        <!--ICON-->
        <link rel="shortcut icon" href="resources/favicon.ico" type="image/x-icon">
        <!--FONTAWESOME-->
        <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
        <link href="${pageContext.request.contextPath}/assets/css/jquery-sakura.css" rel="stylesheet" type="text/css">
    </head>
    <header>
        <a href="${pageContext.request.contextPath}/home">
            <img class="logo" src="${pageContext.request.contextPath}/assets/img/logo.png" alt="logo"></a>
        <ul class="main-nav">
            <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/premere">
                    Movie</a></li>
            <li><a href="AboutCinema.jsp">About Cinema</a></li>
        </ul>
        <div class="clearfix"></div>
        <div class="row">
            <div class="heading-main-box">
                <h1 class="titles">Vietnamese people<br>use Vietnamese goods.<br>So join with us</h1>
            </div>
        </div>
    </header>
    <body>

        <section  class="member-details"  id="aa-blog-archive" style="background-color: #fff" class="member-details" style="padding-top:50px;padding-bottom: 50px; margin-left: 50px; margin-right: 50px">
            <div class="container" >

                <div class="col-lg-3 col-md-4">

                    <div class="col-lg-9 col-md-8">
                        </br>
                        <div class="member_designation">
                            <h2>|Vị trí cần tuyển: ${recruitment.getTitle()}|</h2>
                        </div>
                        </br>
                        <h4>Ngày ${recruitment.getDate()} </h4>

                        </br>
                        <div class="img-container">
                            <img src="${pageContext.request.contextPath}/assets/img/recruitment/${recruitment.getImg()}" alt="" class="img-full">
                        </div>
                        </br>
                        <div class="member_designation">
                            <h1>Mô tả</h1>
                            <p>${recruitment.getContent()}</p>
                        </div>
                        </br>
                        <a href="${pageContext.request.contextPath}/add_CV">Gửi CV tại đây</a>
                        </br>
                        </br>
                    </div>
                </div>
            </div>       
        </section>


        <!-- BOOTSTRAP5-->
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
        ></script>
        <!-- SCRIPT -->
        <script src="${pageContext.request.contextPath}/assets/js/script.js"></script>
        <!-- SAKURA -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery-sakura.js"></script>
        <script>
            $(window).load(function () {
                $('body').sakura();
            });
        </script>
    </body>
</html>