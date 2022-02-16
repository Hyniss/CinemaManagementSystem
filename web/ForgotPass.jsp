<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/changePass.css">
    <title>Forget Pass</title>
</head>
 
<body>
    <div class="home">
        <a href="home" class="home-user">Home</a>
    </div>
    <div class="container">
        <form action="ForgotPassword" method="POST" class="form-change">
            <div class="title">Forget password</div>
            <h3 style="color: red;font-weight: 200;margin: 10px">${mess}</h3>
            <h3 style="color:#3CB371;font-weight: 200;margin: 10px">${messSuccess}</h3>
            <div class="user-details">
                
                 <div class="input-box">
                    <span class="details">Enter username</span>
                    <input name="username" type="text" placeholder="Nhập tài khoản" required>
                </div>
                
                <div class="input-box">
                    <span class="details">Enter email</span>
                    <input name="email" type="text" placeholder="Nhập email" required>
                </div>
             
            </div>

            <div class="button">
                <input type="submit" value="Send">
            </div>
        </form>
    </div>
</body>
</html>