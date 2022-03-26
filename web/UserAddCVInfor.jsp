<%-- 
    Document   : UserAddCVInfor
    Created on : 28-Feb-2022, 14:19:09
    Author     : Bảo Châu Bống
--%>

<%-- 
    Document   : AdminAddBanner
    Created on : 13-Feb-2022, 01:41:21
    Author     : Bảo Châu Bống
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
                            <h2>Add <b>CV</b></h2>
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
                                <h4 class="modal-title">Add CV</h4>
                                <button type="submit" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </form>
                        </div>
                        <form action="add_CV" method="post">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Fullname</label>
                                    <input value="${cvinfor.fullname}" type="text" class="form-control" placeholder="Add Fullname ..." required name="new_fullname">
                                </div>
                                <div class="form-group">
                                    <label>Upload CV</label>
                                    <input value="${cvinfor.CV}" type="file" class="form-control" id="input-1" placeholder="Add Image" required name="new_CV">
                                </div>


                                <div class="form-group">
                                    <label>Description</label>
                                    <div>
                                        <input value="${cvinfor.date}" type="date" class="form-control" id="the-date" placeholder="Ngày đăng" name="new_date">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Role</label> 
                                    <select name="new_chucvu" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${recruitmentList}" var="o">
                                            <option value="${o.ID}" ${o.ID == cvinfor.chucvu ? "selected" : ""}>${o.title}</option>
                                        </c:forEach>                                      
                                    </select>
                                </div>
                                <p style="color: red;font-size: 14px">${error}</p>
                                <p style="color: red;font-size: 14px">${mess}</p>

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Add">
                                <a class="btn btn-danger" href="recruitment" role="button">Back to Manage</a>
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

