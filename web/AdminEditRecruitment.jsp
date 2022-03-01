<%-- 
    Document   : AdminEditRecruitment
    Created on : 27-Feb-2022, 02:18:50
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
<%@include file="template/header.jsp" %>

<body>
    <div class="content-wrapper">
        <div class="container-fluid">
            <div class="row mt-3">
                <div class="col-lg-8">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">Update Promotion</div>
                            <hr>
                            <form action="edit_recruitment" method="post">
                                <h3 style="color: red;font-weight: 200;margin: 10px">${mess}</h3>
                                <div class="form-group">
                                    <label for="input-1">ID</label>
                                    <input type="text" class="form-control" readonly id="input-1" placeholder="ID" value="${recruitment.getID()}" name="new_id">
                                </div>
                                <div class="form-group">
                                    <label for="input-2">Title</label>
                                    <input type="text" class="form-control" id="input-2" placeholder="Update Title ..." value="${recruitment.getTitle()}"name="new_Title">
                                </div>
                                <div class="form-group">
                                    <label for="input-2">Image</label>
                                    <input type="text" class="form-control" id="input-10" placeholder="The direct of Image" value="${recruitment.getImg()}"name="new_img">
                                </div>
                                <div class="form-group">
                                    <label for="input-3">Content</label>
                                    <textarea class="form-control" rows="4" id="input-17" name="new_content">${recruitment.content}</textarea>
                                </div>
                                <div class="form-group">
                                    <label for="input-5">Created Date</label>
                                    <input type="date" class="form-control" id="input-5" value="${recruitment.date}" name="new_date">
                                </div>
                                <div class="form-footer">
                                    <button class="btn btn-success">Save</button>
                                    <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/adminrecruitmentlist">Hủy</a></button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="overlay toggle-menu"></div>
        </div>
    </div>
</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-sakura.js"></script>
<script>
    $(window).load(function () {
        $('body').sakura();
    });
</script>