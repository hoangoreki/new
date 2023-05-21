package ublity;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Data.KhachHangData;
import model.KhachHang;
import model.Sach;

public class ClassTableModel {
	public DefaultTableModel setTableKhachHang(List<KhachHang> listItem, String[] listColumn) {
		DefaultTableModel dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		dtm.setColumnIdentifiers(listColumn);
		int columns = listColumn.length;
		Object[] obj = null;
		int rows = listItem.size();
		if (rows > 0) {
			for (int i = 0; i < rows; i++) {
				KhachHang khachHang = listItem.get(i);
				obj = new Object[columns];
				obj[0] = khachHang.getMa_khach_hang();
				obj[1]=(i+1);
				obj[2]=khachHang.getTen_khach_hang();
				obj[3]=khachHang.getDia_chi();
				obj[4]=khachHang.getSo_dien_thoai();
				obj[5]=khachHang.isTrinh_trang();
				dtm.addRow(obj);
			}
		}
		return dtm;

	}
	public DefaultTableModel setTableSach(List<Sach> listItem, String[] listColumn) {
		DefaultTableModel dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		dtm.setColumnIdentifiers(listColumn);
		int columns = listColumn.length;
		Object[] obj = null;
		int rows = listItem.size();
		if (rows > 0) {
			for (int i = 0; i < rows; i++) {
				Sach sach = listItem.get(i);
				obj = new Object[columns];
				obj[0] = sach.getMa_sach();
				obj[1]=(i+1);
				obj[2]=sach.getTen_sach();
				obj[3]=sach.getTen_tac_gia();
				obj[4]=sach.getGia();
				obj[5]=sach.isTinh_trang();
				obj[6]=sach.getSo_luong();
				dtm.addRow(obj);
			}
		}
		return dtm;

	}
}
