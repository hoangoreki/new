package KhachHangPanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import Controler.KhachHangController;
import Data.DBConnect;
import model.KhachHang;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class KhachHangJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField jtfMaKhachHang;
	private JTextField jtfTenKhachHang;
	private JTextField jtfSoDienThoai;
	private JTextField jtfDiaChi;
	private JCheckBox jcbTinhTrang;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					KhachHangJFrame frame = new KhachHangJFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public KhachHangJFrame(KhachHang khachHang) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kt = jtfMaKhachHang.getText();
				if(kt.equalsIgnoreCase("#0")) {
				insert();
				}else {
					update();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(687, 10, 105, 37);
		contentPane.add(btnAdd);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane_1.setBounds(0, 56, 802, 362);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("Mã Khách Hàng: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 22, 111, 32);
		contentPane_1.add(lblNewLabel);
		
		jtfMaKhachHang = new JTextField();
		jtfMaKhachHang.setBounds(131, 24, 189, 32);
		contentPane_1.add(jtfMaKhachHang);
		jtfMaKhachHang.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng: ");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTnKhchHng.setBounds(10, 104, 111, 32);
		contentPane_1.add(lblTnKhchHng);
		
		jtfTenKhachHang = new JTextField();
		jtfTenKhachHang.setColumns(10);
		jtfTenKhachHang.setBounds(131, 106, 189, 32);
		contentPane_1.add(jtfTenKhachHang);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại: ");
		lblSinThoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSinThoi.setBounds(405, 22, 111, 32);
		contentPane_1.add(lblSinThoi);
		
		jtfSoDienThoai = new JTextField();
		jtfSoDienThoai.setColumns(10);
		jtfSoDienThoai.setBounds(526, 22, 189, 32);
		contentPane_1.add(jtfSoDienThoai);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 181, 111, 32);
		contentPane_1.add(lblNewLabel_1_1);
		
		jtfDiaChi = new JTextField();
		jtfDiaChi.setColumns(10);
		jtfDiaChi.setBounds(131, 183, 189, 32);
		contentPane_1.add(jtfDiaChi);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tình trạng: ");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(405, 104, 111, 32);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JCheckBox  jcbTinhTrang= new JCheckBox("Avallable");
		jcbTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbTinhTrang.setHorizontalAlignment(SwingConstants.CENTER);
		jcbTinhTrang.setBounds(526, 104, 196, 32);
		contentPane_1.add(jcbTinhTrang);
		
		KhachHangController controller = new KhachHangController(btnAdd, jtfMaKhachHang, jtfTenKhachHang, jtfDiaChi, jtfSoDienThoai, jcbTinhTrang);
		
		JButton btnDelete = new JButton("Xoa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(536, 10, 105, 37);
		contentPane.add(btnDelete);
		controller.setView(khachHang);
	}
	public void insert()  {
			try {
			Connection cons = DBConnect.getConnection();
			String sql = "Insert into KhachHang(Name,Address,Phone,Status)Values(?,?,?,?)";
			PreparedStatement ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, jtfTenKhachHang.getText());
			ps.setString(2, jtfDiaChi.getText());
			ps.setString(3, jtfSoDienThoai.getText());
			ps.setBoolean(4, jcbTinhTrang.isSelected());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			int generatdKey=0;
			if(rs.next()) {
				generatdKey = rs.getInt(1);
			}
			ps.close();
			rs.close();
			cons.close();
			JOptionPane.showConfirmDialog(this, "Bạn muốn thêm khách hàng?");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void update() {
		try {
			Connection cons = DBConnect.getConnection();
			String ma =jtfMaKhachHang.getText();
			int value = ma.charAt(1);
			String sql = "Update KhachHang set Name = ?,Address = ?,Phone=?,Status=? Where User_id="+(char)value;
			PreparedStatement ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, jtfTenKhachHang.getText());
			ps.setString(2, jtfDiaChi.getText());
			ps.setString(3, jtfSoDienThoai.getText());
			ps.setBoolean(4, jcbTinhTrang.isSelected());
			ps.executeUpdate();
			
			ps.close();
			cons.close();
			JOptionPane.showConfirmDialog(this, "Bạn muốn thêm khách hàng?");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void delete() {
		try {
			Connection cons = DBConnect.getConnection();
			String ma =jtfMaKhachHang.getText();
			int value = ma.charAt(1);
			String sql = "Delete From KhachHang Where User_id="+(char)value;
			PreparedStatement ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.executeUpdate();
			
			ps.close();
			cons.close();
			JOptionPane.showConfirmDialog(this, "Bạn muốn xoa khách hàng?");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
