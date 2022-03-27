<%-- 
    Document   : Profile
    Created on : 08/02/2022, 9:49:22 PM
    Author     : Thai Tran
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1" />
        <title>Amazing Cinema</title>
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
        <!-- Sakura -->
        <link href="${pageContext.request.contextPath}/assets/css/jquery-sakura.css" rel="stylesheet" type="text/css">
    </head>

    <body>

        <!--        HEADER-->
        <%@include file="template/header.jsp" %>


        <!-- CONTAINER       -->
        <div class="container-xl px-4 mt-4">
            <form action="accountedit" method="post">


                <hr class="mt-0 mb-4">
                <div class="row">
                    <div class="col-xl-4">
                        <!-- Profile picture card-->
                        <div class="card mb-4 mb-xl-0">
                            <div class="card-header">Tài khoản</div>
                            <div class="card-body text-center">
                                <!-- Profile picture image-->

                                <img id="image" class="img-account-profile rounded-circle mb-2" src="${pageContext.request.contextPath}/assets/avatars/${sessionScope.acc.getAvatar()}" alt="">
                                <!-- Profile picture help block-->
                                <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                                <!-- Profile picture upload button-->
                                <div id="myfileupload">
                                    <input value="${pageContext.request.contextPath}/assets/avatars/${sessionScope.acc.getAvatar()}}" type="file" name="avatar" id="uploadfile" onchange="readURL(this);" />
                                </div>
                                <div id="thumbbox">
                                    <img class="img-account-profile rounded-circle mb-2" alt="Thumb image" id="thumbimage" style="display: none" />
                                    <a class="removeimg" href="javascript:"></a>
                                </div>
                                <div id="boxchoice">
                                    <a href="javascript:" class="Choicefile"><i  class="fas fa-cloud-upload-alt" ></i>Browse</a>
                                    <p style="clear:both"></p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xl-8">
                        <!-- Account details card-->
                        <div class="card mb-4">
                            <div class="card-header">Thông tin chi tiết</div>
                            <div class="card-body">
                                <!-- Form Group (fullname)-->
                                <div class="mb-3">
                                    <label class="small mb-1">Họ tên<span style="color:red;"> *</span></label>
                                    <input name="fullname" class="form-control" type="text" placeholder="Enter your fullname" value="${sessionScope.acc.getFullName()}" required>
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (username)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">Tài khoản<span style="color:red;"> *</span></label>
                                        <input name="username" class="form-control" type="email" placeholder="Enter your username" value="${sessionScope.acc.getUsername()}" readonly>
                                    </div>
                                    <!-- Form Group (password)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">Mật khẩu<span style="color:red;"> *</span></label>
                                        <input name="password" class="form-control" type="password" placeholder="Enter your password" value="${sessionScope.acc.getPassword()}" readonly>
                                    </div>
                                </div>
                                <!-- Form Row        -->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (avatar)-->
                                    <!--                                    <div class="col-md-6">
                                                                            <input name="avatar" class="form-control" type="hidden" value="${sessionScope.acc.getAvatar()}" required>
                                                                        </div>-->
                                    <!-- Form Group (role id)-->
                                    <div class="col-md-6">
                                        <input name="roleid" class="form-control" type="hidden" value="${sessionScope.acc.getRoleId()}" required>
                                    </div>
                                </div>
                                <!-- Form Group (email address)-->
                                <div class="mb-3">
                                    <label class="small mb-1">Email<span style="color:red;"> *</span></label>
                                    <input name="email" class="form-control" type="email" placeholder="Enter your email address" value="${sessionScope.acc.getEmail()}" required>
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (phone number)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">Số điện thoại<span style="color:red;"> *</span></label>
                                        <input name="phone" class="form-control" type="number" placeholder="Enter your phone number" value="${sessionScope.acc.getPhone()}" required>
                                    </div>
                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1">DOB<span style="color:red;"> *</span></label>
                                        <input name="dob" class="form-control" type="date" placeholder="Enter your birthday" value="${sessionScope.acc.getDob()}" required>
                                    </div>
                                </div>
                                <!--                                Edit message    -->
                                <p style="color: red;font-size: 14px">${failMessage}</p>
                                <p style="color: red;font-size: 14px">${mess}</p>
                                <p style="color: green;font-size: 14px">${successMessage}</p>
                                <!-- Save changes button-->
                                <button class="btn btn-primary" type="submit">Thay đổi</button>
                                <a class="btn btn-primary" href="account">Quay lại</a>
                            </div>
                        </div>
                    </div>
                </div>

            </form>

        </div>


        <!--                                    CSS-->
        <style>
            body{
                background-color:#f2f6fc;
                color:#69707a;
            }
            .img-account-profile {
                height: 10rem;
            }
            .rounded-circle {
                border-radius: 50% !important;
            }
            .card {
                box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
            }
            .card .card-header {
                font-weight: 500;
            }
            .card-header:first-child {
                border-radius: 0.35rem 0.35rem 0 0;
            }
            .card-header {
                padding: 1rem 1.35rem;
                margin-bottom: 0;
                background-color: rgba(33, 40, 50, 0.03);
                border-bottom: 1px solid rgba(33, 40, 50, 0.125);
            }
            .form-control, .dataTable-input {
                display: block;
                width: 100%;
                padding: 0.875rem 1.125rem;
                font-size: 0.875rem;
                font-weight: 400;
                line-height: 1;
                color: #69707a;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #c5ccd6;
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                border-radius: 0.35rem;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }

            .nav-borders .nav-link.active {
                color: #0061f2;
                border-bottom-color: #0061f2;
            }
            .nav-borders .nav-link {
                color: #69707a;
                border-bottom-width: 0.125rem;
                border-bottom-style: solid;
                border-bottom-color: transparent;
                padding-top: 0.5rem;
                padding-bottom: 0.5rem;
                padding-left: 0;
                padding-right: 0;
                margin-left: 1rem;
                margin-right: 1rem;
            }
        </style>

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
        <script>
                                        $(window).load(function () {
                                            $('body').sakura();
                                        });
        </script>

        <!--        FOOTER-->
        <%@include file="template/footer.jsp" %>

        <style>
            body a{
                text-decoration: none;
            }

            .form-create{
                margin: 50px 30px 10px 30px;
                border: 1px solid #000;
                width: 6%;
                text-align: center;
                padding: 5px 0;
                background-color: #000;
                color:#fff;
            }

            .form-create a{
                color: #fff;
            }


            .content-wrapper {
                margin-left: 5%;
                padding-left: 10px;
                padding-right: 10px;
                margin-right: 5%;
            }

            .card-body-icon {
                position: absolute;
                z-index: 0;
                top: -25px;
                right: -25px;
                font-size: 5rem;
                -webkit-transform: rotate(15deg);
                -ms-transform: rotate(15deg);
                transform: rotate(15deg);
            }

            .table-striped tbody tr:nth-of-type(odd) {
                background-color: rgba(0, 0, 0, 0.05);
            }

            .Choicefile{
                display: block;
                background: #396CF0;
                border: 1px solid #fff;
                color: #fff;
                width: 150px;
                text-align: center;
                text-decoration: none;
                cursor: pointer;
                padding: 5px 0px;
                border-radius: 5px;
                font-weight: 500;
                align-items: center;
                justify-content: center;
            }

            .Choicefile:hover {
                text-decoration: none;
                color: white;
            }

            #uploadfile,
            .removeimg {
                display: none;
            }

            #thumbbox {
                position: relative;
                width: 100%;
                margin-bottom: 20px;
            }

            .removeimg {
                height: 25px;
                position: absolute;
                background-repeat: no-repeat;
                top: 5px;
                left: 5px;
                background-size: 25px;
                width: 25px;
                border-radius: 50%;

            }

            .removeimg::before {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
                content: '';
                border: 1px solid red;
                background: red;
                text-align: center;
                display: block;
                margin-top: 11px;
                transform: rotate(45deg);
            }

            .removeimg::after {
                content: '';
                background: red;
                border: 1px solid red;
                text-align: center;
                display: block;
                transform: rotate(-45deg);
                margin-top: -2px;
            }
        </style>

        <script>
            function readURL(input, thumbimage) {
                if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#thumbimage").attr('src', e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                } else { // Sử dụng cho IE
                    $("#thumbimage").attr('src', input.value);

                }
                $("#thumbimage").show();
                $("#image").hide();
                $('.filename').text($("#uploadfile").val());
                $(".Choicefile").hide();
                $(".removeimg").show();
            }
            $(document).ready(function () {
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();

                });
                $(".removeimg").click(function () {
                    $("#thumbimage").attr('src', '').hide();
                    $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                    $(".removeimg").hide();
                    $("#image").show();
                    $(".Choicefile").show();
                    $(".filename").text("");
                });
            })
        </script>
    </body>
</html>

