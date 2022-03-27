<%-- 
    Document   : CheckSecurity
    Created on : 27/03/2022, 10:12:57 AM
    Author     : TIEN HUY
--%>

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
            <form action="CheckSecurity" method="POST" class="form-change">
                <div class="title">Verify Code</div>
                <h3 style="color: red;font-weight: 200;margin: 10px">${mess}</h3>
                <h3 style="color:#3CB371;font-weight: 200;margin: 10px">${messSuccess}</h3>
                <div class="user-details">

                    <div class="input-box">
                        <span class="details">Enter code</span>
                        <input name="code" type="text" placeholder="Nhập mã xác thực" required>
                    </div>
                </div>

                <div class="button">
                    <input type="submit" value="Verify">
                </div>
            </form>
        </div>
    </body>
</html>