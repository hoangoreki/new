package GioHangPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class GioHangJpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GioHangJpanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 604, 405);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GioHang");
		lblNewLabel.setBounds(75, 63, 108, 87);
		panel.add(lblNewLabel);

	}

}
