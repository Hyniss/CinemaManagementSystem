<%-- 
    Document   : MyOrder
    Created on : 11/02/2022, 10:43:44 AM
    Author     : TIEN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Bootstrap Order Details Table with Search Filter</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">

        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>


        <link rel="stylesheet" href="assets/css/myorder.css" />
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
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <c:if test="${sessionScope.acc ==null}">
            <div class="container mt-5 mb-3 p-3 cart-container" style="background:#e9ecef">
                <h1> Bạn phải đăng nhập để thực hiện tác vụ</h1>
            </div>
        </c:if>
        <c:if test="${sessionScope.acc !=null}">
            <div class="container-xl">
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-10">
                                    <h2>My <b>Order</b></h2>
                                </div>

                            </div>
                        </div>
                        <div class="table-filter">
                            <div class="row">

                                <div class="col-sm-12">
                                    <form action="SearchOrder" method="post">
                                        <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
                                        <div class="filter-group">
                                            <label>Date</label>
                                            <input value="${searchdate}" name="searchdate" value="" type="search" class="form-control" placeholder="Search By Date" aria-label="Search" aria-describedby="search-addon" required/>
                                        </div>
                                    </form>
                                   

                                    <span class="filter-icon"><i class="fa fa-filter"></i></span>
                                </div>
                            </div>
                        </div>
                        <!--                        <form action="SearchOrder" method="post" style="width:40%;min-width: 200px; margin: 10px auto 10px auto " class="input-group rounded">
                                                    <input value="" name="searchdate" value="" type="search" class="form-control rounded" placeholder="Search By Date" aria-label="Search" aria-describedby="search-addon" required/>
                                                    <button type="submit"  style="height:38px;" class="input-group-text border-0" id="search-addon">
                                                        <i class="fas fa-search"></i></a>
                                                    </button>
                                                </form>-->
                        <p style="color:red; text-align: center">${searchMess}</p>    
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Customer</th>
                                    <th>Order Date</th>						
                                    <th>Status</th>						
                                    <th>Amount</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${order}" var="o">
                                    <tr>
                                        <td>${o.cartId}</td>
                                        <td><a href="#"> ${o.username}</a></td>   
                                        <td><fmt:formatDate pattern="EEEE, dd-MM-yyyy"  value = "${o.orderDate}"/></td>    
                                        <c:if test="${o.status == 1}">
                                            <td><span class="status text-success">&bull;</span> Delivered</td>
                                            <td>${o.totalPrice}</td>
                                            <td><a href="${pageContext.request.contextPath}/OrderDetail?cartId=${o.cartId}&username=${acc.username}" class="view" title="View Details" data-toggle="tooltip"><i class="material-icons">&#xE5C8;</i></a></td>
                                        </c:if>
                                        <c:if test="${o.status == 0}">
                                            <td><span class="status text-danger">&bull;</span> Cancelled</td>
                                            <td>${o.totalPrice}</td>
                                            <td><a href="${pageContext.request.contextPath}/payment?id=${o.cartId}&price=${o.totalPrice}" class="view" title="Payment" data-toggle="tooltip"><i class="material-icons">&#xE5C8;</i></a></td>
                                        </c:if>

                                    </tr>

                                    <!--                    <tr>
                                                            <td>3</td>
                                                            <td><a href="#"><img src="/examples/images/avatar/3.jpg" class="avatar" alt="Avatar"> Antonio Moreno</a></td>
                                                            <td>Jul 04, 2017</td>
                                                            <td><span class="status text-danger">&bull;</span> Cancelled</td>
                                                            <td>$350</td>
                                                            <td><a href="#" class="view" title="View Details" data-toggle="tooltip"><i class="material-icons">&#xE5C8;</i></a></td>                        
                                                        </tr>-->

                                </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${searchdate==null}">
                            <div class="clearfix">
                                <div class="hint-text">Showing <b>${order.size()}</b> out of <b>${total1}</b> entries</div>
                                <ul class="pagination">
                                    <c:if test="${pageIndex1>1}">
                                        <li class="page-item disabled"><a href="MyOrder?pageIndex=${pageIndex1-1}">Previous</a></li>
                                        <li class="page-item"><a class="page-link" href="MyOrder?pageIndex=${pageIndex1-1}">${pageIndex1-1}</a></li>
                                        </c:if>
                                        <c:if test="${pageIndex1!=null}">
                                        <li class="page-item active"><a class="page-link" href="MyOrder?pageIndex=${pageIndex1}">${pageIndex1}</a></li>
                                        </c:if>
                                        <c:if test="${pageIndex1<endPage1}">
                                        <li class="page-item"><a class="page-link" href="MyOrder?pageIndex=${pageIndex1+1}">${pageIndex1+1}</a></li>
                                        <li class="page-item"><a href="MyOrder?pageIndex=${pageIndex1+1}" class="page-link">Next</a></li>
                                        </c:if>
                                </ul>
                            </div>
                        </c:if>
                        <c:if test="${searchdate!=null}">
                            <div class="clearfix">
                                <div class="hint-text">Showing <b>${order.size()}</b> out of <b>${total1}</b> entries</div>
                                <ul class="pagination">
                                    <c:if test="${pageIndex1>1}">
                                        <li class="page-item disabled"><a href="SearchOrder?pageIndex=${pageIndex1-1}">Previous</a></li>
                                        <li class="page-item"><a class="page-link" href="SearchOrder?pageIndex=${pageIndex1-1}">${pageIndex1-1}</a></li>
                                        </c:if>
                                        <c:if test="${pageIndex1!=null}">
                                        <li class="page-item active"><a class="page-link" href="SearchOrder?pageIndex=${pageIndex1}">${pageIndex1}</a></li>
                                        </c:if>
                                        <c:if test="${pageIndex1<endPage1}">
                                        <li class="page-item"><a class="page-link" href="SearchOrder?pageIndex=${pageIndex1+1}">${pageIndex1+1}</a></li>
                                        <li class="page-item"><a href="SearchOrder?pageIndex=${pageIndex1+1}" class="page-link">Next</a></li>
                                        </c:if>
                                </ul>
                            </div>
                        </c:if>
                    </div>
                </div>        
            </div> 
        </c:if>       
        <%@include file="template/footer.jsp" %>

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
    </body>
</html>
