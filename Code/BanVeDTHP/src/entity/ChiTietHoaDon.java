package entity;

import java.util.ArrayList;

public class ChiTietHoaDon {
	private String maChiTiet;
	private HoaDon maHoaDon;
	private int soLuong;
	private ArrayList<Ve> dsVe;
	private float thue;
	
	public ChiTietHoaDon(String maChiTiet, HoaDon maHoaDon, int soLuong, ArrayList<Ve> dsVe, float thue) {
		super();
		this.maChiTiet = maChiTiet;
		this.maHoaDon = maHoaDon;
		this.soLuong = soLuong;
		this.dsVe = dsVe;
		this.thue = thue;
	}

	public String getMaChiTiet() {
		return maChiTiet;
	}

	public void setMaChiTiet(String maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
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
		return "ChiTietHoaDon [maChiTiet=" + maChiTiet + ", maHoaDon=" + maHoaDon + ", soLuong=" + soLuong + ", dsVe="
				+ dsVe + ", Thue=" + thue + "]";
	}
	
	public float tinhTien() {
		float tongTien = 0;
		for (Ve ve : dsVe) {
			tongTien += ve.tinhGiaVe();
		}
		return tongTien*(1 + thue);
	}
}
