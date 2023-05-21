package GianHangPanel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Data.DBConnect;
import model.Sach;

public class GianHangJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField jtfMaSach;
	private JTextField jtfTenSach;
	private JTextField jtfGia;
	private JTextField jtfTacGia;
	private JCheckBox jcbTinhTrang;
	private JTextField jtfSoLuong;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GianHangJFrame frame = new GianHangJFrame();
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
	public GianHangJFrame(Sach sach) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kt = jtfMaSach.getText();
				if(kt.equalsIgnoreCase("#0")) {
				insert();
				}else {
					update();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(674, 10, 105, 37);
		contentPane.add(btnAdd);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Sach", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane_1.setBounds(0, 56, 802, 362);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("Mã Sách: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 22, 111, 32);
		contentPane_1.add(lblNewLabel);
		
		jtfMaSach = new JTextField();
		jtfMaSach.setBounds(131, 24, 189, 32);
		contentPane_1.add(jtfMaSach);
		jtfMaSach.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên Sách: ");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTnKhchHng.setBounds(10, 104, 111, 32);
		contentPane_1.add(lblTnKhchHng);
		
		jtfTenSach = new JTextField();
		jtfTenSach.setColumns(10);
		jtfTenSach.setBounds(131, 106, 189, 32);
		contentPane_1.add(jtfTenSach);
		
		JLabel lblSinThoi = new JLabel("Giá: ");
		lblSinThoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSinThoi.setBounds(405, 22, 111, 32);
		contentPane_1.add(lblSinThoi);
		
		jtfGia = new JTextField();
		jtfGia.setColumns(10);
		jtfGia.setBounds(526, 22, 189, 32);
		contentPane_1.add(jtfGia);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Tác Giả: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 181, 111, 32);
		contentPane_1.add(lblNewLabel_1_1);
		
		jtfTacGia = new JTextField();
		jtfTacGia.setColumns(10);
		jtfTacGia.setBounds(131, 183, 189, 32);
		contentPane_1.add(jtfTacGia);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tình trạng: ");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(405, 104, 111, 32);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JCheckBox  jcbCheckBox= new JCheckBox("Avallable");
		jcbCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcbCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		jcbCheckBox.setBounds(526, 104, 196, 32);
		contentPane_1.add(jcbCheckBox);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Số lượng: ");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(10, 255, 111, 32);
		contentPane_1.add(lblNewLabel_1_1_2);
		
		jtfSoLuong = new JTextField();
		jtfSoLuong.setColumns(10);
		jtfSoLuong.setBounds(131, 257, 189, 32);
		contentPane_1.add(jtfSoLuong);
		
		JButton btnDelete = new JButton("Xoa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(539, 10, 105, 37);
		contentPane.add(btnDelete);
	}
	public void insert()  {
		try {
		Connection cons = DBConnect.getConnection();
		String sql = "Insert into KhachHang(Name,TacGia,Price,Status,Amount)Values(?,?,?,?)";
		PreparedStatement ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, jtfTenSach.getText());
		ps.setString(2, jtfTacGia.getText());
		ps.setString(3, jtfGia.getText());
		ps.setBoolean(4, jcbTinhTrang.isSelected());
		ps.setString(5, jtfSoLuong.getText());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		
		int generatdKey=0;
		if(rs.next()) {
			generatdKey = rs.getInt(1);
		}
		ps.close();
		rs.close();
		cons.close();
		JOptionPane.showConfirmDialog(this, "Bạn muốn thêm Sach?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	public void update() {
		try {
			Connection cons = DBConnect.getConnection();
			String ma =jtfMaSach.getText();
			int value = ma.charAt(1);
			String sql = "Update Sach set Name = ?,TacGia = ?,Price=?,Status=?,Amount=? Where Book_id="+(char)value;
			PreparedStatement ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, jtfTenSach.getText());
			ps.setString(2, jtfTacGia.getText());
			ps.setString(3, jtfGia.getText());
			ps.setBoolean(4, jcbTinhTrang.isSelected());
			ps.setString(5, jtfSoLuong.getText());
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
		String ma =jtfMaSach.getText();
		int value = ma.charAt(1);
		String sql = "Delete From Sach Where Book_id="+(char)value;
		PreparedStatement ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		
		ps.executeUpdate();
		
		ps.close();
		cons.close();
		JOptionPane.showConfirmDialog(this, "Bạn muốn xoa sách?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
