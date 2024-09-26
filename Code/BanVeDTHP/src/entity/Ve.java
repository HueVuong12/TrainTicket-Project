package entity;

import java.time.LocalDate;
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
	
	public Ve(String maVe, ChuyenTau chuyenTau, Toa toa, Ghe soGhe, KhachHang khachHang, LocalDate ngayDi, LocalTime gioDi,
			Ga gaDen, boolean trangThai, LoaiVe loaiVe) {
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
		return Math.abs(gaDen.getChiSoKm()-836)*loaiVe.tinhTiGia();
	}
	
	public boolean xuatVe() {
		return true;
	}
	
	public boolean datVe() {
		return true;
	}
	
	public boolean doiVe() {
		return true;
	}
	
	public boolean hoanVe() {
		return true;
	}
}
