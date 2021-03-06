<%-- 
    Document   : Premere.jso
    Created on : 12-Feb-2022, 13:34:08
    Author     : Bảo Châu Bống
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1" />
        <!-- icon -->
        <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">
        <!-- link Fonts -->
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap"
            rel="stylesheet"
            />
        <!--BOOTSTRAP5-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <!--FONTAWESOME-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/queries.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/homepage.css" />

        <!-- Sakura -->
        <link href="${pageContext.request.contextPath}/assets/css/jquery-sakura.css" rel="stylesheet" type="text/css">
        <title>Amazing Cinema</title>
    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <!-- MOVIE -->
        <section class="product">
            <div class="row">
                <div class="title text-center">
                    <img src="${pageContext.request.contextPath}/assets/img/comingsoon.png" width="625px" height="159px">                    
                </div>
            </div>
            <div class="row" style="width: 96%; margin-left: 2%; margin-right: 2%">
                <c:forEach var="o" items="${movieComing}">
                    <div class="col-md-3 mt-4" >
                        <div class="card card-custom h-100 shadow-sm" style="position: relative"> 
                            <a href="movie?mid=${o.getMovieId()}"><img src="${pageContext.request.contextPath}/assets/img/movie/${o.getImage()}" class="aa-product-img shadow border-radius-lg card-header" position="absolute" top="0" left="0" display="block" width="100%" height="500px" margin-bottom ="20px" object-fit= "cover" alt="..."></a>
                            <div class="card-body">
                                <div class="clearfix mb-3 text-center"> 
                                    <h2 class="currency price-hp" style="color: #ff3333">${o.getMovieName()}</h2> 
                                </div>
                                <div class="clearfix mb-3"> 
                                    <h4 class="currency price-hp" style="color: #000">Thể loại: ${o.getCategoryMovie()}</h4> 
                                    <h4 class="currency price-hp" style="color: #000">Thời lượng: ${o.getDuration()} phút</h4> 
                                    <h4 class="currency price-hp" style="color: #000">Khởi chiếu: ${o.getFormatedDate()}</h4> 
                                </div>
                                <div class="text-center my-4 hover"> 
                                    <a href="movie?mid=${o.getMovieId()}" class="btn btn-primary">Xem ngay</a>
                                    <a href="movie?mid=${o.getMovieId()}" class="btn btn-booking fas fa-shopping-cart"> Mua vé</a>
                                </div>
                                <!-- <div class="clearfix mb-1"> <span class="float-start"><i class="far fa-question-circle"></i></span> <span class="float-end"><i class="fas fa-plus"></i></span> </div> -->
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div> 
        </section>

        <%@include file="template/footer.jsp" %>

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
