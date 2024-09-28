package entity;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private LocalDate ngaySinh;
	private boolean gioiTinh;
	private Ca ca;
	private String cccd;
	private String email;
	private String sdt;
	private boolean trangThai;
	private String chucVu;
	
	public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, boolean gioiTinh, Ca maCa, String cccd, String email,
			String sdt, boolean trangThai, String chucVu) {
		super();
		this.setMaNV(maNV);
		this.setTenNV(tenNV);
		this.setNgaySinh(ngaySinh);
		this.setGioiTinh(gioiTinh);
		this.setCa(maCa);
		this.setCccd(cccd);
		this.setEmail(email);
		this.setSdt(sdt);
		this.setTrangThai(trangThai);
		this.setChucVu(chucVu);
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

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Ca getCa() {
		return ca;
	}

	public void setCa(Ca maCa) {
		this.ca = maCa;
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
				+ ", ca=" + ca + ", cccd=" + cccd + ", email=" + email + ", sdt=" + sdt + ", trangThai=" + trangThai
				+ ", chucVu=" + chucVu + "]";
	}
	
}
