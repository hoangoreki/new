package GianHangPanel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Controler.QuanLyGianHangController;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GianHangJpanel extends JPanel {
	private JTextField jtfSearch;
	/**
	 * Create the panel.
	 */
	public GianHangJpanel() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 855, 544);
		add(panel);
		panel.setLayout(null);
		
		jtfSearch = new JTextField();
		jtfSearch.setBounds(10, 10, 170, 49);
		panel.add(jtfSearch);
		jtfSearch	.setColumns(10);
		
		JButton btnAdd = new JButton("Thêm"); 
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(711, 9, 134, 50);
		panel.add(btnAdd);
		
		JPanel jpnView = new JPanel();
		jpnView.setBounds(10, 69, 835, 429);
		panel.add(jpnView);
		jpnView.setLayout(null);
		QuanLyGianHangController controller = new QuanLyGianHangController(jpnView, btnAdd, jtfSearch);
		controller.setDataToModel();
	}

}
