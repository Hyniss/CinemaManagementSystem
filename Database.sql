USE [master]
GO
/****** Object:  Database [Cinema]    Script Date: 03/27/2022 21:53:56 ******/
CREATE DATABASE [Cinema] ON  PRIMARY 
( NAME = N'Cinema', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Cinema.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Cinema_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Cinema_log.LDF' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
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
/****** Object:  Table [dbo].[Seat]    Script Date: 03/27/2022 21:53:56 ******/
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
/****** Object:  Table [dbo].[Room]    Script Date: 03/27/2022 21:53:56 ******/
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
/****** Object:  Table [dbo].[Role]    Script Date: 03/27/2022 21:53:56 ******/
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
/****** Object:  Table [dbo].[Recruitment]    Script Date: 03/27/2022 21:53:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recruitment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[img] [nvarchar](max) NULL,
	[title] [nvarchar](max) NULL,
	[content] [nvarchar](max) NULL,
	[date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promotion]    Script Date: 03/27/2022 21:53:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promotion](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](2500) NULL,
	[Content] [nvarchar](2500) NULL,
	[imageLink] [nvarchar](2500) NULL,
	[date] [date] NULL,
	[discount] [float] NULL,
	[MAGIAM] [nvarchar](2500) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Status]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[status] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Fastfood]    Script Date: 03/27/2022 21:53:57 ******/
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
	[img] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[foodId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Banner]    Script Date: 03/27/2022 21:53:57 ******/
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
/****** Object:  Table [dbo].[MovieRoom]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MovieRoom](
	[movieRoomId] [int] IDENTITY(1,1) NOT NULL,
	[premiere] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[movieRoomId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 03/27/2022 21:53:57 ******/
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
/****** Object:  Table [dbo].[MovieTime]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MovieTime](
	[timeId] [int] IDENTITY(1,1) NOT NULL,
	[slot] [varchar](10) NULL,
	[start] [time](7) NULL,
	[finish] [time](7) NULL,
	[movieRoomId] [int] NULL,
	[add] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[timeId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NotificationAccount]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NotificationAccount](
	[notificationId] [int] NOT NULL,
	[username] [nvarchar](30) NOT NULL,
	[readed] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[notificationId] ASC,
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Notification]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notification](
	[notificationId] [int] IDENTITY(1,1) NOT NULL,
	[notificationImg] [nvarchar](50) NULL,
	[notificationTitle] [nvarchar](100) NULL,
	[notificationDescription] [nvarchar](2500) NULL,
	[notificationDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[notificationId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 03/27/2022 21:53:57 ******/
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
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CVInfor]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CVInfor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fullname] [nvarchar](max) NULL,
	[CV] [nvarchar](max) NULL,
	[date] [date] NULL,
	[chucvu] [int] NULL,
	[status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TimeRoom]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TimeRoom](
	[timeRoomId] [int] IDENTITY(1,1) NOT NULL,
	[movieId] [int] NULL,
	[roomId] [varchar](5) NOT NULL,
	[timeId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[timeRoomId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 03/27/2022 21:53:57 ******/
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
/****** Object:  Table [dbo].[Feedback]    Script Date: 03/27/2022 21:53:57 ******/
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
	[feedbackDate] [date] NULL,
	[feedbackTime] [time](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[feedbackId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FastFoodCart]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FastFoodCart](
	[fastfoodCartId] [int] IDENTITY(1,1) NOT NULL,
	[foodId] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[cartId] [int] NOT NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[fastfoodCartId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SeatRoom]    Script Date: 03/27/2022 21:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SeatRoom](
	[seatRoomId] [int] IDENTITY(1,1) NOT NULL,
	[status] [bit] NULL,
	[seatId] [varchar](5) NOT NULL,
	[timeRoomId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[seatRoomId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SeatRoomCart]    Script Date: 03/27/2022 21:53:57 ******/
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
/****** Object:  Check [CK__Cart__49C3F6B7]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__4AB81AF0]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__4BAC3F29]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__4CA06362]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__4D94879B]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='True' OR [orderDate] IS NULL))
GO
/****** Object:  Check [CK__Cart__4E88ABD4]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='False' OR [orderDate] IS NOT NULL))
GO
/****** Object:  Check [CK__Cart__4F7CD00D]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__5070F446]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__5165187F]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__52593CB8]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__534D60F1]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='True' OR [orderDate] IS NULL))
GO
/****** Object:  Check [CK__Cart__5441852A]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='False' OR [orderDate] IS NOT NULL))
GO
/****** Object:  Check [CK__Cart__5535A963]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__5629CD9C]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__571DF1D5]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__5812160E]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__59063A47]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='True' OR [orderDate] IS NULL))
GO
/****** Object:  Check [CK__Cart__59FA5E80]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='False' OR [orderDate] IS NOT NULL))
GO
/****** Object:  Check [CK__Cart__5AEE82B9]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__5BE2A6F2]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__5CD6CB2B]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(1) OR [orderDate]=NULL))
GO
/****** Object:  Check [CK__Cart__5DCAEF64]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]=(0) OR [orderDate]<>NULL))
GO
/****** Object:  Check [CK__Cart__5EBF139D]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='True' OR [orderDate] IS NULL))
GO
/****** Object:  Check [CK__Cart__5FB337D6]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD CHECK  (([status]='False' OR [orderDate] IS NOT NULL))
GO
/****** Object:  ForeignKey [FK__MovieTime__movie__60A75C0F]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[MovieTime]  WITH CHECK ADD FOREIGN KEY([movieRoomId])
REFERENCES [dbo].[MovieRoom] ([movieRoomId])
GO
/****** Object:  ForeignKey [FK__Notificat__notif__628FA481]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[NotificationAccount]  WITH CHECK ADD FOREIGN KEY([notificationId])
REFERENCES [dbo].[Notification] ([notificationId])
GO
/****** Object:  ForeignKey [FK__Notificat__usern__6383C8BA]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[NotificationAccount]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [FK__Account__roleId__619B8048]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Account]  WITH CHECK ADD FOREIGN KEY([roleId])
REFERENCES [dbo].[Role] ([roleId])
GO
/****** Object:  ForeignKey [FK__CVInfor__chucvu__7B5B524B]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[CVInfor]  WITH CHECK ADD FOREIGN KEY([chucvu])
REFERENCES [dbo].[Recruitment] ([id])
GO
/****** Object:  ForeignKey [FK__CVInfor__status__7C4F7684]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[CVInfor]  WITH CHECK ADD FOREIGN KEY([status])
REFERENCES [dbo].[Status] ([id])
GO
/****** Object:  ForeignKey [FK__TimeRoom__movieI__6477ECF3]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[TimeRoom]  WITH CHECK ADD FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
/****** Object:  ForeignKey [FK__TimeRoom__roomId__656C112C]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[TimeRoom]  WITH CHECK ADD FOREIGN KEY([roomId])
REFERENCES [dbo].[Room] ([roomId])
GO
/****** Object:  ForeignKey [FK__TimeRoom__timeId__66603565]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[TimeRoom]  WITH CHECK ADD FOREIGN KEY([timeId])
REFERENCES [dbo].[MovieTime] ([timeId])
GO
/****** Object:  ForeignKey [FK__Cart__username__6754599E]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
/****** Object:  ForeignKey [fk_feedback_movieId]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [fk_feedback_movieId] FOREIGN KEY([movieId])
REFERENCES [dbo].[Movie] ([movieId])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [fk_feedback_movieId]
GO
/****** Object:  ForeignKey [fk_feedback_username]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [fk_feedback_username] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [fk_feedback_username]
GO
/****** Object:  ForeignKey [FK__FastFoodC__cartI__6A30C649]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__FastFoodC__foodI__6B24EA82]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[FastFoodCart]  WITH CHECK ADD FOREIGN KEY([foodId])
REFERENCES [dbo].[Fastfood] ([foodId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__seatId__6C190EBB]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([seatId])
REFERENCES [dbo].[Seat] ([seatId])
GO
/****** Object:  ForeignKey [FK__SeatRoom__timeRo__6D0D32F4]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[SeatRoom]  WITH CHECK ADD FOREIGN KEY([timeRoomId])
REFERENCES [dbo].[TimeRoom] ([timeRoomId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__cartI__6E01572D]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([cartId])
REFERENCES [dbo].[Cart] ([cartId])
GO
/****** Object:  ForeignKey [FK__SeatRoomC__seatR__6EF57B66]    Script Date: 03/27/2022 21:53:57 ******/
ALTER TABLE [dbo].[SeatRoomCart]  WITH CHECK ADD FOREIGN KEY([seatRoomId])
REFERENCES [dbo].[SeatRoom] ([seatRoomId])
GO
