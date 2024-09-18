package entity;

public class Ghe {
	private int soGhe;
	private Toa maToa;
	private boolean trangThai;
	
	public Ghe(int soGhe, Toa maToa, boolean trangThai) {
		super();
		this.soGhe = soGhe;
		this.maToa = maToa;
		this.trangThai = trangThai;
	}

	public Ghe(Toa maToa) {
		super();
		this.maToa = maToa;
	}

	public int getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}

	public Toa getMaToa() {
		return maToa;
	}

	public void setMaToa(Toa maToa) {
		this.maToa = maToa;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "Ghe [soGhe=" + soGhe + ", maToa=" + maToa + ", trangThai=" + trangThai + "]";
	}
	
}
