package Controler;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import model.KhachHang;
import model.Sach;

public class GianHangController {
	private JButton btnAdd;
	private JTextField jtfMaSach, jtfTenSach, jtfTacGia, jtfGia,jtfSoLuong;
	private JCheckBox jcbTinhTrang;
	public GianHangController(JButton btnAdd, JTextField jtfMaSach, JTextField jtfTenSach, JTextField jtfTacGia,
			JTextField jtfGia, JTextField jtfSoLuong, JCheckBox jcbTinhTrang) {
		super();
		this.btnAdd = btnAdd;
		this.jtfMaSach = jtfMaSach;
		this.jtfTenSach = jtfTenSach;
		this.jtfTacGia = jtfTacGia;
		this.jtfGia = jtfGia;
		this.jtfSoLuong = jtfSoLuong;
		this.jcbTinhTrang = jcbTinhTrang;
	}
	public void setView(Sach sach) {
		jtfMaSach.setText("#"+sach.getMa_sach());
		jtfTenSach.setText(sach.getTen_sach());
		jtfTacGia.setText(sach.getTen_tac_gia());
		jtfGia.setText(sach.getGia());;
		jcbTinhTrang.setSelected(sach.isTinh_trang());
		jtfSoLuong.setText(sach.getSo_luong());
	}
}
