<%-- 
    Document   : MovieDetail
    Created on : 08/02/2022, 9:49:22 PM
    Author     : Thái Trần
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
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
    </head>

    <body class="no-skin">         

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container">
            <%@include file="template/header.jsp" %>
            <section style="background-color: #fff" class="member-details" style="padding-top:50px;padding-bottom: 50px">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-4">
                            <div class="img-container">
                                <img src="${pageContext.request.contextPath}/assets/img/movie/${movie.getImage()}" alt="" class="img-full">
                            </div>
                        </div>
                        <div class="col-lg-9 col-md-8">
                            <div class="member_designation">
                                <h2>${movie.getMovieName()}</h2>
                                <span>${movie.getCategoryMovie()}</span>
                            </div>
                            <div class="member_desc">
                                
                                <ul class="styled_list">
                                    <li class=""><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>   Đạo diễn: ${movie.getAuthor()}</li>
                                    <li class=""><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>   Diễn viên: ${movie.getActor()}</li>
                                    <li class=""><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>   Thời lượng: ${movie.getDuration()} phút</li>
                                    <li class=""><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>   Ngày công chiếu: ${movie.getPremiere()}</li>
                                </ul>
                            </div>

                            <a href="#" type="button" class="btn btn-outline-danger">Đặt vé ngay</a>
                            
                            <div class="member_desc">
                                <h4>Mô tả</h4>
                                <p>
                                    ${movie.getDescription()}
                                </p>

                                <h4>Trailer</h4>
                                <iframe class="center"  style="margin-top:20px; width: 80%; height: 420px" width="560" height="315" src="${movie.getTrailer()}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>
                            
                            
                            
                        </div>

                    </div>
                </div>
            </section>
            <%@include file="template/footer.jsp" %>
        </div>

        <style>
            body{margin-top:20px;}

            .member-details {
                padding-top: 80px;
                padding-bottom: 80px
            }

            @media (min-width:992px) {
                .member-details {
                    padding-top: 100px;
                    padding-bottom: 100px
                }
            }

            .member-details .member_designation {
                margin-bottom: 30px
            }

            .member-details .member_designation h2 {
                margin-bottom: 5px;
                margin-top: 25px
            }

            @media (min-width:768px) {
                .member-details .member_designation h2 {
                    margin-top: 0
                }
            }

            .member-details .member_designation span {
                font-style: italic
            }

            .member-details .member_desc li {
                display: block;
                float: unset;
                width: 100%
            }

            .member-details .member_desc li i {
                color: #0cc652;
                font-size: 14px
            }

            .member-details .member_desc h4 {
                margin-top: 40px
            }

            .member-details .member_desc p {
                margin-top: 10px
            }

            .member-details .member_desc .progress-holder {
                margin-top: 30px
            }

            .member-details .media-box {
                margin-bottom: 20px
            }

            @media (min-width:992px) {
                .member-details .media-box {
                    margin-bottom: 0
                }
            }

            .member-details .member_contact {
                padding: 40px;
                position: relative;
                margin-top: 40px
            }

            .member-details .member_contact .media-icon {
                font-size: 32px;
                color: #dae0e6;
                position: relative;
                width: 30px;
                text-align: center;
                float: left;
                margin-right: 15px
            }

            .member-details .member_contact .media-content {
                padding-left: 0;
                float: left
            }

            .member-details .member_contact .media-content h5 {
                font-size: 15px
            }

            .member-details .member_contact .media-content h5,
            .member-details .member_contact .media-content a {
                color: #dae0e6
            }

            @media (min-width:992px) {
                .member-details .member_contact .social-icons {
                    text-align: right
                }
            }

            .member-details .member_contact .social-icons .btn-social {
                width: 40px;
                height: 40px;
                line-height: 40px
            }

            .member-details .member_contact .social-icons .btn {
                background-color: transparent;
                border: 1px solid;
                border-color: #999;
                color: #dae0e6
            }

            .member-details .member_contact .social-icons .btn:hover {
                background-color: #0cc652;
                border-color: #0cc652;
                opacity: 1
            }

            .bg-image-holder,
            .bg-image {
                background-size: cover!important;
                background-position: 50% 0!important;
                transition: all .3s linear;
                background: #f5f5f6;
                position: relative
            }

            .bg-image:before {
                content: '';
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: rgba(0, 0, 0, .7)
            }

            .bg-fixed {
                background-attachment: fixed
            }

            .bg-image .overlay-content {
                position: relative;
                z-index: 5
            }


            .progress-holder {
                margin-top: 50px
            }

            .progress-holder .barWrapper .progressText {
                font-size: 15px;
                color: #222
            }

            .progress-holder .progress {
                margin-bottom: 25px;
                margin-top: 10px;
                overflow: visible;
                background-color: #f5f5f6
            }

            .progress-holder .progress .progress-bar {
                position: relative
            }

            .progress-holder .progress .progress-bar:after {
                position: absolute;
                content: '';
                width: 1px;
                height: 33px;
                background-color: #0cc652;
                top: -8px;
                right: 0;
                z-index: 55
            }

            .img-full {
                width: 100%;
            }

            p {
                color: #8b8e93;
                font-weight: 300;
                margin-bottom: 0;
                font-size: 14px;
                line-height: 26px;
            }


            .styled_list {
                margin-top: 15px;
                position: relative;
                display: inline-block
            }

            @media (min-width:768px) {
                .styled_list {
                    margin-top: 15px
                }
            }

            .styled_list li {
                font-size: 14px;
                line-height: 30px
            }

            @media (min-width:768px) {
                .styled_list li {
                    font-size: 14px;
                    float: left;
                    width: 50%
                }
            }

            .styled_list li i {
                margin-right: 10px;
                font-size: 12px
            }

            .styled_list li a {
                color: #8b8e93
            }

            @media (min-width:768px) {
                .styled_list li a {
                    font-size: 12px
                }
            }

            @media (min-width:992px) {
                .styled_list li a {
                    font-size: 14px
                }
            }

            ol.styled_list {
                margin-left: 15px
            }

            ol.styled_list li {
                padding-left: 10px
            }
        </style>


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
    </body>
</html>

