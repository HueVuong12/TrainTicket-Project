package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TraCuuKhachHang_GUI extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textFieldTenKH;
	private JTextField textFieldEmail;
	private JTextField textFieldSDT;
	private JTextField textFieldCCCD;
	private JTable table;
	private JTextField textField_MaKH;
	private JTextField textField_TenKH;
	private JTextField textField_Email;
	private JTextField textField_SDT;
	private JTable table_1;
	private String placeholder;
	
	/**
	 * Create the panel.
	 */
	public TraCuuKhachHang_GUI(TrangChu_GUI trangChu) {
		
		setBackground(SystemColor.text);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 1420, 560);
		add(panel);
		panel.setLayout(null);
		
		JPanel jp_QL = new JPanel();
		jp_QL.setBounds(10, 10, 124, 28);
		panel.add(jp_QL);
		jp_QL.setLayout(null);
		
		JLabel lb_quaylai = new JLabel("Quay lại");
		lb_quaylai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_quaylai.setBounds(45, 0, 69, 27);
		jp_QL.add(lb_quaylai);
		
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		JLabel goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		goBackIconLabel.setBounds(10, 0, 39, 27);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ConTent_JPanel jpct = new ConTent_JPanel();
				jpct.setVisible(true);
				TraCuuKhachHang_GUI.this.setVisible(false);
			}
		});
		jp_QL.add(goBackIconLabel);
		
		JPanel panelThongTinKhachHang = new JPanel();
		panelThongTinKhachHang.setBounds(10, 48, 337, 382);
		panelThongTinKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panelThongTinKhachHang);
		panelThongTinKhachHang.setLayout(null);
		
		textField_MaKH = new JTextField();
		String placeholder_maKH = "Theo mã khách hàng";
        
		textField_MaKH.setText(placeholder_maKH);
		textField_MaKH.setForeground(Color.GRAY);
		textField_MaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_MaKH.setBounds(35, 63, 250, 30);
		panelThongTinKhachHang.add(textField_MaKH);
		textField_MaKH.setColumns(10);
		
		textField_TenKH = new JTextField();
		String placeholder_TenKH = "Theo tên khách hàng";
        
		textField_TenKH.setText(placeholder_TenKH);
		textField_TenKH.setForeground(Color.GRAY);
		textField_TenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_TenKH.setColumns(10);
		textField_TenKH.setBounds(35, 114, 250, 30);
		panelThongTinKhachHang.add(textField_TenKH);
		
		textField_Email = new JTextField();
		String placeholder_Email = "Theo email";
        
		textField_Email.setText(placeholder_Email);
		textField_Email.setForeground(Color.GRAY);
		textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_Email.setColumns(10);
		textField_Email.setBounds(35, 174, 250, 30);
		panelThongTinKhachHang.add(textField_Email);
		
		textField_SDT = new JTextField();
		String placeholder_SDT = "Theo số điện thoại";
        
		textField_SDT.setText(placeholder_SDT);
		textField_SDT.setForeground(Color.GRAY);
		textField_SDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(35, 233, 250, 30);
		panelThongTinKhachHang.add(textField_SDT);
		
		JButton btn_Tim = new JButton("Tìm");
		btn_Tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Tim.setBackground(Color.decode("#0091D4"));
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Tim.setBounds(185, 347, 85, 25);
		panelThongTinKhachHang.add(btn_Tim);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 337, 36);
		
		panelThongTinKhachHang.add(panel_2);
		panel_2.setBackground(new Color(51, 102, 153));
		panel_2.setLayout(null);
		
		JLabel lb_Tim = new JLabel("Tìm kiếm");
		lb_Tim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_Tim.setBounds(0, 0, 337, 36);
		panel_2.add(lb_Tim);
		
		textFieldCCCD = new JTextField();
        String placeholder = "Theo căn cước công dân";
        
        textFieldCCCD.setText(placeholder);
        textFieldCCCD.setForeground(Color.GRAY);
        textFieldCCCD.setToolTipText("");
        textFieldCCCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textFieldCCCD.setColumns(10);
        textFieldCCCD.setBounds(35, 287, 250, 30);
		panelThongTinKhachHang.add(textFieldCCCD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(357, 10, 1053, 540);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã khách hàng", "Tên khách hàng", "Email", "Số điện thoại", "Căn cước công dân"
			}
		));
		scrollPane.setViewportView(table_1);
		table_1.setBounds(347, 10, 1053, 517);
		
		// Thêm FocusListener
//		textField_MaKH.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (textField_MaKH.getText().equals(placeholder_maKH)) {
//                	textField_MaKH.setText("");
//                	textField_MaKH.setForeground(Color.BLACK); // Đặt màu chữ khi nhập
//                }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (textField_MaKH.getText().isEmpty()) {
//                	textField_MaKH.setForeground(Color.GRAY);
//                	textField_MaKH.setText(placeholder_maKH); // Khôi phục lại placeholder
//                }
//            }
//        });
		
        textFieldCCCD.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textFieldCCCD.getText().equals(placeholder)) {
                    textFieldCCCD.setText("");
                    textFieldCCCD.setForeground(Color.BLACK); // Đặt màu chữ khi nhập
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldCCCD.getText().isEmpty()) {
                    textFieldCCCD.setForeground(Color.GRAY);
                    textFieldCCCD.setText(placeholder); // Khôi phục lại placeholder
                }
            }
        });
        
	}
}
