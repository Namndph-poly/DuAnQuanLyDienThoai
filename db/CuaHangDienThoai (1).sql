CREATE DATABASE [CuaHangDienThoai]
GO
USE [CuaHangDienThoai]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[ID] [int] NOT NULL identity(1,1),
	[IDSP] [int] NULL,
	[IDKM] [int] NULL,
	[IDImei] [int] NULL,
	[BoNho] [nchar](50) NULL,
	[Camera] [nchar](50) NULL,
	[ManHinh] [nchar](50) NULL,
	[MauSac] [nchar](50) NULL,
	[GiaNhap] [money] NULL,
	[GiaBan] [money] NULL,
	[MoTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_ChiTietSanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[ID] [int] NOT NULL identity(1,1),
	[Ten] [nvarchar](50) NULL,
 CONSTRAINT [pk_ChucVu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiamGia]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiamGia](
	[ID] [int] NOT NULL identity(1,1),
	[IDHinhThuc] [int] NULL,
	[MaKM] [nvarchar](50) NULL,
	[Ten] [nvarchar](50) NULL,
	[NgayBD] [date] NULL,
	[NgayKT] [date] NULL,
	[GiamGia] [money] NULL,
	[TrangThai] [Bit] NULL,
	[Mota] [nvarchar](50) NULL,
 CONSTRAINT [PK_GiamGia] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HangSanPham]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangSanPham](
	[ID] [int] NOT NULL identity(1,1),
	[MaHangSP] [nvarchar](50) NULL,
	[TenHangSP] [nvarchar](50) NULL,
 CONSTRAINT [PK_HangSanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucKhuyenMai]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucKhuyenMai](
	[Id] [int] NOT NULL identity(1,1),
	[TenHinhThucKm] [nvarchar](50) NULL,
 CONSTRAINT [PK_HinhThucKhuyenMai] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucThanhToan]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucThanhToan](
	[ID] [int] NOT NULL identity(1,1),
	[TenHTTT] [nvarchar](100) NULL,
 CONSTRAINT [PK_HinhThucThanhToan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID] [int] NOT NULL identity(1,1),
	[IDKhachHang] [int] NOT NULL,
	[IDUser] [int] NOT NULL,
	[IDHinhTTT] [int] NULL,
	[MaHD] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgayThanhToan] [date] NULL,
	[TongTien] [money] NULL,
	[TrangThai] [int] NULL,
	[Mota] [nvarchar](50) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[IDCTSP] [int] NOT NULL,
	[IDHoaDon] [int] NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [money] NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[IDCTSP] ASC,
	[IDHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Imei]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Imei](
	[Id] [int] NOT NULL identity(1,1),
	[MaImei] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	
 CONSTRAINT [PK_Imei] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ID] [int] NOT NULL identity(1,1),
	[MaKH] [nvarchar](50) NULL,
	[HoVaTen] [nvarchar](50) NULL,
	[SoDienThoai] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[ID] [int] NOT NULL identity(1,1),
	[IDHang] [int] NULL,
	[MaSP] [nvarchar](50) NULL,
	[TenSp] [nvarchar](100) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 2023-03-11 5:53:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[ID] [int] NOT NULL identity(1,1),
	[MaNV] [nvarchar](50) NULL,
	[HoVaTen] [nvarchar](100) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[GioiTinh] [bit] NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](100) NULL,
	[TaiKhoan] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[IDCV] [int] NOT NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IDImei])
