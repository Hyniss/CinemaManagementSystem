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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="getTime" class="dao.impl.MovieTimeDAO"/>

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
                                    <div>
                                        <button  class="custom-btn btn-book" style="background-color: #0092ef">
                                            <a href="movie?mid=${movie.getMovieId()}">
                                                <span>Back</span>
                                                <span>Back</span>
                                            </a>
                                        </button>
                                    </div>
                                    </br>
                                    <div >
                                        </br>
                                        </br>
                                        <cite style="font-size: 50px; color: #006dcc">${movie.movieName}</cite>
                                    </div>
                                    </br>

                                    </br>
                                    <!--                                    <div class="col-sm-6">
                                                                            <h2>
                                                                                Manage <b>Time</b>
                                                                            </h2>
                                                                        </div>-->
                                    <div >
                                        <div class="product-collateral toggle-content tabs tabs-cgv-movie-view-date" style="margin-left: 10%">
                                            <c:forEach items="${movieRoom}" var="o">
                                                <ul class="toggle-tabs parent"  style="    
                                                    border-bottom: 2px solid #2b2b2b;
                                                    border-top: 2px solid #2b2b2b;
                                                    display: inline-block;
                                                    margin-bottom: 30px;
                                                    padding: 20px 0;
                                                    padding: 20px;
                                                    margin: 0px;">
                                                    <li class="" style=" border: 2px solid #222; list-style: none;
                                                        border-radius: 5px;">
                                                        <div class="child" style="color: #717171;
                                                             cursor: pointer;
                                                             height: 48px;
                                                             position: relative;
                                                             width: 77px;" >

                                                            <a class="dropdown-item1 " href="showtimes?movieRoomId=${o.movieRoomId}&movieId=${movieId}">
                                                                <span style="color: #717171;
                                                                      font-size: 11px;
                                                                      left: 4px;
                                                                      font-weight: 900;
                                                                      position: absolute;
                                                                      top: 4px;">
                                                                    ${o.getMonth()}
                                                                </span>
                                                                <em style="    color: #717171;
                                                                    font-size: 11px;
                                                                    font-style: normal;
                                                                    left: 4px;
                                                                    position: absolute;
                                                                    font-weight: 900;
                                                                    top: 20px;">
                                                                    ${o.getDay()}
                                                                </em>
                                                                <strong style="color: #717171;
                                                                        font-size: 32px;
                                                                        font-weight: normal;
                                                                        left: 31px;
                                                                        line-height: 32px;
                                                                        position: absolute;
                                                                        font-weight: 900;
                                                                        top: 8px;">
                                                                    ${o.getDate()}
                                                                </strong>
                                                            </a>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>


                                <style>
                                    .bak{ background-color: #009ceb; color: #fff; font-weight:bold; }
                                </style>

                                <script>

                                    var elements = document.getElementsByClassName("child");
                                    for (var i = 0; i < elements.length; i++)
                                    {
                                        elements[i].onclick = function () {

                                            // remove class from sibling

                                            var el = elements[0];
                                            while (el)
                                            {
                                                if (el.tagName === "DIV") {
                                                    //remove class
                                                    el.classList.remove("bak");

                                                }
                                                // pass to the new sibling
                                                el = el.nextSibling;
                                            }

                                            this.classList.add("bak");
                                        };
                                    }

                                </script>    
                            </div>
                            <div class="table-responsive">
                                <table class="table table-borderless">

                                    <tbody>
                                        <c:forEach items="${room}" var="p">

                                        <td style="padding: 20px">
                                            <p>${p.roomName}</p>

                                        </td>
                                        <c:forEach items="${getTime.getId(movieId, movieRoomId, p.roomId)}" var="i">
                                            <td style="margin: 1px">
                                                <ul class="products-grid-movie tab-showtime" style="margin-bottom: 5px; list-style: none;
                                                    float: left;">
                                                    <ul class="item" style="    border: 1px solid #222;
                                                        padding-top: 5px;
                                                        float: left;
                                                        /*                                                        position: fixed;*/
                                                        margin-right: 5px;
                                                        text-align: center;
                                                        margin-top: 3px;
                                                        width: 120px" >

                                                        <a class="dropdown-item2" href="${pageContext.request.contextPath}/seat" style="color: #e71a0f;
                                                           text-decoration: none;     touch-action: manipulation">
                                                            <span style="color: #222;
                                                                  clear: both;
                                                                  float: left;
                                                                  width: 100%;">
                                                                <fmt:formatDate type="time" pattern="HH:mm aa" value="${i.start}"/></p>  

                                                            </span>
                                                        </a>
                                                        </td>
                                                    </c:forEach>

                                                    </tr>
                                                </c:forEach>
                                                </tbody> 
                                                </table>
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
                                                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
                                                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
                                                <script>
                                    $(window).load(function () {
                                        $('body').sakura();
                                    });
                                                </script>
                                                <script src="https://code.jquery.com/jquery-migrate-3.3.2.js"></script>
                                                <script type="text/javascript">
                                    $(document).on('click', 'li day', function () {
                                    $(this).addClass('active').siblings().removeClass('active')
                                    }
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

                                                <script>
                                                    let btnContainer = document.querySelector('.current');
                                                    let btn = document.querySelectorAll('.day');


                                                    btn.forEach(el => {
                                                        el.addEventListener('click', function () {
                                                            btnContainer.querySelector('.active').classList.remove('active');

                                                            el.classList.add('active');
                                                        });
                                                    });
                                                </script>
                                                <style>
                                                    .active {
                                                        opacity: 1;
                                                    }
                                                </style>

