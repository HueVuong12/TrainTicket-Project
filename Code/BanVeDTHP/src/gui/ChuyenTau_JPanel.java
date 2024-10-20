package gui;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;

public class ChuyenTau_JPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel trainIconLabel;

	/**
	 * Create the panel.
	 */
	public ChuyenTau_JPanel() {
		setLayout(null);
		//Logo chương trình
		ImageIcon trainIcon = new ImageIcon(getClass().getResource("/img/train_Zoom-removebg-preview.png"));
		Image scaledTrainIcon = trainIcon.getImage().getScaledInstance(231,129, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		trainIconLabel = new JLabel(new ImageIcon(scaledTrainIcon));
		trainIconLabel.setBackground(Color.WHITE);
		add(trainIconLabel);
		trainIconLabel.setBounds(0, 0, 211, 119);
		
		JLabel lblNewLabel = new JLabel("         TA001");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(62, 0, 86, 14);
		add(lblNewLabel);
	}
}
