package Controler;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import model.KhachHang;

public class KhachHangController {
	private JButton btnAdd;
	private JTextField jtfMaKhachHang, jtfTenKhachHang, jtfDiaChi, jtfSoDienThoai;
	private JCheckBox jcbTinhTrang;

	public KhachHangController(JButton btnAdd, JTextField jtfMaKhachHang, JTextField jtfTenKhachHang,
			JTextField jtfDiaChi, JTextField jtfSoDienThoai, JCheckBox jcbTinhTrang) {
		super();
		this.btnAdd = btnAdd;
		this.jtfMaKhachHang = jtfMaKhachHang;
		this.jtfTenKhachHang = jtfTenKhachHang;
		this.jtfDiaChi = jtfDiaChi;
		this.jtfSoDienThoai = jtfSoDienThoai;
		this.jcbTinhTrang = jcbTinhTrang;
	}
	public void setView(KhachHang khachHang) {
		jtfMaKhachHang.setText("#"+khachHang.getMa_khach_hang());
		jtfTenKhachHang.setText(khachHang.getTen_khach_hang());
		jtfDiaChi.setText(khachHang.getDia_chi());
		jtfSoDienThoai.setText(khachHang.getSo_dien_thoai());
		jcbTinhTrang.setSelected(khachHang.isTrinh_trang());
		
	}
}
