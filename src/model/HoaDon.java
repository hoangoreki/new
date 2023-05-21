package model;

import java.util.Date;

public class HoaDon {
	private int ma_hoa_don, ma_khach_hang, tongtien;
	private Date ngay_mua;

	

	public int getMa_hoa_don() {
		return ma_hoa_don;
	}

	public void setMa_hoa_don(int ma_hoa_don) {
		this.ma_hoa_don = ma_hoa_don;
	}

	public int getMa_khach_hang() {
		return ma_khach_hang;
	}

	public void setMa_khach_hang(int ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public Date getNgay_mua() {
		return ngay_mua;
	}

	public void setNgay_mua(Date ngay_mua) {
		this.ngay_mua = ngay_mua;
	}

}
