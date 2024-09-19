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
    diaChi VARCHAR(200),
    trangThai BIT NOT NULL
);

-- Tạo bảng ChuyenTau
CREATE TABLE ChuyenTau (
    maTau VARCHAR(50) PRIMARY KEY,
    gaDen VARCHAR(50) NOT NULL,
    ngayDi DATE NOT NULL,
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

-- Tạo bảng Toa
CREATE TABLE Toa (
    maToa VARCHAR(50) PRIMARY KEY,
    maTau VARCHAR(50) NOT NULL,
    loaiToa VARCHAR(100) NOT NULL,
    soLuongGhe INT NOT NULL,
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

-- Tạo bảng LoaiVe
CREATE TABLE LoaiVe (
    maLoai VARCHAR(50) PRIMARY KEY,
    hang VARCHAR(100),
    loai VARCHAR(100)
);

-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
    maKH VARCHAR(50) PRIMARY KEY,
    tenKH VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    sdt VARCHAR(15),
    cccd VARCHAR(12)
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
    maCa VARCHAR(50),
    cccd VARCHAR(12),
    email VARCHAR(100),
    sdt VARCHAR(15),
    trangThai BIT NOT NULL,
    chucVu VARCHAR(100),
    FOREIGN KEY (maCa) REFERENCES Ca(maCa)
);

-- Tạo bảng HoaDon (Tạo trước để tránh lỗi khóa ngoại)
CREATE TABLE HoaDon (
    maHoaDon VARCHAR(50) PRIMARY KEY,
    ngayLapHoaDon DATE NOT NULL,
    maNV VARCHAR(50) NOT NULL,
    maKH VARCHAR(50),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH)
);

-- Tạo bảng Ve
CREATE TABLE Ve (
    maVe VARCHAR(50) PRIMARY KEY,
    maTau VARCHAR(50) NOT NULL,
    maToa VARCHAR(50) NOT NULL,
    soGhe INT NOT NULL,
    maKH VARCHAR(50),
    ngayDi DATE NOT NULL,
    gaDen VARCHAR(50),
    trangThai BIT NOT NULL,
    maLoai VARCHAR(50) NOT NULL,
    FOREIGN KEY (maTau) REFERENCES ChuyenTau(maTau),
    FOREIGN KEY (maToa) REFERENCES Toa(maToa),
    FOREIGN KEY (soGhe, maToa) REFERENCES Ghe(soGhe, maToa),
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
    FOREIGN KEY (gaDen) REFERENCES Ga(maGa),
    FOREIGN KEY (maLoai) REFERENCES LoaiVe(maLoai)
);

-- Tạo bảng ChiTietHoaDon (tạo sau khi HoaDon đã được tạo)
CREATE TABLE ChiTietHoaDon (
    maChiTiet VARCHAR(50) PRIMARY KEY,
    maHoaDon VARCHAR(50) NOT NULL UNIQUE,
    soLuong INT NOT NULL,
    thue FLOAT NOT NULL,
    FOREIGN KEY (maHoaDon) REFERENCES HoaDon(maHoaDon)
);

-- Bảng trung gian giữa Ve và ChiTietHoaDon (n-1)
CREATE TABLE ChiTietHoaDon_Ve (
    maChiTiet VARCHAR(50),
    maVe VARCHAR(50),
    PRIMARY KEY (maChiTiet, maVe),
    FOREIGN KEY (maChiTiet) REFERENCES ChiTietHoaDon(maChiTiet),
    FOREIGN KEY (maVe) REFERENCES Ve(maVe)
);

-- Tạo bảng TaiKhoan
CREATE TABLE TaiKhoan (
    maDangNhap VARCHAR(50) PRIMARY KEY,
    matKhau VARCHAR(100) NOT NULL,
    phanQuyen INT NOT NULL,
    maNV VARCHAR(50) UNIQUE,
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);

-- Thêm dữ liệu vào bảng Ca (để tham chiếu cho nhân viên)
INSERT INTO Ca (maCa, tenCa, thoiGianBatDau, thoiGianKetThuc)
VALUES 
('CA01', 'Ca Sáng', '06:00:00', '14:00:00'),
('CA02', 'Ca Chiều', '14:00:00', '22:00:00'),
('CA03', 'Ca Đêm', '22:00:00', '06:00:00');

