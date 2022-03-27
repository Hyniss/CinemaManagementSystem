<%-- 
    Document   : adminNewHeader
    Created on : Mar 10, 2022, 10:48:47 PM
    Author     : tenhik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-md">
    <div class="container-fluid mx-2">
        <!--Brand-->
        <div class="navbar-header">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#toggle-navbar" aria-controls="toggle-navbar" aria-expanded="false" aria-label="Toggle navigation">
                <i class="uil-bars text-white"></i>
            </button>
            <a class="navbar-brand" href="adminhome">Cinema<span class="main-color"> management <i class="fas fa-cogs"></i></span></a>
        </div>       
        <!--Account info-->
        <div class="collapse navbar-collapse" id="toggle-navbar">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" >
                        <i class="fas fa-user-circle" style="color: #FFF"></i>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:if test ="${sessionScope.acc !=  null}">
                            <!-- Default -->
                            <li><span class="dropdown-item-text">Hello ${acc.getUsername()}</span></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/account?username=${acc.getUsername()}">View profile</a></li>  
                            <!-- Change password -->
                            <li><a class="dropdown-item" href="ChangePassword.jsp">Change password</a></li>
                            <!-- Default Logout -->
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="logout">Logout</a></li>

                        </c:if>

                        <!-- Neu khong co user -->
                        <c:if test ="${sessionScope.acc ==  null}">
                            <li><a class="dropdown-item" href="login">Login</a></li>
                            <li><a class="dropdown-item" href="Register.jsp">Register</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/AboutCinema.jsp">About Cinema</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>