<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rap chieu phim</title>
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="assets/font/themify-icons/themify-icons.css">
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
</head>
<body>
    <div class="home">
        <a href="home" class="home-user">Home</a>
    </div>
    <div id="container">

        
        <form action="login" id="form-login" method="post">
            <h1 class="form-heading">Login</h1>
            <h3 style="color: red;font-weight:50 ">${mess}</h3>
            <div class="form-group">
                <i class="form-icon far fa-user"></i>
                <input value="${username}"  name="user" type="text" class="form-input" placeholder="Tên đăng nhập">
            </div>
            <div class="form-group">
                <i class="form-icon fas fa-key"></i>
                <input value="${password}"  name="pass" type="password" class="form-input" placeholder="Mật khẩu">
                <div id="eye">
                    <i class="form-icon far fa-eye"></i>
                </div>
            </div>

        <div class="form-save">
            <input  name="remember" type="checkbox" class="form-checksave"> Remember me
            <a href="ForgotPass.jsp" class="form-forget">Forgot Password?</a>
        </div>
        <input type="submit" value="Đăng nhập" class="form-submit">

        <h3 class="form-question">Dont't have an Account? <a href="Register.jsp" class="">Register!</a> </h3>
        </form>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="assets/js/app.js"></script>
</html>