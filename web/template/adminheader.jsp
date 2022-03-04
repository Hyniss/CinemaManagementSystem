<%-- 
    Document   : adminheader
    Created on : Mar 1, 2022, 11:16:51 PM
    Author     : HP
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
        <div style="margin-left: 40%" class="collapse navbar-collapse" id="navbarSupportedContent">

            <!-- SEARCHBAR -->
            <ul class="navbar-nav me-auto ms-auto">                

                <!-- EXPANDED -->
                <li class="nav-item dropdown d-none d-lg-block">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-user-circle"></i>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:if test ="${sessionScope.acc !=  null}">
                            <!-- Change password -->

                            <li><a class="dropdown-item" href="ChangePassword.jsp">Change password</a></li>

                            <!-- Default Logout -->
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="logout">Logout</a></li>

                        </c:if>

                        <!-- Neu khong co user -->
                        <c:if test ="${sessionScope.acc ==  null}">
                            <li><a class="dropdown-item" href="Login.jsp">Login</a></li>
                            <li><a class="dropdown-item" href="Register.jsp">Register</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/AboutCinema.jsp">About Cinema</a></li>
                            </c:if>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
</nav>

<!-- SECONDARY NAVBAR -->
<nav id="navbar2" class="navbar navbar-expand-lg navbar-light bg-light d-none d-lg-block p-1">
    <div class="container-fluid">
        <ul class="navbar-nav offset-2 me-auto mb-2 mb-lg-0" style="margin-left: 30%; margin-right: 30%">
            <li class="nav-item me-4">
                <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/adminhome">Admin Home</a>
            </li>
            <li class="nav-item me-4">
                <a class="nav-link" href="#footer">Contacts Us</a>
            </li>
            <li class="nav-item dropdown me-4">
                <a class="nav-link dropdown-toggle d-inline-block" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Manage</a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li>
                        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/adminaccountlist"><h6 class="dropdown-header">Manage Account</h6></a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<%-- NAV --%>
<%-- Top Btn --%>
<button onclick="topFunction()" id="myTBTN" title="Go to top"><i class="fas fa-arrow-up"></i></button>
