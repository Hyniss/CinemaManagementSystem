<%-- 
    Document   : AdminAddShowtimes
    Created on : 10-Mar-2022, 08:47:54
    Author     : Bảo Châu Bống
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
                            <h2>Add <b>Showtimes</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header">
                            <form method="post" action="add_showtimes">
                                <h4 class="modal-title">Add Showtimes</h4>
                                <button type="submit" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </form>
                        </div>
                        <form action="add_showtimes" method="post">
                            <div class="modal-body">
                                <h3 style="color: red;font-weight: 200;margin: 10px">${mess}</h3>
                                <div class="form-group">
                                    <label>Movie ID</label>
                                    <input value="${movie.movieId}" name="movieId" type="text" class="form-control" required readonly>
                                </div>
                                <div class="form-group">
                                    <label>Movie Name</label>
                                    <input value="${movie.movieName}" name="movieName" type="text" class="form-control" required readonly>
                                </div>
                                <div class="form-group">
                                    <label>Date</label>
                                    <input value="${movieRoomList.premiere}" name="premiere" type="date" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Time</label>
                                    <input value="${movieRoomList.time}" name="time" type="time" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Seat</label>
                                    <input value="${movieRoomList.seat}" name="seat" type="number" class="form-control" required>
                                </div>

                                <p style="color: red;font-size: 14px">${failMessage}</p>
                                <p style="color: red;font-size: 14px">${mess}</p>
                                <p style="color: green;font-size: 14px">${successMessage}</p>                                

                            </div>
                            <div class="modal-footer">
                                <a class="btn btn-success" href="adminshowtimeslist" role="button">Add</a>
                                <a class="btn btn-danger" href="adminListMovie" role="button">Back to Movie Management</a>
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
