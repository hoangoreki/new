package model;

public class Sach {
	private int ma_sach;
	private String ten_sach, ten_tac_gia, gia, so_luong;
	private boolean tinh_trang;

	

	public int getMa_sach() {
		return ma_sach;
	}

	public void setMa_sach(int ma_sach) {
		this.ma_sach = ma_sach;
	}

	
	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(String so_luong) {
		this.so_luong = so_luong;
	}

	public String getTen_sach() {
		return ten_sach;
	}

	public void setTen_sach(String ten_sach) {
		this.ten_sach = ten_sach;
	}

	public String getTen_tac_gia() {
		return ten_tac_gia;
	}

	public void setTen_tac_gia(String ten_tac_gia) {
		this.ten_tac_gia = ten_tac_gia;
	}

	public boolean isTinh_trang() {
		return tinh_trang;
	}

	public void setTinh_trang(boolean tinh_trang) {
		this.tinh_trang = tinh_trang;
	}

	
}
