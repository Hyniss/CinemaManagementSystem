<%-- 
    Document   : AdminCVInforList
    Created on : 28-Feb-2022, 14:47:26
    Author     : Bảo Châu Bống
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Amazing Cinema</title>
</head>

<body>
    <%@include file="template/header.jsp" %>
    <div class="content-wrapper" style="margin-bottom: 50px">

        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12" style="margin: 30px">
<!--                    <button class="btn btn-icon btn-3 bg-gradient-primary mx-3"><a href="${pageContext.request.contextPath}/add_banner">
                        <span class="btn-inner--icon text-md" style="color: red"><i class="fas fa-plus-square"></i></span>
                        <span class="btn-inner--text text-sm" style="color: red;">Create</span>
                </button>-->
                </div>
                <form action="${pageContext.request.contextPath}/admincvlist" method="post">

                    <div class="col-lg-12">
                        <div class="card"  style="border-radius: 12px" >
                            <div class="card-body">
                                <h4 class="card-title" style="margin: 30px">List CV</h4>
                                <div class="table-responsive"  style="margin-left: 0px; margin-right: 5%">
                                    <table class="table table-striped ">
                                        <thead>
                                            <tr style="text-align: center">
                                                <th scope="col" style="width: 5%; text-align: center">#</th>
                                                <th scope="col" style="width: 19%">Fullname</th>
                                                <th scope="col" style="width: 19%">CV</th>
                                                <!--                                                <th scope="col" style="width: 19%">Role</th>-->
                                                <th scope="col" style="width: 19%">Status</th>
                                                <th scope="col" style="width: 19%">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${cvInforList}" var="o">
                                                <tr>
                                                    <td name="new_id" style="text-align: center" >${o.id}</td>
                                                    <td style="text-align: center" >${o.fullname}</td>                                                   
                                                    <td >
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
                                                        <a target="_blank" href="${pageContext.request.contextPath}/assets/img/CV/${o.CV}">
                                                            <img src="${pageContext.request.contextPath}/assets/img/CV/${o.CV}" alt="Forest" style="width:150px">
                                                        </a>
                                                    </td>
                                                    <td>  
                                                        <form action="admincvlist" method="GET">
                                                            <select name="new_status" class="form-control" onchange="this.form.submit()" aria-label="Default select example">
                                                                <c:forEach items="${statusList}" var="a">
                                                                    <option value="${a.id}" ${ a.id==o.status ? "selected" : ""}>${a.status}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </form>
                                                    </td>
                                                    <td  style="text-align: center"> <button type="submit" class="btn btn-success">Save</button></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 col-md-4"></div>
                        <div class="col-sm-12 col-md-8">
                            <div class="mt-3" id="dataTable_paginate">
                                <ul class="pagination"   style="text-align: center">
                                    <li
                                        class="paginate_button page-item previous disabled"
                                        id="dataTable_previous"
                                        >
                                        <a
                                            href="#"
                                            aria-controls="dataTable"
                                            data-dt-idx="0"
                                            tabindex="0"
                                            class="page-link"
                                            >Previous</a
                                        >
                                    </li>
                                    <li class="paginate_button page-item active">
                                        <a
                                            href="#"
                                            aria-controls="dataTable"
                                            data-dt-idx="1"
                                            tabindex="0"
                                            class="page-link"
                                            >1</a
                                        >
                                    </li>
                                    <li class="paginate_button page-item next disabled" id="dataTable_next">
                                        <a
                                            href="#"
                                            aria-controls="dataTable"
                                            data-dt-idx="2"
                                            tabindex="0"
                                            class="page-link"
                                            >Next</a
                                        >
                                    </li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </form>
</div>

<script>
    var start = 0;
    function zoom() {
        if (start == 0) {
            w = image.width;
            h = image.height;
            image.width = image.width * 4;
            image.height = * 4;
            start = 1;
        } else {
            image.width = w;
            image.height = h;
            start = 0;
        }
    }
</script>
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
<%@include file="template/footer.jsp" %>
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
            window.location.href = 'delete_banner?id=' + id;
        }
    }
</script>
<script>
    function image(img) {
        var src = img.src;
        window.open(src);
    }
</script>