USE [master]
GO
/****** Object:  Database [Cinema]    Script Date: 02/13/2022 17:07:55 ******/
CREATE DATABASE [Cinema] ON  PRIMARY 
( NAME = N'Cinema', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Cinema.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Cinema_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Cinema_log.LDF' , SIZE = 768KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Cinema] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Cinema].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Cinema] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Cinema] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Cinema] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Cinema] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Cinema] SET ARITHABORT OFF
GO
ALTER DATABASE [Cinema] SET AUTO_CLOSE ON
GO
ALTER DATABASE [Cinema] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [Cinema] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Cinema] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Cinema] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Cinema] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Cinema] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Cinema] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Cinema] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Cinema] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Cinema] SET  ENABLE_BROKER
GO
ALTER DATABASE [Cinema] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Cinema] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Cinema] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Cinema] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Cinema] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Cinema] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Cinema] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Cinema] SET  READ_WRITE
GO
ALTER DATABASE [Cinema] SET RECOVERY SIMPLE
GO
ALTER DATABASE [Cinema] SET  MULTI_USER
GO
ALTER DATABASE [Cinema] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Cinema] SET DB_CHAINING OFF
GO
USE [Cinema]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Movie](
	[movieId] [int] IDENTITY(1,1) NOT NULL,
	[movieName] [nvarchar](100) NOT NULL,
	[image] [varchar](max) NOT NULL,
	[categoryMovie] [nvarchar](50) NOT NULL,
	[describe] [nvarchar](max) NOT NULL,
	[trailer] [varchar](max) NULL,
	[author] [nvarchar](30) NOT NULL,
	[actor] [nvarchar](max) NOT NULL,
	[duration] [varchar](6) NOT NULL,
	[premiere] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[movieId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Movie] ON
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (7, N'FAST & FURIOUS 9', N'fast.png', N'Hành Động, Phiêu Lưu', N'Fast & Furious 9: Huyền Thoại Tốc Độ là một bộ phim hành động sắp ra mắt của Mỹ do Justin Lin đạo diễn và Daniel Casey viết kịch bản. Phần tiếp theo của The Fate of the Furious 2017, đây sẽ là phần thứ chín của mạch truyện chính trong loạt phim The Fast Saga và bộ phim dài thứ mười được phát hành tổng thể.', N'https://www.youtube.com/embed/_Di_PJyDGIg', N'Justin Lin', N'Charlize Theron, Jim Parrack, John Cena', N'143', CAST(0x71430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (10, N'CỔNG ĐỊA NGỤC', N'congdianguc.png', N'Kinh Dị', N'Được dịch từ tiếng Anh-Guimoon: The Lightless Door là một bộ phim kinh dị Hàn Quốc năm 2021, do Kim Yong-wan đạo diễn và có sự tham gia của Kim Kang-woo, Kim So-hye và Lee Jung-hyung. Phim được sản xuất đồng thời ở các phiên bản 2D, ScreenX và 4DX.', N'https://www.youtube.com/embed/_Di_PJyDGIg', N'Sim Deok-geun', N'Kim Kang-woo, Kim So-hye, Lee Jung-hyung', N'85', CAST(0x78430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (12, N'NGƯỜI NHỆN KHÔNG CÒN NHÀ', N'spiderman.png', N'Hành Động, Phiêu Lưu', N'Lần đầu tiên trong lịch sử điện ảnh của Người Nhện, thân phận người hàng xóm thân thiện bị lật mở, khiến trách nhiệm làm một Siêu Anh Hùng xung đột với cuộc sống bình thường và đặt người anh quan tâm nhất vào tình thế nguy hiểm. Khi anh nhờ đến giúp đỡ của Doctor Strange để khôi phục lại bí mật, phép thuật đã gây ra lỗ hổng thời không, giải phóng những ác nhân mạnh mẽ nhất từng đối đầu với Người Nhện từ mọi vũ trụ. Bây giờ, Peter sẽ phải vượt qua thử thách lớn nhất của mình, nó sẽ thay đổi không chỉ tương lai của chính anh mà còn là tương lai của cả Đa Vũ Trụ.', N'https://www.youtube.com/embed/daHCu_jU5mQ', N'Jon Watts', N'Tom Holland, Zendaya, Benedict Cumberbatch, Jacob Batalon, Jon Favreau', N'149', CAST(0x5C430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (13, N'TÍN HIỆU DIỆT VONG', N'tinhieudietvong.png', N'Khoa Học Viễn Tưởng', N'Các nhà khoa học chạy đua với thời gian ít ỏi để tạo ra một cỗ máy giúp cho con người sống sót trên một hành tinh mới trước khi thảm họa tận thế đến. Liệu mọi thứ sẽ suôn sẻ thành công hay sẽ có biến số bất ngờ chờ đợi họ?', N'https://www.youtube.com/embed/7LCaJqr0SCs', N'Serik Beyseu', N'Egor Koreshkov, Dmitriy Frid, Petr Romanov', N'97', CAST(0x78430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (14, N'RỪNG THẾ MẠNG', N'rungthemang.png', N'Hồi hộp', N'Tà Năng - Phan Dũng, cung đường trekking đẹp nhất Việt Nam với những câu chuyện tâm linh kỳ bí chưa có lời giải đáp. Dù được cảnh báo sự nguy hiểm và "mỗi năm sẽ có người thế mạng", nhưng một phượt thủ trẻ vẫn quyết định tách đoàn để tìm người bạn thân đi lạc. Hơn 10 ngày đêm kiệt quệ, anh không chỉ rơi vào cuộc chiến sinh tồn chốn rừng thiêng nước độc, mà còn đối mặt với những ám ảnh rùng rợn như ai đó từng nói "ma đưa lối, quỷ dẫn đường”…', N'https://www.youtube.com/embed/lq6a-KBGFtI', N'Trần Hữu Tấn', N'Huỳnh Thanh Trực, Trần Phong, Thùy Anh, Thùy Dương, Lê Quang Vinh, Nguyễn Phước Lộc, NSƯT. Hữu Châu, Kiều Trinh, Bích Hằng, Hưng Võ', N'94', CAST(0x6A430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (16, N'BIỆT ĐỘI SĂN MA: CHUYỂN KIẾP', N'bietdoisanma.png', N'Hài, Phiêu Lưu, Thần thoại', N'Phim xoay quanh câu chuyện về Callie một bà mẹ đơn thân và hai đứa con Trevor và Phoebe, sau khi gặp phải khó khăn về kinh tế trong cuộc sống, cả gia đình phải từ bỏ hết mọi thứ và chuyển đến một khu nông trại hoang sơ, vắng vẻ tại Summerville để bắt đầu cuộc sống mới. Thế nhưng, khi chuyển đến đây thì cả ba mẹ con tại gặp liên tiếp những sự việc vô cùng bí ẩn, xuất hiện đầy những bóng ma khắp nơi. Khiến nhiều người sợ phải, và Trevor và Phoebe đã dùng những dụ cụng bắt ma và bắt đầu cuộc chiến săn ma đầy hài hước.', N'https://www.youtube.com/embed/zt6fpbN5Bq4', N'Jason Reitman', N'Carrie Coon, Paul Rudd, Finn Wolfhard', N'124', CAST(0x71430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (20, N'VENOM: ĐỐI MẶT TỬ THÙ', N'venom.png', N'Hành Động,  Thần thoại', N'Siêu bom tấn #VENOM: LET THERE BE CARNAGE hứa hẹn trận chiến khốc liệt nhất giữa Venom và kẻ thù truyền kiếp, Carnage.', N'https://www.youtube.com/embed/EVWdzVtSh1I', N'Andy Serkis', N'Tom Hardy, Michelle Williams, Woody Harrelson, Naomie Harris', N'97', CAST(0x55430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (22, N'1990', N'1990.png', N'Hài, Tình cảm', N'Bộ phim ‘1990’ là cú bắt tay giữa ba ngọc nữ tuổi Ngọ của điện ảnh Việt: Diễm My - Ninh Dương Lan Ngọc và Nhã Phương. ‘1990’ thuộc thể loại Hài - Tình cảm, có nội dung xoay quanh một hội bạn thân gồm ba cô gái với ba cá tính khác nhau. Khi ngưỡng tuổi “30 chênh vênh” ập đến với cả ba vào cùng một thời điểm, hàng loạt những vấn đề về hôn nhân, tình yêu, sự nghiệp,... lần lượt xuất hiện, buộc họ phải giúp đỡ nhau vượt qua cột mốc đầy sóng gió này.', N'https://www.youtube.com/embed/0wpObK1vu8w', N'Nhất Trung', N'Diễm My, Ninh Dương Lan Ngọc, Nhã Phương...', N'95', CAST(0x8A430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (23, N'CHÌA KHÓA TRĂM TỶ', N'chiakhoa.png', N'Hài, Hành Động', N'Chìa Khoá Trăm Tỷ là câu chuyện đầy oái ăm và ngập tràn tiếng cười kể về những cuộc gặp gỡ định mệnh của bộ ba Mai (Thu Trang), Dũng (Anh Tú) và Thạch (Kiều Minh Tuấn). Ba con người, ba tính cách vô tình va vào nhau rồi bất ngờ thay đổi hoàn toàn số phận lẫn nhau. Có kẻ giàu lên, có người đột ngột trở thành diễn viên...quần chúng và cũng có người bỗng dưng tìm được một nửa của đời mình. Và đó là một câu chuyện cười ra nước mắt khi mỗi một ngày trôi qua họ lại phải tìm mọi cách để sống thật nhất với thân phận mới mà vô tình có được.', N'https://www.youtube.com/embed/gVI2rTSgeVA', N'Võ Thanh Hoà', N'Kiều Minh Tuấn, Thu Trang, Jun Vũ, Anh Tú, Puka, NSUT Kim Xuân, La Thành', N'117', CAST(0x8A430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (26, N'ĐẤU TRƯỜNG ÂM NHẠC 2', N'dautruong.png', N'Hoạt Hình', N'Sau khi thành công rực rỡ tại quê nhà, Buster Moon và các bạn quyết định dấn thân vào một cuộc chinh phục âm nhạc mới hoành tráng và cam go hơn bao giờ hết.', N'https://www.youtube.com/embed/BxUzlrPviZY', N'Garth Jennings', N'Matthew Scarlett Johansson, Taron Egerton, Tori Kelly, Halsey, Pharrell Williams,...', N'110', CAST(0x8A430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (28, N'ENCANTO: VÙNG ĐẤT THẦN KỲ', N'vungdat.png', N'Hoạt Hình, Phiêu Lưu', N'Câu chuyện về một gia đình lạ thường của những người Madrigals cùng sống trong một ngôi nhà phép thuật ở một thị trấn rực rỡ, kỳ diệu và quyến rũ có tên là Encanto. Phép màu của Encanto đã ban cho mọi người những năng lực độc nhất vô nhị, ngoại trừ một đứa trẻ là Mirabel. Nhưng khi những phép màu của Encanto đang gặp nguy hiểm, Mirabel lại có thể là hy vọng cuối cùng để cứu lấy phép màu này.', N'https://www.youtube.com/embed/6tUyGnJShzg', N'Byron Howard, Jared Bush', N'Stephanie Beatriz, María Cecilia Botero, John Leguizamo, Mauro Castillo, Jessica Darrow, Angie Cepeda, Carolina Gaitán Diane Guerrero, Wilmer Valderrama, Rhenzy Feliz, Ravi Cabot-Conyers, Adassa', N'109', CAST(0x8A430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (29, N'PAW PATROL: ĐỘI ĐẶC NHIỆM SIÊU ĐẲNG', N'pawpatrol.png', N'Hài, Hoạt Hình, Phiêu Lưu', N'Trong khi một chú chó con phải đối mặt với quá khứ của mình ở thành phố Phiêu Lưu, nhóm siêu khuyển tìm thấy sự giúp đỡ từ một đồng minh mới, chú chó dachshund Liberty hiểu biết. Cùng nhau trang bị các thiết bị mới thú vị, Đội tuần tra PAW chiến đấu hết mình để cứu các công dân của thành phố Phiêu Lưu!', N'https://www.youtube.com/embed/qT4MjZa3_Uo', N'Cal Brunker', N'Iain Armitage, Marsai Martin, Ron Pardo, Yara Shahidi, Kim Kardashian West, Randall Park, Dax Shepard, Tyler Perry, Jimmy Kimmel, Will Brisbin', N'86', CAST(0x8D430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (30, N'MƯU KẾ THƯỢNG LƯU', N'muuke.png', N'Hồi hộp, Tâm Lý', N'Mưu Kế Thượng Lưu kế về hành trình của Ngân (Thiên An thủ vai) – một cô gái nghèo – bước chân vào thế giới “con nhà người ta” và khám phá ra những góc khuất ít người biết đằng sau vẻ hào nhoáng của những rich kid sinh ra ở vạch đích', N'https://www.youtube.com/embed/nTfYzlxUc-M', N'Trần Bửu Lộc', N'Thiên An, Anh Tú, Quỳnh Lương, Bảo Anh, Lê Tam Triều Dâng,...', N'101', CAST(0x8C430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (31, N'TRẠNG TÍ PHIÊU LƯU KÝ', N'trangty.png', N'Phiêu Lưu, Thần thoại, Tình cảm', N'Trạng Tí Phiêu Lưu Kí là chuyến phiêu lưu vượt ngoài trí tưởng tượng của bộ tứ Tí - Sửu - Dần - Mẹo khi phải cùng nhau vượt qua rất nhiều thử thách để khám phá bí ẩn về cha Tí. Truyền thuyết Hai Hậu sinh ra Tí vì tựa vào cục đá nghe thật khó tin, nên Tí trở thành tâm điểm chọc phá và coi thường bởi những người xấu tính trong làng. Trên hành trình, bốn đứa trẻ nhiều lần gặp rắc rối, hiểu lầm, tai nạn. Và bất ngờ, bốn đứa trẻ lại bị sơn tặc bắt cóc và bị ép đối đầu trước một âm mưu không thể lường trước được. Nhưng, nhờ những trải nghiệm và có bạn bè bên cạnh những lúc khó khăn đó, Tí dần hoàn thiện tính cách bản thân, bớt háo thắng và biết quan tâm đến người khác, hiểu rằng, cái lý đôi khi không quan trọng bằng cái tình mà con người ta dành cho nhau.', N'https://www.youtube.com/embed/r-SR6-b4OQo', N'Phan Gia Nhật Linh', N'Huỳnh Hữu Khang, Phan Bảo Tiên, Vương Hoàng Long, Trần Đức Anh, NSƯT Trung Anh, NS Phi Phụng, NSƯT Quang Thắng, Hiếu Hiền, Oanh Kiều, Xuân Nghị và Hoàng Phi.', N'110', CAST(0x8A430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (32, N'NHÀ KHÔNG BÁN', N'nhakhongban.png', N'Hài, Kinh Dị', N'Câu chuyện xảy ra vào đầu thập niên 90, Bà Ngọc về quê để cùng em trai là ông Ngà bán ngôi nhà cổ của cha để lại. Những ngày đầu về quê sống trong căn nhà cổ họ đã gặp nhiều hiện tượng kì quái. Chính vì những điều kí bí và lời truyền miệng của dân làng về ngôi nhà cổ bị hồn ma cô Trinh ám căn nhà cổ nên khách đến mua nhà cũng bỏ đi hết. Câu chuyện chỉ thực sự bắt đầu khi bà Mai Liên – vợ ông Ngà chết bí ẩn, Betty cháu ngoại bà Ngọc cùng về quê với bà cũng bị mất tích, mọi thứ bắt đầu hé lộ dần những tình tiết hấp dẫn và không ngừng kịch tính đến cuối phim.', N'https://www.youtube.com/embed/uAt37KNG8oM', N'Hoàng Tuấn Cường', N'NSUT Kim Xuân, NS Minh Hoàng, Hạnh Thúy, Việt Hương, Trung Dân, Bạch Công Khanh', N'125', CAST(0x8A430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (34, N'BẪY NGỌT NGÀO', N'bayngotngao.png', N'Tâm Lý', N'Sau một thời gian dài không gặp, cuộc sống của mỗi thành viên trong hội ế đều có nhiều thay đổi. Camy là người duy nhất “thoát ế” với cuộc sống đáng mơ ước bên người chồng tài hoa Đăng Minh. Quỳnh Lam đã là một nhà thiết kế nổi tiếng, Linh Đan là một luật sư thành đạt, còn Ken trở thành ông chủ phòng gym. Cả nhóm quyết định hội ngộ nhân dịp kỷ niệm 3 năm ngày cưới của Camy. Từ đây, những góc khuất trong cuộc sống riêng của từng người dần được hé lộ. Hội ế sẽ làm gì khi phát hiện ra những bí mật của mỗi thành viên lại là nguyên nhân khiến tình bạn của họ đối mặt với sóng gió.', N'https://www.youtube.com/embed/8n5Xmnd1iS4', N'Đinh Hà Uyên Thư', N'Bảo Anh, Minh Hằng, Diệu Nhi, Thuận Nguyễn, Quốc Trường', N'90', CAST(0x94430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (35, N'CHUYỆN MA GẦN NHÀ', N'chuyenmagannha.png', N'Kinh Dị', N'Là tác phẩm đầu tiên trong vũ trụ kinh dị Việt Nam được lấy cảm hứng từ những truyền thuyết đô thị và các câu chuyện ma được đồn thổi trong dân gian. Bộ phim mang màu sắc u ám, quỷ dị với chất liệu từ cuộc sống đời thường. Văn hoá và tín ngưỡng, phong tục tập quán của người Việt Nam sẽ là một điểm nhấn trong tác phẩm này, bên cạnh những cảnh kinh dị.', N'https://www.youtube.com/embed/TM3eh9xuGk8', N'Trần Hữu Tấn', N'Khả Như, Vân Trang, Mạc Can, Huỳnh Thanh Trực,…', N'108', CAST(0x94430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (37, N'CƯỚI EM ĐI', N'cuoiemdi.png', N'Hài, Tình cảm', N'Cưới Em Đi là một bộ phim thuộc thể loại hài lãng mạn, kể về một siêu sao ca nhạc nọ tên Kat (Lopez) cùng đồng nghiệp là Bastian (Maluma) – vốn cũng là một danh ca tiếng tăm không kém – tổ chức buổi lễ đính hôn trước sự chứng kiến của hàng triệu khán giả toàn cầu. Tuy nhiên, chỉ vài giây trước khi sự kiện diễn ra, cô phát hiện Bastian lăng nhăng sau lưng mình, không thể bỏ lại sân khấu, Kat quyết định… chọn cưới ngẫu nhiên một người lạ trong đám đông fan hâm mộ.', N'https://www.youtube.com/embed/kE-Z48_wkJE', N'Kat Coiro', N'Jennifer Lopez, Owen Wilson, John Bradley', N'113', CAST(0x94430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (39, N'ÁN MẠNG TRÊN SÔNG NILE', N'anmang.png', N'Tâm Lý, Tội phạm', N'Án Mạng Trên Sông Nile xoay quanh chuyến đi tham quan Ai Cập của thám tử Poirot. Trên chiếc du thuyền nhỏ, ông bắt gặp một cặp nam thanh nữ tú: nàng triệu phú trẻ Linnet Doyle và người chồng mới cưới Simon Doyle đang hưởng tuần trăng mật. Chuyến đi hạnh phúc của hai người bị phá hỏng bởi người tình cũ của Simon - Jacqueline de Bellefort không ngừng bám theo phá đám.', N'https://www.youtube.com/embed/_9Xoljxlqg8', N'Kenneth Branagh', N'Gal Gadot, Armie Hammer, Rose Leslie', N' 126 ', CAST(0x94430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (44, N'DUNE: HÀNH TINH CÁT', N'dune.png', N'Hành Động, Phiêu Lưu, Tâm Lý', N'Là chuyến hành trình sử thi đầy cảm xúc của Paul Atreides – một chàng thanh niên trẻ tài ba xuất chúng được sinh ra với một sứ mệnh vĩ đại vượt ngoài tầm hiểu biết của chính bản thân anh. Paul đã phải du hành tới hành tinh nguy hiểm nhất trong Vũ trụ để đảm bảo được tương lai cho gia đình cũng như những người dân của anh ấy. Khi các thế lực tàn độc bắt đầu lao vào cuộc xung đột nhằm tranh giành độc quyền nguồn tài nguyên có giá trị nhất hành tinh – thứ nhiên liệu quý giá có khả năng kích hoạt những tiềm năng lớn nhất của nhân loại – chỉ những người chiến thắng được nỗi sợ hãi của mình mới có thể sống sót…', N'https://www.youtube.com/embed/R797Sf-2zt0', N'Denis Villeneuve', N'Timothée Chalamet, Rebecca Ferguson, Zendaya', N'156', CAST(0x55430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (45, N'GINTAMA: THE VERY FINAL', N'gintama.png', N'Hành Động, Hoạt Hình', N'Được chuyển thể từ phần cuối của thương hiệu anime/manga hành động, bựa lầy bậc nhất - Gintama: The Very Final từ Warner Bros. Pictures sẽ là cuộc chiến “khủng” nhất mà Gintoki, Takasugi và Katsura phải tham gia để bảo vệ trái đất khỏi sự hủy diệt và cứu lấy quốc gia của Samurai. Hàng loạt màn chiến đấu đỉnh cao, siêu hài hước, bựa lầy nhưng không kém phần cảm động. Phần phim kỉ niệm 15 năm này được đánh giá cao không kém gì bom tấn Thanh Gươm Diệt Quỷ tại các fandom Nhật Bản!', N'https://www.youtube.com/embed/IUC3D2qJVvI', N'Chizuru Miyawaki', N'Takehito Koyasu, Sugita Tomokazu, Kugimiya Rie, Akira Ishida, Kenichi Suzumura…', N'104', CAST(0x94430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (46, N'GIA TỘC GUCCI', N'gucci.png', N'Tâm Lý, Tội phạm', N'House of Gucci được lấy cảm hứng từ câu chuyện có gây sốc có thật về đế chế gia đình đằng sau nhà mốt Gucci của Ý. Trải qua ba thập kỷ yêu, phản bội, suy đồi, trả thù và cuối cùng là giết người, chúng ta thấy được ý nghĩa đằng sau cái tên, giá trị của danh tiếng và mức độ một gia đình có thể nắm quyền kiểm soát.', N'http://www.youtube.com/embed/CF9Nabk8PUA', N'Ridley Scott', N'Lady Gaga, Adam Driver, Jared Leto, Jeremy Irons, Jack Huston, Salma Hayek, Al Pacino', N'158', CAST(0x9B430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (48, N'THỢ SĂN CỔ VẬT', N'thosan.png', N'Hành Động, Phiêu Lưu', N'Thợ Săn Cổ Vật xoay quanh nhân vật chính là chàng trai trẻ yêu phiêu lưu mạo hiểm Nathan Drake (Tom Holland). Với sự trợ giúp của huấn luyện viên Victor Sullivan (Mark Wahlberg), Nathan dấn thân vào cuộc hành trình khám phá những di tích cổ xưa, sử dụng vũ khí và kỹ năng leo trèo để đối phó với kẻ thù và những cạm bẫy trên hành trình. Dọc đường đi, Nathan gặp gỡ nhiều thợ săn kho báu khác, trong đó có cô nàng nóng bỏng Chloe Frazer (Sophia Taylor Ali).', N'https://www.youtube.com/embed/m-YcgDL3H64', N'Ruben Fleischer', N'Tom Holland Mark Wahlberg Antonio Banderas Sophia Ali Tati Gabrielle', N'120', CAST(0x9B430B00 AS Date))
INSERT [dbo].[Movie] ([movieId], [movieName], [image], [categoryMovie], [describe], [trailer], [author], [actor], [duration], [premiere]) VALUES (49, N'MOONFALL', N'moonfall.png', N'Hành Động, Khoa Học Viễn Tưởng', N'Năm 2011, một tai nạn ngoài vũ trụ khiến một phi hành gia tử vong đầy bí ẩn. Đúng 10 năm sau, Mặt Trăng đột nhiên rời khỏi quỹ đạo và dần trên đường va chạm với Trái Đất. Chuyện dường như có liên quan tới tai nạn năm xưa, và chỉ có những đồng đội của phi hành gia xấu số kia mới có thể tìm ra chân tướng sự việc, cũng như bản chất của Mặt Trăng sau hàng tỷ năm bị giấu kín.', N'https://www.youtube.com/embed/0IMxOd4KCsQ', N'Roland Emmerich', N'Halle Berry, Patrick Wilson, John Bradley, Michael Pena', N'130 ', CAST(0x9B430B00 AS Date))
SET IDENTITY_INSERT [dbo].[Movie] OFF
/****** Object:  Table [dbo].[Fastfood]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Fastfood](
	[foodId] [int] IDENTITY(1,1) NOT NULL,
	[category] [varchar](30) NULL,
	[name] [nvarchar](100) NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[foodId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Fastfood] ON
INSERT [dbo].[Fastfood] ([foodId], [category], [name], [price]) VALUES (1, N'food', N'Bỏng phô mai', 50000)
INSERT [dbo].[Fastfood] ([foodId], [category], [name], [price]) VALUES (2, N'food', N'Bỏng socola', 50000)
INSERT [dbo].[Fastfood] ([foodId], [category], [name], [price]) VALUES (3, N'food', N'Bỏng caramel', 50000)
INSERT [dbo].[Fastfood] ([foodId], [category], [name], [price]) VALUES (4, N'drink', N'Pepsi', 20000)
INSERT [dbo].[Fastfood] ([foodId], [category], [name], [price]) VALUES (5, N'drink', N'Trà sữa', 30000)
INSERT [dbo].[Fastfood] ([foodId], [category], [name], [price]) VALUES (6, N'food', N'Xúc xích', 15000)
INSERT [dbo].[Fastfood] ([foodId], [category], [name], [price]) VALUES (7, N'food', N'Hot dog', 25000)
INSERT [dbo].[Fastfood] ([foodId], [category], [name], [price]) VALUES (8, N'drink', N'Milo lon', 25000)
SET IDENTITY_INSERT [dbo].[Fastfood] OFF
/****** Object:  Table [dbo].[Blog]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Blog](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Author] [nvarchar](100) NULL,
	[Title] [nvarchar](2500) NULL,
	[Content] [nvarchar](2500) NULL,
	[imageLink] [nvarchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Blog] ON
INSERT [dbo].[Blog] ([ID], [Author], [Title], [Content], [imageLink]) VALUES (1, N'BaoChauBong', N'LIVESTREAM PREMIERE RA MẮT PHIM 1990', N'Đợi gì nữa mà chưa đặt lịch xem ngay livestream trên CGV Fanpage nhận 10 cặp vé liền tay!', N'blog1.png')
INSERT [dbo].[Blog] ([ID], [Author], [Title], [Content], [imageLink]) VALUES (2, N'BaoChauBong', N'FAST & FURIOUS 9 - HUYỀN THOẠI TỐC ĐỘ', N'Sở hữu ngay Combo Fast & Furious 9 đầy hấp dẫn với bắp thơm lừng và ly sang xịn mịn có vòng bánh xe xoay theo những pha rượt đuổi gay cấn!', N'blog2.png')
SET IDENTITY_INSERT [dbo].[Blog] OFF
/****** Object:  Table [dbo].[Banner]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Banner](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Img] [varchar](2500) NULL,
	[Title] [nvarchar](2500) NULL,
	[desc] [nvarchar](2500) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Banner] ON
INSERT [dbo].[Banner] ([ID], [Img], [Title], [desc]) VALUES (1, N'1990.png', N'1990', N'1990')
INSERT [dbo].[Banner] ([ID], [Img], [Title], [desc]) VALUES (2, N'chiakhoa.png', N'Chìa khóa trăm tỷ', N'Phim của Thu Trang')
INSERT [dbo].[Banner] ([ID], [Img], [Title], [desc]) VALUES (3, N'dautruong.png', N'Đấu trường âm nhạc 2', N'Sự bùng nổ của phần 2')
INSERT [dbo].[Banner] ([ID], [Img], [Title], [desc]) VALUES (4, N'khaixuan.png', N'Khai xuân Nhâm Dần 2022', N'Mừng xuân Nhâm Dần Tưng bừng terowr lại')
INSERT [dbo].[Banner] ([ID], [Img], [Title], [desc]) VALUES (5, N'khuyenmai.png', N'Khuyến mại', N'Cơ hội đầu xuân')
INSERT [dbo].[Banner] ([ID], [Img], [Title], [desc]) VALUES (6, N'trasua.png', N'Trà sữa Nestle', N'Mua 2 tặng 1')
SET IDENTITY_INSERT [dbo].[Banner] OFF
/****** Object:  Table [dbo].[Seat]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Seat](
	[seatId] [varchar](5) NOT NULL,
	[seatNumber] [int] NOT NULL,
	[seatRow] [char](5) NOT NULL,
	[price] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[seatId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'A1', 1, N'A    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'A2', 2, N'A    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'A3', 3, N'A    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'A4', 4, N'A    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'A5', 5, N'A    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'A6', 6, N'A    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'A7', 7, N'A    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'A8', 8, N'A    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'B1', 1, N'B    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'B2', 2, N'B    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'B3', 3, N'B    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'B4', 4, N'B    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'B5', 5, N'B    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'B6', 6, N'B    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'B7', 7, N'B    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'B8', 8, N'B    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'C1', 1, N'C    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'C2', 2, N'C    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'C3', 3, N'C    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'C4', 4, N'C    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'C5', 5, N'C    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'C6', 6, N'C    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'C7', 7, N'C    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'C8', 8, N'C    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'D1', 1, N'D    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'D2', 2, N'D    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'D3', 3, N'D    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'D4', 4, N'D    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'D5', 5, N'D    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'D6', 6, N'D    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'D7', 7, N'D    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'D8', 8, N'D    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'E1', 1, N'E    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'E2', 2, N'E    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'E3', 3, N'E    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'E4', 4, N'E    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'E5', 5, N'E    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'E6', 6, N'E    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'E7', 7, N'E    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'E8', 8, N'E    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'F1', 1, N'F    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'F2', 2, N'F    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'F3', 3, N'F    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'F4', 4, N'F    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'F5', 5, N'F    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'F6', 6, N'F    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'F7', 7, N'F    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'F8', 8, N'F    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'G1', 1, N'G    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'G2', 2, N'G    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'G3', 3, N'G    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'G4', 4, N'G    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'G5', 5, N'G    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'G6', 6, N'G    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'G7', 7, N'G    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'G8', 8, N'G    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'H1', 1, N'H    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'H2', 2, N'H    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'H3', 3, N'H    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'H4', 4, N'H    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'H5', 5, N'H    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'H6', 6, N'H    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'H7', 7, N'H    ', 55000)
INSERT [dbo].[Seat] ([seatId], [seatNumber], [seatRow], [price]) VALUES (N'H8', 8, N'H    ', 55000)
/****** Object:  Table [dbo].[Room]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Room](
	[roomId] [varchar](5) NOT NULL,
	[roomName] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[roomId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Room] ([roomId], [roomName]) VALUES (N'1', N'Cinema 1')
INSERT [dbo].[Room] ([roomId], [roomName]) VALUES (N'2', N'Cinema 2')
INSERT [dbo].[Room] ([roomId], [roomName]) VALUES (N'3', N'Cinema 3')
INSERT [dbo].[Room] ([roomId], [roomName]) VALUES (N'4', N'Cinema 4')
INSERT [dbo].[Room] ([roomId], [roomName]) VALUES (N'5', N'Cinema 5')
/****** Object:  Table [dbo].[Role]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Role](
	[roleId] [int] IDENTITY(1,1) NOT NULL,
	[roleName] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[roleId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Role] ON
INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (1, N'admin')
INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (2, N'staff')
INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (3, N'user')
INSERT [dbo].[Role] ([roleId], [roleName]) VALUES (4, N'marketing')
SET IDENTITY_INSERT [dbo].[Role] OFF
/****** Object:  Table [dbo].[MovieRoom]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MovieRoom](
	[movieRoomId] [int] IDENTITY(1,1) NOT NULL,
	[premiere] [datetime] NULL,
	[movieId] [int] NOT NULL,
	[roomId] [varchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[movieRoomId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[MovieRoom] ON
INSERT [dbo].[MovieRoom] ([movieRoomId], [premiere], [movieId], [roomId]) VALUES (15, CAST(0x0000AF8100000000 AS DateTime), 7, N'2')
SET IDENTITY_INSERT [dbo].[MovieRoom] OFF
/****** Object:  Table [dbo].[Account]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](30) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[avatar] [varchar](max) NULL,
	[fullName] [nvarchar](30) NOT NULL,
	[DOB] [date] NULL,
	[email] [varchar](30) NOT NULL,
	[phone] [varchar](20) NULL,
	[roleId] [int] NULL,
	[security] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Account] ([username], [password], [avatar], [fullName], [DOB], [email], [phone], [roleId], [security]) VALUES (N'admin', N'admin', N'profile-pic.jpg', N'Nguyễn Admin', CAST(0xF8170B00 AS Date), N'admin123@gmail.com', N'999999999', 1, N'cat')
INSERT [dbo].[Account] ([username], [password], [avatar], [fullName], [DOB], [email], [phone], [roleId], [security]) VALUES (N'mkt', N'123456', N'profile-pic.jpg', N'marketing', CAST(0xC6260B00 AS Date), N'mkt.cinema@gmail.com', N'147147147', 4, N'dog')
INSERT [dbo].[Account] ([username], [password], [avatar], [fullName], [DOB], [email], [phone], [roleId], [security]) VALUES (N'nguyengiangnam', N'123456', N'nguyengiangnam.jpg', N'Nguyễn Giang Nam', CAST(0x05260B00 AS Date), N'namng@gmail.com', N'111111111', 3, N'cat')
INSERT [dbo].[Account] ([username], [password], [avatar], [fullName], [DOB], [email], [phone], [roleId], [security]) VALUES (N'nguyentienhuy', N'123456', N'nguyentienhuy.jpg', N'Nguyễn Tiến Huy', CAST(0x05260B00 AS Date), N'huynt@gmail.com', N'111111111', 3, N'dog')
INSERT [dbo].[Account] ([username], [password], [avatar], [fullName], [DOB], [email], [phone], [roleId], [security]) VALUES (N'nguyenvietbaochau', N'123456', N'nguyenvietbaochau.jpg', N'Nguyễn Viết Bảo Châu', CAST(0x05260B00 AS Date), N'chaunvb@gmail.com', N'111111111', 3, N'dog')
INSERT [dbo].[Account] ([username], [password], [avatar], [fullName], [DOB], [email], [phone], [roleId], [security]) VALUES (N'staff1', N'staff1', N'profile-pic.jpg', N'Nguyễn Staff1', CAST(0x74240B00 AS Date), N'staff1@gmail.com', N'111111111', 2, N'cat')
INSERT [dbo].[Account] ([username], [password], [avatar], [fullName], [DOB], [email], [phone], [roleId], [security]) VALUES (N'tavantan', N'123456', N'tavantan.jpg', N'Tạ Văn Tân', CAST(0x05260B00 AS Date), N'tantv@gmail.com', N'111111111', 3, N'cat')
INSERT [dbo].[Account] ([username], [password], [avatar], [fullName], [DOB], [email], [phone], [roleId], [security]) VALUES (N'tranvietdanhthai', N'123456', N'tranvietdanhthai.jpg', N'Tran Viet Danh Thai Dep Trai', CAST(0x69260B00 AS Date), N'tranvietdanhthai@gmail.com', N'0941815064', 3, N'bird')
/****** Object:  Table [dbo].[Cart]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[cartId] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](30) NOT NULL,
	[totalPrice] [float] NOT NULL,
	[status] [bit] NULL,
	[orderDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[cartId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Cart] ON
INSERT [dbo].[Cart] ([cartId], [username], [totalPrice], [status], [orderDate]) VALUES (1, N'nguyentienhuy', 0, 1, CAST(0x7D250B00 AS Date))
INSERT [dbo].[Cart] ([cartId], [username], [totalPrice], [status], [orderDate]) VALUES (2, N'nguyenvietbaochau', 0, 0, NULL)
SET IDENTITY_INSERT [dbo].[Cart] OFF
/****** Object:  Table [dbo].[Feedback]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[feedbackId] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](30) NOT NULL,
	[movieId] [int] NOT NULL,
	[feedback] [nvarchar](300) NULL,
	[rate] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[feedbackId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Feedback] ON
INSERT [dbo].[Feedback] ([feedbackId], [username], [movieId], [feedback], [rate]) VALUES (1, N'tranvietdanhthai', 7, N'Phim rất hay', 5)
INSERT [dbo].[Feedback] ([feedbackId], [username], [movieId], [feedback], [rate]) VALUES (2, N'nguyentienhuy', 7, N'Hơi hay', 4)
INSERT [dbo].[Feedback] ([feedbackId], [username], [movieId], [feedback], [rate]) VALUES (3, N'nguyengiangnam', 7, N'Ổn', 3)
INSERT [dbo].[Feedback] ([feedbackId], [username], [movieId], [feedback], [rate]) VALUES (4, N'nguyenvietbaochau', 10, N'Very good', 5)
INSERT [dbo].[Feedback] ([feedbackId], [username], [movieId], [feedback], [rate]) VALUES (6, N'tavantan', 10, N'Rất nhân văn', 5)
SET IDENTITY_INSERT [dbo].[Feedback] OFF
/****** Object:  Table [dbo].[SeatRoom]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SeatRoom](
	[seatRoomId] [int] IDENTITY(1,1) NOT NULL,
	[status] [bit] NULL,
	[movieRoomId] [int] NOT NULL,
	[seatId] [varchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[seatRoomId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[SeatRoom] ON
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1345, 0, 15, N'A1')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1346, 0, 15, N'A2')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1347, 0, 15, N'A3')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1348, 0, 15, N'A4')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1349, 0, 15, N'A5')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1350, 0, 15, N'A6')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1351, 0, 15, N'A7')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1352, 0, 15, N'A8')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1353, 0, 15, N'B1')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1354, 0, 15, N'B2')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1355, 0, 15, N'B3')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1356, 0, 15, N'B4')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1357, 0, 15, N'B5')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1358, 0, 15, N'B6')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1359, 0, 15, N'B7')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1360, 0, 15, N'B8')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1361, 0, 15, N'C1')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1362, 0, 15, N'C2')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1363, 0, 15, N'C3')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1364, 0, 15, N'C4')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1365, 0, 15, N'C5')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1366, 0, 15, N'C6')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1367, 0, 15, N'C7')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1368, 0, 15, N'C8')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1369, 0, 15, N'D1')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1370, 0, 15, N'D2')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1371, 0, 15, N'D3')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1372, 0, 15, N'D4')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1373, 0, 15, N'D5')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1374, 0, 15, N'D6')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1375, 0, 15, N'D7')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1376, 0, 15, N'D8')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1377, 0, 15, N'E1')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1378, 0, 15, N'E2')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1379, 0, 15, N'E3')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1380, 0, 15, N'E4')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1381, 0, 15, N'E5')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1382, 0, 15, N'E6')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1383, 0, 15, N'E7')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1384, 0, 15, N'E8')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1385, 0, 15, N'F1')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1386, 0, 15, N'F2')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1387, 0, 15, N'F3')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1388, 0, 15, N'F4')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1389, 0, 15, N'F5')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1390, 0, 15, N'F6')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1391, 0, 15, N'F7')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1392, 0, 15, N'F8')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1393, 0, 15, N'G1')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1394, 0, 15, N'G2')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1395, 0, 15, N'G3')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1396, 0, 15, N'G4')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1397, 0, 15, N'G5')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1398, 0, 15, N'G6')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1399, 0, 15, N'G7')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1400, 0, 15, N'G8')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1401, 0, 15, N'H1')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1402, 0, 15, N'H2')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1403, 0, 15, N'H3')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1404, 0, 15, N'H4')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1405, 0, 15, N'H5')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1406, 0, 15, N'H6')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1407, 0, 15, N'H7')
INSERT [dbo].[SeatRoom] ([seatRoomId], [status], [movieRoomId], [seatId]) VALUES (1408, 0, 15, N'H8')
SET IDENTITY_INSERT [dbo].[SeatRoom] OFF
/****** Object:  Table [dbo].[SeatRoomCart]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SeatRoomCart](
	[seatRoomCartId] [int] IDENTITY(1,1) NOT NULL,
	[seatRoomId] [int] NOT NULL,
	[cartId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[seatRoomCartId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[SeatRoomCart] ON
INSERT [dbo].[SeatRoomCart] ([seatRoomCartId], [seatRoomId], [cartId]) VALUES (1, 1345, 1)
INSERT [dbo].[SeatRoomCart] ([seatRoomCartId], [seatRoomId], [cartId]) VALUES (2, 1346, 1)
INSERT [dbo].[SeatRoomCart] ([seatRoomCartId], [seatRoomId], [cartId]) VALUES (4, 1347, 2)
SET IDENTITY_INSERT [dbo].[SeatRoomCart] OFF
/****** Object:  Table [dbo].[FastFoodCart]    Script Date: 02/13/2022 17:07:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FastFoodCart](
	[fastfoodCartId] [int] IDENTITY(1,1) NOT NULL,
	[foodId] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[cartId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[fastfoodCartId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[FastFoodCart] ON
INSERT [dbo].[FastFoodCart] ([fastfoodCartId], [foodId], [quantity], [cartId]) VALUES (1, 1, 1, 1)
INSERT [dbo].[FastFoodCart] ([fastfoodCartId], [foodId], [quantity], [cartId]) VALUES (2, 4, 2, 1)
INSERT [dbo].[FastFoodCart] ([fastfoodCartId], [foodId], [quantity], [cartId]) VALUES (3, 1, 1, 2)
SET IDENTITY_INSERT [dbo].[FastFoodCart] OFF
/****** Object:  Check [CK__Cart__32E0915F]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__33D4B598]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__34C8D9D1]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__35BCFE0A]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__36B12243]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='True' OR [orderDate] IS NULL))
GO
/****** Object:  Check [CK__Cart__37A5467C]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='False' OR [orderDate] IS NOT NULL))
GO
/****** Object:  Check [CK__Cart__38996AB5]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__398D8EEE]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__3A81B327]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__3B75D760]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__3C69FB99]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='True' OR [orderDate] IS NULL))
GO
/****** Object:  Check [CK__Cart__3D5E1FD2]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='False' OR [orderDate] IS NOT NULL))
GO
/****** Object:  Check [CK__Cart__3E52440B]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__3F466844]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__403A8C7D]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__412EB0B6]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__4222D4EF]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='True' OR [orderDate] IS NULL))
GO
/****** Object:  Check [CK__Cart__4316F928]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='False' OR [orderDate] IS NOT NULL))
GO
/****** Object:  Check [CK__Cart__440B1D61]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__44FF419A]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__45F365D3]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__46E78A0C]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__47DBAE45]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='True' OR [orderDate] IS NULL))
GO
/****** Object:  Check [CK__Cart__48CFD27E]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='False' OR [orderDate] IS NOT NULL))
GO
/****** Object:  Check [CK__Feedback__rate__49C3F6B7]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD CHECK  (([rate]<=(5) AND [rate]>=(1)))
GO
/****** Object:  Check [CK__Feedback__rate__4AB81AF0]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD CHECK  (([rate]<=(5) AND [rate]>=(1)))
GO
/****** Object:  Check [CK__Feedback__rate__4BAC3F29]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD CHECK  (([rate]<=(5) AND [rate]>=(1)))
GO
/****** Object:  Check [CK__Feedback__rate__4CA06362]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD CHECK  (([rate]<=(5) AND [rate]>=(1)))
GO
/****** Object:  ForeignKey [FK__MovieRoom__movie__4D94879B]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[MovieRoom]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__MovieRoom__movie__4E88ABD4]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[MovieRoom]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__MovieRoom__movie__4F7CD00D]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[MovieRoom]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__MovieRoom__movie__5070F446]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[MovieRoom]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__MovieRoom__roomI__5165187F]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[MovieRoom]  WITH CHECK ADD FOREIGN KEY([roomId])
REFERENCES [dbo].[Room] ([roomId])
GO
/****** Object:  ForeignKey [FK__MovieRoom__roomI__52593CB8]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[MovieRoom]  WITH CHECK ADD FOREIGN KEY([roomId])
REFERENCES [dbo].[Room] ([roomId])
GO
/****** Object:  ForeignKey [FK__MovieRoom__roomI__534D60F1]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[MovieRoom]  WITH CHECK ADD FOREIGN KEY([roomId])
REFERENCES [dbo].[Room] ([roomId])
GO
/****** Object:  ForeignKey [FK__MovieRoom__roomI__5441852A]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[MovieRoom]  WITH CHECK ADD FOREIGN KEY([roomId])
REFERENCES [dbo].[Room] ([roomId])
GO
/****** Object:  ForeignKey [FK__Account__roleId__5535A963]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Account]  WITH CHECK ADD FOREIGN KEY([roleId])
REFERENCES [dbo].[Role] ([roleId])
GO
/****** Object:  ForeignKey [FK__Account__roleId__5629CD9C]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Account]  WITH CHECK ADD FOREIGN KEY([roleId])
REFERENCES [dbo].[Role] ([roleId])
GO
/****** Object:  ForeignKey [FK__Account__roleId__571DF1D5]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Account]  WITH CHECK ADD FOREIGN KEY([roleId])
REFERENCES [dbo].[Role] ([roleId])
GO
/****** Object:  ForeignKey [FK__Account__roleId__5812160E]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Account]  WITH CHECK ADD FOREIGN KEY([roleId])
REFERENCES [dbo].[Role] ([roleId])
GO
/****** Object:  ForeignKey [FK__Cart__username__59063A47]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__Cart__username__59FA5E80]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__Cart__username__5AEE82B9]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__Cart__username__5BE2A6F2]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__Feedback__movieI__5CD6CB2B]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__Feedback__movieI__5DCAEF64]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__Feedback__movieI__5EBF139D]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__Feedback__movieI__5FB337D6]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__Feedback__userna__60A75C0F]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__Feedback__userna__619B8048]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__Feedback__userna__628FA481]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__Feedback__userna__6383C8BA]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__SeatRoom__movieR__6477ECF3]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([movieRoomId])
REFERENCES [dbo].[MovieRoom] ([movieRoomId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__movieR__656C112C]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([movieRoomId])
REFERENCES [dbo].[MovieRoom] ([movieRoomId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__movieR__66603565]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([movieRoomId])
REFERENCES [dbo].[MovieRoom] ([movieRoomId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__movieR__6754599E]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([movieRoomId])
REFERENCES [dbo].[MovieRoom] ([movieRoomId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__seatId__68487DD7]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([seatId])
REFERENCES [dbo].[Seat] ([seatId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__seatId__693CA210]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([seatId])
REFERENCES [dbo].[Seat] ([seatId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__seatId__6A30C649]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([seatId])
REFERENCES [dbo].[Seat] ([seatId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__seatId__6B24EA82]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([seatId])
REFERENCES [dbo].[Seat] ([seatId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__cartI__6C190EBB]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__cartI__6D0D32F4]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__cartI__6E01572D]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__cartI__6EF57B66]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__seatR__6FE99F9F]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([seatRoomId])
REFERENCES [dbo].[SeatRoom] ([seatRoomId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__seatR__70DDC3D8]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([seatRoomId])
REFERENCES [dbo].[SeatRoom] ([seatRoomId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__seatR__71D1E811]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([seatRoomId])
REFERENCES [dbo].[SeatRoom] ([seatRoomId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__seatR__72C60C4A]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([seatRoomId])
REFERENCES [dbo].[SeatRoom] ([seatRoomId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__cartI__73BA3083]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__cartI__74AE54BC]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__cartI__75A278F5]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__cartI__76969D2E]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__foodI__778AC167]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([foodId])
REFERENCES [dbo].[Fastfood] ([foodId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__foodI__787EE5A0]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([foodId])
REFERENCES [dbo].[Fastfood] ([foodId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__foodI__797309D9]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([foodId])
REFERENCES [dbo].[Fastfood] ([foodId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__foodI__7A672E12]    Script Date: 02/13/2022 17:07:55 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([foodId])
REFERENCES [dbo].[Fastfood] ([foodId])
GO
