<%-- 
    Document   : AdminEditBanner
    Created on : 13-Feb-2022, 02:29:34
    Author     : Bảo Châu Bống
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
                            <h2>Edit <b>Banner</b></h2>
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
                                <h4 class="modal-title">Edit Banner</h4>
                                <button type="submit" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </form>
                        </div>
                        <form action="edit_banner" method="post">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${banner.id}" type="text" class="form-control" readonly id="input-1" placeholder="ID" value="${banner.id}" name="new_id">
                                </div>
                                <div class="form-group">
                                    <label>Title</label>
                                    <input value="${banner.title}" type="text" class="form-control" id="input-2" placeholder="Update Title ..." value="${banner.title}"name="new_title">
                                </div>
                                <div class="form-group">
                                    <label>Image</label>
                                    <input value="${banner.img}" type="file" class="form-control" id="input-10" placeholder="The direct of Image" value="${banner.img}"name="new_Img">
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <textarea class="form-control" rows="4" id="input-17" placeholder="Update Description ..." name="new_desc">${banner.desc}</textarea>
                                </div>
                                <p style="color: red;font-size: 14px">${error}</p>
                                <p style="color: red;font-size: 14px">${mess}</p>
                                <p style="color: green;font-size: 14px">${successMessage}</p>                                

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                                <a class="btn btn-danger" href="adminbannerlist" role="button">Back to Manage</a>
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

