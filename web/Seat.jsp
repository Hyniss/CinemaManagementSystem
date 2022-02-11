<%-- 
    Document   : Seat
    Created on : Feb 10, 2022, 8:53:28 PM
    Author     : tenhik
--%>

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
                        <div class="top-content">
                            <ol class="products-list">
                                <li class="item">
                                    <div class="product-shop">
                                        <div class="f-fix">
                                            <div class="product-primary">
                                                <p>
                                                    Room 1 | Số ghế (64/64) 
                                                </p>
                                                <p>14/02/2022 | từ 18:30 đến 20h42</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>   
                            </ol>
                        </div>
                        <div class="main-content">
                            <ul class="progress">
                                <li class="booking-step" style="position: absolute;top:0px;
                                    left: 0px;z-index: 100;opacity: 1;display: block;
                                    visibility: visible">               
                                    <label class="h2">Seat / Person</label>
                                    <div class="ticketbox">
                                        <div class="screen">
                                            <span class="text-screen">Phòng chiếu</span>
                                        </div>
                                        <form action="book" method="post">
                                            <table class="seat-map" border="0">
                                                <tr style="height: 10px">
                                                    <td></td>         
                                                    <%String[] a = {"A", "B", "C", "D", "E", "F", "G", "H"};%>
                                                    <% for (int i = 0; i < a.length; i++) {%>
                                                    <td style="text-align: center;width:50px"><%=a[i]%></td>
                                                    <%}%> 
                                                </tr>
                                                <% for (int j = 1; j <= 8; j++) {%>
                                                <tr style="height: 26px">
                                                    <td style="text-align:center;width:10px;" ><%=j%></td>
                                                    <% for (int i = 0; i < a.length; i++) {%>
                                                    <td style="text-align: center;width:50px;padding-top: 1px">                                                
                                                        <input type="checkbox">
                                                        <label class="seat__label">
                                                            <i class="fas fa-box rating__icon--star"></i>
                                                        </label>
                                                    </td>
                                                    <%}%> 
                                                </tr>              
                                                <%}%> 
                                            </table>
                                            <div class="submit-btn">
                                                <input type="submit" value="Submit">
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
                        <div class="bottom-content">
                            <div class="format-bg-top"></div> 
                            <a class="btn-pre-left" href="" title="Previous"></a>
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
                                                            <img src="https://www.cgv.vn/media/catalog/product/cache/1/thumbnail/dc33889b0f8b5da88052ef70de32f1cb/b/n/bnn-new-year-poster-2022_1__2.jpg">
                                                        </td>
                                                        <td>
                                                            <table>
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="label"> BẪY NGỌT NGÀO </td>
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
                                    <li class="item">
                                        <div class="product-details">
                                            <table class ="info-wrapper">
                                                <colgroup>
                                                    <col width="30%">
                                                    <col>
                                                </colgroup>
                                                <tbody>
                                                    <tr style="height: 43px">
                                                        <td class="label">Rạp chiếu</td>
                                                        <td style="font-weight: bold;font-size:16px;">CGV Aeon mall Hà Đông<td>
                                                    </tr>
                                                    <tr style="height: 43px">
                                                        <td class="label">Suất chiếu</td>
                                                        <td style="font-weight: bold;font-size:16px;">10h05, 11/02/2022<td>
                                                    </tr>
                                                    <tr>
                                                        <td class="label">Phòng</td>
                                                        <td style="font-weight: bold;font-size:16px;">Room 2<td>
                                                    </tr>
                                                </tbody>
                                            </table> 
                                        </div>
                                    </li>
                                    <li class="item">
                                        <div class="product-details">
                                            <table class ="info-wrapper">
                                                <thead>
                                                    <tr class="block-box" style="height: 20px">
                                                        <td class="label">Giá vé</td>
                                                        <td class="price"> 55,000 vnđ</td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="block-box" style="height: 23px">
                                                        <td class="label">Combo</td>
                                                        <td class="price"> 0 vnđ</td>
                                                    </tr>
                                                </tbody>
                                                <tfoot>
                                                    <tr class="block-box">
                                                        <td class="label" style="font-weight: bold">TỔNG</td>
                                                        <td class="price"> 55,000 vnđ</td>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <a class="btn-next-right" href="" title="Next"></a>
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
    </body>
</html>
