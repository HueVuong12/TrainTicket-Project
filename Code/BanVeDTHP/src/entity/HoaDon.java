package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private LocalDateTime ngayLapHoaDon;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private ChiTietHoaDon maChiTiet;
	
	public HoaDon(String maHoaDon, LocalDateTime ngayLapHoaDon, NhanVien nhanVien, KhachHang khachHang,
			ChiTietHoaDon maChiTiet) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.maChiTiet = maChiTiet;
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDateTime getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDateTime ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public ChiTietHoaDon getMaChiTiet() {
		return maChiTiet;
	}

	public void setMaChiTiet(ChiTietHoaDon maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + "]";
	}
	
	public float getTongTien() {
		return this.maChiTiet.tinhTien();
	}
}
