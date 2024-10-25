package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.SystemColor;

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
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class QuanLyKhachHang_GUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textFieldTenKH;
	private JTextField textFieldEmail;
	private JTextField textFieldSDT;
	private JTextField textFieldCCCD;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_1;
	private JTextField textField_5;
	private String placeholder;
	
	/**
	 * Create the panel.
	 */
	public QuanLyKhachHang_GUI() {
		setBackground(SystemColor.text);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1440, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 1420, 560);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setBounds(10, 10, 337, 100);
		panelTimKiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panelTimKiem);
		panelTimKiem.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 153));
		panel_1.setBounds(0, 0, 337, 36);
		panelTimKiem.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbTimKiem = new JLabel("Tìm kiếm");
		lbTimKiem.setBounds(0, 0, 337, 36);
		lbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTimKiem.setBackground(new Color(0, 191, 255));
		panel_1.add(lbTimKiem);
		
		textField_5 = new JTextField();
		textField_5.setBounds(34, 60, 250, 30);
		panelTimKiem.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panelThongTinKhachHang = new JPanel();
		panelThongTinKhachHang.setBounds(10, 120, 337, 407);
		panelThongTinKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panelThongTinKhachHang);
		panelThongTinKhachHang.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên Khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 46, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBounds(35, 75, 250, 30);
		panelThongTinKhachHang.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 115, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(35, 195, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Căn cước công dân:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(35, 270, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(35, 145, 250, 30);
		panelThongTinKhachHang.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(35, 225, 250, 30);
		panelThongTinKhachHang.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(35, 300, 250, 30);
		panelThongTinKhachHang.add(textField_4);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setBackground(Color.BLUE);
		btnThem.setBackground(Color.decode("#0091D4"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(45, 359, 85, 25);
		panelThongTinKhachHang.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.decode("#0091D4"));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(190, 359, 85, 25);
		panelThongTinKhachHang.add(btnSua);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 337, 36);
		
		panelThongTinKhachHang.add(panel_2);
		panel_2.setBackground(new Color(51, 102, 153));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Thông tin khách hàng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(0, 0, 337, 36);
		panel_2.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(357, 10, 1053, 517);
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
	}
}
