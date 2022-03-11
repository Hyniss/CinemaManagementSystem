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
                <form action="adminaccountsearch" method="post" class="input-group rounded">
                    <input name="searchtxt" value="${accSubUsername}" type="search" class="form-control" placeholder="Search username" aria-label="Search" aria-describedby="search-addon" />
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
                    <button onclick="openAddModal()"  class="custom-btn btn-crud"><span>Add !</span><span>Add more</span></button>
                </div>
                <div class="admin-table table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First</th>
                                <th scope="col">Last</th>
                                <th scope="col">Handle</th>
                                <th scope="col">Handle</th>
                                <th scope="col">Handle</th>
                                <th scope="col">Handle</th>
                                <th scope="col">Handle</th>
                                <th> Function</th>
                                <th>Function</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                                <td>                    
                                    <button onclick="openUpdate()"  class="custom-btn btn-crud"><span>Update now !</span><span>Update</span></button>
                                </td>
                                <td>                                    
                                    <button onclick=" showDelMess()"  class="custom-btn btn-crud"><span>Delete now !</span><span>Delete</span></button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!--pagging-->
                <div class="clearfix">
                    <div class="hint-text">Showing <b>${accountList.size()}</b> out of <b>${total}</b> entries</div>
                    <ul class="pagination">
                        <c:if test="${pageIndex>1}">
                            <li class="page-item disabled"><a href="adminaccountlist?pageIndex=${pageIndex-1}&roleId=${accountList.get(0).roleId}">Previous</a></li>
                            <li class="page-item"><a class="page-link" href="adminaccountlist?pageIndex=${pageIndex-1}&roleId=${accountList.get(0).roleId}">1</a></li>
                            </c:if>

                        <li class="page-item active"><a class="page-link" href="adminaccountlist?pageIndex=${pageIndex}&roleId=${accountList.get(0).roleId}">1</a></li>
                        <li class="page-item active"><a class="page-link" href="adminaccountlist?pageIndex=${pageIndex}&roleId=${accountList.get(0).roleId}">2</a></li>
                        <li class="page-item active"><a class="page-link" href="adminaccountlist?pageIndex=${pageIndex}&roleId=${accountList.get(0).roleId}">3</a></li>

                        <c:if test="${pageIndex<endPage}">
                            <li class="page-item"><a class="page-link" href="adminaccountlist?pageIndex=${pageIndex+1}&roleId=${accountList.get(0).roleId}">2</a></li>
                            <li class="page-item"><a href="adminaccountlist?pageIndex=${pageIndex+1}&roleId=${accountList.get(0).roleId}" class="page-link">Next</a></li>
                            </c:if>
                    </ul>
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
            <div class="modal-add modal-dialog-scrollable">
                <form class="full-width" action="" method="post">
                    <h5 class="modal-add-title">Add movie</h5>
                    <div class="modal-add-body">
                        <div class="add-input">
                            <label>Movie name: </label>  
                            <input class="" name="" type="" placeholder="">
                        </div>
                        <div class="add-input">
                            <label>Movie name: </label>  
                            <input class="" name="" type="" placeholder="">
                        </div>
                        <div class="add-input">
                            <label>Movie name: </label>  
                            <input class="" name="" type="" placeholder="">
                        </div>
                        <div class="add-input">
                            <label>Movie name: </label>  
                            <input class="" name="" type="" placeholder="">
                        </div>
                        <div class="add-input">
                            <label>Movie name: </label>  
                            <input class="" name="" type="" placeholder="">
                        </div>
                        <div class="add-input">
                            <label>Movie name: </label>  
                            <input class="" name="" type="" placeholder="">
                        </div>
                        <div class="add-input">
                            <label>Movie name: </label>  
                            <textarea></textarea>
                        </div>
                    </div>
                    <div class="modal-btn">
                        <button type="submit" class="custom-btn btn-crud"><span>Add now !</span><span>Add more</span></button>
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

                            function showDelMess() {
                                var result = confirm("Bạn có muốn tiếp tục xóa không?");
                                if (result === true) {
                                    window.location.href = '';
                                }
                            }

        </script>
    </body>
</html>
