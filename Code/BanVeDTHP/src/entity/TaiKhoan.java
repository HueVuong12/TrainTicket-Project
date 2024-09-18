package entity;

import java.util.Objects;

public class TaiKhoan {
	private String maDangNhap;
	private String matKhau;
	private int phanQuyen;
	
	public TaiKhoan(String maDangNhap, String matKhau, int phanQuyen) {
		super();
		this.maDangNhap = maDangNhap;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
	}

	public String getMaDangNhap() {
		return maDangNhap;
	}

	public void setMaDangNhap(String maDangNhap) {
		this.maDangNhap = maDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDangNhap, matKhau);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maDangNhap, other.maDangNhap) && Objects.equals(matKhau, other.matKhau);
	}

	@Override
	public String toString() {
		return "TaiKhoan [maDangNhap=" + maDangNhap + ", matKhau=" + matKhau + ", phanQuyen=" + phanQuyen + "]";
	}
	
}
