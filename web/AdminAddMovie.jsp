<%-- 
    Document   : AdminAddMovie
    Created on : Feb 26, 2022, 9:11:42 PM
    Author     : Tạ Văn Tân
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Sakura -->
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

    <!-- Sakura -->
    <link href="${pageContext.request.contextPath}/assets/css/jquery-sakura.css" rel="stylesheet" type="text/css">
    <title>Amazing Cinema</title>
</head>

<body>
    <div class="content-wrapper">
        <div class="container-fluid">

            <div class="row mt-3">
                <div class="col-lg-5" style="margin-left: auto;margin-right: auto" >
                    <div class="card">

                        <div class="card-body">
                            <h2><a href="adminListMovie">List movie </a></h2>
                            <div class="card-title" style="margin: 10px; color: #ffffff">Add Movie</div>

                            <form action="AdminAddMovie" method="post">

                                <h3 style="color: #18a665 ">${mess}</h3>
                                <h3 style="color: red ">${error}</h3>

                                <div class="form-group">
                                    <label>Movie name</label>
                                    <input value="${movie.movieName}" type="text" class="form-control" required name="movieName">
                                </div>

                                <div>
                                    <p class="text-muted">Image</p>
                                    <div id="myfileupload">
                                        <input type="file" name="movieImage" id="uploadfile" name="ImageUpload" onchange="readURL(this);" />
                                    </div>
                                    <div id="thumbbox">
                                        <img class="rounded" height="20%" width="30%" alt="Thumb image" id="thumbimage" style="display: none" />
                                        <a class="removeimg" href="javascript:"></a>
                                    </div>
                                    <div id="boxchoice">
                                        <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i> Chọn ảnh</a>
                                        <p style="clear:both"></p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="input-1">Category Movie</label>
                                    <input value="${movie.categoryMovie}" type="text" class="form-control" id="input-1"  name="movieCategory">
                                </div>

                                <div class="form-group">
                                    <label for="input-2" class="col-form-label">description</label>
                                    <div>
                                        <textarea class="form-control" rows="2" id="input-17" name="movieDescription">${movie.description}</textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="input-1">Trailer</label>
                                    <input value="${movie.trailer}" type="text" class="form-control" id="input-1"  name="movieTrailer">
                                </div>

                                <div class="form-group">
                                    <label for="input-1">Author</label>
                                    <input value="${movie.author}" type="text" class="form-control" id="input-1"  name="movieAuthor">
                                </div>

                                <div class="form-group">
                                    <label for="input-1">Actor</label>
                                    <input value="${movie.actor}" type="text" class="form-control" id="input-1"  name="movieActor">
                                </div>

                                <div class="form-group">
                                    <label for="input-1">Duration</label>
                                    <input value="${movie.duration}" type="text" class="form-control" id="input-1"  name="movieDuration">
                                </div>

                                <div class="form-group">
                                    <label for="input-1">Premiere</label> 
                                    <div>
                                        <input value="${movie.premiere}" type="date" class="form-control" id="the-date" placeholder="Ngày công chiếu" name="moviePremiere" required="">
                                    </div>
                                </div>
                                <div class="form-footer" style="margin-top: 10px">
                                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i>Add</button>
                                    <button class="btn btn-danger"><i class="fa fa-times"></i><a href="adminListMovie">Cancel</a></button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="overlay toggle-menu"></div>
        </div>
    </div>
</body>
<style>
    .Choicefile{
        display: block;
        background: #396CF0;
        border: 1px solid #fff;
        color: #fff;
        width: 150px;
        text-align: center;
        text-decoration: none;
        cursor: pointer;
        padding: 5px 0px;
        border-radius: 5px;
        font-weight: 500;
        align-items: center;
        justify-content: center;
    }

    .Choicefile:hover {
        text-decoration: none;
        color: white;
    }

    #uploadfile,
    .removeimg {
        display: none;
    }

    #thumbbox {
        position: relative;
        width: 100%;
        margin-bottom: 20px;
    }

    .removeimg {
        height: 25px;
        position: absolute;
        background-repeat: no-repeat;
        top: 5px;
        left: 5px;
        background-size: 25px;
        width: 25px;
        border-radius: 50%;

    }

    .removeimg::before {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        content: '';
        border: 1px solid red;
        background: red;
        text-align: center;
        display: block;
        margin-top: 11px;
        transform: rotate(45deg);
    }

    .removeimg::after {
        content: '';
        background: red;
        border: 1px solid red;
        text-align: center;
        display: block;
        transform: rotate(-45deg);
        margin-top: -2px;
    }
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-sakura.js"></script>
<script>
                                                            $(window).load(function () {
                                                                $('body').sakura();
                                                            });
</script>

<script>
    function readURL(input, thumbimage) {
        if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
            var reader = new FileReader();
            reader.onload = function (e) {
                $("#thumbimage").attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        } else { // Sử dụng cho IE
            $("#thumbimage").attr('src', input.value);

        }
        $("#thumbimage").show();
        $('.filename').text($("#uploadfile").val());
        $(".Choicefile").hide();
        $(".removeimg").show();
    }
    $(document).ready(function () {
        $(".Choicefile").bind('click', function () {
            $("#uploadfile").click();

        });
        $(".removeimg").click(function () {
            $("#thumbimage").attr('src', '').hide();
            $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
            $(".removeimg").hide();
            $(".Choicefile").show();
            $(".filename").text("");
        });
    });
</script>



