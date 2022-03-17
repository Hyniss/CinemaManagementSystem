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
        <c:if test="${sessionScope.acc ==null}">
            <div class="container mt-5 mb-3 p-3 cart-container" style="background:#e9ecef">
                <h1> Bạn phải đăng nhập để thực hiện tác vụ</h1>
            </div>
        </c:if>
        <c:if test="${sessionScope.acc !=null}">
           
            <c:if test="${ searchMess !=null}">
                <div class="container mt-5 mb-3 p-3 cart-container" style="background:#e9ecef">
                <h1> Không có dữ liệu</h1>
            </div>
            </c:if>
             <c:if test="${ searchMess ==null}">
            <div class="cart-content mt-3">
                <div class="format-bg-top"></div> 
                <div class="minicart">
                    <ul>
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
                                                <img src="${pageContext.request.contextPath}/assets/img/movie/${movie.image}" class="rounded">
                                            </td>
                                            <td>
                                                <table>
                                                    <tbody>
                                                        <tr>
                                                            <td class="label"> ${movie.movieName} </td>
                                                        </tr>
                                                    </tbody>
                                                </table>  
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </li>
                        <li class="item">
                            <div class="product-details">
                                <table class ="info-wrapper">
                                    <colgroup>
                                        <col width="30%">
                                        <col>
                                    </colgroup>
                                    <tbody>
                                        <!--check xem là phim hay đồ ăn, nếu là phim thì hiện cái này, còn đồ ăn thì phần này không hiện-->
                                        <tr style="height: 43px">
                                            <td class="label">Rạp chiếu</td>
                                            <td style="font-weight: bold;font-size:16px;">Amazing Cinema<td>
                                        </tr>
                                        <tr style="height: 43px">
                                            <td class="label">Suất chiếu</td>
                                            <td style="font-weight: bold;font-size:16px;"><fmt:formatDate pattern="HH:mm " type="time" value="${movieTime.start}"/> , <fmt:formatDate pattern="EEEE, dd-MM-yyyy" value = "${date.premiere}"/><td>
                                        </tr>
                                        <tr>
                                            <td class="label">Phòng</td>
                                            <td style="font-weight: bold;font-size:16px;">${room.roomName}<td>
                                        </tr>

                                        <tr>
                                            <td class="label">Ghế</td>

                                            <td style="font-weight: bold;font-size:16px;">
                                                <c:forEach items="${seatDetails}" var="s">
                                                    ${s.seatId};
                                                </c:forEach>
                                            <td>
                                        </tr>
                                    </tbody>
                                </table> 
                            </div>
                        </li>
                        <li class="item">
                            <div class="product-details">
                                <table class ="info-wrapper">
                                    <thead>
                                        <tr class="block-box" style="height: 24px">
                                            <td class="label">Giá</td>
                                            <td class="price">: ${priceseat} VNĐ</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="block-box" style="height: 23px">
                                            <td class="label">Số lượng</td>
                                            <td class="price">: ${quanseat} ghế</td>
                                        </tr>
                                    </tbody>
                                    <thead>
                                        <tr class="block-box" style="height: 24px">
                                            <td class="label">Combo</td>
                                            <td class="price">:  
                                                <c:forEach items="${foodDetails}" var="f">
                                                    ${f.name};
                                                </c:forEach>
                                            </td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="block-box" style="height: 23px">
                                            <td class="label">Số lượng</td>
                                            <td class="price">: ${quan}</td>
                                        </tr>
                                    </tbody>
                                    <tbody>
                                        <tr class="block-box" style="height: 23px">
                                            <td class="label">Giá</td>
                                            <td class="price">: ${giadoan}</td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </li>
                    </ul>

                </div>
                <div class="format-bg-bottom"></div>           
            </div>
        </c:if>
            </c:if>
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
