package entity;

import java.sql.Time;
import java.util.Objects;

public class Ca {
	private String maCa;
	private String tenCa;
	private Time thoiGianBatDau;
	private Time thoiGianKetThuc;
	
	public Ca(String maCa, String tenCa, Time thoiGianBatDau, Time thoiGianKetThuc) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public Ca(String maCa) {
		super();
		this.maCa = maCa;
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public String getTenCa() {
		return tenCa;
	}

	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}

	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Time getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Time thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ca other = (Ca) obj;
		return Objects.equals(maCa, other.maCa);
	}

	@Override
	public String toString() {
		return "Ca [maCa=" + maCa + ", tenCa=" + tenCa + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc="
				+ thoiGianKetThuc + "]";
	}
}
