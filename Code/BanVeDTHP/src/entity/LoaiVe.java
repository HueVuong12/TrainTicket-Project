package entity;

import java.util.Objects;

public class LoaiVe {
	private String maLoai;
	private String hang;
	private String loai;
	
	public LoaiVe(String maLoai, String hang, String loai) {
		super();
		this.setMaLoai(maLoai);
		this.setHang(hang);
		this.setLoai(loai);
	}

	public LoaiVe(String maLoai) {
		super();
		this.maLoai = maLoai;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		String ktMaLoai = "^(LVGME[12]|LVGMNL|LVGMCT|LVGMSV|LVGNE[12]|LVGNNL|LVGNCT|LVGNSV|LVVIE[12]|LVVINL|LVVICT|LVVISV)$";
		if (maLoai.matches(ktMaLoai))
			this.maLoai = maLoai;
		else
			throw new IllegalArgumentException("Mã vé không tồn tại!");
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		String ktHang = "^(ghế mềm|giường nằm|VIP)$";
		if (hang.matches(ktHang))
			this.hang = hang;
		else
			throw new IllegalArgumentException("Hạng không tồn tại!");
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		String ktLoai = "^(Trẻ em dưới 6 tuổi|trẻ em 6 đến 10 tuổi|người lớn|người cao tuổi|sinh viên)$";
		if (loai.matches(ktLoai))
			this.loai = loai;
		else
			throw new IllegalArgumentException("Loại không tồn tại!");
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
