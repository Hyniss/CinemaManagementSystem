
<%@page import="model.SeatRoom"%>
<%-- 
    Document   : Seat
    Created on : 08/02/2022, 9:49:22 PM
    Author     : Nguyen Nam
--%>
<%@page import="model.Seat"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <!--get session--> 
        <%ArrayList<Seat> listCheckedSeatId = (ArrayList<Seat>) request.getSession().getAttribute("listcheckedSeatId"); %>   
        <%ArrayList<SeatRoom> listSeatBooked = (ArrayList<SeatRoom>) request.getAttribute("listSeatBooked");%>
        <title>Amazing Cinema</title>
    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <div class="main-container co11-layout">
            <div class="main">
                <div class="col-main">
                    <div class="booking-progress">
                        <div class="page-title">
                            <h1>Booking online</h1>
                        </div>
                        <!--top content-->
                        <div class="top-content">
                            <ol class="products-list">
                                <li class="item">
                                    <div class="product-shop">
                                        <div class="f-fix">
                                            <div class="product-primary">
                                                <p>
                                                    ${room.roomName} | Gh???
                                                    <% if (listCheckedSeatId != null) {%>          
                                                    <% for (int k = 0; k < listCheckedSeatId.size(); k++) {%>
                                                    <%=listCheckedSeatId.get(k).getSeatId()%>;
                                                    <%}%>
                                                    <%}%>
                                                </p>
                                                <p><fmt:formatDate pattern="dd/MM/yyyy" value = "${movieRoom.premiere}"/>  | t???  <fmt:formatDate type="time" pattern="HH:mm aa" value="${movieTime.start}"/> ?????n  <fmt:formatDate type="time" pattern="HH:mm aa" value="${movieTime.end}"/></p>
                                            </div>
                                        </div>
                                    </div>
                                </li>   
                            </ol>
                        </div>
                        <!--main content-->
                        <div class="main-content">
                            <ul class="progress">
                                <li class="booking-step" style="position: absolute;top:0px;
                                    left: 0px;z-index: 100;opacity: 1;display: block;
                                    visibility: visible">               
                                    <label class="h2">Seat / Person</label>
                                    <div class="ticketbox">
                                        <!--screen-->
                                        <div class="screen">
                                            <span class="text-screen">Ph??ng chi???u</span>
                                        </div>
                                        <!--seat map-->
                                        <form action="book" method="post">
                                            <!--room info-->
                                            <input name="room" value="" hidden>
                                            <!--movie info-->
                                            <input name="movie" value="" hidden>
                                            <!--seat info-->
                                            <table class="seat-map" border="0">
                                                <tr style="height: 10px">
                                                    <td></td>  
                                                    <!--seat column-->
                                                    <%String[] a = {"A", "B", "C", "D", "E", "F", "G", "H"};%>
                                                    <% for (int i = 0; i < a.length; i++) {%>
                                                    <td style="text-align: center;width:50px"><%=a[i]%></td>
                                                    <%}%> 
                                                </tr>
                                                <!--seat row-->
                                                <% for (int j = 1; j <= 8; j++) {%>
                                                <tr style="height: 26px">
                                                    <td style="text-align:center;width:10px;" ><%=j%></td>
                                                    <!--seat map-->
                                                    <% for (int i = 0; i < a.length; i++) {%>
                                                    <% String pos = a[i] + j;%>
                                                    <td style="text-align: center;width:50px;padding-top: 1px"> 

                                                        <!--seats are not checked-->
                                                        <% if (listCheckedSeatId == null) {%>  
                                                        <input type="checkbox" id="<%=pos%>" name="seatId" value="<%=pos%>"onchange="this.form.submit()"
                                                               <% for (int g = 0; g < listSeatBooked.size(); g++) {%>
                                                               <%if (listSeatBooked.get(g).getSeatId().equals(pos)) {%>
                                                               disabled
                                                               <%}%>
                                                               <%}%>
                                                               >                                                    
                                                        <label class="seat__label" for="<%=pos%>">
                                                            <i class="fas fa-box rating__icon--star"></i>
                                                        </label>
                                                        <%}%>
                                                        <!--seats are checked-->
                                                        <% if (listCheckedSeatId != null) {%>                              
                                                        <input type="checkbox" id="<%=pos%>" name="seatId" value="<%=pos%>"onchange="this.form.submit()"                                                              
                                                               <% for (int g = 0; g < listSeatBooked.size(); g++) {%>
                                                               <%if (listSeatBooked.get(g).getSeatId().equals(pos)) {%>                                                              
                                                               disabled
                                                               <%}%>                                                               
                                                               <%}%>
                                                               <% for (int k = 0; k < listCheckedSeatId.size(); k++) {%>
                                                               <%if (listCheckedSeatId.get(k).getSeatId().equals(pos)) {%>                                                               
                                                               checked
                                                               <%}%>
                                                               <%}%>
                                                               >  
                                                        <label class="seat__label" for="<%=pos%>">
                                                            <i class="fas fa-box rating__icon--star"></i>
                                                        </label>
                                                        <%}%>
                                                    </td>
                                                    <%}%> 
                                                </tr>              
                                                <%}%> 
                                            </table>
                                            <div>
                                            </div>
                                        </form>
                                        <div class="ticketbox-notice">
                                            <div class="iconlist">
                                                <div class="icon checked">
                                                    <i class="fas fa-box"></i>: Checked seat
                                                </div>
                                                <div class="icon available">
                                                    <i class="fas fa-box"></i>: Available seat 
                                                </div>
                                                <div class="icon unavaiable">
                                                    <i class="fas fa-box"></i>: Unavailable seat
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div id="seat-alert">
                            <p>H??y ch???n gh??? ng???i c???a b???n</p>
                        </div>
                        <!--bottom content-->
                        <div class="bottom-content">
                            <!--button go back-->
                            <div class="format-bg-top"></div> 
                            <a class="btn-pre-left" href="showtimes?movieRoomId=${movieRoom.movieRoomId}&movieId=${movie.movieId}" title="Previous"></a>
                            <div class="minicart">
                                <ul>
                                    <!--movie info-->
                                    <li class="item first">
                                        <div class="product-details">
                                            <table class ="info-wrapper">
                                                <colgroup>
                                                    <col width="40%">
                                                    <col>
                                                </colgroup>                                             
                                                <tbody>
                                                    <tr>
                                                        <td>

                                                        </td>
                                                        <td>
                                                            <table>
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="label">${movie.movieName}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>2D</td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>  
                                                        </td>
                                                    </tr>
                                                </tbody>

                                            </table>
                                        </div>
                                    </li>
                                    <!--movie schedule-->
                                    <li class="item">
                                        <div class="product-details">
                                            <table class ="info-wrapper">
                                                <colgroup>
                                                    <col width="30%">
                                                    <col>
                                                </colgroup>
                                                <tbody>
                                                    <tr style="height: 43px">
                                                        <td class="label">Su???t chi???u</td>
                                                        <td style="font-weight: bold;font-size:16px;">      
                                                            <fmt:formatDate type="time" pattern="HH:mm aa" value="${movieTime.start}"/>,<br><fmt:formatDate pattern="dd/MM/yyyy" value = "${movieRoom.premiere}"/> 
                                                        <td>
                                                    </tr>
                                                    <tr style="height: 43px">
                                                        <td class="label">Ph??ng chi???u</td>
                                                        <td style="font-weight: bold;font-size:16px;">${room.roomName}<td>
                                                    </tr>
                                                </tbody>
                                            </table> 
                                        </div>
                                    </li>
                                    <!--movie ticket price-->
                                    <li class="item">
                                        <div class="product-details">
                                            <table class ="info-wrapper">
                                                <thead>
                                                    <tr class="block-box" style="height: 20px">
                                                        <td class="label">Gi?? v??</td>
                                                        <td class="price"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value = "${totalSeatPrice}" type = "currency"/></td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="block-box" style="height: 23px">
                                                        <c:if test="${sessionScope.totalFoodPrice == 0}">
                                                            <td class="label">Combo</td>
                                                            <td class="price"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value = "0" type = "currency"/></td>
                                                        </c:if>
                                                        <c:if test="${sessionScope.totalFoodPrice > 0}">
                                                            <td class="label">Combo</td>
                                                            <td class="price"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value = "${sessionScope.totalFoodPrice}" type = "currency"/></td>          
                                                        </c:if>
                                                    </tr>

                                                </tbody>
                                                <tfoot>
                                                    <tr class="block-box">
                                                        <c:if test="${sessionScope.totalFoodPrice > 0}">
                                                            <td class="label" style="font-weight: bold">T???NG</td>
                                                            <td class="price"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value = "${sessionScope.totalPrice}" type = "currency"/></td>
                                                        </c:if>
                                                        <c:if test="${sessionScope.totalFoodPrice == 0}">
                                                            <td class="label">Gi?? v??</td>
                                                            <td class="price"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value = "${totalSeatPrice}" type = "currency"/></td>
                                                        </c:if>
                                                    </tr>   
                                                </tfoot>
                                            </table>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <!--button go next-->                        
                            <% if (listCheckedSeatId == null) {%> 
                            <a class="btn-next-right" href="#" onclick="showAlert()" title="Next"></a>
                            <% } else { %>
                            <a class="btn-next-right" href="food?viewFood=true"title="Next"></a>
                            <%}%> 
                            <div class="format-bg-bottom"></div>           
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
        <script>
                                function showAlert() {
                                    document.getElementById("seat-alert").style.display = "block";
                                }
        </script>
    </body>

</html>
