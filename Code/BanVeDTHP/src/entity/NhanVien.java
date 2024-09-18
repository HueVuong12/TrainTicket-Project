package entity;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private Date ngaySinh;
	private boolean gioiTinh;
	private Ca maCa;
	private String cccd;
	private String email;
	private String sdt;
	private boolean trangThai;
	private String chucVu;
	
	public NhanVien(String maNV, String tenNV, Date ngaySinh, boolean gioiTinh, Ca maCa, String cccd, String email,
			String sdt, boolean trangThai, String chucVu) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.maCa = maCa;
		this.cccd = cccd;
		this.email = email;
		this.sdt = sdt;
		this.trangThai = trangThai;
		this.chucVu = chucVu;
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Ca getMaCa() {
		return maCa;
	}

	public void setMaCa(Ca maCa) {
		this.maCa = maCa;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", maCa=" + maCa + ", cccd=" + cccd + ", email=" + email + ", sdt=" + sdt + ", trangThai=" + trangThai
				+ ", chucVu=" + chucVu + "]";
	}
	
}
