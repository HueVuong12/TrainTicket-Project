package entity;

import java.util.ArrayList;

public class ChiTietHoaDon {
	private String maChiTiet;
	private HoaDon hoaDon;
	private int soLuong;
	private ArrayList<Ve> dsVe;
	private float thue;
	
	public ChiTietHoaDon(String maChiTiet, HoaDon hoaDon, int soLuong, ArrayList<Ve> dsVe, float thue) {
		super();
		this.setMaChiTiet(maChiTiet);
		this.setHoaDon(hoaDon);
		this.setSoLuong(soLuong);
		this.setDsVe(dsVe);
		this.setThue(thue);
	}

	public String getMaChiTiet() {
		return maChiTiet;
	}

	public void setMaChiTiet(String maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ArrayList<Ve> getDsVe() {
		return dsVe;
	}

	public void setDsVe(ArrayList<Ve> dsVe) {
		this.dsVe = dsVe;
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue1) {
		thue = thue1;
	}
	
	@Override
	public String toString() {
		return "ChiTietHoaDon [maChiTiet=" + maChiTiet + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", dsVe="
				+ dsVe + ", thue=" + thue + "]";
	}

	public float tinhTien() {
		float tongTien = 0;
		for (Ve ve : dsVe) {
			tongTien += ve.tinhGiaVe();
		}
		return tongTien*(1 + thue);
	}
}
