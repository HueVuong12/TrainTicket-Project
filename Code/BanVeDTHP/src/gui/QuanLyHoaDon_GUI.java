package gui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class QuanLyHoaDon_GUI extends JPanel {
	private JTextField txtMaHD;
	private JTextField txtNhanVien;
	private JTextField txtKH;
	private JDateChooser chooserNgayDi;
	private JDateChooser chooserNgayVe;
	private Container jp_Content_ThongTin;
	private JTable table;
	public QuanLyHoaDon_GUI() {
		setBackground(Color.white);
		setBounds(0, 170, 1460, 610);
		setLayout(null);
		
		JPanel panelTimKiem_Tong = new JPanel();
		panelTimKiem_Tong.setBounds(10, 10, 286, 229);
		add(panelTimKiem_Tong);
		panelTimKiem_Tong.setLayout(null);
		
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBackground(new Color(51, 102, 153));
		panel_TimKiem.setBounds(0, 0, 286, 34);
		panelTimKiem_Tong.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setForeground(new Color(255, 255, 255));
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(10, 0, 95, 34);
		panel_TimKiem.add(lblTimKiem);
		
		JLabel lblKyHieuTimKiem = new JLabel("New label");
		lblKyHieuTimKiem.setIcon(new ImageIcon("D:\\PTUD_BTLON\\TrainTicket-Project\\Code\\BanVeDTHP\\img\\Polygon_20.png"));
		lblKyHieuTimKiem.setBounds(243, 0, 33, 32);
		panel_TimKiem.add(lblKyHieuTimKiem);
		
		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn:");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoaDon.setBounds(10, 38, 104, 34);
		panelTimKiem_Tong.add(lblMaHoaDon);
		
		JLabel lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhanVien.setBounds(10, 104, 90, 27);
		panelTimKiem_Tong.add(lblNhanVien);
		
		JLabel lblKhachHang = new JLabel("Khách hàng:");
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhachHang.setBounds(10, 166, 119, 27);
		panelTimKiem_Tong.add(lblKhachHang);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(10, 70, 266, 27);
		panelTimKiem_Tong.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		txtNhanVien = new JTextField();
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(10, 129, 266, 27);
		panelTimKiem_Tong.add(txtNhanVien);
		
		txtKH = new JTextField();
		txtKH.setBounds(10, 190, 266, 27);
		panelTimKiem_Tong.add(txtKH);
		txtKH.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 249, 286, 121);
		add(panel_2);
		
		JPanel panelThoiGian = new JPanel();
		panelThoiGian.setLayout(null);
		panelThoiGian.setBackground(new Color(51, 102, 153));
		panelThoiGian.setBounds(0, 0, 286, 34);
		panel_2.add(panelThoiGian);
		
		JLabel lblThiGian = new JLabel("Thời gian");
		lblThiGian.setForeground(Color.WHITE);
		lblThiGian.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThiGian.setBounds(10, 0, 95, 34);
		panelThoiGian.add(lblThiGian);
		
		JLabel lblKyHieuThoiGian = new JLabel("New label");
		lblKyHieuThoiGian.setIcon(new ImageIcon("D:\\PTUD_BTLON\\TrainTicket-Project\\Code\\BanVeDTHP\\img\\Polygon_20.png"));
		lblKyHieuThoiGian.setBounds(243, 0, 33, 32);
		panelThoiGian.add(lblKyHieuThoiGian);
		
		JDateChooser dateChooserTu = new JDateChooser();
		dateChooserTu.setBounds(10, 44, 266, 27);
		panel_2.add(dateChooserTu);
		
		JDateChooser dateChooserDen = new JDateChooser();
		dateChooserDen.setBounds(10, 81, 266, 27);
		panel_2.add(dateChooserDen);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 380, 286, 137);
		add(panel_2_1);
		
		JPanel panelTrangThai = new JPanel();
		panelTrangThai.setLayout(null);
		panelTrangThai.setBackground(new Color(51, 102, 153));
		panelTrangThai.setBounds(0, 0, 286, 34);
		panel_2_1.add(panelTrangThai);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setBounds(10, 0, 95, 34);
		panelTrangThai.add(lblTrngThi);
		lblTrngThi.setForeground(Color.WHITE);
		lblTrngThi.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblKyHieuTrangThai = new JLabel("New label");
		lblKyHieuTrangThai.setIcon(new ImageIcon("D:\\PTUD_BTLON\\TrainTicket-Project\\Code\\BanVeDTHP\\img\\Polygon_20.png"));
		lblKyHieuTrangThai.setBounds(243, 0, 33, 32);
		panelTrangThai.add(lblKyHieuTrangThai);
		
		JLabel lblTatCa = new JLabel("Tất cả");
		lblTatCa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTatCa.setBounds(79, 44, 78, 19);
		panel_2_1.add(lblTatCa);
		
		JLabel lblDaHoanVe = new JLabel("Đã hoàn vé");
		lblDaHoanVe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDaHoanVe.setBounds(79, 62, 96, 34);
		panel_2_1.add(lblDaHoanVe);
		
		JLabel lblDaHoanTien = new JLabel("Đã hoàn tiền");
		lblDaHoanTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDaHoanTien.setBounds(79, 93, 118, 34);
		panel_2_1.add(lblDaHoanTien);
		
		JCheckBox chckbxTatCa = new JCheckBox("");
		chckbxTatCa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxTatCa.setBounds(23, 34, 21, 34);
		panel_2_1.add(chckbxTatCa);
		
		JCheckBox chckbxDaHoanVe = new JCheckBox("");
		chckbxDaHoanVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxDaHoanVe.setBounds(23, 62, 40, 28);
		panel_2_1.add(chckbxDaHoanVe);
		
		JCheckBox chckbxDaHoanTien = new JCheckBox("");
		chckbxDaHoanTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxDaHoanTien.setBounds(23, 93, 27, 28);
		panel_2_1.add(chckbxDaHoanTien);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(320, 10, 1119, 547);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1119, 547);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "Nh\u00E2n vi\u00EAn l\u1EADp", "Kh\u00E1ch h\u00E0ng", "\u0110\u00E3 ho\u00E0n v\u00E9", "\u0110\u00E3 ho\u00E0n ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXemChiTiet.setBounds(10, 527, 125, 30);
		add(btnXemChiTiet);
		
		JButton btnXuatHoaDon = new JButton("Xuất hóa đơn");
		btnXuatHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXuatHoaDon.setBounds(163, 527, 133, 30);
		add(btnXuatHoaDon);
		
	}
}
