<%-- 
    Document   : AdminListNotification
    Created on : Mar 8, 2022, 7:12:12 PM
    Author     : HP
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

        <!--        CRUD ACC-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Varela Round', sans-serif;
                font-size: 13px;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                min-width: 1000px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {        
                padding-bottom: 15px;
                background: #435d7d;
                color: #fff;
                padding: 16px 30px;
                min-width: 100%;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }
            .table-title .btn-group {
                float: right;
            }
            .table-title .btn {
                color: #fff;
                float: right;
                font-size: 13px;
                border: none;
                min-width: 50px;
                border-radius: 2px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }
            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }
            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }
            table.table tr th:first-child {
                width: 60px;
            }
            table.table tr th:last-child {
                width: 100px;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }	
            table.table td:last-child i {
                opacity: 0.9;
                font-size: 22px;
                margin: 0 5px;
            }
            table.table td a {
                font-weight: bold;
                color: #566787;
                display: inline-block;
                text-decoration: none;
                outline: none !important;
            }
            table.table td a:hover {
                color: #2196F3;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #F44336;
            }
            table.table td i {
                font-size: 19px;
            }
            table.table .avatar {
                border-radius: 50%;
                vertical-align: middle;
                margin-right: 10px;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }
            .pagination li a:hover {
                color: #666;
            }	
            .pagination li.active a, .pagination li.active a.page-link {
                background: #03A9F4;
            }
            .pagination li.active a:hover {        
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 10px;
                font-size: 13px;
            }    
            #navbar1 {
                padding: 0 0 0 0 ;
            }
        </style>
        <script>
            $(document).ready(function () {
                // Activate tooltip
                $('[data-toggle="tooltip"]').tooltip();

                // Select/Deselect checkboxes
                var checkbox = $('table tbody input[type="checkbox"]');
                $("#selectAll").click(function () {
                    if (this.checked) {
                        checkbox.each(function () {
                            this.checked = true;
                        });
                    } else {
                        checkbox.each(function () {
                            this.checked = false;
                        });
                    }
                });
                checkbox.click(function () {
                    if (!this.checked) {
                        $("#selectAll").prop("checked", false);
                    }
                });
            });
        </script>
    </head>
    <body>


        <!--        HEADER-->
        <%@include file="template/adminheader.jsp" %>


        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>
                                    Manage <b>Notification</b>
                                </h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="adminnotificationadd" class="btn btn-success"><i class="material-icons">&#xE147;</i>Add New Notification</a>
                            </div>
                        </div>
                    </div>
                    <form action="adminnotificationsearch" method="post" style="width:40%;min-width: 200px; margin: 10px auto 10px auto " class="input-group rounded">
                        <input value="${searchtxt}" name="searchtxt" value="" type="search" class="form-control rounded" placeholder="Search by Title" aria-label="Search" aria-describedby="search-addon" />
                        <button type="submit"  style="height:38px;" class="input-group-text border-0" id="search-addon">
                            <i class="fas fa-search"></i></a>
                        </button>
                    </form>
                    <p style="color:red; text-align: center">${searchMess}</p>    
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Notification Title</th>
                                <th>Notification Description</th>
                                <th>Notification Date</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${notificationList}" var="notification" varStatus="i" >
                                <tr>
                                    <td style="width:25%"><img style="height:100%; width: 100%" src="${pageContext.request.contextPath}/assets/img/notification/${notification.notificationImg}"></td>
                                    <td>${notification.notificationTitle}</td>
                                    <td>${notification.notificationDescription}</td>
                                    <td>${notification.notificationDate}</td>
                                    <td>
                                        <a href="adminnotificationedit?notiId=${notification.notificationId}"><i class="material-icons" title="Edit">&#xE254;</i></a>
                                        <a href="#" onclick="showDelMess(${notification.notificationId})"><i class="material-icons" title="Delete">&#xE872;</i></a>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${searchtxt==null}">
                        <div class="clearfix">
                            <div class="hint-text">Showing <b>${notificationList.size()}</b> out of <b>${total}</b> entries</div>
                            <ul class="pagination">
                                <c:if test="${pageIndex>1}">
                                    <li class="page-item disabled"><a href="adminnotificationlist?pageIndex=${pageIndex-1}">Previous</a></li>
                                    <li class="page-item"><a class="page-link" href="adminnotificationlist?pageIndex=${pageIndex-1}">${pageIndex-1}</a></li>
                                    </c:if>
                                    <c:if test="${pageIndex!=null}">
                                    <li class="page-item active"><a class="page-link" href="adminnotificationlist?pageIndex=${pageIndex}">${pageIndex}</a></li>
                                    </c:if>
                                    <c:if test="${pageIndex<endPage}">
                                    <li class="page-item"><a class="page-link" href="adminnotificationlist?pageIndex=${pageIndex+1}">${pageIndex+1}</a></li>
                                    <li class="page-item"><a href="adminnotificationlist?pageIndex=${pageIndex+1}" class="page-link">Next</a></li>
                                    </c:if>
                            </ul>
                        </div>
                    </c:if>
                    <c:if test="${searchtxt!=null}">
                        <div class="clearfix">
                            <div class="hint-text">Showing <b>${notificationList.size()}</b> out of <b>${total}</b> entries</div>
                            <ul class="pagination">
                                <c:if test="${pageIndex>1}">
                                    <li class="page-item disabled"><a href="adminnotificationsearch?pageIndex=${pageIndex-1}&searchtxt=${searchtxt}">Previous</a></li>
                                    <li class="page-item"><a class="page-link" href="adminnotificationsearch?pageIndex=${pageIndex-1}&searchtxt=${searchtxt}">${pageIndex-1}</a></li>
                                    </c:if>
                                    <c:if test="${pageIndex!=null}">
                                    <li class="page-item active"><a class="page-link" href="adminnotificationsearch?pageIndex=${pageIndex}&searchtxt=${searchtxt}">${pageIndex}</a></li>
                                    </c:if>
                                    <c:if test="${pageIndex<endPage}">
                                    <li class="page-item"><a class="page-link" href="adminnotificationsearch?pageIndex=${pageIndex+1}&searchtxt=${searchtxt}">${pageIndex+1}</a></li>
                                    <li class="page-item"><a href="adminnotificationsearch?pageIndex=${pageIndex+1}&searchtxt=${searchtxt}" class="page-link">Next</a></li>
                                    </c:if>
                            </ul>
                        </div>
                    </c:if>
                </div>
            </div>
            <p style="color: red;font-size: 14px">${failMessage}</p>
            <p style="color: red;font-size: 14px">${mess}</p>
            <p style="color: green;font-size: 14px">${successMessage}</p>
        </div>

        <script>
            function showMess2(username, roleId) {
                var option = confirm('Are you sure to delete?');
                if (option === true) {
                    window.location.href = 'adminaccountdelete?username=' + username;
                }
            }
        </script>

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
        <script>
            function showDelMess(notiid) {
                var result = confirm("Bạn có muốn tiếp tục xóa không?");
                if (result === true) {
                    window.location.href = 'adminnotificationdelete?notiId=' + notiid;
                }
            }
        </script>


        <!--        FOOTER-->
        <%@include file="template/footer.jsp" %>
    </body>
</html>
