package entity;

import java.util.Objects;

public class LoaiVe {
	private String maLoai;
	private String hang;
	private String loai;
	
	public LoaiVe(String maLoai, String hang, String loai) {
		super();
		this.maLoai = maLoai;
		this.hang = hang;
		this.loai = loai;
	}

	public LoaiVe(String maLoai) {
		super();
		this.maLoai = maLoai;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiVe other = (LoaiVe) obj;
		return Objects.equals(maLoai, other.maLoai);
	}

	@Override
	public String toString() {
		return "LoaiVe [maLoai=" + maLoai + ", hang=" + hang + ", loai=" + loai + "]";
	}
	
	public float tinhTiGia() {
		float tiGia = 0;
		if (hang.equalsIgnoreCase("Ghe mem"))
			tiGia += 1;
		else if (hang.equalsIgnoreCase("Giuong nam"))
			tiGia += 1.2;
		else
			tiGia += 1.8;
		if (loai.equalsIgnoreCase("Sinh vien"))
			tiGia += -0.1;
		else if (loai.equalsIgnoreCase("Nguoi lon"))
			tiGia += 0;
		else if (loai.equalsIgnoreCase("Nguoi lon tuoi"))
			tiGia += -0.15;
		else if (loai.equalsIgnoreCase("Tre em 6 den 10 tuoi"))
			tiGia += -0.25;
		else tiGia = 0;
		return tiGia;
	}
}
