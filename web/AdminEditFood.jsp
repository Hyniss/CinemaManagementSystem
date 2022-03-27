
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Amazing Cinema</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>

        <!-- icon -->
        <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/queries.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/homepage.css" />
        <!-- Sakura -->
        <link href="${pageContext.request.contextPath}/assets/css/jquery-sakura.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Food and Drink</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>

            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header">
                            <form method="post" action="tourmanage">
                                <h4 class="modal-title">Edit Food and Drink</h4>
                                <button type="submit" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </form>
                        </div>
                        <form action="AdminEditFood" method="post">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${fd.foodId}" type="text" class="form-control" readonly id="input-1" placeholder="ID" name="new_id">
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <input value="${fd.category}" type="text" class="form-control" id="input-2" placeholder="Update Category ..." name="new_Category">
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input value="${fd.name}" type="text" class="form-control" id="input-2" placeholder="Update Name ..." name="new_Name">
                                </div>

                                <div>
                                    <p class="text-muted">Image<span style="color:red;"> *</span></p>
                                    <img class="rounded" height="20%" width="30%" id="image" src="${pageContext.request.contextPath}/assets/img/food/${fd.img}" />
                                    <div id="myfileupload">
                                        <input value="${pageContext.request.contextPath}/assets/img/food/${fd.img}" type="file" name="new_Img" id="uploadfile" onchange="readURL(this);" />
                                    </div>
                                    <div id="thumbbox">
                                        <img class="rounded" height="20%" width="30%" alt="Thumb image" id="thumbimage" style="display: none" />
                                        <a class="removeimg" href="javascript:"></a>
                                    </div>
                                    <div id="boxchoice">
                                        <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i>Browse</a>
                                        <p style="clear:both"></p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>Price (VNĐ)</label>
                                    <input value="${fd.price}" type="number" class="form-control" id="input-10" placeholder="Update Price ... " name="new_Price">
                                </div>
                                <p style="color: red;font-size: 14px">${error}</p>
                                <p style="color: red;font-size: 14px">${mess}</p>
                                <p style="color: green;font-size: 14px">${successMessage}</p>                                

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                                <a class="btn btn-danger" href="AdminListFood" role="button">Back to Manage</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- SAKURA -->
        <!--        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>-->
        <script src="assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery-sakura.js"></script>
        <script>
                                            $(window).load(function () {
                                                $('body').sakura();
                                            });
        </script>

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


