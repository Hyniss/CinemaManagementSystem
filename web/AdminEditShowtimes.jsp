<%-- 
    Document   : AdminEditShowtimes
    Created on : 10-Mar-2022, 16:33:07
    Author     : Bảo Châu Bống
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Amazing Cinema</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>

        <!-- icon -->
        <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/queries.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/homepage.css" />
        <!-- Sakura -->
        <link href="${pageContext.request.contextPath}/assets/css/jquery-sakura.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Showtimes</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <form action="edit_showtimes" method="post">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Movie Room ID</label>
                                    <input value="${movieRoom.movieRoomId}" name="new_movieRoomId" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Movie ID</label>
                                    <input value="${movieRoom.movieId}" name="new_movieId" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label for="input-2">Date</label>
                                    <input type="date" class="form-control" id="input-2" value="${movieRoom.premiere}"name="new_premiere">
                                </div>
                                <div class="form-group">
                                    <label for="input-2">Time</label>
                                    <input type="time" class="form-control" id="input-2" value="${movieRoom.time}"name="new_time">
                                </div>
                                <div class="form-group">
                                    <label for="input-2">Room Number</label>
                                    <input type="number" class="form-control" id="input-2" value="${movieRoom.roomId}"name="new_roomId">
                                </div>                              

                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-success">Update</button>
                                <a class="btn btn-danger" href="adminshowtimeslist" role="button">Back</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- SAKURA -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery-sakura.js"></script>
        <script>
            $(window).load(function () {
                $('body').sakura();
            });
        </script>
    </body>
</html>

