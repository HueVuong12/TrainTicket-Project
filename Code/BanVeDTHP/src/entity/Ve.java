package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Ve {
	private String maVe;
	private ChuyenTau chuyenTau;
	private Toa toa;
	private Ghe soGhe;
	private KhachHang khachHang;
	private LocalDate ngayDi;
	private LocalTime gioDi;
	private Ga gaDen;
	private boolean trangThai;
	private LoaiVe loaiVe;
	private ChiTietHoaDon chiTiet;
	
	public Ve(String maVe, ChuyenTau chuyenTau, Toa toa, Ghe soGhe, KhachHang khachHang, LocalDate ngayDi, LocalTime gioDi,
			Ga gaDen, boolean trangThai, LoaiVe loaiVe, ChiTietHoaDon chiTiet) {
		super();
		this.setMaVe(maVe);
		this.setChuyenTau(chuyenTau);
		this.setToa(toa);
		this.setSoGhe(soGhe);
		this.setKhachHang(khachHang);
		this.ngayDi = chuyenTau.getNgayDi();
		this.gioDi = chuyenTau.getGioDi();
		this.setGaDen(gaDen);
		this.setTrangThai(trangThai);
		this.setLoaiVe(loaiVe);
		this.setChiTiet(chiTiet);
	}

	public Ve(String maVe) {
		super();
		this.maVe = maVe;
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		String ktMaVe = "^VE\\d{2}\\d{2}\\d{2}\\d{4}$";
		if (maVe.matches(ktMaVe))
			this.maVe = maVe;
		else
			throw new IllegalArgumentException("Mã vé không hợp lệ! Mã vé có dạng VE + 6 số chỉ ngày tháng năm + 4 số chỉ số thứ tự ");
	}

	public ChuyenTau getChuyenTau() {
		return chuyenTau;
	}

	public void setChuyenTau(ChuyenTau chuyenTau) {
		this.chuyenTau = chuyenTau;
		//Kiểm tra tồn tại
	}

	public Toa getToa() {
		return toa;
	}

	public void setToa(Toa toa) {
		this.toa = toa;
		//Kiểm tra tồn tại
	}

	public Ghe getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(Ghe soGhe) {
		this.soGhe = soGhe;
		//Kiểm tra tồn tại
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
		//Kiểm tra tồn tại
}

	public LocalDate getNgayDi() {
		return ngayDi;
	}

	public LocalTime getGioDi() {
		return gioDi;
	}

	public Ga getGaDen() {
		return gaDen;
	}

	public void setGaDen(Ga gaDen) {
		this.gaDen = gaDen;
		//Kiểm tra tồn tại
}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public LoaiVe getLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(LoaiVe loaiVe) {
		this.loaiVe = loaiVe;
		//Kiểm tra tồn tại
	}

	public ChiTietHoaDon getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(ChiTietHoaDon chiTiet) {
		this.chiTiet = chiTiet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maVe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ve other = (Ve) obj;
		return Objects.equals(maVe, other.maVe);
	}
	
	@Override
	public String toString() {
		return "Ve [maVe=" + maVe + ", chuyenTau=" + chuyenTau + ", toa=" + toa + ", soGhe=" + soGhe + ", khachHang="
				+ khachHang + ", ngayDi=" + ngayDi + ", gioDi=" + gioDi + ", gaDen=" + gaDen + ", trangThai="
				+ trangThai + ", loaiVe=" + loaiVe + "]";
	}

	public float tinhGiaVe() {
		int quangDuong = Math.abs(gaDen.getChiSoKm()-836);
		
		if (quangDuong <= 50)
			return quangDuong*2000*loaiVe.tinhTiGia();
		else if (quangDuong <= 400)
			return quangDuong*800*loaiVe.tinhTiGia();
		return quangDuong*600*loaiVe.tinhTiGia();
	}
	
	public boolean xuatVe() {
		LocalDate ngayHienTai = LocalDate.now();
		LocalTime gioHienTai = LocalTime.now();
		
		if (ngayHienTai.isBefore(ngayDi) && gioHienTai.isBefore(gioDi)) {
			setTrangThai(false);
			return true;
		}
		return false;
	}
	
	public boolean datVe() {
		if (gaDen.isTrangThai())
			return true;
		return false;
	}
	
	public boolean doiVe() {
	    LocalDateTime now = LocalDateTime.now();
	    LocalDateTime thoiGianDi = LocalDateTime.of(ngayDi, gioDi);
	    
	    if (now.isBefore(thoiGianDi.minusHours(24))) {
	        setTrangThai(false);
	        return true;
	    }
	    return false;
	}
	
	public boolean hoanVe(Boolean isTapThe) {
	    LocalDateTime now = LocalDateTime.now();
	    LocalDateTime thoiGianDi = LocalDateTime.of(ngayDi, gioDi);
	    
	    if (isTapThe) {
	    	if (now.isBefore(thoiGianDi.minusHours(72)))
	    		return true;
	    } else {
	    	if (now.isBefore(thoiGianDi.minusHours(24)))
	    		return true;
	    }
	    return false;
	}
}
