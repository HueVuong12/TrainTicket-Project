package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Toa {
	private String maToa;
	private String loaiToa;
	private ArrayList<Ghe> dsGhe;
	
	public Toa(String maToa, String loaiToa, ArrayList<Ghe> dsGhe) {
		super();
		this.maToa = maToa;
		this.loaiToa = loaiToa;
		this.dsGhe = dsGhe;
	}

	public Toa(String maToa) {
		super();
		this.maToa = maToa;
	}

	public String getMaToa() {
		return maToa;
	}

	public void setMaToa(String maToa) {
		this.maToa = maToa;
	}

	public String getLoaiToa() {
		return loaiToa;
	}

	public void setLoaiToa(String loaiToa) {
		this.loaiToa = loaiToa;
	}

	public ArrayList<Ghe> getDsGhe() {
		return dsGhe;
	}

	public void setDsGhe(ArrayList<Ghe> dsGhe) {
		this.dsGhe = dsGhe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maToa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toa other = (Toa) obj;
		return Objects.equals(maToa, other.maToa);
	}

	@Override
	public String toString() {
		return "Toa [maToa=" + maToa + ", loaiToa=" + loaiToa + ", dsGhe=" + dsGhe + "]";
	}
}
