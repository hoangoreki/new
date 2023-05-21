package Ban;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhMucBan {
	private String kind;
	private JPanel jpn;
	private JLabel jlb;

	public DanhMucBan(String kind, JPanel jpn, JLabel jlb) {
		super();
		this.kind = kind;
		this.jpn = jpn;
		this.jlb = jlb;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public JPanel getJpn() {
		return jpn;
	}

	public void setJpn(JPanel jpn) {
		this.jpn = jpn;
	}

	public JLabel getJlb() {
		return jlb;
	}

	public void setJlb(JLabel jlb) {
		this.jlb = jlb;
	}

}
