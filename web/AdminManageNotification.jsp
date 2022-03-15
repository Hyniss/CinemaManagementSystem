<%-- 
    Document   : AdminAddMovieSchedule
    Created on : Mar 10, 2022, 7:44:17 PM
    Author     : tenhik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <form action="adminnotificationsearch" method="post" class="input-group rounded">
                    <input oninput="checkSearch()" name="searchtxt" value="${searchtxt}" type="search" class="form-control" placeholder="Search by Title" aria-label="Search" aria-describedby="search-addon" />
                    <button type="submit"  style="height:38px;background-color: #252636;" class="input-group-text border-0" id="search-addon">
                        <i class="fas fa-search" style="color: #FFF"></i></a>
                    </button>
                </form>
                <p style="color:red; text-align: center">${searchMess}</p>  
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
                        <h1 class="fs-3"><i class="fa fa-users" aria-hidden="true"></i> Notification Management</h1>
                    </div>
                </div>
                <div style="display: flex; justify-content: end; margin: 10px">
                    <!--                    <button onclick="openAddModal()"  class="custom-btn btn-crud"><span>Add !</span><span>Add more</span></button>-->
                    <a href="adminnotificationadd" class="custom-btn btn-crud"><span>Add !</span><span>Add more</span></a>
                </div>
                <div class="admin-table table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th>Image</th>
                                <th>Notification Title</th>
                                <th>Notification Description</th>
                                <th>Notification Date</th>
                                <th>Actions</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <% Integer count = (Integer) request.getAttribute("pageIndex");%>
                        <% count = (count - 1) * 5 + 1;%>
                        <tbody>
                            <c:forEach items="${notificationList}" var="notification" varStatus="i" >
                                <tr>
                                    <th scope="row"><%=count%></th>
                                    <td style="width:25%"><img style="height:100%; width: 100%" src="${pageContext.request.contextPath}/assets/img/notification/${notification.notificationImg}"></td>
                                    <td>${notification.notificationTitle}</td>
                                    <td>${notification.notificationDescription}</td>
                                    <td>${notification.notificationDate}</td>
                                    <td>                    
                                        <a href="adminnotificationedit?notiId=${notification.notificationId}"  class="custom-btn btn-crud"><span>Update now !</span><span>Update</span></button></a>
                                    </td>
                                    <td>                                    
                                        <button onclick="showDelMess(${notification.notificationId})"  class="custom-btn btn-crud"><span>Delete now !</span><span>Delete</span></button>
                                    </td>
                                </tr>
                                <% count = count + 1;%>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!--pagging-->
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
                <!--static-->
                <%@include file="template/adminStatics.jsp" %>
            </div>
            <!--footer-->
            <%@include file="template/adminFooter.jsp" %>
        </section>
        <!--add modal-->
        <div class="modal-nofi" id="admin-add-modal">
            <div class="modal-nofi-overlay"></div>
            <div class="modal-add modal-dialog-scrollable">
                <form class="full-width" action="adminnotificationadd" method="post">
                    <h5 class="modal-add-title">Add movie</h5>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Notification Image</label>
                            <input value="" name="addimg" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Notification Title</label>
                            <input value="${successMessage==null? notification.notificationTitle:""}" name="addtitle" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Notification Description</label>
                            <textarea value="${successMessage==null? notification.notificationDescription:""}" name="addescription" type="text" class="form-control">${successMessage==null? notification.notificationDescription:""}</textarea>
                        </div>
                        <div class="form-group">
                            <!--<label>Notification Date</label>-->
                            <input value="${currentdate}" name="adddate" type="date" class="form-control" hidden>
                        </div>
                        <p style="color: red;font-size: 14px">${failMessage}</p>
                        <p style="color: red;font-size: 14px">${mess}</p>
                        <p style="color: green;font-size: 14px">${successMessage}</p>                                

                    </div>
                    <div class="modal-btn">
                        <button onclick="checkAdd()"  type="submit" class="custom-btn btn-crud"><span>Add now !</span><span>Add more</span></button>
                        <button type="button" onclick="closeModal()" class="custom-btn btn-crud"><span>Close !</span><span>Close</span></button>
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
                            function openAddModal() {
                                document.getElementById("admin-add-modal").style.display = "flex";
                            }
                            function closeModal() {
                                var x = document.querySelectorAll(".modal-nofi");
                                for (var i = 0; i < x.length; i++) {
                                    if (x[i].style.display !== "none") {
                                        x[i].style.display = "none";
                                    }
                                }
                            }

                            function showDelMess(notiid) {
                                var result = confirm("Bạn có muốn tiếp tục xóa không?");
                                if (result === true) {
                                    window.location.href = 'adminnotificationdelete?notiId=' + notiid;
                                }
                            }

                            function checkAdd() {
                                var mess1 = document.querySelector('input[name=addimg]');
                                var mess1Trim = mess1.value.trim();
                                var mess1ReplaceSpace = mess1Trim.replace(/\s\s+/g, ' ');
                                console.log(mess1ReplaceSpace);
                                if (mess1ReplaceSpace.length > 50 || mess1ReplaceSpace.length < 6) {
                                    mess1.setCustomValidity('Description nằm trong khoảng 6 đến 50 ký tự');
                                } else {
                                    mess1.setCustomValidity('');
                                }

                                var mess2 = document.querySelector('input[name=addtitle]');
                                var mess2Trim = mess2.value.trim();
                                var mess2ReplaceSpace = mess2Trim.replace(/\s\s+/g, ' ');
                                console.log(mess2ReplaceSpace);
                                if (mess2ReplaceSpace.length > 250 || mess2ReplaceSpace.length < 6) {
                                    mess2.setCustomValidity('Description nằm trong khoảng 6 đến 250 ký tự');
                                } else {
                                    mess2.setCustomValidity('');
                                }

                                var mess3 = document.querySelector('textarea[name=adddescription]');
                                var mess3Trim = mess3.value.trim();
                                var mess3ReplaceSpace = mess3Trim.replace(/\s\s+/g, ' ');
                                console.log(mess3ReplaceSpace);
                                if (mess3ReplaceSpace.length > 2500 || mess3ReplaceSpace.length < 6) {
                                    mess3.setCustomValidity('Description nằm trong khoảng 6 đến 2500 ký tự');
                                } else {
                                    mess3.setCustomValidity('');
                                }
                            }

                            function checkSearch() {
                                var mess = document.querySelector('input[name=searchtxt]');
                                var messTrim = mess.value.trim();
                                var messReplaceSpace = messTrim.replace(/\s\s+/g, ' ');
                                console.log(messReplaceSpace);
                                if (messReplaceSpace.length == 0) {
                                    mess.setCustomValidity('Can not be empty!');
                                } else {
                                    mess.setCustomValidity('');
                                }
                            }

        </script>
    </body>
</html>
