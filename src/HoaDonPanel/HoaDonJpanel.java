package HoaDonPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class HoaDonJpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HoaDonJpanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 855, 544);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoa Don");
		lblNewLabel.setBounds(100, 130, 178, 102);
		panel.add(lblNewLabel);

	}

}
