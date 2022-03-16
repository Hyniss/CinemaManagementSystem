<%-- 
    Document   : Food
    Created on : 08/02/2022, 9:49:22 PM
    Author     : Nguyen Nam
--%>
<%@page import="model.FoodAndDrink"%>
<%@page import="model.FoodAndDrinkCart"%>
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
        <%ArrayList<FoodAndDrink> listFoodAndDrink = (ArrayList<FoodAndDrink>) request.getAttribute("listFoodAndDrink"); %> 
        <%ArrayList<FoodAndDrinkCart> listFoodCarts = (ArrayList<FoodAndDrinkCart>) request.getSession().getAttribute("listFoodCarts"); %> 
        <%ArrayList<Seat> listCheckedSeatId = (ArrayList<Seat>) request.getSession().getAttribute("listcheckedSeatId"); %>         
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
                                                    ${room.roomName} | Ghế
                                                    <% if (listCheckedSeatId != null) {%>          
                                                    <% for (int k = 0; k < listCheckedSeatId.size(); k++) {%>
                                                    <%=listCheckedSeatId.get(k).getSeatId()%>;
                                                    <%}%>
                                                    <%}%>
                                                </p>
                                                <p><fmt:formatDate pattern="dd/MM/yyyy" value = "${movieRoom.premiere}"/>  | từ  <fmt:formatDate type="time" pattern="HH:mm aa" value="${movieTime.start}"/> đến  <fmt:formatDate type="time" pattern="HH:mm aa" value="${movieTime.end}"/></p>
                                            </div>
                                        </div>
                                    </div>
                                </li>   
                            </ol>
                        </div>
                        <!--main content-->
                        <div class="main-content">
                            <ul class="food progress">
                                <li class="booking-step" style="position: absolute;top:0px;
                                    left: 0px;z-index: 100;opacity: 1;display: block;
                                    visibility: visible">               
                                    <label class="h2"> Combo </label>
                                    <!--pagging food and drink-->

                                    <nav class="pagging" aria-label="Page navigation example">
                                        <c:if test="${bookFood != true}">
                                            <form action="food" method="post">
                                                <input name="viewFood" value="true" hidden>
                                                <c:if test="${back>0}">
                                                    <button type="submit" name="pageIndex" value="${back}">Quay lại</button>
                                                </c:if>  
                                                <c:forEach begin="1" end="${totalPage}" step="1" var="i">
                                                    <c:if test="${i==pageIndex}">
                                                        <button type="submit" class="active-true" name="pageIndex" value="${i}">${i}</button>
                                                    </c:if>
                                                    <c:if test="${i!=pageIndex}">
                                                        <button type="submit" class="active-false" name="pageIndex" value="${i}">${i}</button>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${next<totalPage+1}">
                                                    <button type="submit" name="pageIndex" value="${next}">Trang sau</button>
                                                </c:if>
                                            </form>
                                        </c:if>
                                        <!--chưa xong-->
                                        <c:if test="${bookFood == true}">
                                            <form action="book-food" method="get">
                                                <input name="bookFood" value="true" hidden>
                                                <input name="changePage" value="true" hidden>
                                                <c:if test="${back>0}">
                                                    <button type="submit" name="pageIndex" value="${back}">Quay lại</button>
                                                </c:if>  
                                                <c:forEach begin="1" end="${totalPage}" step="1" var="i">
                                                    <c:if test="${i==pageIndex}">
                                                        <button type="submit" class="active-true" name="pageIndex" value="${i}">${i}</button>
                                                    </c:if>
                                                    <c:if test="${i!=pageIndex}">
                                                        <button type="submit" class="active-false" name="pageIndex" value="${i}">${i}</button>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${next<totalPage+1}">
                                                    <button type="submit" name="pageIndex" value="${next}">Trang sau</button>
                                                </c:if>
                                            </form>                                     
                                        </c:if>
                                    </nav>
                                    <ol class="products-list">
                                        <!--list food and drink-->
                                        <%for (int i = 0; i < listFoodAndDrink.size(); i++) {%>                                         
                                        <li class="item first">
                                            <img src="assets/img/food/<%=listFoodAndDrink.get(i).getImg()%>" class="combo-image" >
                                            <div class="product-shop">
                                                <div class="f-fix">
                                                    <div class="product-primary">
                                                        <h4 style="font-weight: bold; text-transform:uppercase"> <%=listFoodAndDrink.get(i).getName()%> </h4>
                                                    </div>
                                                    <div class="desc std">
                                                        *Nhận trong ngày xem phim*
                                                    </div>
                                                    <div class="desc">
                                                        <div class="price-box">
                                                            <span class="label">Giá: </span>
                                                            <span class="price"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value = "<%=listFoodAndDrink.get(i).getPrice()%>" type = "currency"/></span>
                                                        </div>
                                                        <div class="product-choose"> 
                                                            <span class="input-group-btn">
                                                                <a href="book-food?&bookFood=true&foodId=<%=listFoodAndDrink.get(i).getFoodId()%>&caculateType=plus&quantity=1&type=minus&pageIndex=${pageIndex}" class="btn" data-type="minus">
                                                                    <i class="fas fa-minus"></i>
                                                                </a>
                                                            </span>
                                                            <% int count = 0;%>           
                                                            <%if (listFoodCarts == null) {%>
                                                            <input type="number"  name="" class="form-control input-number" value="0" min="0" max="10" readonly>
                                                            <%}%> 
                                                            <%if (listFoodCarts != null) {%>
                                                            <% for (int j = 0; j < listFoodCarts.size(); j++) {%>
                                                            <%if (listFoodCarts.get(j).getFoodId() == listFoodAndDrink.get(i).getFoodId()) {%>
                                                            <input type="number"  name="" class="form-control input-number" value="<%=listFoodCarts.get(j).getQuantity()%>" min="0" max="10" readonly>
                                                            <% count = 1;%>
                                                            <%}%>
                                                            <%}%>
                                                            <%if (count == 0) {%>
                                                            <input type="number"  name="" class="form-control input-number" value="0" min="0" max="10" readonly>
                                                            <%}%>
                                                            <%}%>                                                         
                                                            <span class="input-group-btn ml-1">
                                                                <a href="book-food?&bookFood=true&foodId=<%=listFoodAndDrink.get(i).getFoodId()%>&caculateType=plus&quantity=1&type=plus&pageIndex=${pageIndex}" class="btn" data-type="plus">
                                                                    <i class="fas fa-plus"></i>
                                                                </a>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <%}%>
                                    </ol>
                                </li>
                            </ul>
                        </div>
                        <!--bottom content-->
                 <div class="bottom-content">
                            <!--button go back-->
                            <div class="format-bg-top"></div> 
                            <a class="btn-pre-left" href="seat?movieRoomId=${movieRoom.movieRoomId}&roomId=${room.roomId}&movieId=${movie.movieId}&time=${timeRoom.timeId}" title="Previous"></a>
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
                                                        <td class="label">Suất chiếu</td>
                                                        <td style="font-weight: bold;font-size:16px;">      
                                                            <fmt:formatDate type="time" pattern="HH:mm aa" value="${movieTime.start}"/>,<br><fmt:formatDate pattern="dd/MM/yyyy" value = "${movieRoom.premiere}"/> 
                                                        <td>
                                                    </tr>
                                                    <tr style="height: 43px">
                                                        <td class="label">Phòng chiếu</td>
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
                                                        <td class="label">Giá vé</td>
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
                                                            <td class="label" style="font-weight: bold">TỔNG</td>
                                                            <td class="price"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value = "${sessionScope.totalPrice}" type = "currency"/></td>
                                                        </c:if>
                                                        <c:if test="${sessionScope.totalFoodPrice == 0}">
                                                            <td class="label">Giá vé</td>
                                                            <td class="price"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value = "${totalSeatPrice}" type = "currency"/></td>
                                                        </c:if>
                                                    </tr>   
                                                </tfoot>
                                            </table>
                                        </div>
                                    </li>
                                </ul>
                            </div>                            <!--button go next-->  
                            <a class="btn-next-right" href="${pageContext.request.contextPath}/Cart"  title="Next"></a>
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
                                    window.alert("Hãy chọn một loại đồ ăn hoặc thức uống!");
                                }
        </script>
    </body>
</html>