-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (maNV, tenNV, ngaySinh, gioiTinh, maCa, cccd, email, sdt, trangThai, chucVu)
VALUES 
('NV001', 'Nguyen Van A', '1985-01-15', 1, 'CA01', '123456789012', 'a.nguyen@example.com', '0912345678', 1, 'Nhân viên'),
('NV002', 'Tran Thi B', '1990-05-22', 0, 'CA02', '234567890123', 'b.tran@example.com', '0923456789', 1, 'Nhân viên'),
('NV003', 'Le Van C', '1982-08-30', 1, 'CA03', '345678901234', 'c.le@example.com', '0934567890', 1, 'Quản lý'),
('NV004', 'Hoang Thi D', '1995-03-12', 0, 'CA01', '456789012345', 'd.hoang@example.com', '0945678901', 1, 'Nhân viên'),
('NV005', 'Pham Van E', '1988-07-25', 1, 'CA02', '567890123456', 'e.pham@example.com', '0956789012', 1, 'Nhân viên');

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (maKH, tenKH, email, sdt, cccd)
VALUES 
('KH001', 'Nguyen Thi Hoa', 'hoa.nguyen@example.com', '0987654321', '111223344567'),
('KH002', 'Tran Van Minh', 'minh.tran@example.com', '0976543210', '222334455678'),
('KH003', 'Le Thi Mai', 'mai.le@example.com', '0965432109', '333445566789'),
('KH004', 'Hoang Van Trung', 'trung.hoang@example.com', '0954321098', '444556677890'),
('KH005', 'Pham Thi Thu', 'thu.pham@example.com', '0943210987', '555667788901');

-- Thêm dữ liệu vào bảng Ga
INSERT INTO Ga (maGa, tenGa, diaChi, trangThai)
VALUES 
('GA001', 'Ga A', 'Dia chi A', 1),
('GA002', 'Ga B', 'Dia chi B', 1),
('GA003', 'Ga C', 'Dia chi C', 1);

-- Thêm dữ liệu vào bảng ChuyenTau
INSERT INTO ChuyenTau (maTau, gaDen, ngayDi)
VALUES ('TA001', 'GA001', '2024-09-25');

-- Thêm dữ liệu vào bảng Toa
INSERT INTO Toa (maToa, maTau, loaiToa, soLuongGhe)
VALUES 
('TA001_VIP', 'TA001', 'VIP', 20),
('TA001_T01', 'TA001', 'Thường', 64),
('TA001_T02', 'TA001', 'Thường', 64),
('TA001_T03', 'TA001', 'Thường', 64);

-- Thêm dữ liệu vào bảng Ghe
-- Ghế cho toa VIP TA001_VIP
INSERT INTO Ghe (soGhe, maToa, trangThai)
VALUES 
(1, 'TA001_VIP', 1), (2, 'TA001_VIP', 1), (3, 'TA001_VIP', 1), (4, 'TA001_VIP', 1),
(5, 'TA001_VIP', 1), (6, 'TA001_VIP', 1), (7, 'TA001_VIP', 1), (8, 'TA001_VIP', 1),
(9, 'TA001_VIP', 1), (10, 'TA001_VIP', 1), (11, 'TA001_VIP', 1), (12, 'TA001_VIP', 1),
(13, 'TA001_VIP', 1), (14, 'TA001_VIP', 1), (15, 'TA001_VIP', 1), (16, 'TA001_VIP', 1),
(17, 'TA001_VIP', 1), (18, 'TA001_VIP', 1), (19, 'TA001_VIP', 1), (20, 'TA001_VIP', 1);

