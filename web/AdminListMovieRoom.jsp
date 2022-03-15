<%-- 
    Document   : AdminAddMovieSchedule
    Created on : Mar 10, 2022, 7:44:17 PM
    Author     : tenhik
--%>

<%@page import="model.TimeRoom"%>
<%@page import="model.Movie"%>
<%@page import="model.MovieTime"%>
<%@page import="model.MovieRoom"%>
<%@page import="model.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="getMovie" class="dao.impl.MovieDAO"/>
<jsp:useBean id="getTime" class="dao.impl.MovieTimeDAO"/>
<jsp:useBean id="getDate" class="dao.impl.ShowtimesDAO"/>
<jsp:useBean id="getRoom" class="dao.impl.RoomDAO"/>
<jsp:useBean id="getTimeRoom" class="dao.impl.TimeRoomDAO"/>
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
        <%ArrayList<Room> listRoom = (ArrayList<Room>) request.getAttribute("listRoom");%>  
        <%ArrayList<MovieRoom> listDate = (ArrayList<MovieRoom>) request.getAttribute("listDate");%>  
        <%ArrayList<MovieTime> listTime = (ArrayList<MovieTime>) request.getAttribute("listTime");%>  
        <%ArrayList<MovieTime> listTimeChoose = (ArrayList<MovieTime>) request.getAttribute("listTimeChoose");%> 
        <%ArrayList<Movie> listMovie = (ArrayList<Movie>) request.getAttribute("listMovie");%>  
        <%ArrayList<TimeRoom> listTimeRoom = (ArrayList<TimeRoom>) request.getAttribute("listTimeRoom");%>

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
                <form action="adminaccountsearch" method="post" class="input-group rounded">
                    <input name="searchtxt" value="${accSubUsername}" type="search" class="form-control" placeholder="Search cinema" aria-label="Search" aria-describedby="search-addon" />
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
                        <h1 class="fs-3"><i class="fa fa-users" aria-hidden="true"></i> Movie Management</h1>
                    </div>
                </div>
                <div style="display: flex; justify-content: end; margin: 10px">
                    <div style="margin: auto">
                        <p style="font-size: 30px;font-weight:bold">                               
                            <fmt:formatDate pattern="EEEE, dd-MM-yyyy" value = "${movieRoom.premiere}"/>
                        </p>
                    </div>
                    <div class="btn-group">
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Date (7 days)
                        </button>
                        <div class="dropdown-menu dropdown-menu-right">
                            <% for (int i = 0; i < listDate.size(); i++) {%>
                            <button type="button" onclick="showTimeLine(<%=listDate.get(i).getMovieRoomId()%>)" class="dropdown-item">
                                <fmt:formatDate pattern="EEEE, dd-MM-yyyy" value = "<%=listDate.get(i).getPremiere()%>"/>
                            </button>
                            <%}%>
                        </div>
                    </div>
                </div>
                <div class="admin-table table-responsive">
                    <%if (!listTime.isEmpty()) {%>
                    <table class="table">
                        <thead>
                            <tr>
                                <th style="width: 200px" scope="col">Room name</th>
                                <th scope="col">Slot 1</th>
                                <th scope="col">Slot 2</th>
                                <th scope="col">Slot 3</th>
                                <th scope="col">Slot 4</th>
                                <th scope="col">Slot 5</th>
                                <th scope="col">Slot 6</th>
                            </tr> 
                        </thead>
                        <tbody>
                            <% for (int i = 0; i < listRoom.size(); i++) {%>
                            <tr>


                                <th scope="row"><%=listRoom.get(i).getRoomName()%></th>
                                    <% for (int j = 0; j < listTime.size(); j++) {%>
                                    <%if (listTime.get(j).getAdd().equals("yes")) {%>
                                <td>  
                                    <% boolean checkExist = false;%>
                                    <%int roomTimeId = 0;%>
                                    <%int movieId = 0;%>
                                    <div style="display: flex;flex-direction: row; justify-content: space-between"> 
                                        <div style="display: flex;flex-direction:column;margin-right: 12px">
                                            <% boolean check = false;%>
                                            <% for (int k = 0; k < listTimeRoom.size(); k++) {%>
                                            <%if (listTimeRoom.get(k).getTimeId() == listTime.get(j).getTimeId() && listRoom.get(i).getRoomId().equals(listTimeRoom.get(k).getRoomId())) {%>
                                            <%for (int g = 0; g < listMovie.size(); g++) {%>
                                            <% if (listMovie.get(g).getMovieId() == listTimeRoom.get(k).getMovieId()) {%>
                                            <h5><i class="fas fa-film"></i> Movie: <%=listMovie.get(g).getMovieName()%></h5>                                 
                                            <fmt:formatDate pattern="HH:mm" type="time" value="<%=listTime.get(j).getStart()%>"/> to <fmt:formatDate pattern="HH:mm" type="time" value="<%=listTime.get(j).getEnd()%>"/>
                                            <%check = true;%>
                                            <% roomTimeId = listTimeRoom.get(k).getTimeRoomId();%>
                                            <% movieId = listMovie.get(g).getMovieId();%>
                                            <%}%>
                                            <% if (check) {
                                                    break;
                                                }%>
                                            <%}%>
                                            <%check = true;%>
                                            <%checkExist = true;%>
                                            <%}%>
                                            <% if (check) {
                                                    break;
                                                }%>
                                            <%}%>
                                            <% if (!check) {%>
                                            <img src="${pageContext.request.contextPath}/assets/images/light-gray-color-solid-background-1920x1080.png" width="100px" height="100px"> 
                                            <fmt:formatDate pattern="HH:mm" type="time" value="<%=listTime.get(j).getStart()%>"/> to <fmt:formatDate pattern="HH:mm" type="time" value="<%=listTime.get(j).getEnd()%>"/>
                                            <%}%>
                                        </div>
                                        <div style="display: flex;flex-direction:column;">
                                            <% if (!checkExist) {%>
                                            <button onclick="openAddModal('<%=listRoom.get(i).getRoomId()%>',<%=listTime.get(j).getTimeId()%>,${movieRoom.movieRoomId},<%=roomTimeId%>)"  class="btn-movie">Add</button>
                                            <%}%>
                                            <% if (checkExist) {%>
                                            <button onclick="openUpdateModal('<%=listRoom.get(i).getRoomId()%>',<%=listTime.get(j).getTimeId()%>,${movieRoom.movieRoomId},<%=roomTimeId%>,<%=movieId%>)"  class="btn-movie">Edit</button>
                                            <button onclick=" showDelMess(<%=roomTimeId%>,${movieRoom.movieRoomId})"  class="btn-movie">Delete</button>
                                            <%} else {%>
                                            <button class="btn-movie">Edit</button>
                                            <button  class="btn-movie">Delete</button>
                                            <%}%>
                                        </div>
                                    </div>
                                </td>
                                <%} else {%>
                                <td>
                                    This slot isn't added
                                </td>
                                <%}%>

                                <%}%> 
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <%}%>
                </div>
                <div class="clearfix">
                    <div class="hint-text">Showing <b></b> out of <b>${total}</b> entries</div>
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
        <!--modal list movie room-->
        <c:if test="${viewAdd == true}">
            <div class="modal-nofi" id="modal-add-movie">
                <div class="modal-nofi-overlay"></div>
                <div class="modal-add-movieroom modal-dialog-scrollable">
                    <form class="full-width" action="adminUpdateMovieRoom" method="post">
                        <h5 class="modal-add-title">Add movie in room</h5>
                        <div class="modal-add-body">
                            <div class="add-input-option">
                                <input name="addTimeRoomId" value="${addTimeRoomId}"hidden>
                                <input name="addMovieRoomId" value="${addMovieRoomId}"hidden>
                                <input name="addMovieId" value="${movieId}"hidden>
                                <input name="addTimeId" value="${addTimeId}"hidden>
                                <input name="addRoomId" value="${addRoomId}"hidden>
                                <input name="function" value="add"hidden>
                                <label>Movie name: </label>                              
                                <input class="" name="" value="${getMovie.getMovieById(movieId).movieName}" placeholder="" readonly>
                                <button type="button" onclick="openChooseMovie()" class="btn-change-option">Choose</button>
                            </div>
                            <div class="add-input-option">
                                <label>Slot: </label>  
                                <input class=""  value="${getTime.getMovieTime(addTimeId).slot}" type="" placeholder="" readonly>
                                <button type="button" onclick="openChooseTime()" class="btn-change-option">Choose</button>
                            </div>
                            <div class="add-input-option">
                                <label>Room: </label>  
                                <input class="" value="${getRoom.room(addRoomId).roomName}" type="" placeholder=""readonly>
                                <button type="button" onclick="openchooseRoom()" class="btn-change-option">Choose</button>
                            </div>
                            <div class="add-input-option">
                            </div>
                        </div>
                        <div class="modal-btn">
                            <button type="submit" class="custom-btn btn-crud"><span>Add now !</span><span>Add</span></button>
                            <button type="button" onclick="closeModal(${movieRoom.movieRoomId})" class="custom-btn btn-crud"><span>Close !</span><span>Close</span></button>
                        </div> 
                    </form>
                </div>
            </div>
        </c:if>
        <c:if test="${viewUpdate == true}">
            <div class="modal-nofi" id="modal-update-movie">
                <div class="modal-nofi-overlay"></div>
                <div class="modal-add-movieroom modal-dialog-scrollable">
                    <form class="full-width" action="adminUpdateMovieRoom" method="post">
                        <h5 class="modal-add-title">Edit movie in room</h5>
                        <c:if test="${updateValid != null}">                
                            <p id="alertExist">Slot and room has already had a film</p>
                        </c:if>
                        <div class="modal-add-body">
                            <div class="add-input-option">
                                <input name="addTimeRoomId" value="${addTimeRoomId}"hidden>
                                <input name="addMovieRoomId" value="${addMovieRoomId}"hidden>
                                <input name="addMovieId" value="${movieId}"hidden>
                                <input name="addTimeId" value="${addTimeId}"hidden>
                                <input name="addRoomId" value="${addRoomId}"hidden>
                                <input name="function" value="update"hidden>
                                <label>Movie name: </label>                              
                                <input class="" name="movieName" value="${getMovie.getMovieById(movieId).movieName}" placeholder=""  required>
                                <button type="button" onclick="openChooseMovie()" class="btn-change-option">Choose</button>
                            </div>
                            <div class="add-input-option">
                                <label>Slot: </label>  
                                <input class=""  value="${getTime.getMovieTime(addTimeId).slot}" type="" placeholder="" readonly>
                                <button type="button" onclick="openChooseTime()" class="btn-change-option">Choose</button>
                            </div>
                            <div class="add-input-option">
                                <label>Room: </label>  
                                <input class="" value="${getRoom.room(addRoomId).roomName}" type="" placeholder=""readonly>
                                <button type="button" onclick="openchooseRoom()" class="btn-change-option">Choose</button>
                            </div>
                            <div class="add-input-option">
                            </div>
                        </div>
                        <div class="modal-btn">
                            <button type="submit" class="custom-btn btn-crud"><span>Update now !</span><span>Update</span></button>
                            <button type="button" onclick="closeModal(${movieRoom.movieRoomId})" class="custom-btn btn-crud"><span>Close !</span><span>Close</span></button>
                        </div> 
                    </form>
                </div>
            </div>
        </c:if>
        <!--choose-modal movie-->
        <div class="modal-nofi modal-choose" id="modal-choose-movie">
            <div class="modal-nofi-overlay"></div>
            <div class="modal-add-movie modal-dialog-scrollable">
                <form class="full-width" action="" method="post">
                    <h5 class="modal-add-title">Choose movie</h5>
                    <div class="modal-add-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Movie Id</th>
                                        <th scope="col">Movie name</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Duration</th>
                                        <th scope="col">Premiere</th>
                                        <th scope="col">Function</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${viewAdd == true || viewUpdate == true}"> 
                                        <%for (int i = 0; i < listMovie.size(); i++) {%>
                                        <tr>
                                            <td><%=listMovie.get(i).getMovieId()%></td>
                                            <td style="font-weight: bold"><%=listMovie.get(i).getMovieName()%></td>
                                            <td><%=listMovie.get(i).getCategoryMovie()%></td>
                                            <td><%=listMovie.get(i).getDuration()%></td>
                                            <td><%=listMovie.get(i).getPremiere()%></td>
                                            <c:if test="${viewAdd == true}"> 
                                                <td><a href="adminUpdateMovieInRoom?movieRoomId=${addMovieRoomId}&timeId=${addTimeId}&roomId=${addRoomId}&addMovieId=<%=listMovie.get(i).getMovieId()%>&timeRoomId=${addTimeRoomId}&viewAdd=true">Choose this</a></td>
                                            </c:if>
                                            <c:if test="${viewUpdate == true}"> 
                                                <td><a href="adminUpdateMovieInRoom?movieRoomId=${addMovieRoomId}&timeId=${addTimeId}&roomId=${addRoomId}&addMovieId=<%=listMovie.get(i).getMovieId()%>&timeRoomId=${addTimeRoomId}&viewUpdate=true">Choose this</a></td>
                                            </c:if>
                                        </tr>
                                        <%}%>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="modal-btn">
                        <button type="button" onclick="closeModalChoose()" class="custom-btn btn-crud"><span>Close !</span><span>Close</span></button>
                    </div> 
                </form>
            </div>
        </div>
        <!--modal choose slot-->                    
        <div class="modal-nofi modal-choose" id="modal-choose-slot">
            <div class="modal-nofi-overlay"></div>
            <div class="modal-add-medium modal-dialog-scrollable">
                <form class="full-width" action="" method="post">
                    <h5 class="modal-add-title">Choose Slot</h5>
                    <div class="modal-add-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Slot</th>
                                        <th scope="col">From</th>
                                        <th scope="col">To</th>
                                        <th scope="col">Function</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${viewAdd == true || viewUpdate == true}">
                                        <%for (int i = 0; i < listTimeChoose.size(); i++) {%>
                                        <tr>
                                            <td><%=listTimeChoose.get(i).getSlot()%></td>
                                            <td><%=listTimeChoose.get(i).getStart()%></td>
                                            <td><%=listTimeChoose.get(i).getEnd()%></td>
                                            <c:if test="${viewAdd == true}"> 
                                                <td><a href="adminUpdateMovieInRoom?movieRoomId=${addMovieRoomId}&timeId=<%=listTime.get(i).getTimeId()%>&roomId=${addRoomId}&addMovieId=${movieId}&timeRoomId=${addTimeRoomId}&viewAdd=true">Choose this</a></td>
                                            </c:if>
                                            <c:if test="${viewUpdate == true}"> 
                                                <td><a href="adminUpdateMovieInRoom?movieRoomId=${addMovieRoomId}&timeId=<%=listTime.get(i).getTimeId()%>&roomId=${addRoomId}&addMovieId=${movieId}&timeRoomId=${addTimeRoomId}&viewUpdate=true">Choose this</a></td>
                                            </c:if>
                                        </tr>
                                        <%}%>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="modal-btn">
                        <button type="button" onclick="closeModalChoose()" class="custom-btn btn-crud"><span>Close !</span><span>Close</span></button>
                    </div> 
                </form>
            </div>
        </div>
        <!--modal choose room-->
        <div class="modal-nofi modal-choose" id="modal-choose-room">
            <div class="modal-nofi-overlay"></div>
            <div class="modal-add-small modal-dialog-scrollable">
                <form class="full-width" action="" method="post">
                    <h5 class="modal-add-title">Choose Room</h5>
                    <div class="modal-add-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Room</th>
                                        <th scope="col">Function</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${viewAdd == true || viewUpdate == true}">
                                        <%for (int i = 0; i < listRoom.size(); i++) {%>
                                        <tr>
                                            <td><%=listRoom.get(i).getRoomName()%></td>
                                            <c:if test="${viewAdd == true}"> 
                                                <td><a href="adminUpdateMovieInRoom?movieRoomId=${addMovieRoomId}&timeId=${addTimeId}&roomId=<%=listRoom.get(i).getRoomId()%>&addMovieId=${movieId}&timeRoomId=${addTimeRoomId}&viewAdd=true">Choose this</a></td>
                                            </c:if>
                                            <c:if test="${viewUpdate == true}"> 
                                                <td><a href="adminUpdateMovieInRoom?movieRoomId=${addMovieRoomId}&timeId=${addTimeId}&roomId=<%=listRoom.get(i).getRoomId()%>&addMovieId=${movieId}&timeRoomId=${addTimeRoomId}&viewUpdate=true">Choose this</a></td>
                                            </c:if>
                                        </tr>
                                        <%}%>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="modal-btn">
                        <button type="button" onclick="closeModalChoose()" class="custom-btn btn-crud"><span>Close !</span><span>Close</span></button>
                    </div> 
                </form>
            </div>
        </div>
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


                            function showTimeLine(movieRoomId) {
                                window.location.href = 'adminListMovieRoom?movieRoomId=' + movieRoomId;
                            }


                            function openAddModal(roomId, timeId, movieRoomId, timeRoomId) {
                                window.location.href = 'adminViewModalMovieRoom?movieRoomId=' + movieRoomId + "&timeId=" + timeId + "&roomId=" + roomId + "&timeRoomId=" + timeRoomId + "&viewAdd=true";
                            }
                            function openUpdateModal(roomId, timeId, movieRoomId, timeRoomId, movieId) {
                                window.location.href = 'adminViewModalMovieRoom?movieRoomId=' + movieRoomId + "&timeId=" + timeId + "&roomId=" + roomId + "&movieId=" + movieId + "&timeRoomId=" + timeRoomId + "&viewUpdate=true";
                            }

                            function openChooseMovie() {
                                document.getElementById("modal-choose-movie").style.display = "flex";
                                if (document.getElementById("modal-add-movie") !== null) {
                                    document.getElementById("modal-add-movie").style.display = "none";
                                }
                                if (document.getElementById("modal-update-movie") !== null) {
                                    document.getElementById("modal-update-movie").style.display = "none";
                                }
                            }
                            function openChooseTime() {
                                document.getElementById("modal-choose-slot").style.display = "flex";
                                if (document.getElementById("modal-add-movie") !== null) {
                                    document.getElementById("modal-add-movie").style.display = "none";
                                }
                                if (document.getElementById("modal-update-movie") !== null) {
                                    document.getElementById("modal-update-movie").style.display = "none";
                                }
                            }
                            function openchooseRoom() {
                                document.getElementById("modal-choose-room").style.display = "flex";
                                if (document.getElementById("modal-add-movie") !== null) {
                                    document.getElementById("modal-add-movie").style.display = "none";
                                }
                                if (document.getElementById("modal-update-movie") !== null) {
                                    document.getElementById("modal-update-movie").style.display = "none";
                                }
                            }
                            function openchooseDate() {
                                document.getElementById("modal-choose-date").style.display = "flex";
                                if (document.getElementById("modal-add-movie") !== null) {
                                    document.getElementById("modal-add-movie").style.display = "none";
                                }
                                if (document.getElementById("modal-update-movie") !== null) {
                                    document.getElementById("modal-update-movie").style.display = "none";
                                }
                            }
                            function closeModalChoose() {
                                var x = document.querySelectorAll(".modal-choose");
                                for (var i = 0; i < x.length; i++) {
                                    if (x[i].style.display !== "none") {
                                        x[i].style.display = "none";
                                    }
                                }
                                if (document.getElementById("modal-add-movie") !== null) {
                                    document.getElementById("modal-add-movie").style.display = "flex";
                                } else if (document.getElementById("modal-update-movie") !== null) {
                                    document.getElementById("modal-update-movie").style.display = "flex";
                                }
                            }

                            function closeModal(movieRoomId) {
                                var x = document.querySelectorAll(".modal-nofi");
                                for (var i = 0; i < x.length; i++) {
                                    if (x[i].style.display !== "none") {
                                        x[i].style.display = "none";
                                    }
                                    window.location.href = 'adminListMovieRoom?movieRoomId=' + movieRoomId;
                                }
                            }

                            function showDelMess(timeRoomId, movieRoomId) {
                                var result = confirm("Bạn có muốn tiếp tục xóa không?");
                                if (result === true) {
                                    window.location.href = 'adminDeleteMovieRoom?timeRoomId=' + timeRoomId + "&movieRoomId=" + movieRoomId;
                                }
                            }

        </script>
    </body>
</html>
