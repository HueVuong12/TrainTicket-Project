package entity;

import java.sql.Date;
import java.util.Objects;

public class Ve {
	private String maVe;
	private ChuyenTau maChuyenTau;
	private Toa maToa;
	private Ghe maGhe;
	private KhachHang khachHang;
	private Date ngayDi;
	private Ga gaDen;
	private boolean trangThai;
	private LoaiVe loaiVe;
	
	public Ve(String maVe, ChuyenTau maChuyenTau, Toa maToa, Ghe maGhe, KhachHang khachHang, Date ngayDi, Ga gaDen,
			boolean trangThai, LoaiVe loaiVe) {
		super();
		this.maVe = maVe;
		this.maChuyenTau = maChuyenTau;
		this.maToa = maToa;
		this.maGhe = maGhe;
		this.khachHang = khachHang;
		this.ngayDi = ngayDi;
		this.gaDen = gaDen;
		this.trangThai = trangThai;
		this.loaiVe = loaiVe;
	}

	public Ve(String maVe) {
		super();
		this.maVe = maVe;
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public ChuyenTau getMaChuyenTau() {
		return maChuyenTau;
	}

	public void setMaChuyenTau(ChuyenTau maChuyenTau) {
		this.maChuyenTau = maChuyenTau;
	}

	public Toa getMaToa() {
		return maToa;
	}

	public void setMaToa(Toa maToa) {
		this.maToa = maToa;
	}

	public Ghe getMaGhe() {
		return maGhe;
	}

	public void setMaGhe(Ghe maGhe) {
		this.maGhe = maGhe;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public Ga getGaDen() {
		return gaDen;
	}

	public void setGaDen(Ga gaDen) {
		this.gaDen = gaDen;
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
		return "Ve [maVe=" + maVe + ", maChuyenTau=" + maChuyenTau + ", maToa=" + maToa + ", maGhe=" + maGhe
				+ ", khachHang=" + khachHang + ", ngayDi=" + ngayDi + ", gaDen=" + gaDen + ", trangThai=" + trangThai
				+ ", loaiVe=" + loaiVe + "]";
	}
	
	public float tinhGiaVe() {
		return 0;
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
