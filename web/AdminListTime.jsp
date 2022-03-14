<%-- 
    Document   : AdminAddMovieSchedule
    Created on : Mar 10, 2022, 7:44:17 PM
    Author     : tenhik
--%>

<%@page import="java.sql.Time"%>
<%@page import="java.sql.Date"%>
<%@page import="model.MovieTime"%>
<%@page import="model.MovieRoom"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%ArrayList<MovieRoom> listDate = (ArrayList<MovieRoom>) request.getAttribute("listDate");%>  
        <%ArrayList<MovieTime> listTime = (ArrayList<MovieTime>) request.getAttribute("listTime");%> 
        <%ArrayList<MovieTime> listTimeMovieRoom = (ArrayList<MovieTime>) request.getAttribute("listTimeMovieRoom");%>  
        <% MovieRoom movieRoom = (MovieRoom) request.getAttribute("movieRoom");%>
    </head>

    <body>
        <!--side bar-->
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
            <!--search input-->
            <div class="search position-relative text-center py-3 mt-2">
                <form action="adminListTime" method="post" class="input-group rounded">
                    <input name="searchtxt"  oninput="checkDate()" type="date" value="${date}" class="form-control" aria-describedby="search-addon" />
                    <button type="submit"  style="height:38px;background-color: #252636;" class="input-group-text border-0" id="search-addon">
                        <i class="fas fa-search" style="color: #FFF"></i></a>
                    </button>
                </form>
            </div>
            <!--menu sidebar-->
            <%@include file="template/adminMenu.jsp" %>
        </aside>
        <!--main content-->
        <section id="wrapper">
            <!--header-->
            <%@include file="template/adminNewHeader.jsp" %>
            <!--content-->
            <div class="p-4">
                <!--header table-->
                <div class="welcome">
                    <div class="content rounded-3 p-3">
                        <h1 class="fs-3"><i class="far fa-calendar-alt"></i> Schedule Management</h1>
                    </div>
                </div>
                <div style="display: flex; justify-content: end; margin: 10px">
                    <button onclick="openAddModal()"  class="custom-btn btn-crud"><span>Add !</span><span>Add more</span></button>
                </div>
                <div class="admin-table table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th style="width: 200px" scope="col">Date</th>
                                <th scope="col">Slot 1</th>
                                <th scope="col">Slot 2</th>
                                <th scope="col">Slot 3</th>
                                <th scope="col">Slot 4</th>
                                <th scope="col">Slot 5</th>
                                <th scope="col">Slot 6</th>
                                <th> Function</th>
                                <th>Function</th>
                            </tr> 
                        </thead>
                        <tbody>
                            <% for (int i = 0; i < listDate.size(); i++) {%>
                            <tr>
                                <th><fmt:formatDate pattern="EEEE, dd-MM-yyyy" value = "<%=listDate.get(i).getPremiere()%>"/></th>
                                    <% int count = 0;%>
                                    <% for (int j = 0; j < listTime.size(); j++) {%>
                                    <%if (listDate.get(i).getMovieRoomId() == listTime.get(j).getMovieRoomId()) {%>
                                <td>
                                    <%if (listTime.get(j).getAdd().equals("yes")) {%>
                                    <fmt:formatDate pattern="HH:mm" type="time" value="<%=listTime.get(j).getStart()%>"/> to <fmt:formatDate pattern="HH:mm" type="time" value="<%=listTime.get(j).getEnd()%>"/>
                                    <%} else {%>
                                    Not yet
                                    <%}%>
                                </td>
                                <%}%>
                                <%}%>
                                <td> 

                                    <button onclick="openUpdate(<%=listDate.get(i).getMovieRoomId()%>)" type="button"  class="custom-btn btn-crud"><span>Update now !</span><span>Update</span></button>

                                </td>
                                <td>  
                                    <button onclick="showDelMess(<%=listDate.get(i).getMovieRoomId()%>)" type="button"  class="custom-btn btn-crud"><span>Delete now !</span><span>Delete</span></button>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
                <!--pagging-->
                <div class="clearfix">
                    <div class="hint-text">Showing <b><%=listDate.size()%></b> out of <b>${total}</b> entries</div>
                    <nav class="pagination" aria-label="Page navigation example">
                        <form action="adminListTime" method="get">
                            <input type="hidden" name="searchtxt" value="null"/>
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
                </div>
                <!--static-->
                <%@include file="template/adminStatics.jsp" %>
            </div>
            <!--footer-->
            <%@include file="template/adminFooter.jsp" %>
        </section>
        <!--add modal-->
        <div class="modal-nofi" id="admin-add-modal">
            <div class="modal-nofi-overlay"></div>
            <div class="modal-add-time modal-dialog-scrollable">
                <form class="full-width" action="AddListTime" method="post">
                    <h5 class="modal-add-title">Add Time</h5>
                    <div class="modal-add-body">
                        <div class="add-input">
                            <label>Date: </label>  
                            <input class="" name="datetxta" oninput="checkDateValid('Add')" type="date" required>
                        </div>
                        <div class="add-checkbox">
                            <label>Slot 1 (08h00 đến 10h00): </label>  
                            <input class="" name="slot" value="1" type="checkbox" checked>
                        </div>
                        <div class="add-checkbox">
                            <label>Slot 2 (10h10 đến 12h10): </label>  
                            <input class="" name="slot" value="2" type="checkbox" checked>
                        </div>
                        <div class="add-checkbox">
                            <label>Slot 3 (12h20 đến 14h20): </label>  
                            <input class="" name="slot" value="3" type="checkbox" checked>
                        </div>
                        <div class="add-checkbox">
                            <label>Slot 4 (14h30 đến 16h30): </label>  
                            <input class="" name="slot" value="4" type="checkbox" checked>
                        </div>
                        <div class="add-checkbox">
                            <label>Slot 5 (16h40 đến 18h40): </label>  
                            <input class="" name="slot" value="5" type="checkbox" checked>
                        </div>
                        <div class="add-checkbox">
                            <label>Slot 6 (18h50 đến 20h50): </label>  
                            <input class="" name="slot" value="6" type="checkbox" checked>
                        </div>
                    </div>
                    <div class="modal-btn">
                        <button type="submit" class="custom-btn btn-crud"><span>Add now !</span><span>Add time</span></button>
                        <button type="button" onclick="closeModal()" class="custom-btn btn-crud"><span>Close !</span><span>Close</span></button>
                    </div> 
                </form>
            </div>
        </div>
        <!--edit modal-->
        <c:if test="${view == true}">
            <div class="modal-nofi" id="admin-edit-modal">
                <div class="modal-nofi-overlay"></div>
                <div class="modal-add-time modal-dialog-scrollable">
                    <form class="full-width" action="updateListTime" method="post">
                        <h5 class="modal-add-title">Update Time</h5>
                        <div class="modal-add-body">
                            <div class="add-input">
                                <label>Date: </label>  
                                <input class="" name="datetxte" oninput="checkDateValid('Edit')" type="date" value="<%=movieRoom.getPremiere()%>" required>
                                <input name="movieRoomId" value="<%=movieRoom.getMovieRoomId()%>" hidden>
                            </div>
                            <div class="add-checkbox">
                                <label>Slot 1 (08h00 đến 10h00): </label>  
                                <input class="" name="slot" value="1" type="checkbox" 
                                       <% for (int i = 0; i < listTimeMovieRoom.size(); i++) { %>
                                       <%if (listTimeMovieRoom.get(i).getStart() != null && listTimeMovieRoom.get(i).getSlot().equals("slot1")) {%>
                                       <%if (listTimeMovieRoom.get(i).getAdd().equals("yes")) {%>
                                       checked
                                       <%=i++%>
                                       <%}%>
                                       <%}%>
                                       <%}%>
                                       >
                            </div>
                            <div class="add-checkbox">
                                <label>Slot 2 (10h10 đến 12h10): </label>  
                                <input class="" name="slot" value="2" type="checkbox"
                                       <% for (int i = 0; i < listTimeMovieRoom.size(); i++) { %>
                                       <%if (listTimeMovieRoom.get(i).getStart() != null && listTimeMovieRoom.get(i).getSlot().equals("slot2")) {%>
                                       <%if (listTimeMovieRoom.get(i).getAdd().equals("yes")) {%>
                                       checked
                                       <%=i++%>
                                       <%}%>
                                       <%}%>
                                       <%}%>
                                       >
                            </div>
                            <div class="add-checkbox">
                                <label>Slot 3 (12h20 đến 14h20): </label>  
                                <input class="" name="slot" value="3" type="checkbox"
                                       <% for (int i = 0; i < listTimeMovieRoom.size(); i++) { %>
                                       <%if (listTimeMovieRoom.get(i).getStart() != null && listTimeMovieRoom.get(i).getSlot().equals("slot3")) {%>
                                       <%if (listTimeMovieRoom.get(i).getAdd().equals("yes")) {%>
                                       checked
                                       <%=i++%>
                                       <%}%>
                                       <%}%>
                                       <%}%>
                                       >
                            </div>
                            <div class="add-checkbox">
                                <label>Slot 4 (14h30 đến 16h30): </label>  
                                <input class="" name="slot" value="4" type="checkbox"
                                       <% for (int i = 0; i < listTimeMovieRoom.size(); i++) { %>
                                       <%if (listTimeMovieRoom.get(i).getStart() != null && listTimeMovieRoom.get(i).getSlot().equals("slot4")) {%>
                                       <%if (listTimeMovieRoom.get(i).getAdd().equals("yes")) {%>
                                       checked
                                       <%=i++%>
                                       <%}%>
                                       <%}%>
                                       <%}%>
                                       >
                            </div>
                            <div class="add-checkbox">
                                <label>Slot 5 (16h40 đến 18h40): </label>  
                                <input class="" name="slot" value="5" type="checkbox"
                                       <% for (int i = 0; i < listTimeMovieRoom.size(); i++) { %>
                                       <%if (listTimeMovieRoom.get(i).getStart() != null && listTimeMovieRoom.get(i).getSlot().equals("slot5")) {%>
                                       <%if (listTimeMovieRoom.get(i).getAdd().equals("yes")) {%>
                                       checked
                                       <%=i++%>
                                       <%}%>
                                       <%}%>
                                       <%}%>
                                       >
                            </div>
                            <div class="add-checkbox">
                                <label>Slot 6 (18h50 đến 20h50): </label>  
                                <input class="" name="slot" value="6" type="checkbox"
                                       <% for (int i = 0; i < listTimeMovieRoom.size(); i++) { %>
                                       <%if (listTimeMovieRoom.get(i).getStart() != null && listTimeMovieRoom.get(i).getSlot().equals("slot6")) {%>
                                       <%if (listTimeMovieRoom.get(i).getAdd().equals("yes")) {%>
                                       checked
                                       <%=i++%>
                                       <%}%>
                                       <%}%>
                                       <%}%>
                                       >
                            </div>
                        </div>
                        <div class="modal-btn">
                            <button type="submit" class="custom-btn btn-crud"><span>Update now !</span><span>Update time</span></button>
                            <button type="button" onclick="closeModal()" class="custom-btn btn-crud"><span>Close !</span><span>Close</span></button>
                        </div> 
                    </form>
                </div>
            </div>
        </c:if>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
        ></script>
        <script>
                                function dropdown() {
                                    if (document.getElementById("sidebar-dropdown").style.display === "none") {
                                        document.getElementById("sidebar-dropdown").style.display = "block";
                                    } else {
                                        document.getElementById("sidebar-dropdown").style.display = "none";
                                    }
                                }
                                function openAddModal() {
                                    document.getElementById("admin-add-modal").style.display = "flex";
                                }

                                function openUpdate(movieRoomId) {
                                    window.location.href = 'viewUpdateListTime?movieRoomId=' + movieRoomId + '&view=true';
                                }

                                function closeModal() {
                                    var x = document.querySelectorAll(".modal-nofi");
                                    for (var i = 0; i < x.length; i++) {
                                        if (x[i].style.display !== "none") {
                                            x[i].style.display = "none";
                                        }
                                        window.location.href = 'adminListTime'
                                    }
                                }

                                function showDelMess(movieRoomId) {
                                    var result = confirm("Bạn có muốn tiếp tục xóa không?");
                                    if (result === true) {
                                        window.location.href = 'deleteListTime?movieRoomId=' + movieRoomId;
                                    }
                                }

                                function checkDate() {
                                    var today = new Date();
                                    //date input
                                    var mess = document.querySelector('input[name=searchtxt]');
                                    var dateInput = mess.value.split("-");
                                    var inputDate = new Date(dateInput[0], parseInt(dateInput[1]) - 1, dateInput[2]);
                                    //current date
                                    var dd = String(today.getDate()).padStart(2, '0');
                                    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
                                    var yyyy = today.getFullYear();
                                    today = yyyy + '-' + mm + '-' + dd;
                                    var dateCur = today.split("-");
                                    var current = new Date(dateCur[0], parseInt(dateCur[1]) - 1, dateCur[2]);
                                    if (current > inputDate) {
                                        if ((current - inputDate) / (365 * 24 * 60 * 60 * 1000) <= 10) {
                                            mess.setCustomValidity("");
                                        } else {
                                            mess.setCustomValidity("Năm nhập không quá 10 năm tính từ ngày hiện tại");
                                        }
                                    } else {
                                        if ((inputDate - current) / (365 * 24 * 60 * 60 * 1000) <= 10) {
                                            mess.setCustomValidity("");
                                        } else {
                                            mess.setCustomValidity('Năm nhập không quá 10 năm tính từ ngày hiện tại');
                                        }
                                    }
                                }
                                function checkDateValid(option) {
                                    var today = new Date();
                                    //date input
                                    var mess;
                                    if (option === 'Add') {
                                        mess = document.querySelector('input[name=datetxta]');
                                    } else if (option === 'Edit') {
                                        mess = document.querySelector('input[name=datetxte]');
                                    }
                                    var dateInput = mess.value.split("-");
                                    var inputDate = new Date(dateInput[0], parseInt(dateInput[1]) - 1, dateInput[2]);
                                    var jsArray = [];
            <% for (int i = 0; i < listDate.size(); i++) {%>
                                    jsArray.push('<%=listDate.get(i).getPremiere()%>');
            <%}%>
                                    //current date
                                    var dd = String(today.getDate()).padStart(2, '0');
                                    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
                                    var yyyy = today.getFullYear();
                                    today = yyyy + '-' + mm + '-' + dd;
                                    var dateCur = today.split("-");
                                    var current = new Date(dateCur[0], parseInt(dateCur[1]) - 1, dateCur[2]);
                                    console.log((inputDate.getTime() - current.getTime()) / (1000 * 60 * 60 * 24));
                                    if (current.getTime() >= inputDate.getTime()) {
                                        if ((current.getTime() - inputDate.getTime()) / (1000 * 60 * 60 * 24) < 0) {
                                            for (var i = 0; i < jsArray.length; i++) {
                                                if (mess.value === jsArray[i]) {
                                                    mess.setCustomValidity("Ngày đã có trong dữ liệu");
                                                } else {
                                                    mess.setCustomValidity("");
                                                }
                                            }
                                        } else {
                                            mess.setCustomValidity("Ngày nhập không nhỏ hơn ngày hiện tại");
                                        }
                                    } else if (current.getTime() < inputDate.getTime()) {
                                        if ((inputDate.getTime() - current.getTime()) / (1000 * 60 * 60 * 24) <= 365) {
                                            for (var i = 0; i < jsArray.length; i++) {
                                                if (mess.value === jsArray[i]) {
                                                    mess.setCustomValidity("Ngày đã có trong dữ liệu");
                                                    break;
                                                } else {
                                                    mess.setCustomValidity("");
                                                }
                                            }
                                        } else {
                                            mess.setCustomValidity('Năm nhập cách năm hiện tại quá 1 năm');
                                        }
                                    }
                                }

        </script>
    </body>
</html>
