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
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.Icon;

public class BanVeNhapThongTin_Gui extends JPanel {
	
	private JTable table;
	private JLabel goBackIconLabel;
	private JLabel lbl_quayLai;
	private JPanel jp_KHMV;
	private JTabbedPane tabbedPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_KHSDV;
	private JTextField textField_1_KHSDV;
	private JTextField textField_2_KHSDV;
	private JTextField textField_3_KHSDV;
	private JTable table_KHMV;
	private JTable table_KHSDV;
	private JPanel jp_KHSDV;
	
	public BanVeNhapThongTin_Gui(BanVe_GUI banVe_GUI) {
		setBackground(SystemColor.window);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
		JPanel jp_quayLai = new JPanel();
	    jp_quayLai.setBackground(SystemColor.text);
		jp_quayLai.setBounds(10, 0, 124, 47);
		add(jp_quayLai);
		jp_quayLai.setLayout(null);
		
		//Icon Quay lại
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		jp_quayLai.add(goBackIconLabel);
		goBackIconLabel.setBounds(10, 10, 39, 27);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 124, 47);
		jp_quayLai.add(panel_1);
		panel_1.setLayout(null);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ConTent_JPanel jpct = new ConTent_JPanel();
				jpct.setVisible(true);
				BanVeNhapThongTin_Gui.this.setVisible(false);
			}
		});
		
		//JLabel Quay lại
		lbl_quayLai = new JLabel("Quay lại");
		lbl_quayLai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_quayLai.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_quayLai.setBounds(45, 10, 69, 27);
		jp_quayLai.add(lbl_quayLai);
		
		// Khởi tạo tabbedPane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(46, 61, 1373, 486);
		add(tabbedPane);
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 15));
				
		jp_KHMV = new JPanel();
		jp_KHMV.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Khách hàng mua vé", null, jp_KHMV, null);
		jp_KHMV.setLayout(null);
		
		JButton bt_ThanhToan = new JButton("Thanh toán");
		bt_ThanhToan.setBounds(1235, 411, 120, 30);
		jp_KHMV.add(bt_ThanhToan);
		bt_ThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(20, 0, 1335, 98);
		jp_KHMV.add(panel_2);
		
		JLabel lb_Ten = new JLabel("Họ và tên");
		lb_Ten.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_Ten.setBounds(75, 15, 96, 25);
		panel_2.add(lb_Ten);
		
		JLabel lb_Email = new JLabel("Email");
		lb_Email.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_Email.setBounds(75, 56, 96, 22);
		panel_2.add(lb_Email);
		
		RoundedTextField textField = new RoundedTextField(15);
		textField.setColumns(10);
		textField.setBounds(260, 15, 300, 25);
		panel_2.add(textField);
		
		RoundedTextField textField_1 = new RoundedTextField(15);
		textField_1.setColumns(10);
		textField_1.setBounds(260, 53, 300, 25);
		panel_2.add(textField_1);
		
		JLabel lb_SDT = new JLabel("Số điện thoại");
		lb_SDT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_SDT.setBounds(732, 15, 143, 25);
		panel_2.add(lb_SDT);
		
		JLabel lb_CCCD = new JLabel("CCCD/ Hộ chiếu");
		lb_CCCD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_CCCD.setBounds(732, 56, 143, 25);
		panel_2.add(lb_CCCD);
		
		RoundedTextField textField_2 = new RoundedTextField(15);
		textField_2.setColumns(10);
		textField_2.setBounds(945, 15, 300, 25);
		panel_2.add(textField_2);
		
		RoundedTextField textField_3 = new RoundedTextField(15);
		textField_3.setColumns(10);
		textField_3.setBounds(945, 53, 300, 25);
		panel_2.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 123, 1335, 259);
		jp_KHMV.add(scrollPane);
		
		table_KHMV = new JTable();
		table_KHMV.setFont(new Font("Tahoma", Font.BOLD, 16));
		scrollPane.setViewportView(table_KHMV);
		table_KHMV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Khách hàng", "Đối tượng", "Thông tin chỗ", "Giá", "Giảm đối tượng", "Thành tiền", ""
			}
		));
		
		jp_KHSDV = new JPanel();
		jp_KHSDV.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Khách hàng mua vé", null, jp_KHSDV, null);
		jp_KHSDV.setLayout(null);
		
		JButton bt_ThanhToan_1 = new JButton("Thanh toán");
		bt_ThanhToan_1.setBounds(1235, 411, 120, 30);
		jp_KHSDV.add(bt_ThanhToan_1);
		bt_ThanhToan_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(20, 0, 1335, 98);
		jp_KHSDV.add(panel_2_1);
		
		JLabel lb_Ten_1 = new JLabel("Họ và tên");
		lb_Ten_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_Ten_1.setBounds(75, 15, 96, 25);
		panel_2_1.add(lb_Ten_1);
		
		JLabel lb_Email_1 = new JLabel("Email");
		lb_Email_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_Email_1.setBounds(75, 56, 96, 22);
		panel_2_1.add(lb_Email_1);
		
		RoundedTextField textField_KHSDV = new RoundedTextField(15);
		textField_KHSDV.setColumns(10);
		textField_KHSDV.setBounds(260, 15, 300, 25);
		panel_2_1.add(textField_KHSDV);
		
		RoundedTextField textField_1_KHSDV = new RoundedTextField(15);
		textField_1_KHSDV.setColumns(10);
		textField_1_KHSDV.setBounds(260, 53, 300, 25);
		panel_2_1.add(textField_1_KHSDV);
		
		JLabel lb_SDT_KHSDV = new JLabel("Số điện thoại");
		lb_SDT_KHSDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_SDT_KHSDV.setBounds(732, 15, 143, 25);
		panel_2_1.add(lb_SDT_KHSDV);
		
		JLabel lb_CCCD_KHSDV = new JLabel("CCCD/ Hộ chiếu");
		lb_CCCD_KHSDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_CCCD_KHSDV.setBounds(732, 56, 143, 25);
		panel_2_1.add(lb_CCCD_KHSDV);
		
		RoundedTextField textField_2_KHSDV = new RoundedTextField(15);
		textField_2_KHSDV.setColumns(10);
		textField_2_KHSDV.setBounds(945, 15, 300, 25);
		panel_2_1.add(textField_2_KHSDV);
		
		RoundedTextField textField_3_KHSDV = new RoundedTextField(15);
		textField_3_KHSDV.setColumns(10);
		textField_3_KHSDV.setBounds(945, 53, 300, 25);
		panel_2_1.add(textField_3_KHSDV);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 123, 1335, 259);
		jp_KHSDV.add(scrollPane_1);
		
		table_KHSDV = new JTable();
		table_KHSDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		scrollPane_1.setViewportView(table_KHSDV);
		table_KHSDV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Khách hàng", "Đối tượng", "Thông tin chỗ", "Giá", "Giảm đối tượng", "Thành tiền", ""
			}
		));
	}
}
