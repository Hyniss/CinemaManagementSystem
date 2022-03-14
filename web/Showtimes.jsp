<%-- 
    Document   : Showtimes
    Created on : 23-Feb-2022, 16:01:28
    Author     : Bảo Châu Bống
--%>
<%@page import = "java.time.LocalDateTime"%>
<%@page import = "java.time.ZoneId"%>
<%@page import = "java.sql.Date"%>
<%@page import = "java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

        <script>
            $(document).ready(function () {
                // Activate tooltip
                $('[data-toggle="tooltip"]').tooltip();

                // Select/Deselect checkboxes
                var checkbox = $('table tbody input[type="checkbox"]');
                $("#selectAll").click(function () {
                    if (this.checked) {
                        checkbox.each(function () {
                            this.checked = true;
                        });
                    } else {
                        checkbox.each(function () {
                            this.checked = false;
                        });
                    }
                });
                checkbox.click(function () {
                    if (!this.checked) {
                        $("#selectAll").prop("checked", false);
                    }
                });
            });
        </script>
        <%@include file="template/header.jsp" %>
        <!-- MOVIE -->
        <section class="product">
            <div class="table-title">
                <div class="container-xl">
                    <div class="table-responsive">
                        <div class="table-wrapper">
                            <div class="table-title">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h2>
                                            Manage <b>Time</b>
                                        </h2>
                                    </div>
                                    <div >
                                        <div class="product-collateral toggle-content tabs tabs-cgv-movie-view-date">
                                            <!--   <div class="dropdown" style="background: transparent;
                                                    border: medium none;
                                                    text-align: center;
                                                    }">-->
                                            <!--                                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                            Choose Time
                                                                                        </button>-->

                                            <!--                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <c:forEach items="${movieRoom2}" var="o">
                                                <a class="dropdown-item" href="showtimes?movieRoomId=${o.movieRoomId}&movieId=${o.movieId}">
                                                <fmt:formatDate pattern="EEEE, dd-MM-yyyy"  value = "${o.premiere}"/> 
                                               <p>${o.getDate()}</p>
                                            </a>                                       
                                            </c:forEach>
                                        </div>-->
                                            <c:forEach items="${movieRoom2}" var="o">
                                                <ul class="toggle-tabs"  style="    border-bottom: 2px solid #2b2b2b;
                                                    border-top: 2px solid #2b2b2b;
                                                    display: inline-block;
                                                    margin-bottom: 30px;
                                                    padding: 20px 0;
                                                    padding: 20px;
                                                    margin: 0px;">
                                                    <ul class="current" style="    border: 2px solid #222;
                                                        border-radius: 5px;">
                                                        <div class="day active" style="color: #717171;
                                                             cursor: pointer;
                                                             height: 48px;
                                                             position: relative;
                                                             width: 77px;" >

                                                            <a class="dropdown-item1" href="showtimes?movieRoomId=${o.movieRoomId}&movieId=${o.movieId}">
                                                                <span style="color: #717171;
                                                                      font-size: 11px;
                                                                      left: 4px;
                                                                      position: absolute;
                                                                      top: 4px;">
                                                                    0${o.getMonth()}
                                                                </span>
                                                                <em style="    color: #717171;
                                                                    font-size: 11px;
                                                                    font-style: normal;
                                                                    left: 4px;
                                                                    position: absolute;
                                                                    top: 20px;">
                                                                    ${o.getDay()}
                                                                </em>
                                                                <strong style="color: #717171;
                                                                        font-size: 32px;
                                                                        font-weight: normal;
                                                                        left: 31px;
                                                                        line-height: 32px;
                                                                        position: absolute;
                                                                        top: 8px;">
                                                                    ${o.getDate()}
                                                                </strong>
                                                            </a>
                                                        </div>
                                                    </ul>
                                                </ul>
                                            </c:forEach>

                                        </div>

                                    </div>
                                </div>
                            </div>
                            <table class="table table-striped table-hover">
                                <!--                                <thead>
                                                                    <tr>
                                                                        <th>Time</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                <c:forEach items="${movieDate1}" var="o">
                                    <tr>
                                        <td>                                   
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/seat">
                                    <fmt:formatDate pattern="HH:mm" type="time" value="${o.time}"/>
                                </a>                                       
                            </td>
                        </tr>
                                </c:forEach>
                            </tbody>-->
                                <c:forEach items="${movieDate1}" var="o">
                                    <ul class="products-grid-movie tab-showtime" style="margin-bottom: 15px; list-style: none;
                                        float: left;">
                                        <ul class="item" style="    border: 1px solid #222;
                                            padding: 5px 10px;
                                            float: left;
                                            margin-right: 3px;
                                            text-align: center;
                                            margin-top: 3px;" >
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/seat" style="color: #e71a0f;
                                               text-decoration: none;     touch-action: manipulation">
                                                <span style="color: #222;
                                                      clear: both;
                                                      float: left;
                                                      width: 100%;">${o.getTimeFormatted()}</span>
                                            </a>
                                        </ul>
                                    </ul>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <style>
                    .active {
                        background: #2196F3;
                        color: #fff;
                        
                    }
                    </style>
            </div>
        </section>
        <script type="text/javascript">
            $('#myTable').click(function () {
                $(this).addClass('active').siblings().removeClass('active');
            });
        </script>
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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script>
            $(window).load(function () {
                $('body').sakura();
            });
        </script>

        <!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script type="text/javascript">
        
                    $(document).ready(function () {
                        $(".day").click(function () {
                            $(".day").removeClass("highlight");
                            $(this).addClass("highlight");
                        });
                    });
        
                </script>-->

    </body>
</html>

