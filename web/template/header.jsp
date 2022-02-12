<%-- 
    Document   : header
    Created on : 09-Feb-2022, 00:17:32
    Author     : Bảo Châu Bống
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %> 
<!DOCTYPE html>

<div class="row m-0 p-0" style="background-color: #2E3293">
    <span id="promo" class="d-lg-block d-none" style="color: #00FFFFFF">
        <marquee behavior="scroll" direction="left">Bùng nổ với năm Nhâm Dần 2022 !!!</marquee>
    </span>
</div>

<nav class="navbar main-navbar navbar-expand-lg navbar-light bg-light pt-0" id="navbar1">
    <div class="container-fluid" style="background-image: linear-gradient(#2E3192, #1BFFFF);" >
        <!-- LOGO -->
        <a class="navbar-brand col-lg-2 offset-lg-2 logo" href="${pageContext.request.contextPath}/home">
            <img src="${pageContext.request.contextPath}/assets/img/logo.png">
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <!-- SEARCHBAR -->
            <form class="d-flex searchbar" method="get" action="${pageContext.request.contextPath}/movie">
                <input type="hidden" name="page" value="1"/>
                <input name="query" class="form-control me-2" type="search" placeholder="Search movie you want ..." aria-label="Search">

                <button class="btn btn-danger" type="submit"><i class="fas fa-search" style="font-size: 100%; "></i></button>
            </form>
            <ul class="navbar-nav me-auto ms-auto">                

                <!-- EXPANDED -->
                <li class="nav-item d-none d-lg-block">
                    <a class="nav-link" role="button" data-bs-toggle="offcanvas" data-bs-target="#notification" aria-controls="offcanvasRight"><i class="fas fa-bell"></i>
                        <c:if test="${sessionScope.user !=null}">
                            <span class="position-relative translate-middle badge rounded-pill bg-danger">
                                ${unreadnoti}
                                <span class="visually-hidden">unread notifications</span>
                            </span>
                        </c:if>
                    </a>                   
                </li>
                <li class="nav-item d-none d-lg-block">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/cart">
                        <i class="fas fa-shopping-cart"></i>
                        <c:if test="${sessionScope.user !=null}">
                            <span class="position-relative translate-middle badge rounded-pill bg-danger">
                                ${cartAmount}
                                <span class="visually-hidden">cart items</span>
                            </span>
                        </c:if>
                    </a>
                </li> 
                <li class="nav-item dropdown d-none d-lg-block">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-user-circle"></i>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:if test ="${sessionScope.acc !=  null}">
                            <!-- Default -->
                            <li><span class="dropdown-item-text">Hello ${acc.getUsername()}</span></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ProfileControl">View profile</a></li>  
                            <!-- Admin -->
                            <c:if test="${sessionScope.acc.roleId ==  1}">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/AccountManagerControl">Manage Staff</a></li>
                                </c:if>
                            <!-- Staff -->
                            <c:if test="${sessionScope.acc.roleId  ==  2}">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Dashboard">DashBoard</a></li>
                                </c:if>
                            <!-- Marketing -->
                            <c:if test="${sessionScope.acc.roleId  ==  4}">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/mkt/banner">Manage Banner</a></li>
                                </c:if>
                                
                            <!-- Change password -->
                            
                            <li><a class="dropdown-item" href="ChangePassword.jsp">Change password</a></li>
                            
                            <!-- Default Logout -->
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="logout">Logout</a></li>
                            
                            </c:if>
                            
                        <!-- Neu khong co user -->
                        <c:if test ="${sessionScope.acc ==  null}">
                            <li><a class="dropdown-item" href="Login.jsp">Login</a></li>
                            <li><a class="dropdown-item" href="Register.jsp">Regiter</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/AboutCinema.jsp">About Cinema</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- SECONDARY NAVBAR -->
<nav id="navbar2" class="navbar navbar-expand-lg navbar-light bg-light d-none d-lg-block p-1">
    <div class="container-fluid">
        <ul class="navbar-nav offset-2 me-auto mb-2 mb-lg-0">
            <li class="nav-item me-4">
                <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li class="nav-item me-4">
                <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/movie">Movie</a>
            </li>
            <li class="nav-item dropdown me-4">
                <a class="nav-link dropdown-toggle d-inline-block" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Category</a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

                    <li><h6 class="dropdown-header">Phim đang chiếu</h6></li>
                    <li><h6 class="dropdown-header">Phim sắp chiếu</h6></li>

                </ul>
            </li>
            <li class="nav-item me-4">
                <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/PostControl">Showtimes</a>
            </li>
            <li class="nav-item me-4">
                <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/blog">Promotions</a>
            </li>
            <li class="nav-item me-4">
                <a class="nav-link" href="#footer">Contacts Us</a>
            </li>
        </ul>
    </div>
</nav>
<%-- NAV --%>
<%-- Top Btn --%>
<button onclick="topFunction()" id="myTBTN" title="Go to top"><i class="fas fa-arrow-up"></i></button>