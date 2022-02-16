<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="assets/css/register.css">
</head>
<body>
    <div class="home">
        <a href="home" class="home-user">Home</a>
    </div>
    <div class="container">
        
        <form action="signup" class="form-register">
            <div class="title">Registration</div>
            <h3 style="color: red;font-weight: 200;margin: 10px">${mess}</h3>
            <h3 style="color:#3CB371;font-weight: 200;margin: 10px">${messSuccess}</h3>
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Fullname</span>
                    <input value="${fullname}" name="fullname" type="text" placeholder="Enter your name" required>
                </div>
                
            
                <div class="input-box">
                    <span class="details">Username</span>
                    <input value="${username}" name="username" type="text" placeholder="Enter your username" required>
                </div>
                
            
                <div class="input-box">
                    <span class="details">Email</span>
                    <input value="${email}" name="email" type="text" placeholder="Enter your email" required>
                </div>
                

                <div class="input-box">
                    <span class="details">Phone number</span>
                    <input value="${phone}" name="phone" type="text" placeholder="Enter your phone" required>
                </div>
                
            
                <div class="input-box">
                    <span class="details">Password</span>
                    <input value="${password}" name="password" type="password" placeholder="Enter your password" required>
                </div>
                
         
            
                <div class="input-box">
                    <span class="details">Confirm password</span>
                    <input value="${repassword}" name="repassword" type="password" placeholder="Confirm your password" required>
                </div>
                
            
                <div class="input-box">
                    <span class="details">Date</span>
                    <input value="${date}" name="date" type="date" placeholder="Enter your date" required>
                </div>
                
      
            </div>

            <div class="button">
                <input type="submit" value="Register">
            </div>
            
            <h4 class="form-question">Dont't have an Account? <a href="Login.jsp" class="">Login now!</a> </h4>
        </form>
    </div>
</body>
</html>