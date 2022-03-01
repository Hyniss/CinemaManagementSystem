<%-- 
    Document   : Showtimes
    Created on : 23-Feb-2022, 16:01:28
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

            <div class="row" style="width: 96%; margin-left: 2%; margin-right: 2%">
                <c:forEach var="o" items="${showtimes}">
                    <div class="col-md-3 mt-4" >
                        <div class="card card-custom h-100 shadow-sm" style="position: relative"> 
                            <div class="card-body">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/seat"></a>
                                <ul class="current"> 
                                    <div class="day">
                                        <span style="color: #717171;
                                              font-size: 15px;
                                              left: 4px;
                                              position: absolute;
                                              top: 4px">${o.getFormatedMonth()}</span>
                                        <em style="color: #717171;
                                            font-size: 15px;
                                            font-style: normal;
                                            left: 4px;
                                            position: absolute;
                                            top: 20px">${o.getFormatedDate()}</em>
                                        <strong style="color: #717171;
                                                font-size: 32px;
                                                font-weight: normal;
                                                left: 31px;
                                                line-height: 32px;
                                                position: absolute;
                                                top: 8px">${o.getFormatedDay()}</strong>
                                    </div>
                                </ul>
                            </div>
                        </div>
                        <div class="clearfix mb-3" style="margin: 10px"> 
                            <h4 class="currency price-hp" style="color: #000">Time: ${o.getTimeMovie()}</h4> 
                        </div>
                    </div>
                    <!-- <div class="clearfix mb-1"> <span class="float-start"><i class="far fa-question-circle"></i></span> <span class="float-end"><i class="fas fa-plus"></i></span> </div> -->
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

