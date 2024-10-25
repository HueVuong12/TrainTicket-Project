package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class BanVeNhapThongTin_Gui extends JPanel {
	private JTextField textField_Ten;
	private JTextField textField_Email;
	private JTextField textField_SDT;
	private JTextField textField_CCCD;
	private JTable table;
	private JTable table_TTBV;
	public BanVeNhapThongTin_Gui(BanVe_GUI banVe_GUI) {
		setBackground(SystemColor.window);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1460, 570);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 124, 28);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lb_quaylai = new JLabel("Quay lại");
		lb_quaylai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_quaylai.setBounds(45, 0, 69, 27);
		panel_1.add(lb_quaylai);
		
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		JLabel goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		goBackIconLabel.setBounds(10, 0, 39, 27);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ConTent_JPanel jpct = new ConTent_JPanel();
				jpct.setVisible(true);
				BanVeNhapThongTin_Gui.this.setVisible(false);
			}
		});
		panel_1.add(goBackIconLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(46, 88, 1355, 99);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lb_Ten = new JLabel("Họ và tên");
		lb_Ten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_Ten.setBounds(75, 15, 96, 25);
		panel_2.add(lb_Ten);
		
		JLabel lb_Email = new JLabel("Email");
		lb_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_Email.setBounds(75, 56, 96, 22);
		panel_2.add(lb_Email);
		
		textField_Ten = new JTextField();
		textField_Ten.setBounds(260, 15, 300, 25);
		panel_2.add(textField_Ten);
		textField_Ten.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(260, 53, 300, 25);
		panel_2.add(textField_Email);
		
		JLabel lb_SDT = new JLabel("Số điện thoại");
		lb_SDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_SDT.setBounds(732, 15, 143, 25);
		panel_2.add(lb_SDT);
		
		JLabel lb_CCCD = new JLabel("CCCD/ Hộ chiếu");
		lb_CCCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_CCCD.setBounds(732, 56, 143, 25);
		panel_2.add(lb_CCCD);
		
		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(945, 15, 300, 25);
		panel_2.add(textField_SDT);
		
		textField_CCCD = new JTextField();
		textField_CCCD.setColumns(10);
		textField_CCCD.setBounds(945, 53, 300, 25);
		panel_2.add(textField_CCCD);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(46, 197, 1355, 290);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1355, 290);
		panel_3.add(scrollPane);
		
		table_TTBV = new JTable();
		scrollPane.setViewportView(table_TTBV);
		table_TTBV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Khách hàng", "Đối tượng", "Thông tin chỗ", "Giá", "Giảm đối tượng", "Thành tiền", ""
			}
		));
		
		JButton bt_ThanhToan = new JButton("Thanh toán");
		bt_ThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_ThanhToan.setBounds(1230, 513, 120, 30);
		panel.add(bt_ThanhToan);
		
		JPanel jp_KHMV = new JPanel();
		jp_KHMV.setBackground(new Color(30, 144, 255));
		jp_KHMV.setBounds(46, 50, 260, 28);
		jp_KHMV.setBackground(new Color(51, 102, 153));
		panel.add(jp_KHMV);
		jp_KHMV.setLayout(null);
		
		JLabel lb_KHMV = new JLabel("Khách hàng mua vé");
		lb_KHMV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_KHMV.setBounds(0, 0, 260, 28);
		jp_KHMV.add(lb_KHMV);
		
		JPanel jp_KHSDV = new JPanel();
		jp_KHSDV.setBounds(330, 50, 260, 28);
		panel.add(jp_KHSDV);
		jp_KHSDV.setLayout(null);
		
		JLabel lb_KHSDV = new JLabel("Khách hàng sử dụng vé");
		lb_KHSDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_KHSDV.setBounds(0, 0, 260, 28);
		jp_KHSDV.add(lb_KHSDV);
		
		
	}
}
