package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ban.DanhMucBan;
import Controler.ChuyenManHinh;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("QUẢN LÝ CỬA HÀNG SÁCH M&M");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1132, 451);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel jpnMenu = new JPanel();
		jpnMenu.setBackground(Color.GRAY);
		jpnMenu.setBounds(0, 0, 283, 441);
		panel.add(jpnMenu);
		jpnMenu.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 0, 283, 72);
		jpnMenu.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M&M");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 10, 263, 52);
		panel_1.add(lblNewLabel);
		
		JPanel jpnKhachHang = new JPanel();
		jpnKhachHang.setBackground(Color.GREEN);
		jpnKhachHang.setBounds(10, 82, 263, 72);
		jpnMenu.add(jpnKhachHang);
		jpnKhachHang.setLayout(null);
		
		JLabel jlbKhachHang = new JLabel("KHÁCH HÀNG");
		jlbKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbKhachHang.setForeground(Color.WHITE);
		jlbKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		jlbKhachHang.setBounds(10, 10, 243, 60);
		jpnKhachHang.add(jlbKhachHang);
		
		JPanel jpnGioHang = new JPanel();
		jpnGioHang.setBackground(Color.GREEN);
		jpnGioHang.setForeground(Color.BLACK);
		jpnGioHang.setBounds(10, 164, 263, 72);
		jpnMenu.add(jpnGioHang);
		jpnGioHang.setLayout(null);
		
		JLabel jlbGioHang = new JLabel("GIỎ HÀNG");
		jlbGioHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbGioHang.setForeground(Color.WHITE);
		jlbGioHang.setHorizontalAlignment(SwingConstants.CENTER);
		jlbGioHang.setBounds(10, 10, 243, 52);
		jpnGioHang.add(jlbGioHang);
		
		JPanel jpnHoaDon = new JPanel();
		jpnHoaDon.setBackground(Color.GREEN);
		jpnHoaDon.setBounds(10, 246, 263, 72);
		jpnMenu.add(jpnHoaDon);
		jpnHoaDon.setLayout(null);
		
		JLabel jlbHoaDon = new JLabel("HÓA ĐƠN");
		jlbHoaDon.setForeground(Color.WHITE);
		jlbHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		jlbHoaDon.setBounds(10, 10, 243, 52);
		jpnHoaDon.add(jlbHoaDon);
		
		JPanel jpnThongKe = new JPanel();
		jpnThongKe.setBackground(Color.GREEN);
		jpnThongKe.setBounds(10, 328, 263, 72);
		jpnMenu.add(jpnThongKe);
		jpnThongKe.setLayout(null);
		
		JLabel jlbThongKe = new JLabel("GIAN HANG");
		jlbThongKe.setForeground(Color.WHITE);
		jlbThongKe.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		jlbThongKe.setBounds(10, 10, 243, 52);
		jpnThongKe.add(jlbThongKe);
		
		JPanel jpnView = new JPanel();
		jpnView.setBounds(293, 0, 829, 441);
		panel.add(jpnView);
		
		ChuyenManHinh controler = new ChuyenManHinh(jpnView);
		controler.setView(jpnThongKe, jlbThongKe);
		
		List<DanhMucBan> list = new ArrayList<>();
		list.add(new DanhMucBan("ThongKe", jpnThongKe, jlbThongKe));
		list.add(new DanhMucBan("GioHang", jpnGioHang, jlbGioHang));
		list.add(new DanhMucBan("HoaDon", jpnHoaDon, jlbHoaDon));
		list.add(new DanhMucBan("KhachHang", jpnKhachHang, jlbKhachHang));
		controler.setEvent(list);
	}
}
