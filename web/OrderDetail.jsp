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
          <link rel="stylesheet" href="assets/css/OrderDetail.css" />
          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
           <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js" />
             <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" />
    </head>
    <body>
      <div class="d-flex flex-column justify-content-center align-items-center" id="order-heading">
    <div class="text-uppercase">
        <p>Order detail</p>
    </div>
    <div class="h4">Thursday, July 24, 2017</div>
    <div class="pt-1">
        <p>Order #12615 is currently<b class="text-dark"> processing</b></p>
    </div>
    <div class="btn close text-white"> &times; </div>
</div>
<div class="wrapper bg-white">
    <div class="table-responsive">
        <table class="table table-borderless">
            <thead>
                <tr class="text-uppercase text-muted">
                    <th scope="col">product</th>
                    <th scope="col" class="text-right">total</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">Babyblends: 1meal/day</th>
                    <td class="text-right"><b>$69.86</b></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="d-flex justify-content-start align-items-center list py-1">
        <div><b>1px</b></div>
        <div class="mx-3"> <img src="https://images.pexels.com/photos/206959/pexels-photo-206959.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="apple" class="rounded-circle" width="30" height="30"> </div>
        <div class="order-item">Apple</div>
    </div>
    <div class="d-flex justify-content-start align-items-center list my-2 py-1">
        <div><b>4px</b></div>
        <div class="mx-3"> <img src="https://images.unsplash.com/photo-1602081593819-65e7a8cee0dd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80" alt="apple" class="rounded-circle" width="30" height="30"> </div>
        <div class="order-item">Mango</div>
    </div>
    <div class="d-flex justify-content-start align-items-center list my-2 py-1">
        <div><b>2px</b></div>
        <div class="mx-3"> <img src="https://images.unsplash.com/photo-1584183187885-071d53d42531?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60" alt="apple" class="rounded-circle" width="30" height="30"> </div>
        <div class="order-item">Carrot Apple Ginger</div>
    </div>
    <div class="d-flex justify-content-start align-items-center list my-2 py-1">
        <div><b>3px</b></div>
        <div class="mx-3"> <img src="https://images.unsplash.com/photo-1602096934878-5028bf10ca50?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60" alt="apple" class="rounded-circle" width="30" height="30"> </div>
        <div class="order-item">Pear</div>
    </div>
    <div class="pt-2 border-bottom mb-3"></div>
    <div class="d-flex justify-content-start align-items-center pl-3">
        <div class="text-muted">Payment Method</div>
        <div class="ml-auto"> <img src="https://www.freepnglogos.com/uploads/mastercard-png/mastercard-logo-logok-15.png" alt="" width="30" height="30"> <label>Mastercard ******5342</label> </div>
    </div>
    <div class="d-flex justify-content-start align-items-center py-1 pl-3">
        <div class="text-muted">Shipping</div>
        <div class="ml-auto"> <label>Free</label> </div>
    </div>
    <div class="d-flex justify-content-start align-items-center pb-4 pl-3 border-bottom">
        <div class="text-muted"> <button class="text-white btn">50% Discount</button> </div>
        <div class="ml-auto price"> -$34.94 </div>
    </div>
    <div class="d-flex justify-content-start align-items-center pl-3 py-3 mb-4 border-bottom">
        <div class="text-muted"> Today's Total </div>
        <div class="ml-auto h5"> $34.94 </div>
    </div>
    <div class="row border rounded p-1 my-3">
        <div class="col-md-6 py-3">
            <div class="d-flex flex-column align-items start"> <b>Billing Address</b>
                <p class="text-justify pt-2">James Thompson, 356 Jonathon Apt.220,</p>
                <p class="text-justify">New York</p>
            </div>
        </div>
        <div class="col-md-6 py-3">
            <div class="d-flex flex-column align-items start"> <b>Shipping Address</b>
                <p class="text-justify pt-2">James Thompson, 356 Jonathon Apt.220,</p>
                <p class="text-justify">New York</p>
            </div>
        </div>
    </div>
    <div class="pl-3 font-weight-bold">Related Subsriptions</div>
    <div class="d-sm-flex justify-content-between rounded my-3 subscriptions">
        <div> <b>#9632</b> </div>
        <div>May 22, 2017</div>
        <div>Status: Processing</div>
        <div> Total: <b> $68.8 for 10 items</b> </div>
    </div>
</div>
    </body>
</html>
