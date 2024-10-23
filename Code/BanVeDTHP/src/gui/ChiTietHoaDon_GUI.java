package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChiTietHoaDon_GUI extends JPanel {
	public ChiTietHoaDon_GUI() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(30, 10, 146, 44);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\PTUD_BTLON\\TrainTicket-Project\\Code\\BanVeDTHP\\img\\9054423_bx_arrow_back_icon.png"));
		lblNewLabel.setBounds(10, 10, 43, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quay lại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(63, -6, 86, 55);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 77, 274, 195);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 153));
		panel_2.setBounds(0, 0, 274, 42);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setForeground(new Color(255, 255, 255));
		lblTimKiem.setBounds(10, 10, 98, 19);
		panel_2.add(lblTimKiem);
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	}
}
