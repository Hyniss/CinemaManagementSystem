<%-- 
    Document   : AdminEditAccount
    Created on : Feb 23, 2022, 9:08:25 PM
    Author     : HP
--%>

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
                            <h2>Edit <b>Account</b></h2>
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
                                <h4 class="modal-title">Edit Account</h4>
                                <button type="submit" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </form>
                        </div>
                        <form action="adminaccountedit" method="post">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>User name<span style="color:red;"> *</span></label>
                                    <input value="${account.username}" name="username" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Password<span style="color:red;"> *</span></label>
                                    <input value="${account.password}" name="password" type="password" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <!--                                    <label>Avatar</label>-->
                                    <input value="${account.avatar}" name="avatar" type="hidden" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Full name<span style="color:red;"> *</span></label>
                                    <input value="${account.fullName}" name="fullname" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>DOB<span style="color:red;"> *</span></label>
                                    <input value="${account.dob}" name="dob" type="date" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Email<span style="color:red;"> *</span></label>
                                    <input value="${account.email}" name="email" type="email" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Phone<span style="color:red;"> *</span></label>
                                    <input value="${account.phone}" name="phone" type="number" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <!--                                    <label>Role</label>-->
                                    <input value="${account.roleId}" name="roleid" type="hidden" class="form-control" required>
                                </div>
                                <p style="color: red;font-size: 14px">${failMessage}</p>
                                <p style="color: red;font-size: 14px">${mess}</p>
                                <p style="color: green;font-size: 14px">${successMessage}</p>                                

                            </div>
                            <div class="modal-footer">
                                <a class="btn btn-danger" href="adminaccountlist?roleId=${account.roleId}" role="button">Back to Manage</a>
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- SAKURA -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery-sakura.js"></script>
        <script>
            $(window).load(function () {
                $('body').sakura();
            });
        </script>
    </body>
</html>
