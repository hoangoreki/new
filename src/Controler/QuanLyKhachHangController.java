package Controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import KhachHangPanel.KhachHangJFrame;
import model.KhachHang;
import service.KhachHangService;
import service.KhachHangServiceImp;
import ublity.ClassTableModel;

public class QuanLyKhachHangController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JTextField jtfSearch;

	private KhachHangService khachHangService = null;

	private String[] listColumn = { "Mã Khách Hàng", "STT", "Tên Khách Hàng", "Địa chỉ", "Số điện thoại",
			"Tình trạng" };
	private TableRowSorter<TableModel> rowSorter = null;

	public QuanLyKhachHangController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
		super();
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.jtfSearch = jtfSearch;
		this.khachHangService = new KhachHangServiceImp();
	}

	public void setDataToModel() {
		List<KhachHang> listItem = khachHangService.getList();
		DefaultTableModel model = new ClassTableModel().setTableKhachHang(listItem, listColumn);
		JTable table =  new JTable(model);
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = jtfSearch.getText();
				if(text.trim().length()==0) {
					rowSorter.setRowFilter(null);
				}else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = jtfSearch.getText();
				if(text.trim().length()==0) {
					rowSorter.setRowFilter(null);
				}else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		table.getTableHeader().setFont(new Font("Arrial",Font.BOLD,14));
		table.getTableHeader().setPreferredSize(new Dimension(100,50));
		table.setRowHeight(50);
		
		table.validate();
		table.repaint();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2 && table.getSelectedRow()!=-1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					selectedRowIndex = table.convertColumnIndexToView(selectedRowIndex);
					
					KhachHang khachHang = new KhachHang();
					khachHang.setMa_khach_hang((int) model.getValueAt(selectedRowIndex, 0));
					khachHang.setTen_khach_hang((String) model.getValueAt(selectedRowIndex, 2).toString());
					khachHang.setDia_chi(model.getValueAt(selectedRowIndex, 3).toString());
					khachHang.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 4).toString());
					khachHang.setTrinh_trang((boolean) model.getValueAt(selectedRowIndex, 5));
					
					KhachHangJFrame frame = new KhachHangJFrame(khachHang);
					frame.setTitle("Thông tin khách Hàng");
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
;				}
			}
		});
		
		JScrollPane scollPane = new JScrollPane();
		scollPane.getViewport().add(table);
		scollPane.setPreferredSize(new Dimension(1300,400));
		
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(scollPane);
		jpnView.validate();
		jpnView.repaint();
		
	}
	public void setEvent() {
		btnAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				KhachHangJFrame jframe = new KhachHangJFrame(new KhachHang());
				jframe.setTitle("Thêm thông tin khách hàng");
				jframe.setLocationRelativeTo(null);
				jframe.setResizable(false);
				jframe.setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0,200,83));
			}
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(100,221,23));
			}
		});
	}
}
