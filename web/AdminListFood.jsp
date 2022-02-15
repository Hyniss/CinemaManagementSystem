

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
                    <button class="btn btn-icon btn-3 bg-gradient-primary mx-3"><a href="${pageContext.request.contextPath}/AdminAddFoodController">
                            <span class="btn-inner--icon text-md" style="color: red"><i class="fas fa-plus-square"></i></span>
                            <span class="btn-inner--text text-sm" style="color: red;">Create</span></button>
                </div>
                <div class="col-lg-12">
                    <div class="card"  style="border-radius: 12px" >
                        <div class="card-body">
                            <h4 class="card-title" style="margin: 30px">List Food</h4>
                            <div class="table-responsive"  style="margin-left: 0px; margin-right: 5%">
                                <table class="table table-striped ">
                                    <thead>
                                        <tr style="text-align: center">
                                            <th scope="col" style="width: 2%; text-align: center">#</th>
                                            <th scope="col" style="width: 15%">Category</th>
                                            <th scope="col" style="width: 35%">Image</th>
                                            <th scope="col" style="width: 15%">Name</th>
                                            <th scope="col" style="width: 10%">Price</th>
                                            <th scope="col" style="width: 25%">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${foodList}" var="food">
                                            <tr>
                                                <td scope="row" style="text-align: center">${food.foodId}</td>
                                                <td style="text-align: center">${food.category}</td>
                                                <td style="text-align: center"><img style="object-fit: cover; height: 50%; width: 100%; text-align: center" src="${pageContext.request.contextPath}/assets/img/food/${food.img}"></td>
                                                <td style="text-align: center">${food.name}</td>
                                                <td style="text-align: center">${food.price}</td>
                                                <td style="text-align: center">
                                                    <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/AdminEditFood?id=${food.foodId}"><p  style="color: #ffffff; margin: 1px">Update</p></a></button>
                                                 
                                                    <a href="#" onclick="showMess(${food.foodId})" class="btn btn-success"><p  style="color: #ffffff; margin: 1px">Delete</p>

                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
            window.location.href = 'AdminDeleteFood?id=' + id;
        }
    }
</script>