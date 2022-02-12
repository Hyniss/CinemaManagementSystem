<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/forgotPass.css">
    <title>Document</title>
</head>
<body>
    <div class="home">
        <a href="home" class="home-user">Home</a>
    </div>
    <div class="container">
        <form action="" class="form-forgot">
            <div class="title">Khôi phục lại mật khẩu</div>
            <p class="form-mess">
               Hãy nhập email của bạn chúng tôi sẽ gửi mật khẩu mới vào email.
            </p>

            <div class="user-details">
                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="text" placeholder="Nhập email của bạn" required>
                </div>
            </div>

            <div class="button">
                <input type="submit" value="Xác nhận">
            </div>
            
            <a href="Login.jsp" class="form-returnlogin">Đăng nhập</a>
        </form>
    </div>
</body>
</html>