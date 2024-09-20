package entity;

import java.util.Objects;

public class Ga {
	private String maGa;
	private String tenGa;
	private String diaChi;
	private int chiSoKm;
	private boolean trangThai;

	public Ga(String maGa, String tenGa, String diaChi, int chiSoKm, boolean trangThai) {
		super();
		this.maGa = maGa;
		this.tenGa = tenGa;
		this.diaChi = diaChi;
		this.chiSoKm = chiSoKm;
		this.trangThai = trangThai;
	}

	public Ga(String maGa) {
		super();
		this.maGa = maGa;
	}

	public String getMaGa() {
		return maGa;
	}

	public void setMaGa(String maGa) {
		this.maGa = maGa;
	}

	public String getTenGa() {
		return tenGa;
	}

	public void setTenGa(String tenGa) {
		this.tenGa = tenGa;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getChiSoKm() {
		return chiSoKm;
	}

	public void setChiSoKm(int chiSoKm) {
		this.chiSoKm = chiSoKm;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maGa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ga other = (Ga) obj;
		return Objects.equals(maGa, other.maGa);
	}

	@Override
	public String toString() {
		return "Ga [maGa=" + maGa + ", tenGa=" + tenGa + ", diaChi=" + diaChi + ", chiSoKm=" + chiSoKm + ", trangThai="
				+ trangThai + "]";
	}
	
}
