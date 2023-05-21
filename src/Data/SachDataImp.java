package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sach;


public class SachDataImp implements SachData {

	@Override
	public List<Sach> getList() {
		// TODO Auto-generated method stub
		try {
//			DBConnect dbconn = new DBConnect();
//			Connection cons = dbconn.connect();
			Connection cons = DBConnect.getConnection();
			String sql = "Select * from Sach";
			List<Sach> list = new ArrayList<>();
			PreparedStatement ps = cons.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sach sach = new Sach();
				sach.setMa_sach(rs.getInt("Book_id"));
				sach.setTen_sach(rs.getString("Name"));
				sach.setTen_tac_gia(rs.getString("TacGia"));
				sach.setGia(rs.getString("Price"));
				sach.setTinh_trang(rs.getBoolean("TinhTrang"));
				sach.setSo_luong(rs.getString("Amount"));
				list.add(sach);
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
		SachData sachData = new SachDataImp();
		System.out.println("ket noi data sach thanh cong "+sachData.getList());
	}
}