REFERENCES [dbo].[Imei] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IDKM])
REFERENCES [dbo].[GiamGia] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IDSP])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[GiamGia]  WITH CHECK ADD FOREIGN KEY([IDHinhThuc])
REFERENCES [dbo].[HinhThucKhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IDHinhTTT])
REFERENCES [dbo].[HinhThucThanhToan] ([ID])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IDKhachHang])
REFERENCES [dbo].[KhachHang] ([ID])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IDUser])
REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IDCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IDHang])
REFERENCES [dbo].[HangSanPham] ([ID])
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD FOREIGN KEY([IDCV])
REFERENCES [dbo].[ChucVu] ([ID])
GO
--chuc vu
INSERT INTO ChucVu VALUES(N'quản lí')
INSERT INTO ChucVu VALUES(N'nhân viên')
--users
INSERT INTO Users VALUES ('NV01',N'Nguyễn Nam','2003-08-06',N'Hà Nội',0,'0967493115','namndph22694@gmail.com','1','1',1,0)
INSERT INTO Users VALUES ('NV02',N'Nguyễn Hiếu','2004-08-06',N'Hà Nam',0,'0967493115','hiundph22694@gmail.com','2','2',1,0)
INSERT INTO Users VALUES ('NV03',N'Nguyễn Thể','2005-08-06',N'Hà Nội',0,'0967493115','thendph22694@gmail.com','3','3',1,0)
INSERT INTO Users VALUES ('NV04',N'Nguyễn Phượng','2006-08-06',N'Hà Nội',0,'0967493115','phuongndph22694@gmail.com','3','3',2,0)
--hang
INSERT INTO HangSanPham VALUES('HANG01','OPPO')
INSERT INTO HangSanPham VALUES('HANG02','APPLE')
INSERT INTO HangSanPham VALUES('HANG03','SAMSUNG')
INSERT INTO HangSanPham VALUES('HANG04','NOKIA')
--san pham
--oppo
INSERT INTO SanPham VALUES(1,'SP01',N'Oppo A37')
INSERT INTO SanPham VALUES(1,'SP02',N'Oppo A53')
--iphone
INSERT INTO SanPham VALUES(2,'SP03',N'Iphone 5')
INSERT INTO SanPham VALUES(2,'SP04',N'Iphone 6')
INSERT INTO SanPham VALUES(2,'SP05',N'Iphone 6s')
INSERT INTO SanPham VALUES(2,'SP06',N'Iphone 6sPlus')
INSERT INTO SanPham VALUES(2,'SP07',N'Iphone 7')
INSERT INTO SanPham VALUES(2,'SP08',N'Iphone 7Plus')
INSERT INTO SanPham VALUES(2,'SP09',N'Iphone 8')
INSERT INTO SanPham VALUES(2,'SP10',N'Iphone 8Plus')
INSERT INTO SanPham VALUES(2,'SP11',N'Iphone X')
INSERT INTO SanPham VALUES(2,'SP12',N'Iphone Xs')
INSERT INTO SanPham VALUES(2,'SP13',N'Iphone XsMax')
--samsung
INSERT INTO SanPham VALUES(3,'SP14',N'Galaxy J7')
INSERT INTO SanPham VALUES(3,'SP15',N'Galaxy J7 Pro')
INSERT INTO SanPham VALUES(3,'SP16',N'Galaxy J5')
INSERT INTO SanPham VALUES(3,'SP17',N'Galaxy S12 Ultra')
--nokia
INSERT INTO SanPham VALUES(4,'SP18',N'Nokia 1280')
INSERT INTO SanPham VALUES(4,'SP19',N'Nokia C2')
INSERT INTO SanPham VALUES(4,'SP20',N'Nokia C3')

--hinh thuc khuyen mai
INSERT INTO HinhThucKhuyenMai VALUES(N'vnđ')
INSERT INTO HinhThucKhuyenMai VALUES(N'%')
--giam gia
INSERT INTO GiamGia VALUES(1,'KM01',N'Ngày lễ tình nhân Valentine','2023-03-15','2023-03-16',20000,0,N'Ưu đãi cực lớn')
INSERT INTO GiamGia VALUES(2,'KM02',N'Black Friday','2023-03-18','2023-03-19',10,0,N'Mua ngay kẻo hết')

--hinh thuc thanh toan
INSERT INTO HinhThucThanhToan VALUES(N'Tiền mặt')
INSERT INTO HinhThucThanhToan VALUES(N'Thẻ tín dụng')

