<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/changePass.css">
    <title>Document</title>
</head>
<body>
    <div class="home">
        <a href="home" class="home-user">Home</a>
    </div>
    <div class="container">
        <form action="changepass" class="form-change">
            <div class="title">Change password</div>
            <h3 style="color: red;font-weight: 200;margin: 10px">${mess}</h3>
            <h3 style="color:#3CB371;font-weight: 200;margin: 10px">${messSuccess}</h3>
            <div class="user-details">

                
                <div class="input-box">
                    <span class="details">Enter current password</span>
                    <input value="${oldpass}" name="pass" type="text" placeholder="Mật khẩu hiện tại" required>
                </div>
                
            
                <div class="input-box">
                    <span class="details">Enter new password</span>
                    <input value="${newpass}" name="newpass" type="text" placeholder="Mật khẩu mới" required>
                </div>
                
            
                <div class="input-box">
                    <span class="details">Enter a new password</span>
                    <input value="${renewpass}" name="renewpass" type="text" placeholder="Nhập lại mật khẩu mới" required>
                </div>
            </div>

            <div class="button">
                <input type="submit" value="Save">
            </div>
        </form>
    </div>
</body>
</html>