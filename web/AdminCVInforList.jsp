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
                                                <th scope="col" style="width: 2%; text-align: center">#</th>
                                                <th scope="col" style="width: 15%">Fullname</th>
                                                <th scope="col" style="width: 15%">CV</th>
                                                <!--                                                <th scope="col" style="width: 15%">Chức vụ</th>-->
<!--                                                <th scope="col" style="width: 15%">Date</th>-->
                                                <th scope="col" style="width: 15%">Status</th>
                                                <th scope="col" style="width: 15%">Action</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${cvInforList}" var="cvInforList">
                                                <tr>
                                                    <td scope="row" style="text-align: center">${cvInforList.id}</td>
                                                    <td style="text-align: center">${cvInforList.fullname}</td>
                                                    <td>
<!--                                                        <img id="myImg" src="${pageContext.request.contextPath}/assets/img/CV/${cvInforList.CV}" alt="CV Image" style="width:100%;max-width:300px">
                                                         The Modal 
                                                        <div id="myModal" class="modal">

                                                             The Close Button 
                                                            <span class="close">&times;</span>

                                                             Modal Content (The Image) 
                                                            <img class="modal-content" id="img01">

                                                             Modal Caption (Image Text) 
                                                            <div id="caption"></div>
                                                        </div>
                                                        <style>
                                                            #myImg {
                                                                border-radius: 5px;
                                                                cursor: pointer;
                                                                transition: 0.3s;
                                                            }

                                                            #myImg:hover {opacity: 0.7;}

                                                            /* The Modal (background) */
                                                            .modal {
                                                                display: none; /* Hidden by default */
                                                                position: fixed; /* Stay in place */
                                                                z-index: 1; /* Sit on top */
                                                                padding-top: 100px; /* Location of the box */
                                                                left: 0;
                                                                top: 0;
                                                                width: 100%; /* Full width */
                                                                height: 100%; /* Full height */
                                                                overflow: auto; /* Enable scroll if needed */
                                                                background-color: rgb(0,0,0); /* Fallback color */
                                                                background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
                                                            }

                                                            /* Modal Content (Image) */
                                                            .modal-content {
                                                                margin: auto;
                                                                display: block;
                                                                width: 80%;
                                                                max-width: 700px;
                                                            }

                                                            /* Caption of Modal Image (Image Text) - Same Width as the Image */
                                                            #caption {
                                                                margin: auto;
                                                                display: block;
                                                                width: 80%;
                                                                max-width: 700px;
                                                                text-align: center;
                                                                color: #ccc;
                                                                padding: 10px 0;
                                                                height: 150px;
                                                            }

                                                            /* Add Animation - Zoom in the Modal */
                                                            .modal-content, #caption {
                                                                animation-name: zoom;
                                                                animation-duration: 0.6s;
                                                            }

                                                            @keyframes zoom {
                                                                from {transform:scale(0)}
                                                                to {transform:scale(1)}
                                                            }

                                                            /* The Close Button */
                                                            .close {
                                                                position: absolute;
                                                                top: 15px;
                                                                right: 35px;
                                                                color: #f1f1f1;
                                                                font-size: 40px;
                                                                font-weight: bold;
                                                                transition: 0.3s;
                                                            }

                                                            .close:hover,
                                                            .close:focus {
                                                                color: #bbb;
                                                                text-decoration: none;
                                                                cursor: pointer;
                                                            }

                                                            /* 100% Image Width on Smaller Screens */
                                                            @media only screen and (max-width: 700px){
                                                                .modal-content {
                                                                    width: 100%;
                                                                }
                                                            }
                                                        </style>
                                                        <script>
                                                            // Get the modal
                                                            var modal = document.getElementById("myModal");

                                                            // Get the image and insert it inside the modal - use its "alt" text as a caption
                                                            var img = document.getElementById("myImg");
                                                            var modalImg = document.getElementById("img01");
                                                            var captionText = document.getElementById("caption");
                                                            img.onclick = function () {
                                                                modal.style.display = "block";
                                                                modalImg.src = this.src;
                                                                captionText.innerHTML = this.alt;
                                                            }

                                                            // Get the <span> element that closes the modal
                                                            var span = document.getElementsByClassName("close")[0];

                                                            // When the user clicks on <span> (x), close the modal
                                                            span.onclick = function () {
                                                                modal.style.display = "none";
                                                            }
                                                        </script>-->
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
                                                        <a target="_blank" href="${pageContext.request.contextPath}/assets/img/CV/${cvInforList.CV}">
                                                            <img src="${pageContext.request.contextPath}/assets/img/CV/${cvInforList.CV}" alt="Forest" style="width:150px">
                                                        </a>
                                                    </td>
<!--                                                    <td style="text-align: center">${cvInforList.chucvu}</td>-->
<!--                                                    <td style="text-align: center">${cvInforList.date}</td>-->
                                                    <td>
                                                        <select name="cvStatusList" class="form-select" aria-label="Default select example">
                                                            <c:forEach items="${cvStatusList}" var="o">
                                                                <option value="${o.id}" ${ o.id==cvInforList.id ? "selected" : ""}>${o.getStatus()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                    <td  style="text-align: center"> <button type="submit" class="btn btn-success">Save</button></td>
                                                    </div>
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