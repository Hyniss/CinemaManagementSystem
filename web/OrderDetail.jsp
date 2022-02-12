<%-- 
    Document   : OrderDetail
    Created on : 11/02/2022, 4:44:40 PM
    Author     : TIEN HUY
--%>

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
                                            <img src="https://www.cgv.vn/media/catalog/product/cache/1/thumbnail/dc33889b0f8b5da88052ef70de32f1cb/b/n/bnn-new-year-poster-2022_1__2.jpg" class="rounded">
                                        </td>
                                        <td>
                                            <table>
                                                <tbody>
                                                    <tr>
                                                        <td class="label"> BẪY NGỌT NGÀO </td>
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

                                    <tr>
                                        <td class="label">Ghế</td>
                                        <td style="font-weight: bold;font-size:16px;">D6<td>
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
                                        <td class="price">: 55,000 vnđ</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="block-box" style="height: 23px">
                                        <td class="label">Số lượng</td>
                                        <td class="price">: 1</td>
                                    </tr>
                                </tbody>
                                <thead>
                                    <tr class="block-box" style="height: 24px">
                                        <td class="label">Combo</td>
                                        <td class="price">: 55,000 vnđ</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="block-box" style="height: 23px">
                                        <td class="label">Số lượng</td>
                                        <td class="price">: 1</td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                    </li>
                </ul>

            </div>
            <div class="format-bg-bottom"></div>           
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
