<%-- 
    Document   : Promotion
    Created on : 12-Feb-2022, 21:46:10
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

        <section id="aa-catg-head-banner">
            <div class="title text-center">
                <img src="${pageContext.request.contextPath}/assets/img/promotion.png" width="625px" height="159px">                    
            </div>
            <section id="aa-blog-archive">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="aa-blog-archive-area">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="aa-blog-content">
                                            <div class="row">
                                                <c:forEach items="${promotionList}" var="promotion">
                                                    <div class="col-md-4 col-sm-4" style="margin-bottom: 20px">
                                                        <article class="aa-blog-content-single">                        
                                                            <h4><a href="${pageContext.request.contextPath}/promotion_detail?id=${promotion.id}" style="color: #ffffff">${promotion.title}</a></h4>
                                                            <figure class="aa-blog-img">
                                                                <a href="${pageContext.request.contextPath}/promotion_detail?id=${promotion.id}"><img src="${pageContext.request.contextPath}/assets/img/promotion/${promotion.imageLink}" alt="farm products" height="180px" width="300px"></a>
                                                            </figure>
                                                            <div class="aa-article-bottom">
                                                                <div class="aa-post-date"><h4>${promotion.getFormatedDate()}</h4></div>
                                                            </div>
                                                        </article>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <!-- Blog Pagination -->

                                    </div>

                                </div>
                            </div>
                        </div>
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
    </body>
</html>