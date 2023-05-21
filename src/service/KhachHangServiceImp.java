package service;

import java.util.List;

import Data.KhachHangData;
import Data.KhachHangDataImp;
import model.KhachHang;

public class KhachHangServiceImp implements KhachHangService {
	private KhachHangData khachHangData =null;
	public KhachHangServiceImp() {
		khachHangData = new KhachHangDataImp();
	}
	@Override
	public List<KhachHang> getList() {
		// TODO Auto-generated method stub
		return khachHangData.getList();
	}

}
