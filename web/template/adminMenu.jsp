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
            <!--staff-->
            <li><a href="#"><i class="fas fa-address-card"></i> Staff </a></li>
            <!--cv-->
            <li><a href="${pageContext.request.contextPath}/adminrecruitmentlist" ><i class="fas fa-address-card"></i> Recruitment</a></li>
        </ul>
    </li>
    <!--movie-->
    <li class="">
        <a href="${pageContext.request.contextPath}/adminListMovie"><i class="fas fa-film"></i> Movie</a>
    </li>
    <!--schedule-->
    <li class="">
        <a href="${pageContext.request.contextPath}/adminaccountlist"><i class="far fa-calendar-alt"></i> Schedule</a>
    </li>
    <!--promtion-->
    <li class="">
        <a href="href=${pageContext.request.contextPath}/adminpromotionlist"><i class='fas fa-bullhorn'></i> Promotion</a>
    </li>
    <!--banner-->
    <li class="">
        <a href="${pageContext.request.contextPath}/adminbannerlist"><i class="fas fa-ad"></i> Banner</a>
    </li>
</ul>