-- Ghế cho toa thường TA001_T01
INSERT INTO Ghe (soGhe, maToa, trangThai)
VALUES 
(1, 'TA001_T01', 1), (2, 'TA001_T01', 1), (3, 'TA001_T01', 1), (4, 'TA001_T01', 1),
(5, 'TA001_T01', 1), (6, 'TA001_T01', 1), (7, 'TA001_T01', 1), (8, 'TA001_T01', 1),
(9, 'TA001_T01', 1), (10, 'TA001_T01', 1), (11, 'TA001_T01', 1), (12, 'TA001_T01', 1),
(13, 'TA001_T01', 1), (14, 'TA001_T01', 1), (15, 'TA001_T01', 1), (16, 'TA001_T01', 1),
(17, 'TA001_T01', 1), (18, 'TA001_T01', 1), (19, 'TA001_T01', 1), (20, 'TA001_T01', 1),
(21, 'TA001_T01', 1), (22, 'TA001_T01', 1), (23, 'TA001_T01', 1), (24, 'TA001_T01', 1),
(25, 'TA001_T01', 1), (26, 'TA001_T01', 1), (27, 'TA001_T01', 1), (28, 'TA001_T01', 1),
(29, 'TA001_T01', 1), (30, 'TA001_T01', 1), (31, 'TA001_T01', 1), (32, 'TA001_T01', 1),
(33, 'TA001_T01', 1), (34, 'TA001_T01', 1), (35, 'TA001_T01', 1), (36, 'TA001_T01', 1),
(37, 'TA001_T01', 1), (38, 'TA001_T01', 1), (39, 'TA001_T01', 1), (40, 'TA001_T01', 1),
(41, 'TA001_T01', 1), (42, 'TA001_T01', 1), (43, 'TA001_T01', 1), (44, 'TA001_T01', 1),
(45, 'TA001_T01', 1), (46, 'TA001_T01', 1), (47, 'TA001_T01', 1), (48, 'TA001_T01', 1),
(49, 'TA001_T01', 1), (50, 'TA001_T01', 1), (51, 'TA001_T01', 1), (52, 'TA001_T01', 1),
(53, 'TA001_T01', 1), (54, 'TA001_T01', 1), (55, 'TA001_T01', 1), (56, 'TA001_T01', 1),
(57, 'TA001_T01', 1), (58, 'TA001_T01', 1), (59, 'TA001_T01', 1), (60, 'TA001_T01', 1),
(61, 'TA001_T01', 1), (62, 'TA001_T01', 1), (63, 'TA001_T01', 1), (64, 'TA001_T01', 1);

-- Ghế cho toa thường TA001_T02
INSERT INTO Ghe (soGhe, maToa, trangThai)
VALUES 
(1, 'TA001_T02', 1), (2, 'TA001_T02', 1), (3, 'TA001_T02', 1), (4, 'TA001_T02', 1),
(5, 'TA001_T02', 1), (6, 'TA001_T02', 1), (7, 'TA001_T02', 1), (8, 'TA001_T02', 1),
(9, 'TA001_T02', 1), (10, 'TA001_T02', 1), (11, 'TA001_T02', 1), (12, 'TA001_T02', 1),
(13, 'TA001_T02', 1), (14, 'TA001_T02', 1), (15, 'TA001_T02', 1), (16, 'TA001_T02', 1),
(17, 'TA001_T02', 1), (18, 'TA001_T02', 1), (19, 'TA001_T02', 1), (20, 'TA001_T02', 1),
(21, 'TA001_T02', 1), (22, 'TA001_T02', 1), (23, 'TA001_T02', 1), (24, 'TA001_T02', 1),
(25, 'TA001_T02', 1), (26, 'TA001_T02', 1), (27, 'TA001_T02', 1), (28, 'TA001_T02', 1),
(29, 'TA001_T02', 1), (30, 'TA001_T02', 1), (31, 'TA001_T02', 1), (32, 'TA001_T02', 1),
(33, 'TA001_T02', 1), (34, 'TA001_T02', 1), (35, 'TA001_T02', 1), (36, 'TA001_T02', 1),
(37, 'TA001_T02', 1), (38, 'TA001_T02', 1), (39, 'TA001_T02', 1), (40, 'TA001_T02', 1),
(41, 'TA001_T02', 1), (42, 'TA001_T02', 1), (43, 'TA001_T02', 1), (44, 'TA001_T02', 1),
(45, 'TA001_T02', 1), (46, 'TA001_T02', 1), (47, 'TA001_T02', 1), (48, 'TA001_T02', 1),
(49, 'TA001_T02', 1), (50, 'TA001_T02', 1), (51, 'TA001_T02', 1), (52, 'TA001_T02', 1),
(53, 'TA001_T02', 1), (54, 'TA001_T02', 1), (55, 'TA001_T02', 1), (56, 'TA001_T02', 1),
(57, 'TA001_T02', 1), (58, 'TA001_T02', 1), (59, 'TA001_T02', 1), (60, 'TA001_T02', 1),
(61, 'TA001_T02', 1), (62, 'TA001_T02', 1), (63, 'TA001_T02', 1), (64, 'TA001_T02', 1);

