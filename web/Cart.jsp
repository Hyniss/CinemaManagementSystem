<%-- 
    Document   : Cart
    Created on : 10/02/2022, 9:42:15 PM
    Author     : TIEN HUY
--%>

<%@page import="model.FoodAndDrinkCart"%>
<%@page import="model.Seat"%>
<%@page import="java.util.ArrayList"%>
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
         <%ArrayList<Seat> listCheckedSeatId = (ArrayList<Seat>) request.getSession().getAttribute("list"); %> 
          <%ArrayList<FoodAndDrinkCart> listFoodCarts = (ArrayList<FoodAndDrinkCart>) request.getSession().getAttribute("listFoodCarts"); %> 
        <title>Amazing Cinema</title>
    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <div class="container mt-5 mb-3 p-3 cart-container" style="background:#e9ecef">
            <div class="row no-gutters">
                <div class="col-md-8">
                    <div class="product-details mr-2">
                        <div class="booking-progress">
                            <div class="page-title">
                                <h1>Booking online</h1>
                            </div>
                        </div>
                        <hr>
                        <h6 class="mb-0">Shopping cart</h6>
                        <div class="d-flex justify-content-between"><span>You have 4 items in your cart</span>
<!--                            <div class="d-flex flex-row align-items-center" style="border: 1px solid #000;padding:5px; margin-top:-18px;border-radius:5px ">
                                <form action="" method="">
                                    <select name="" onchange="this.form.submit()" style="background-color: #e9ecef; border: none ">
                                        <option value="">Sort by price</option>
                                        <option value="">Sort by name</option>
                                    </select>
                                </form>
                            </div>-->
                        </div>
                        <br>
                        
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
                                                       <% if (listCheckedSeatId != null) {%>          
                                                    <% for (int k = 0; k < listCheckedSeatId.size(); k++) {%>
                                                   <td style="font-weight: bold;font-size:16px;"> <%=listCheckedSeatId.get(k).getSeatId()%><td> 
                                                       
                                                    <%}%>
                                                    <%}%>
                                                       
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
                                                        <td class="price">: ${totalFoodPrice} vnđ</td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="block-box" style="height: 23px">
                                                        <td class="label">Số lượng</td>
                                                        <td class="price">: ${quantitySeat}</td>
                                                    </tr>
                                                </tbody>
                                                 <thead>
                                                    <tr class="block-box" style="height: 24px">
                                                        <td class="label">Combo</td>
                                                        <td class="price">: ${totalSeatPrice} vnđ</td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="block-box" style="height: 23px">
                                                        <td class="label">Số lượng</td>
                                                        <% int pos = 0;%>
                                                          <%if (listFoodCarts != null) {%>
                                                            <% for (int j = 0; j < listFoodCarts.size(); j++) {%>
                                                            <%  pos +=listFoodCarts.get(j).getQuantity();%>
                                                            
                                                           
                                                            <%}%>
                                                            <%}%> 
                                                            <td class="price">: <%=pos%> </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            
                                        </div>
                                    </li>
                                </ul>
                                
                            </div>
                            <div class="format-bg-bottom"></div>           
                        </div>

                     <button class="btn btn-secondary btn-block d-flex justify-content-between mt-3" type="button" style="background-color: #000">
                            <a style="text-decoration: none" href="#">Back<i class="fa fa-long-arrow-right ml-1"></i></a>
                        </button>
                    </div>
                </div>

                <div class="col-md-4" style="background:#fff1ce">
                    <div class="payment-info">
                       
                        <div class="d-flex justify-content-between align-items-center"><span>Card details</span></div><span class="type d-block mt-3 mb-1">Card type</span><label class="radio"> <input type="radio" name="card" value="payment" checked> <span><img width="30" src="https://img.icons8.com/color/48/000000/mastercard.png" /></span> Thanh toán với VISA </label>
                        
                        <br>
                        <br>
                        <label class="radio"> <input type="radio" name="card" value="payment"> <span><img width="30" src="https://developers.momo.vn/v3/vi/assets/images/square-8c08a00f550e40a2efafea4a005b1232.png" /></span>  Thanh toán với MOMO </label> 
                        <br>
                        <br>
                        <label class="radio"> <input type="radio" name="card" value="payment"> <span><img width="30" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJZPbSE5ssowAn0vChY-R7E6xfjG3TeNe5k9xcGaA9G5DnNX_v5YpC9ozQ0-sr4WBIkME&usqp=CAU" /></span> Thanh toán với ViettelPay</label>
                        <br>
                                <br>
                        <label class="radio"> <input type="radio" name="card" value="payment"> <span><img width="30" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRanuAdlL4DpFARUlwfObpts-eSlnfhXdETpaWcnevAOcOmkrG8-7kZ9N2c1kERrxLx_uc&usqp=CAU" /></span> Thanh toán với thẻ ngân hàng </label>
                        <hr class="line">
                        <div class="d-flex justify-content-between information">
                            <span>Subtotal</span><span>${totalPrice}</span>
                        </div>
                        <button class="btn btn-secondary btn-block d-flex justify-content-between mt-3" type="button" style="background-color: #000">
                            <span>Checkout<i class="fa fa-long-arrow-right ml-1"></i></span>
                        </button>
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
