-- Tạo database DTHP
CREATE DATABASE DTHP
COLLATE Vietnamese_CI_AS;
GO

-- Sử dụng database DTHP
USE DTHP;
GO

-- Tạo bảng Ga
CREATE TABLE Ga (
    maGa VARCHAR(50) PRIMARY KEY,
    tenGa NVARCHAR(100) NOT NULL,
    diaChi NVARCHAR(200) NOT NULL,
    chiSoKm INT NOT NULL,
    trangThai BIT NOT NULL
);

-- Tạo bảng ChuyenTau
CREATE TABLE ChuyenTau (
    maTau VARCHAR(50) PRIMARY KEY,
	gaDi VARCHAR(50) NOT NULL,
    gaDen VARCHAR(50) NOT NULL,
    ngayDi DATE NOT NULL,
    gioDi TIME NOT NULL,
    FOREIGN KEY (gaDen) REFERENCES Ga(maGa)
);

-- Bảng trung gian giữa Ga và ChuyenTau (n-n)
CREATE TABLE ChuyenTau_Ga (
    maTau VARCHAR(50),
    maGa VARCHAR(50),
    PRIMARY KEY (maTau, maGa),
    FOREIGN KEY (maTau) REFERENCES ChuyenTau(maTau),
    FOREIGN KEY (maGa) REFERENCES Ga(maGa)
);

CREATE TABLE Toa (
    maToa VARCHAR(50) PRIMARY KEY,
    loaiToa NVARCHAR(50) NOT NULL,
    maTau VARCHAR(50) NOT NULL,
    FOREIGN KEY (maTau) REFERENCES ChuyenTau(maTau)
);

-- Tạo bảng Ghe
CREATE TABLE Ghe (
    soGhe INT NOT NULL,
    maToa VARCHAR(50) NOT NULL,
    trangThai BIT NOT NULL,
    PRIMARY KEY (soGhe, maToa),
    FOREIGN KEY (maToa) REFERENCES Toa(maToa)
);

-- Tạo bảng Ca
CREATE TABLE Ca (
    maCa VARCHAR(50) PRIMARY KEY,
    tenCa NVARCHAR(100) NOT NULL,
    thoiGianBatDau TIME NOT NULL,
    thoiGianKetThuc TIME NOT NULL
);

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    maNV VARCHAR(50) PRIMARY KEY,
    tenNV NVARCHAR(100) NOT NULL,
    ngaySinh DATE,
    gioiTinh BIT,
	ca VARCHAR(50) NOT NULL,
	cccd VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    sdt VARCHAR(20),
    trangThai BIT,
    chucVu INT NOT NULL,
	FOREIGN KEY (ca) REFERENCES Ca(maCa)
);

-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
    maKH VARCHAR(50) PRIMARY KEY,
    tenKH NVARCHAR(100) NOT NULL,
    email VARCHAR(100),
    sdt VARCHAR(20) NOT NULL,
    cccd VARCHAR(20)
);

-- Tạo bảng HoaDon
CREATE TABLE HoaDon (
    maHoaDon VARCHAR(50) PRIMARY KEY,
    ngayLapHoaDon DATETIME NOT NULL,
    nhanVien VARCHAR(50) NOT NULL,
    khachHang VARCHAR(50) NOT NULL,
    daHoanVe BIT NOT NULL,
	daHoanTien BIT NOT NULL,
    FOREIGN KEY (nhanVien) REFERENCES NhanVien(maNV),
    FOREIGN KEY (khachHang) REFERENCES KhachHang(maKH)
);

-- Tạo bảng ChiTietHoaDon
CREATE TABLE ChiTietHoaDon (
    maChiTiet VARCHAR(50) PRIMARY KEY,
    hoaDon VARCHAR(50) NOT NULL,
    soLuong INT NOT NULL,
    thue FLOAT,
    FOREIGN KEY (hoaDon) REFERENCES HoaDon(maHoaDon)
);

-- Tạo bảng Ve
CREATE TABLE Ve (
    maVe VARCHAR(50) PRIMARY KEY,
    tau VARCHAR(50) NOT NULL,
    toa VARCHAR(50) NOT NULL,
    soGhe INT NOT NULL,
    khachHang VARCHAR(50) NOT NULL,
    ngayDi DATE NOT NULL,
    gioDi TIME NOT NULL,
	gaDi VARCHAR(50) NOT NULL,
    gaDen VARCHAR(50) NOT NULL,
	hang VARCHAR(100) NOT NULL,
	khuyenMai VARCHAR(100) NOT NULL,
    trangThai BIT,
	chiTiet VARCHAR(50) NOT NULL,
    FOREIGN KEY (tau) REFERENCES ChuyenTau(maTau),
    FOREIGN KEY (toa) REFERENCES Toa(maToa),
    FOREIGN KEY (soGhe, toa) REFERENCES Ghe(soGhe, maToa),
    FOREIGN KEY (khachHang) REFERENCES KhachHang(maKH),
    FOREIGN KEY (gaDen) REFERENCES Ga(maGa),
	FOREIGN KEY (chiTiet) REFERENCES ChiTietHoaDon(maChiTiet)
);

-- Tạo bảng TaiKhoan
CREATE TABLE TaiKhoan (
    maTaiKhoan VARCHAR(50) PRIMARY KEY,
    matKhau VARCHAR(50) NOT NULL,
    phanQuyen INT NOT NULL,
    nhanVien VARCHAR(50),
    FOREIGN KEY (nhanVien) REFERENCES NhanVien(maNV)
);

-- Thêm 3 ca vào bảng Ca
INSERT INTO Ca (maCa, tenCa, thoiGianBatDau, thoiGianKetThuc) VALUES
('CA01', N'Ca 1', '06:00:00', '13:59:00'),
('CA02', N'Ca 2', '14:00:00', '21:59:00'),
('CA03', N'Ca 3', '22:00:00', '05:59:00');

-- Thêm 3 nhân viên vào bảng NhanVien
INSERT INTO NhanVien (maNV, tenNV, ngaySinh, gioiTinh, ca, cccd, email, sdt, trangThai, chucVu) VALUES
('NV001', N'Lê Tấn Phong', '2004-03-30', 0, 'CA01', '049204013502', 'letanphong400@gmail.com', '0919128639', 1, 1),
('NV002', N'Vương Ngọc Huệ', '2003-08-12', 1, 'CA02', '049203000000', 'ngochue12@gmail.com', '0987654321', 0, 2);

-- Thêm 2 tài khoản vào bảng TaiKhoan
INSERT INTO TaiKhoan (maTaiKhoan, matKhau, phanQuyen, nhanVien) VALUES
('TKQL001', 'password1', 1, 'NV001'), 
('TKNV001', 'password2', 2, 'NV002');

