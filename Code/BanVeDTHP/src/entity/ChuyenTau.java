package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class ChuyenTau {
	private String maTau;
	private String gaDen;
	private ArrayList<Ga> tramDung;
	private Date ngayDi;
	private ArrayList<Toa> dsToa;
	
	public ChuyenTau(String maTau, String gaDen, ArrayList<Ga> tramDung, Date ngayDi, ArrayList<Toa> dsToa) {
		super();
		this.maTau = maTau;
		this.gaDen = gaDen;
		this.tramDung = tramDung;
		this.ngayDi = ngayDi;
		this.dsToa = dsToa;
	}

	public ChuyenTau(String maTau) {
		super();
		this.maTau = maTau;
	}

	public String getMaTau() {
		return maTau;
	}

	public void setMaTau(String maTau) {
		this.maTau = maTau;
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
	}

	public ArrayList<Ga> getTramDung() {
		return tramDung;
	}

	public void setTramDung(ArrayList<Ga> tramDung) {
		this.tramDung = tramDung;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public ArrayList<Toa> getDsToa() {
		return dsToa;
	}

	public void setDsToa(ArrayList<Toa> dsToa) {
		this.dsToa = dsToa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTau);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenTau other = (ChuyenTau) obj;
		return Objects.equals(maTau, other.maTau);
	}

	@Override
	public String toString() {
		return "ChuyenTau [maTau=" + maTau + ", gaDen=" + gaDen + ", tramDung=" + tramDung + ", ngayDi=" + ngayDi
				+ ", dsToa=" + dsToa + "]";
	}
	
	
}
