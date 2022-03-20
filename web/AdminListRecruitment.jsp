<%-- 
    Document   : AdminRecruitmentList
    Created on : 27-Feb-2022, 01:05:10
    Author     : Bảo Châu Bống
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.text.DateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0,minimum-scale=1" />
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!--FONTAWESOME-->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>Amazing Cinema</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/queries.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/admin.css" />
    </head>

    <body>

        <aside class="sidebar position-fixed top-0 left-0 overflow-auto h-100 float-left" id="show-side-navigation1">
            <i class="fas fa-bars close-aside d-md-none d-lg-none" data-close="show-side-navigation1"></i>
            <div class="sidebar-header d-flex justify-content-center align-items-center px-3 py-4">
                <img
                    class="rounded-pill img-fluid"
                    width="65"
                    src="${pageContext.request.contextPath}/assets/images/128-1280822_check-mark-box-clip-art-blue-admin-icon.png"
                    alt="">
                <div class="ms-2">
                    <h5 class="fs-6 mb-0">
                        <a class="text-decoration-none" href="#">Admin                       
                            <i class="fas fa-cogs"></i> 
                        </a>
                    </h5>
                </div>
            </div>
            <%@include file="template/adminMenu.jsp" %>
        </aside>

        <section id="wrapper">
            <%@include file="template/adminNewHeader.jsp" %>
            <div class="p-4">
                <div class="welcome">
                    <div class="content rounded-3 p-3">
                        <h1 class="fs-3"><i class="fa fa-users" aria-hidden="true"></i> Recruitment Management</h1>
                    </div>
                </div>   
                <div style="display: flex; justify-content: end; margin: 10px">
                    <a href="add_recruitment" class="custom-btn btn-crud"><span>Add !</span><span>Add more</span></a>
                </div>

                <div class="admin-table table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col" style="width: 10%; text-align: center">Title</th>
                                <th scope="col" style="width: 25%; text-align: center">Image</th>
                                <th scope="col" style="width: 20%; text-align: center">Content</th>
                                <th scope="col" style="width: 15%; text-align: center">Created Date</th>
                                <th scope="col" style="width: 15%; text-align: center">Action</th>
                                <th scope="col" style="width: 15%; text-align: center">Action</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${recruitmentList}" var="recruitment">                               
                                <tr>
                                    <td scope="row">${recruitment.getID()}</td>
                                    <td style="text-align: center; font-size: 15px">${recruitment.getTitle()}</td>

                                    <td style="text-align: center ; font-size: 15px">

                                        <style>
                                            .row img {
                                                border: 1px solid #ddd;
                                                border-radius: 4px;
                                                padding: 5px;
                                                width: 150px;
                                            }

                                            img:hover {
                                                box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
                                            }
                                        </style>
                                        <a target="_blank" href="${pageContext.request.contextPath}/assets/img/recruitment/${recruitment.getImg()}">
                                            <img src="${pageContext.request.contextPath}/assets/img/recruitment/${recruitment.getImg()}" alt="Forest" style="width:80%">
                                        </a>

                                    </td>
                                    <td style="text-align: center; font-size: 15px">${recruitment.getContent()}</td>
                                    <td style="text-align: center; font-size: 15px">${recruitment.getFormatedDate()}</td>
                                    <td style="text-align: center; font-size: 15px">                    
                                        <a href="${pageContext.request.contextPath}/edit_recruitment?id=${recruitment.getID()}" class="custom-btn btn-crud"><span>Update now!</span><span>Update</span></button></a>
                                    </td>
                                    <td style="text-align: center">                                    
                                        <button onclick="showMess(${recruitment.getID()})"  class="custom-btn btn-crud"><span>Delete now !</span><span>Delete</span></button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="template/adminStatics.jsp" %>
            </div>
            <!--footer-->
            <%@include file="template/adminFooter.jsp" %>
        </section>



        <style>
            .content-wrapper {
                margin-left: 10%;
                padding-left: 10px;
                padding-right: 10px;
                margin-right: 10%;
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
        </style>
    </div>
</body>

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
    function showMess(id) {
        var option = confirm('Are you sure to delete?');
        if (option === true) {
            window.location.href = 'delete_recruitment?id=' + id;
        }
    }
</script>

