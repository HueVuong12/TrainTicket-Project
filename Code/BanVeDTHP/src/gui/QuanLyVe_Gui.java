package gui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.NhanVien_DAO;
import entity.Ca;
import entity.NhanVien;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;

public class QuanLyVe_Gui extends JPanel implements ActionListener,MouseListener {

	private JTextField txtTenKH;
	private JTextField txtGaDen;
	private JTextField textField;
	private JTextField txtLoaiVe;
	private JTextField txtMaToa;
	private JTextField txtMaSoGhe;
	private JTextField txtMaVe;
	private JTextField txtMaChuyenTau;
	private JTextField txtGioDi;
	private JTextField txtGia;
	private JTextField txtTen;
	private JTextField txtGDen;
	private JTextField txtLVe;
	private JTextField txtNgayDi;
	private JTextField txtMToa;
	private JTextField txtMaGhe;
	private JTextField txtMVe;
	private JTextField txtMChuyenTau;
	private JTextField txtGDi;
	private JTextField txtG_ia;
	private JTable table;
	private JButton btnDoiVe;
	private JButton btnTraVe;
	public QuanLyVe_Gui() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 42, 462, 523);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 153));
		panel_1.setBounds(0, 0, 489, 29);
		panel.add(panel_1);
		
		JLabel lblThongTinVe = new JLabel("THÔNG TIN VÉ");
		panel_1.add(lblThongTinVe);
		lblThongTinVe.setForeground(new Color(255, 255, 255));
		lblThongTinVe.setBackground(new Color(255, 255, 255));
		lblThongTinVe.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 29, 460, 496);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenKH.setBounds(10, 19, 136, 32);
		panel_2.add(lblTenKH);
		
		txtTen = new JTextField();
		txtTen.setBounds(147, 19, 295, 32);
		panel_2.add(txtTen);
		txtTen.setColumns(10);
		
		txtGDen = new JTextField();
		txtGDen.setColumns(10);
		txtGDen.setBounds(147, 62, 295, 32);
		panel_2.add(txtGDen);
		
		txtLVe = new JTextField();
		txtLVe.setColumns(10);
		txtLVe.setBounds(147, 149, 295, 32);
		panel_2.add(txtLVe);
		
		txtNgayDi = new JTextField();
		txtNgayDi.setColumns(10);
		txtNgayDi.setBounds(147, 104, 295, 32);
		panel_2.add(txtNgayDi);
		
		JLabel lblNgayDi = new JLabel("Ngày đi:");
		lblNgayDi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayDi.setBounds(10, 104, 136, 32);
		panel_2.add(lblNgayDi);
		
		JLabel lblGaDen = new JLabel("Ga đến:");
		lblGaDen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGaDen.setBounds(10, 61, 136, 32);
		panel_2.add(lblGaDen);
		
		JLabel lblLoaiVe = new JLabel("Loại vé:");
		lblLoaiVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiVe.setBounds(10, 149, 136, 32);
		panel_2.add(lblLoaiVe);
		
		JLabel lblMToa = new JLabel("Mã toa:");
		lblMToa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMToa.setBounds(10, 191, 136, 32);
		panel_2.add(lblMToa);
		
		JLabel lblMSGh = new JLabel("Mã số ghế:");
		lblMSGh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSGh.setBounds(10, 233, 136, 32);
		panel_2.add(lblMSGh);
		
		JLabel lblMV = new JLabel("Mã vé:");
		lblMV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMV.setBounds(10, 275, 136, 32);
		panel_2.add(lblMV);
		
		txtMToa = new JTextField();
		txtMToa.setColumns(10);
		txtMToa.setBounds(147, 191, 295, 32);
		panel_2.add(txtMToa);
		
		txtMaGhe = new JTextField();
		txtMaGhe.setColumns(10);
		txtMaGhe.setBounds(147, 236, 295, 32);
		panel_2.add(txtMaGhe);
		
		txtMVe = new JTextField();
		txtMVe.setColumns(10);
		txtMVe.setBounds(147, 278, 295, 32);
		panel_2.add(txtMVe);
		
		JLabel lblMChuyenTau = new JLabel("Mã chuyến tàu:");
		lblMChuyenTau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMChuyenTau.setBounds(10, 319, 136, 29);
		panel_2.add(lblMChuyenTau);
		
		txtMChuyenTau = new JTextField();
		txtMChuyenTau.setColumns(10);
		txtMChuyenTau.setBounds(147, 320, 295, 32);
		panel_2.add(txtMChuyenTau);
		
		txtGDi = new JTextField();
		txtGDi.setColumns(10);
		txtGDi.setBounds(147, 362, 295, 32);
		panel_2.add(txtGDi);
		
		txtG_ia = new JTextField();
		txtG_ia.setColumns(10);
		txtG_ia.setBounds(147, 404, 295, 32);
		panel_2.add(txtG_ia);
		
		JLabel lblGioDi = new JLabel("Giờ đi:");
		lblGioDi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioDi.setBounds(10, 359, 136, 32);
		panel_2.add(lblGioDi);
		
		JLabel lblGia = new JLabel("Gía:");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGia.setBounds(10, 404, 136, 32);
		panel_2.add(lblGia);
		
		btnDoiVe = new JButton("Đổi vé");
		btnDoiVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDoiVe.setBounds(147, 452, 136, 32);
		panel_2.add(btnDoiVe);
		
		btnTraVe = new JButton("Trả vé");
		btnTraVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTraVe.setBounds(299, 452, 143, 32);
		panel_2.add(btnTraVe);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(44, 10, 209, 34);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png")));
		lblNewLabel.setBounds(10, 10, 35, 13);
		panel_3.add(lblNewLabel);
		
		JLabel lblQuayLai = new JLabel("Quay lại");
		lblQuayLai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuayLai.setBounds(55, 2, 89, 24);
		panel_3.add(lblQuayLai);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(502, 44, 958, 521);
		add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 938, 498);
		panel_4.add(scrollPane);
		btnDoiVe.addActionListener(this);
		btnTraVe.addActionListener(this);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn kh\u00E1ch h\u00E0ng", "Ga \u0111\u1EBFn", "Ng\u00E0y \u0111i", "Lo\u1EA1i v\u00E9", "Toa", "Gh\u1EBF", "M\u00E3 v\u00E9", "M\u00E3 chuy\u1EBFn t\u00E0u", "Gi\u1EDD", "G\u00EDa"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(21);
		table.getColumnModel().getColumn(7).setPreferredWidth(15);
		table.getColumnModel().getColumn(8).setPreferredWidth(15);
		scrollPane.setViewportView(table);}
		

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
