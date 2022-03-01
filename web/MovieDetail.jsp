<%-- 
    Document   : MovieDetail
    Created on : 08/02/2022, 9:49:22 PM
    Author     : Thái Trần
--%>

<%@page import="model.Account"%>
<%@page import="model.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Feedback"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <%Movie movie = (Movie) request.getAttribute("movie");%>
        <%Account account = (Account) request.getSession().getAttribute("acc");%>
        <%ArrayList<Feedback> listFeedback = (ArrayList<Feedback>) request.getAttribute("listFeedback");%>     
    </head>

    <body class="no-skin">   
        <%@include file="template/header.jsp" %>

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container">
            <section style="background-color: #fff" class="member-details" style="padding-top:50px;padding-bottom: 50px">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-4">
                            <div class="img-container">
                                <img src="${pageContext.request.contextPath}/assets/img/movie/<%=movie.getImage()%>" alt="" class="img-full">
                            </div>
                        </div>
                        <div class="col-lg-9 col-md-8">
                            <div class="member_designation">
                                <h2><%=movie.getMovieName()%></h2>
                                <span><%=movie.getCategoryMovie()%></span>
                            </div>
                            <div class="member_desc">

                                <ul class="styled_list">
                                    <li class=""><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>   Đạo diễn: <%=movie.getAuthor()%></li>
                                    <li class=""><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>   Diễn viên: <%=movie.getActor()%></li>
                                    <li class=""><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>   Thời lượng: <%=movie.getDuration()%> phút</li>
                                    <li class=""><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>   Ngày công chiếu:
                                        <fmt:formatDate pattern="dd-MM-yyyy" value = "<%=movie.getPremiere()%>"/>  </li>
                                </ul>
                            </div>
                             <!--tag để biết đường dẫn thôi nhé -->
                            <a href="#" type="button" class="btn btn-outline-danger">Đặt vé ngay</a>

                            <div class="member_desc">
                                <h4 style="font-weight: bold">Mô tả</h4>
                                <p>
                                    <%=movie.getDescription()%> 
                                </p>

                                <h4 style="font-weight: bold">Trailer</h4>
                                <iframe class="center"  style="margin-top:20px; width: 80%; height: 420px" width="560" height="315" src="<%=movie.getTrailer()%>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>                           
                            <!--start review part-->
                            <div class="movie_review">
                                <h4 style="font-weight: bold">Đánh giá về bộ phim</h4>
                                <div class="review-action-list">
                                    <div class="review-sort">
                                        <form action="movie" method="get">
                                            <input type="hidden" name="mid" value="<%=movie.getMovieId()%>"/>
                                            <input type="hidden" name="pageIndex" value="${pageIndex}"/>
                                            <select name ="sortId" class="" onchange="this.form.submit()">
                                                <option value ="0" disabled selected>Sắp xếp theo</option>
                                                <option value="1" ${sortId == 1 ? "selected" : ""}>Đánh giá mới nhất</option>
                                                <option value="2" ${sortId == 2 ? "selected" : ""}>Đánh giá lâu nhất</option>
                                                <option value="3" ${sortId == 3 ? "selected" : ""}>Đánh giá cao nhất</option>
                                                <option value="4" ${sortId == 4 ? "selected" : ""}>Đánh giá thấp nhất</option>
                                            </select>
                                        </form>                                      
                                    </div>
                                    <div class="review-view">
                                        <!--have a review-->
                                        <% boolean check = false;%>
                                        <% if (listFeedback.isEmpty() || listFeedback == null) {
                                                check = true;
                                            }%>
                                        <% int count = 0;%>
                                        <%for (int i = 0; i < listFeedback.size(); i++) {%>
                                        <% if (listFeedback.get(i).getMovieId() == movie.getMovieId()) {%>
                                        <div class="user-rating">
                                            <div class="rating-content">
                                                <div class="rating-header">
                                                    <%count++;%>
                                                    <% String result = "";%>
                                                    <% if (account != null) {%>
                                                    <% if (account.getUsername().equals(listFeedback.get(i).getUsername())) {%>
                                                    <% for (int j = 0; j < account.getUsername().length(); j++) {
                                                            char u = account.getUsername().charAt(j);
                                                            u++;
                                                            result += u;
                                                        }
                                                    %>
                                                    <p><%=account.getFullName()%></p>
                                                    <p><fmt:formatDate pattern="dd-MM-yyyy" value = "<%=listFeedback.get(i).getFeedbackDate()%>"/> | 
                                                        <fmt:formatDate type="time" value="<%=listFeedback.get(i).getFeedbackTime()%>"/></p>  
                                                    <!--dropdown edit,delete-->
                                                    <% String dropdown = "dr" + count;%>
                                                    <% String editbtnId = "ebtn" + count;%>
                                                    <% String viewRateIndex = "rating" + count;%>
                                                    <% String viewrTextIndex = "ratingText" + count;%>
                                                    <% int feedIdIndex = listFeedback.get(i).getFeedbackId();%>
                                                    <div class="dropdown" id="<%=dropdown%>">
                                                        <a href=""><i class="fas fa-ellipsis-h"></i></a>
                                                        <div class="dropdown-content">
                                                            <a href="#"
                                                               onclick="openEditModal('<%=dropdown%>', '<%=editbtnId%>',<%=feedIdIndex%>, '<%=viewRateIndex%>', '<%=viewrTextIndex%>')"> Edit</a>
                                                            <a href="#" onclick="showConfirm(<%=listFeedback.get(i).getFeedbackId()%>,<%=movie.getMovieId()%>, '<%=result%>')">Delete</a>
                                                        </div>
                                                    </div>
                                                    <div class="edit-btn" id="<%=editbtnId%>">
                                                        <p>Update</p>
                                                        <a href="#" onclick="closeEditModal('<%=dropdown%>', '<%=editbtnId%>',<%=feedIdIndex%>, '<%=viewRateIndex%>', '<%=viewrTextIndex%>')"><i class="far fa-times-circle"></i></a>
                                                    </div>
                                                    <% } else {%>
                                                    <!--account list not equal account session-->
                                                    <p><%="User " + count%></p>
                                                    <p><fmt:formatDate pattern="dd-MM-yyyy" value = "<%=listFeedback.get(i).getFeedbackDate()%>"/> | 
                                                        <fmt:formatDate type="time" value="<%=listFeedback.get(i).getFeedbackTime()%>"/></p> 
                                                        <% }%>
                                                        <% } else {%>
                                                    <!--account is null-->
                                                    <p><%="User " + count%></p>
                                                    <p><fmt:formatDate pattern="dd-MM-yyyy" value = "<%=listFeedback.get(i).getFeedbackDate()%>"/> | 
                                                        <fmt:formatDate type="time" value="<%=listFeedback.get(i).getFeedbackTime()%>"/></p> 
                                                        <% }%>
                                                </div>
                                                <!--view review-->
                                                <div class="rating-content-main">
                                                    <!--close view review-->
                                                    <% String viewRateIndex = "rating" + count;%>
                                                    <% String viewrTextIndex = "ratingText" + count;%>
                                                    <% int feedIdIndex = listFeedback.get(i).getFeedbackId();%>
                                                    <% String feedIndex = "mess" + listFeedback.get(i).getFeedbackId();%>
                                                    <div id="content">
                                                        <div class="rating-view-input" id="<%=viewRateIndex%>">                                                       
                                                            <div class="rating">
                                                                <%if (listFeedback.get(i).getRate() == 5) {%>
                                                                <input type="radio" id="rateview5" name="rating" value="5" />
                                                                <label class = "full" for="rateview5" style="color: #FFD700;"></label>
                                                                <% }%>
                                                                <% if (listFeedback.get(i).getRate() >= 4) {%>
                                                                <input type="radio" id="rateview4" name="rating" value="4"/>
                                                                <label class = "full" for="rateview4" style="color: #FFD700;"></label>
                                                                <% }%>
                                                                <% if (listFeedback.get(i).getRate() >= 3) {%>
                                                                <input type="radio" id="rateview3" name="rating" value="3" />
                                                                <label class = "full" for="rateview3" style="color: #FFD700;"></label>
                                                                <% }%>
                                                                <% if (listFeedback.get(i).getRate() >= 2) {%>
                                                                <input type="radio" id="rateview2" name="rating" value="2" />
                                                                <label class = "full" for="rateview2" style="color: #FFD700;" ></label>
                                                                <% }%>
                                                                <% if (listFeedback.get(i).getRate() >= 1) {%>
                                                                <input type="radio" id="rateview1" name="rating" value="1" />
                                                                <label class = "full" for=" rateview1"style="color: #FFD700;" ></label>
                                                                <% }%>
                                                            </div>
                                                        </div>
                                                        <div class="rating-view-text" id="<%=viewrTextIndex%>">
                                                            <p><%=listFeedback.get(i).getFeedback()%></p>
                                                        </div>
                                                    </div>
                                                    <!--edit review-->
                                                    <div class="rating-edit-form" id="<%=feedIdIndex%>">
                                                        <% if (account != null && listFeedback.get(i).getFeedbackId() == feedIdIndex) {%>
                                                        <form class="review-edit-form" action="edit-feedback" method="post">
                                                            <input name="feedbackId" value="<%=listFeedback.get(i).getFeedbackId()%>" hidden >
                                                            <input  name="username" value="<%=listFeedback.get(i).getUsername()%>" hidden>
                                                            <input name="mid" value="<%=listFeedback.get(i).getMovieId()%>" hidden>
                                                            <div class="form-group">
                                                                <div class="reviews-counter">
                                                                    <div class="rating">
                                                                        <%if (listFeedback.get(i).getRate() == 5) {%>
                                                                        <input type="radio" id="<%="rate5" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="5" checked/>
                                                                        <label class = "full" for="<%="rate5" + listFeedback.get(i).getFeedbackId()%>"></label>
                                                                        <%} else {%>
                                                                        <input type="radio" id="<%="rate5" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="5"/>
                                                                        <label class = "full" for="<%="rate5" + listFeedback.get(i).getFeedbackId()%>"></label>
                                                                        <%}%>
                                                                        <%if (listFeedback.get(i).getRate() == 4) {%>
                                                                        <input type="radio" id="<%="rate4" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="4" checked/>
                                                                        <label class = "full" for="<%="rate4" + listFeedback.get(i).getFeedbackId()%>"></label>
                                                                        <%} else {%>
                                                                        <input type="radio" id="<%="rate4" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="4"/>
                                                                        <label class = "full" for="<%="rate4" + listFeedback.get(i).getFeedbackId()%>"></label>
                                                                        <%}%>
                                                                        <%if (listFeedback.get(i).getRate() == 3) {%>
                                                                        <input type="radio" id="<%="rate3" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="3" checked/>
                                                                        <label class = "full" for="<%="rate3" + listFeedback.get(i).getFeedbackId()%>" ></label>
                                                                        <%} else {%>
                                                                        <input type="radio" id="<%="rate3" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="3"/>
                                                                        <label class = "full" for="<%="rate3" + listFeedback.get(i).getFeedbackId()%>" ></label>
                                                                        <%}%>
                                                                        <%if (listFeedback.get(i).getRate() == 2) {%>
                                                                        <input type="radio" id="<%="rate2" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="2" checked/>
                                                                        <label class = "full" for="<%="rate2" + listFeedback.get(i).getFeedbackId()%>"></label>
                                                                        <%} else {%>
                                                                        <input type="radio" id="<%="rate2" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="2" />
                                                                        <label class = "full" for="<%="rate2" + listFeedback.get(i).getFeedbackId()%>"></label>
                                                                        <%}%>
                                                                        <%if (listFeedback.get(i).getRate() == 1) {%>
                                                                        <input type="radio" id="<%="rate1" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="1" checked />
                                                                        <label class = "full" for="<%="rate1" + listFeedback.get(i).getFeedbackId()%>"></label>
                                                                        <%} else {%>
                                                                        <input type="radio" id="<%="rate1" + listFeedback.get(i).getFeedbackId()%>" name="rating" value="1" />
                                                                        <label class = "full" for="<%="rate1" + listFeedback.get(i).getFeedbackId()%>"></label>
                                                                        <%}%>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div style="display:flex; flex-direction:row; justify-content:end; margin-top 22px">
                                                                <p>Số kí tự:</p> 
                                                                <p id="<%=feedIndex%>" style=" color: #000"></p>
                                                                <p>/300</p>
                                                            </div>
                                                            <div class="form-group mt-2">
                                                                <div class="rating-text">  
                                                                    <textarea name="<%=feedIndex%>" oninput="checkMessEdit('<%=feedIndex%>')"  class="form-control" rows="4"><%=listFeedback.get(i).getFeedback()%></textarea>
                                                                </div>
                                                            </div>
                                                            <button class="round-black-btn mb-5" type="submit">Cập nhật đánh giá</button>
                                                        </form>
                                                        <%}%>  
                                                    </div>
                                                </div>
                                            </div>
                                        </div>                                      
                                        <%}%>
                                        <%}%>
                                        <!--pagging review-->
                                        <% if (count > 0) {%>
                                        <nav class="page" aria-label="Page navigation example">
                                            <form action="movie" method="get">
                                                <input type="hidden" name="mid" value="${movie.getMovieId()}"/>
                                                <c:if test="${back>0}">
                                                    <button type="submit" name="pageIndex" value="${back}">Quay lại</button>
                                                </c:if>  
                                                <c:forEach begin="1" end="${totalPage}" step="1" var="i">
                                                    <c:if test="${i==pageIndex}">
                                                        <button type="submit" class="active-true" name="pageIndex" value="${i}">${i}</button>
                                                    </c:if>
                                                    <c:if test="${i!=pageIndex}">
                                                        <button type="submit" class="active-false" name="pageIndex" value="${i}">${i}</button>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${next<totalPage+1}">
                                                    <button type="submit" name="pageIndex" value="${next}">Trang sau</button>
                                                </c:if>
                                                <c:if test="${sortId!=null}">
                                                    <input type="hidden" name="sortId" value="${sortId}"/>
                                                </c:if>
                                            </form>
                                        </nav>
                                        <%}%>
                                        <!--no review-->
                                        <% if (check) {%>
                                        <div class="user-rating">
                                            <p> Hiện tại chưa có đánh giá nào </p>
                                        </div>
                                        <%}%>
                                    </div>
                                    <!--add review-->
                                    <% if (account != null) {%>
                                    <form class="review-form" action="add-feedback" method="post" id="add-review">
                                        <input  name="username" value="<%=account.getUsername()%>" hidden>

                                        <input name="mid" value="<%=movie.getMovieId()%>" hidden>
                                        <div class="form-group">
                                            <h5>Đánh giá</h5>
                                            <div class="reviews-counter">
                                                <div class="rating">
                                                    <input type="radio" id="star5" name="rating" value="5" required/>
                                                    <label class = "full" for="star5"></label>
                                                    <input type="radio" id="star4" name="rating" value="4" required/>
                                                    <label class = "full" for="star4"></label>
                                                    <input type="radio" id="star3" name="rating" value="3" required/>
                                                    <label class = "full" for="star3" ></label>
                                                    <input type="radio" id="star2" name="rating" value="2" required/>
                                                    <label class = "full" for="star2"></label>
                                                    <input type="radio" id="star1" name="rating" value="1" required/>
                                                    <label class = "full" for="star1"></label>
                                                </div>
                                            </div>
                                        </div>
                                        <div style="display:flex; flex-direction:row; justify-content:end; margin-top 22px">
                                            <p>Số kí tự:</p> 
                                            <p id="length" style=" color: #000"></p>
                                            <p>/300</p>
                                        </div>
                                        <div class="form-group mt-2">
                                            <div class="rating-text">                                            
                                                <textarea name="reviewmess" oninput="checkMess()" class="form-control" rows="4"></textarea>
                                            </div>
                                        </div>
                                        <button class="round-black-btn mb-5" type="submit">Lưu đánh giá</button>
                                    </form>
                                    <%}%>   
                                </div>
                            </div>
                            <!--end review part-->
                        </div>

                    </div>
                </div>
            </section>
        </div>
        <style>
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
        <script>
            function showConfirm(feedbackId, movieId, username) {
                var option = confirm('Bạn có muốn xóa đánh giá này không ?');
                if (option === true) {
                    window.location.href = 'delete-feedback?username=' + username + '&mid=' + movieId + '&feedbackId=' + feedbackId;
                }
            }

            function checkMess() {
                var mess = document.querySelector('textarea[name=reviewmess]');
                var messTrim = mess.value.trim();
                var messReplaceSpace = messTrim.replace(/\s\s+/g, ' ');
                console.log(messReplaceSpace);
                var messLength = messReplaceSpace.length;
                document.getElementById("length").innerHTML = messLength;
                if (messLength > 300) {
                    mess.setCustomValidity('Quá 300 ký tự xin mời nhập lại');
                } else {
                    mess.setCustomValidity('');
                }
            }

            function checkMessEdit(index) {
                var mess = document.querySelector('textarea[name=' + index + ']');
                var messTrim = mess.value.trim();
                var messReplaceSpace = messTrim.replace(/\s\s+/g, ' ');
                console.log(messReplaceSpace);
                var messLength = messReplaceSpace.length;
                document.getElementById(index).innerHTML = messLength;
                if (messLength > 300) {
                    mess.setCustomValidity('Quá 300 ký tự xin mời nhập lại');
                } else {
                    mess.setCustomValidity('');
                }
            }

            function openEditModal(dropdownIndex, btnEditIndex, editFormIndex, rateFormIndex, rateTextFormIndex) {
                document.getElementById(btnEditIndex).style.display = "flex";
                document.getElementById(editFormIndex).style.display = "block";
                document.getElementById(dropdownIndex).style.display = "none";
                document.getElementById(rateFormIndex).style.display = "none";
                document.getElementById(rateTextFormIndex).style.display = "none";
                document.getElementById("add-review").style.display = "none";
            }
            function closeEditModal(dropdownIndex, btnEditIndex, editFormIndex, rateFormIndex, rateTextFormIndex) {
                document.getElementById(btnEditIndex).style.display = "none";
                document.getElementById(editFormIndex).style.display = "none";
                document.getElementById(dropdownIndex).style.display = "block";
                document.getElementById(rateFormIndex).style.display = "block";
                document.getElementById(rateTextFormIndex).style.display = "block";
                document.getElementById("add-review").style.display = "block";
            }
        </script>
        <%@include file="template/footer.jsp" %>
    </body>
</html>