--khach hang
INSERT INTO KhachHang VALUES('KH01',N'Lê Bảo','0967493115',0)
INSERT INTO KhachHang VALUES('KH02',N'Lê Lợi','0967493115',0)
INSERT INTO KhachHang VALUES('KH03',N'Sơn Tùng','0967493115',1)
INSERT INTO KhachHang VALUES('KH04',N'Jack 5m','0967493115',1)
INSERT INTO KhachHang VALUES('KH05',N'Trần Dần','0967493115',0)
--emei
INSERT INTO Imei VALUES ('350892608935051',N'đã bán')
INSERT INTO Imei VALUES ('350892608935052',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935053',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935054',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935055',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935056',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935057',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935058',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935059',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935012',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935013',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935014',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935015',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935017',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935019',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935030',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935031',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935089',N'còn hàng')
INSERT INTO Imei VALUES ('350892608935312',N'còn hàng')
INSERT INTO Imei VALUES ('350892608932311',N'còn hàng')

--hoadon
INSERT INTO HoaDon VALUES (1,1,1,'HD01','2023-03-16','2023-03-16',10000000,0,N'hoa don cho thanh toan')
INSERT INTO HoaDon VALUES (2,2,2,'HD02','2023-03-16','2023-03-16',50000000,0,N'hoa don cho thanh toan')
INSERT INTO HoaDon VALUES (3,3,2,'HD03','2023-03-16','2023-03-16',30000000,0,N'hoa don cho thanh toan')
INSERT INTO HoaDon VALUES (3,3,1,'HD04','2023-03-16','2023-03-16',20000000,0,N'hoa don cho thanh toan')
--sanpham chitiet
INSERT INTO ChiTietSanPham VALUES (1,1,1,'256GB','108MP','5,4',N'Đen',9000000,9000000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (2,1,2,'128GB','108MP','5,4',N'Đỏ',20000000,30000000,N'Rẻ ')
INSERT INTO ChiTietSanPham VALUES (3,1,3,'64GB','12MP','5,4',N'Vàng',5000000,6000000,N'Rẻ')
INSERT INTO ChiTietSanPham VALUES (4,1,4,'128GB','10MP','5,4',N'Vàng',6000000,7000000,N'Rẻ ')
INSERT INTO ChiTietSanPham VALUES (5,1,5,'256GB','108MP','5,4',N'Đen',7000000,8000000,N'Rẻ ')
INSERT INTO ChiTietSanPham VALUES (6,1,6,'128GB','10MP','5,4',N'Vàng',8000000,9000000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (7,1,7,'256GB','12MP','5,4',N'Đỏ',9000000,10000000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (8,1,8,'521GB','108MP','5,4',N'Đen',10000000,1100000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (9,1,9,'64GB','12MP','5,4',N'Vàng',1100000,1200000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (10,1,10,'521GB','12MP','5,4',N'Đỏ',1200000,1300000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (11,1,11,'256GB','108MP','5,4',N'Đen',1300000,1400000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (12,1,12,'521GB','12MP','5,4',N'Vàng',1400000,1500000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (13,1,13,'64GB','10MP','5,4',N'Đỏ',1500000,1600000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (14,1,14,'521GB','108MP','5,4',N'Đen',1600000,1700000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (15,1,15,'256GB','10MP','5,4',N'Vàng',1700000,1800000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (16,1,16,'521GB','12MP','5,4',N'Đen',1800000,1900000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (17,1,17,'64GB','108MP','5,4',N'Vàng',1900000,2000000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (18,1,18,'521GB','12MP','5,4',N'Đen',2000000,2100000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (19,1,19,'64GB','108MP','5,4',N'Đỏ',2100000,2200000,N'Rẻ như cho')
INSERT INTO ChiTietSanPham VALUES (20,1,20,'521GB','12MP','5,4',N'Đỏ',2200000,2300000,N'Rẻ như cho')
--hoadon chitiet
INSERT INTO HoaDonChiTiet VALUES (1,1,10,9000000)
INSERT INTO HoaDonChiTiet VALUES (2,2,5,30000000)
INSERT INTO HoaDonChiTiet VALUES (3,3,2,6000000)








