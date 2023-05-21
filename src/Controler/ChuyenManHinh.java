package Controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Ban.DanhMucBan;
import GianHangPanel.GianHangJpanel;
import GioHangPanel.GioHangJpanel;
import HoaDonPanel.HoaDonJpanel;
import KhachHangPanel.KhachHangJpanel;

public class ChuyenManHinh {
	private JPanel root;
	private String Selected = "";

	private List<DanhMucBan> list = null;

	public ChuyenManHinh(JPanel jpnRoot) {
		this.root = jpnRoot;
	}

	public void setView(JPanel jpnItem, JLabel jblItem) {
		Selected = "ThongKe";
		jpnItem.setBackground(new Color(96, 100, 191));
		jpnItem.setBackground(new Color(96, 100, 191));

		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new GianHangJpanel());
		root.validate();
		root.repaint();
		
	}
	
	public void setEvent(List<DanhMucBan> list) {
		this.list = list;
		for(DanhMucBan item: list) {
			item.getJlb().addMouseListener(new LabelEvent(item.getJpn(), item.getKind(), item.getJlb()));
		}
	}
	
	class LabelEvent implements  MouseListener{
		
		private JPanel node,jpnItem;
		private String kind;
		private JLabel jlbItem;
		
	
		public LabelEvent(JPanel jpnItem, String kind, JLabel jlbItem) {
			super();
			this.jpnItem = jpnItem;
			this.kind = kind;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(kind) {
			case "ThongKe":
				node = new GianHangJpanel();
				break;
			case "GioHang":
				node = new GioHangJpanel();
				break;
			case "HoaDon":
				node = new HoaDonJpanel();
				break;
			case "KhachHang":
				node = new KhachHangJpanel();
				break;
			default: 
				node =new GianHangJpanel();
				break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackGround(kind);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			Selected =kind;
			jpnItem.setBackground(new Color(96,100,191));
			jlbItem.setBackground(new Color(96,100,191));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			jpnItem.setBackground(new Color(96,100,191));
			jlbItem.setBackground(new Color(96,100,191));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(!Selected.equalsIgnoreCase(kind)) {
				jpnItem.setBackground(new Color(96,100,191));
				jlbItem.setBackground(new Color(96,100,191));
			}
		}
		private void setChangeBackGround(String kind) {
			for(DanhMucBan item: list) {
				if(item.getKind().equalsIgnoreCase(kind)) {
					item.getJlb().setBackground(new Color(96,100,191));
					item.getJpn().setBackground(new Color(96,100,191));
				}else {
					item.getJlb().setBackground(new Color(76,175,80));
					item.getJpn().setBackground(new Color(76,175,80));
				}
			}
		}
	}
}
