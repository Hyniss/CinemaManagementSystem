<%-- 
    Document   : OrderDetail
    Created on : 11/02/2022, 4:44:40 PM
    Author     : TIEN HUY
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OrderDetail Page</title>
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


    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <div class="container-fluid my-5 d-flex justify-content-center">
            <div class="card card-1" style="width: 880px;">
                <div class="card-header bg-white">
                    <div class="media flex-sm-row flex-column-reverse justify-content-between ">
                        <div class="col my-auto">
                            <h4 class="mb-0">Order Detail<span class="change-color"></span> </h4>
                        </div>

                    </div>
                </div>
                <div class="card-body">
                    <div class="row justify-content-between mb-3">


                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="card card-2">
                                <div class="card-body">
                                    <div class="media">
                                        <div class="sq align-self-center "> <img class="img-fluid my-auto align-self-center mr-2 mr-md-4 pl-0 p-0 m-0" src="${pageContext.request.contextPath}/assets/img/movie/${movie.image}" width="50" height="50" /> </div>
                                        <div class="media-body my-auto text-right">
                                            <div class="row my-auto flex-column flex-md-row">
                                                <div class="col my-auto">
                                                    <h6 class="mb-0">${movie.movieName}</h6>
                                                </div>


                                                <div class="col my-auto"> <small>Quantity:${quanseat}</small></div>
                                                <div class="col my-auto">
                                                    <h6 class="mb-0"><fmt:formatNumber type = "number" maxIntegerDigits = "10" value = "${priceseat}"/> VNĐ</h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="my-3 ">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col">
                            <div class="card card-2">
                                <div class="card-body">
                                    <div class="media">
                                        <div class="sq align-self-center "> 
                                            <c:forEach items="${foodDetails}" var="f">
                                                <img class="img-fluid my-auto align-self-center mr-2 mr-md-4 pl-0 p-0 m-0" src="${pageContext.request.contextPath}/assets/img/food/${f.img}" width="50" height="50" /> 
                                            </c:forEach>
                                        </div>
                                        <div class="media-body my-auto text-right">
                                            <div class="row my-auto flex-column flex-md-row">
                                                <c:forEach items="${foodDetails}" var="f">
                                                    <div class="col-auto my-auto ">
                                                        <h6 class="mb-0">${f.name};</h6>
                                                    </div>
                                                </c:forEach>

                                                <div class="col my-auto "> <small>Quantity: ${quan}</small></div>
                                                <div class="col my-auto ">
                                                    <h6 class="mb-0"><fmt:formatNumber type = "number" maxIntegerDigits = "10" value = "${giadoan}"/> VNĐ</h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="my-3 ">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col">
                            <div class="row justify-content-between">

                                <div class="flex-sm-col text-right col">
                                    <p class="mb-1"><b>Date:</b></p>
                                </div>
                                <div class="flex-sm-col col-auto">
                                    <p class="mb-1"><fmt:formatDate pattern="HH:mm" type="time" value="${movieTime.start}"/> , <fmt:formatDate pattern="EEEE, dd-MM-yyyy" value = "${date.premiere}"/></p>
                                </div>
                            </div>
                            <div class="row justify-content-between">

                                <div class="flex-sm-col text-right col">
                                    <p class="mb-1"><b>Room:</b></p>
                                </div>
                                <div class="flex-sm-col col-auto">
                                    <p class="mb-1">${room.roomName}</p>
                                </div>
                            </div>
                            <div class="row justify-content-between">

                                <div class="flex-sm-col text-right col">
                                    <p class="mb-1"><b>Seet:</b></p>
                                </div>
                                <div class="flex-sm-col col-auto">
                                    <c:forEach items="${seatDetails}" var="s">
                                        <p class="mb-1"> ${s.seatId};</p>
                                    </c:forEach>

                                </div>
                            </div>



                        </div>
                    </div>

                </div>

            </div>

        </div>
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
    </body>
</html>