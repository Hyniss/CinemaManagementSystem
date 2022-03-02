<%-- 
    Document   : Homepage
    Created on : 09-Feb-2022, 00:20:55
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
        <!-- SLIDER -->
        <section class="slider">
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-indicators text-center">
                        <c:forEach items="${banners}" var="banner" varStatus="i" >
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="${i.index}" <c:if test="${i.index==0}"> class="active" aria-current="true"</c:if> aria-label="${banner.getTitle()}"></button>
                        </c:forEach>
                    </div>
                    <c:forEach items="${banners}" var="banner" varStatus="i">
                        <div class="carousel-item text-center ${i.index==0?'active':''}" >
                            <img src="${pageContext.request.contextPath}/assets/img/banner/${banner.getImg()}" width="80%" height="auto" alt="..." />
                        </div>  
                    </c:forEach>

                    <button class="carousel-control-prev" style="margin-left: 2%" type="button" data-bs-target="#carouselExampleCaptions"
                            data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" style="margin-right: 2%" type="button" data-bs-target="#carouselExampleCaptions"
                            data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </section>

        <!-- MOVIE -->
        <section class="product">
            <div class="row">
                <div class="title text-center">
                    <img src="${pageContext.request.contextPath}/assets/img/moviecollection.png" width="625px" height="159px">                    
                </div>
            </div>

            <div id="movie-content" class="row" style="width: 93%; margin:auto;">
                <c:forEach var="o" items="${listMovie}">
                    <div class="movie col-md-3 mt-4" >
                        <div class="card card-custom h-100 shadow-sm" style="position: relative"> 
                            <a href="movie?mid=${o.getMovieId()}"><img src="${pageContext.request.contextPath}/assets/img/movie/${o.getImage()}" class="aa-product-img shadow border-radius-lg card-header" position="absolute" top="0" left="0" display="block" width="100%" height="450px" margin-bottom ="20px" object-fit= "cover" alt="..."></a>
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

            <!--            Load more button    -->
            <div style="text-align:center; margin-top: 50px">
                <button onclick="loadMoreMovie()" type="button" class="btn btn-warning" style="width:120px; height: 50px;">Load more</button>
            </div>

        </section>


        <!-- PROMOTION -->
        <section class="slider">
            <div id="carouselExampleCaptions1" class="carousel slide" data-bs-ride="carousel" style="margin-bottom: 20px">
                <div class="carousel-inner">
                    <div class="carousel-indicators text-center">
                        <c:forEach items="${promotions}" var="p" varStatus="i" >
                            <button type="button" data-bs-target="#carouselExampleCaptions1" data-bs-slide-to="${i.index}" <c:if test="${i.index==0}"> class="active" aria-current="true"</c:if> aria-label="${p.getTitle()}"></button>
                        </c:forEach>
                    </div>
                    <c:forEach items="${promotions}" var="p" varStatus="i">
                        <div class="carousel-item text-center ${i.index==0?'active':''}" >
                            <figure class="aa-blog-img">
                                <a href="${pageContext.request.contextPath}/promotion_detail?id=${p.id}"><img src="${pageContext.request.contextPath}/assets/img/promotion/${p.imageLink}" alt="farm products" height="50%" width="50%"></a>
                            </figure>
                        </div>  
                    </c:forEach>

                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions1"
                            data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions1"
                            data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
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


        <!--        Java script function: Load more movie when click load more button-->
        <script>

                    function loadMoreMovie() {
                        var amount = document.getElementsByClassName("movie").length;
                        $.ajax({
                            url: "${pageContext.request.contextPath}/loadmoremovie",
                            type: "get",
                            data: {
                                exists: amount
                            },
                            success: function (data) {
                                var row = document.getElementById("movie-content");
                                row.innerHTML += data;
                            },
                            error: function (xhr) {
                                //Do something handle 
                            }
                        });
                    }

        </script>
    </body>
</html>