-- Tạo database DTHP
CREATE DATABASE DTHP;
GO

-- Sử dụng database DTHP
USE DTHP;
GO

-- Tạo bảng Ga
CREATE TABLE Ga (
    maGa VARCHAR(50) PRIMARY KEY,
    tenGa VARCHAR(100) NOT NULL,
    diaChi VARCHAR(200) NOT NULL,
    chiSoKm INT NOT NULL,
    trangThai BIT NOT NULL
);

-- Tạo bảng ChuyenTau
CREATE TABLE ChuyenTau (
    maTau VARCHAR(50) PRIMARY KEY,
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
    loaiToa VARCHAR(50) NOT NULL,
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
    tenCa VARCHAR(100) NOT NULL,
    thoiGianBatDau TIME NOT NULL,
    thoiGianKetThuc TIME NOT NULL
);

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    maNV VARCHAR(50) PRIMARY KEY,
    tenNV VARCHAR(100) NOT NULL,
    ngaySinh DATE,
    gioiTinh BIT,
	ca VARCHAR(50) NOT NULL,
	cccd VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    sdt VARCHAR(20),
    trangThai BIT,
    chucVu VARCHAR(100) NOT NULL,
	FOREIGN KEY (ca) REFERENCES Ca(maCa)
);

-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
    maKH VARCHAR(50) PRIMARY KEY,
    tenKH VARCHAR(100) NOT NULL,
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

-- Tạo bảng LoaiVe
CREATE TABLE LoaiVe (
    maLoai VARCHAR(50) PRIMARY KEY,
    hang VARCHAR(100),
    loai VARCHAR(100)
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
    gaDen VARCHAR(50) NOT NULL,
    trangThai BIT,
    loaiVe VARCHAR(50) NOT NULL,
	chiTiet VARCHAR(50) NOT NULL,
    FOREIGN KEY (tau) REFERENCES ChuyenTau(maTau),
    FOREIGN KEY (toa) REFERENCES Toa(maToa),
    FOREIGN KEY (soGhe, toa) REFERENCES Ghe(soGhe, maToa),
    FOREIGN KEY (khachHang) REFERENCES KhachHang(maKH),
    FOREIGN KEY (loaiVe) REFERENCES LoaiVe(maLoai),
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