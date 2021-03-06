<%-- 
    Document   : adminMenu
    Created on : Mar 10, 2022, 10:56:30 PM
    Author     : tenhik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="categories list-unstyled">
    <li class="">
        <p>DASHBOARD</p>
    </li>
    <!--account-->
    <li class="">
        <a href="${pageContext.request.contextPath}/adminaccountlist"><i class="fa fa-users" aria-hidden="true"></i> Account</a>
    </li>
    <!--staff-->
    <li class="has-dropdown">
        <a href="#" onclick="dropdown()" ><i class="fas fa-cogs"></i> Staff</a>
        <ul id="sidebar-dropdown" class="list-unstyled">
            
<!--            <li><a href="#"><i class="fas fa-address-card"></i> Staff </a></li>-->
            <!--cv-->
            <li><a href="${pageContext.request.contextPath}/adminrecruitmentlist" ><i class="fas fa-certificate"></i> Recruitment</a></li>
            <li><a href="${pageContext.request.contextPath}/admincvlist" ><i class="fas fa-address-card"></i> CV List</a></li>
        </ul>
    </li>
    <!--movie-->
    <li class="">
        <a href="${pageContext.request.contextPath}/adminListMovie"><i class="fas fa-film"></i> Movie</a>
    </li>
    <!--schedule-->
    <li class="">
        <a href="${pageContext.request.contextPath}/adminListTime"><i class="far fa-calendar-alt"></i> Schedule</a>
    </li>
    <li class="">
        <a href="${pageContext.request.contextPath}/adminListMovieRoom"><i class="far fa-calendar-alt"></i> Movie room</a>
    </li>
    <!--Food And Drink-->
    <li class="">
        <a href="${pageContext.request.contextPath}/AdminListFood"><i class="far fa-life-bouy"></i> Food And Drink</a>
    </li>
    <!--notification-->
    <li class="">
        <a href="${pageContext.request.contextPath}/adminnotificationlist"><i class='fas fa-bell'></i> Notification</a>
    </li>
</ul>