-- Ghế cho toa thường TA001_T03
INSERT INTO Ghe (soGhe, maToa, trangThai)
VALUES 
(1, 'TA001_T03', 1), (2, 'TA001_T03', 1), (3, 'TA001_T03', 1), (4, 'TA001_T03', 1),
(5, 'TA001_T03', 1), (6, 'TA001_T03', 1), (7, 'TA001_T03', 1), (8, 'TA001_T03', 1),
(9, 'TA001_T03', 1), (10, 'TA001_T03', 1), (11, 'TA001_T03', 1), (12, 'TA001_T03', 1),
(13, 'TA001_T03', 1), (14, 'TA001_T03', 1), (15, 'TA001_T03', 1), (16, 'TA001_T03', 1),
(17, 'TA001_T03', 1), (18, 'TA001_T03', 1), (19, 'TA001_T03', 1), (20, 'TA001_T03', 1),
(21, 'TA001_T03', 1), (22, 'TA001_T03', 1), (23, 'TA001_T03', 1), (24, 'TA001_T03', 1),
(25, 'TA001_T03', 1), (26, 'TA001_T03', 1), (27, 'TA001_T03', 1), (28, 'TA001_T03', 1),
(29, 'TA001_T03', 1), (30, 'TA001_T03', 1), (31, 'TA001_T03', 1), (32, 'TA001_T03', 1),
(33, 'TA001_T03', 1), (34, 'TA001_T03', 1), (35, 'TA001_T03', 1), (36, 'TA001_T03', 1),
(37, 'TA001_T03', 1), (38, 'TA001_T03', 1), (39, 'TA001_T03', 1), (40, 'TA001_T03', 1),
(41, 'TA001_T03', 1), (42, 'TA001_T03', 1), (43, 'TA001_T03', 1), (44, 'TA001_T03', 1),
(45, 'TA001_T03', 1), (46, 'TA001_T03', 1), (47, 'TA001_T03', 1), (48, 'TA001_T03', 1),
(49, 'TA001_T03', 1), (50, 'TA001_T03', 1), (51, 'TA001_T03', 1), (52, 'TA001_T03', 1),
(53, 'TA001_T03', 1), (54, 'TA001_T03', 1), (55, 'TA001_T03', 1), (56, 'TA001_T03', 1),
(57, 'TA001_T03', 1), (58, 'TA001_T03', 1), (59, 'TA001_T03', 1), (60, 'TA001_T03', 1),
(61, 'TA001_T03', 1), (62, 'TA001_T03', 1), (63, 'TA001_T03', 1), (64, 'TA001_T03', 1);

-- Thêm dữ liệu vào bảng liên kết ChuyenTau_Ga
INSERT INTO ChuyenTau_Ga (maTau, maGa)
VALUES 
('TA001', 'GA001'),
('TA001', 'GA002'),
('TA001', 'GA003');

-- Thêm 15 loại vé vào bảng LoaiVe
INSERT INTO LoaiVe (maLoai, hang, loai)
VALUES 
('LVGM_E1', 'Ghe mem', 'Tre em duoi 6 tuoi'),
('LVGM_E2', 'Ghe mem', 'Tre em 6 den 10 tuoi'),
('LVGM_NL', 'Ghe mem', 'Nguoi lon'),
('LVGM_LT', 'Ghe mem', 'Nguoi lon tuoi'),
('LVGM_SV', 'Ghe mem', 'Sinh vien'),

('LVGN_E1', 'Giuong nam', 'Tre em duoi 6 tuoi'),
('LVGN_E2', 'Giuong nam', 'Tre em 6 den 10 tuoi'),
('LVGN_NL', 'Giuong nam', 'Nguoi lon'),
('LVGN_LT', 'Giuong nam', 'Nguoi lon tuoi'),
('LVGN_SV', 'Giuong nam', 'Sinh vien'),

('LVVI_E1', 'VIP', 'Tre em duoi 6 tuoi'),
('LVVI_E2', 'VIP', 'Tre em 6 den 10 tuoi'),
('LVVI_NL', 'VIP', 'Nguoi lon'),
('LVVI_LT', 'VIP', 'Nguoi lon tuoi'),
('LVVI_SV', 'VIP', 'Sinh vien');

-- Thêm 5 tài khoản vào bảng TaiKhoan
INSERT INTO TaiKhoan (maDangNhap, matKhau, phanQuyen, maNV)
VALUES 
('user1', 'password1', 1, 'NV001'),
('user2', 'password2', 2, 'NV002'),
('user3', 'password3', 1, 'NV003'),
('user4', 'password4', 2, 'NV004'),
('user5', 'password5', 1, 'NV005');
