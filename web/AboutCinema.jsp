<%-- 
    Document   : AboutCinema
    Created on : 26-Feb-2022, 10:13:24
    Author     : Bảo Châu Bống
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Amazing Cinema</title>
        <!--CSS-->


        <link href="assets/css/AboutCinema.css" rel="stylesheet" type="text/css"/> 
        <!--ICON-->
    <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
        <link href="${pageContext.request.contextPath}/assets/css/jquery-sakura.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <header>

            <a href="${pageContext.request.contextPath}/home">
                <img class="logo" src="${pageContext.request.contextPath}/assets/img/logo.png" alt="logo"></a>
            <ul class="main-nav">
                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/recruitment">Recruitment</a></li>
            </ul>
            <div class="clearfix"></div>
            <div class="row">
                <div class="heading-main-box">
                    <h1 class="titles">Vietnamese people<br>use Vietnamese goods.<br>So join with us</h1>
                </div>
            </div>
        </header>
        <br>
        <div class="container">
            <h1>Giới thiệu</h1>
            <br>
            <div class="content">
                <h4>
                    Amazing Cinema được biết đến với cụm rạp đầu tiên với 5 phòng chiếu vào năm 2010, tại Maximark 3/2 (nay là Vincom 3/2). 
                    Từ 2014, Amazing Cinema là cụm rạp của doanh nghiệp Việt Nam duy nhất có sức phát triển mạnh mẽ, 
                    qua việc liên tục mở thêm các vị trí rạp mới, ở những khu vực đắc địa của Thành phố Hồ Chí Minh, Hà Nội, 
                    Huế và các tỉnh thành khác.
                </h4>
                </br>
                <img src="assets/img/bhd.png" 
                     style="display: block; margin-left: auto; margin-right: auto;">
                </br>
                <h3 style="color: #006dcc">MỤC TIÊU HOẠT ĐỘNG</h3></br>
                <p>Các mục tiêu này được thiết lập bởi Amazing Cinema như là kim chỉ nam cho các Ban Quản Lý Rạp để bảo đảm trải nghiệm điện ảnh hoàn hảo cho khách hàng.</p>    </br>
                <li>Phục vụ khách hàng: Chúng tôi cam kết chất lượng phục vụ theo tiêu chuẩn cao nhất qua việc thoả mãn các yêu cầu của khách hàng kịp thời,đầy đủ và chuyên nghiệp.</li>

                <li>Không gian thoải mái: Chúng tôi cam kết mang đến một không gian sạch sẽ, thoải mái và thuận lợi, để khách hàng luôn cảm thấy được trân trọng và được phục vụ chu đáo.</li>

                <li>Địa điểm an toàn: Chúng tôi cam kết bảo đảm một không gian giải trí an ninh và an toàn để khách hàng quay lại thường xuyên.</ul>

                <li>Âm thanh hình ảnh: Chúng tôi cam kết cung cấp chất lượng âm thanh và hình ảnh theo tiêu chuẩn cao nhằm gìn giữ, quảng bá và nâng cao trải nghiệm điện ảnh như chính sự kỳ vọng của các nhà làm phim và khán giả xem phim.</li>
                </br>
                Bên cạnh việc sẽ tiếp tục mở rộng ra các tỉnh thành khác, giá trị cốt lõi của thương hiệu Amazing Cinema là luôn luôn bảo đảm trải nghiệm của khách hàng qua chất lượng phục vụ, đồng nhất tại tất cả các cụm rạp.</li>
                <br>
                </br>
                <img src="assets/img/bhd2.png" 
                     style="display: block; margin-left: auto; margin-right: auto;">
                </br>

                <br>
                <h3 style="font-weight: 500; text-align: center;"><strong>Hãy đến thăm chúng tôi</strong></h3>
                <br>
                <p class="map" style="text-align: center">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.4855345740657!2d105.52487561413173!3d21.013249986006784!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31345b465a4e65fb%3A0xaae6040cfabe8fe!2sFPT%20University!5e0!3m2!1sen!2s!4v1636287484694!5m2!1sen!2s" 
                            width="700" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                </p>
                <br>
            </div>
        </div>
        <br>

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
        <script>
            $(window).load(function () {
                $('body').sakura();
            });
        </script>
    </body>
</html>

