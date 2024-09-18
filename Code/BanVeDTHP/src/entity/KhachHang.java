package entity;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String email;
	private String sdt;
	private String cccd;
	
	public KhachHang(String maKH, String tenKH, String email, String sdt, String cccd) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.email = email;
		this.sdt = sdt;
		this.cccd = cccd;
	}
	
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
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

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", email=" + email + ", sdt=" + sdt + ", cccd=" + cccd
				+ "]";
	}
}
