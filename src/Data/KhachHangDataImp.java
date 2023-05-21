package Data;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang;

public class KhachHangDataImp implements KhachHangData {

	@Override
	public List<KhachHang> getList() {
		// TODO Auto-generated method stub
		try {
//			DBConnect dbconn = new DBConnect();
//			Connection cons = dbconn.connect();
			Connection cons = DBConnect.getConnection();
			String sql = "Select * from KhachHang";
			List<KhachHang> list = new ArrayList<>();
			PreparedStatement ps = cons.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhachHang khachHang = new KhachHang();
				khachHang.setMa_khach_hang(rs.getInt("User_id"));
				khachHang.setTen_khach_hang(rs.getString("Name"));
				khachHang.setDia_chi(rs.getString("Address"));
				khachHang.setSo_dien_thoai(rs.getString("Phone"));
				khachHang.setTrinh_trang(rs.getBoolean("Status"));
				list.add(khachHang);
			}
			ps.close();
			rs.close();
			cons.close();
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		KhachHangData khachhangData = new KhachHangDataImp();
		System.out.println("ket noi data khach hang thanh cong "+khachhangData.getList());
	}
}
