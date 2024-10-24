package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import dao.ChuyenTau_DAO;
import dao.Ga_DAO;
import dao.Ghe_DAO;
import dao.Toa_DAO;
import dao.Ve_DAO;
import entity.ChuyenTau;
import entity.Ga;
import entity.Ghe;
import entity.Toa;
import entity.Ve;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

public class BanVe_GUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jp_title;
	private JLabel downIconLabel_2;
	private JLabel lbl_Chieu_1;
	private JLabel lbl_NgayDi_1;
	private JLabel lbl_Ga_1;
	private JLabel lblMaToa;
	private JTextField txt_GaDi;
	private JTextField txt_GaDen;
	private JDateChooser chooserNgayDi;
	private JDateChooser chooserNgayVe;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtn_MotChieu;
	private JRadioButton rdbtn_KhuHoi;
	private JPanel jp_ThongTinChuyenTau;
	private JPanel jp_TinhTrangToa;
	private JPanel jp_TinhTrangGhe;
	ArrayList<Ve> dsVeDatTam = new ArrayList<Ve>();
	private JPanel jp_VeMua;
	
	// Khai bao DAO
	Ga_DAO ga_dao = new Ga_DAO();
	ArrayList<Ga> dsGa = ga_dao.docTuBang();
	ChuyenTau_DAO chuyenTau_dao = new ChuyenTau_DAO();
	ArrayList<ChuyenTau> dsChuyenTau = chuyenTau_dao.docTuBang();
	Toa_DAO toa_DAO = new Toa_DAO();
	Ve_DAO ve_DAO = new Ve_DAO();
	Ghe_DAO ghe_DAO = new Ghe_DAO();

	/**
	 * Create the panel.
	 */
	public BanVe_GUI(TrangChu_GUI trangChu) {
		setBackground(SystemColor.window);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);

		// Icon xổ xuống
		ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		downIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		System.out.println("Them ve thanh cong");

		jp_title = new JPanel();
		jp_title.setLayout(null);
		jp_title.setBackground(new Color(51, 102, 153));
		jp_title.setBounds(264, 10, 686, 36);
		add(jp_title);

		downIconLabel_2 = new JLabel((Icon) null);
		downIconLabel_2.setBounds(0, 0, 30, 35);
		jp_title.add(downIconLabel_2);

		lbl_Chieu_1 = new JLabel("Chiều đi:");
		lbl_Chieu_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Chieu_1.setForeground(Color.WHITE);
		lbl_Chieu_1.setBounds(40, 0, 152, 35);
		jp_title.add(lbl_Chieu_1);

		lbl_NgayDi_1 = new JLabel();
		lbl_NgayDi_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_NgayDi_1.setForeground(Color.WHITE);
		lbl_NgayDi_1.setBounds(192, 0, 152, 35);
		jp_title.add(lbl_NgayDi_1);

		lbl_Ga_1 = new JLabel();
		lbl_Ga_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Ga_1.setForeground(Color.WHITE);
		lbl_Ga_1.setBounds(342, 0, 334, 35);
		jp_title.add(lbl_Ga_1);

		jp_ThongTinChuyenTau = new JPanel();
		jp_ThongTinChuyenTau.setBounds(264, 56, 1186, 118);
		add(jp_ThongTinChuyenTau);
		jp_ThongTinChuyenTau.setLayout(null);

		jp_TinhTrangToa = new JPanel();
		jp_TinhTrangToa.setBounds(264, 184, 1186, 76);
		add(jp_TinhTrangToa);
		jp_TinhTrangToa.setLayout(null);

		jp_TinhTrangGhe = new JPanel();
		jp_TinhTrangGhe.setBounds(264, 300, 1186, 260);
		add(jp_TinhTrangGhe);
		jp_TinhTrangGhe.setLayout(null);

		JPanel jp_timKiem = new JPanel();
		jp_timKiem.setLayout(null);
		jp_timKiem.setBackground(Color.WHITE);
		jp_timKiem.setBounds(10, 10, 244, 351);
		add(jp_timKiem);

		JPanel jp_Content_ThongTin = new JPanel();
		jp_Content_ThongTin.setLayout(null);
		jp_Content_ThongTin.setBackground(SystemColor.controlHighlight);
		jp_Content_ThongTin.setBounds(0, 32, 244, 319);
		jp_timKiem.add(jp_Content_ThongTin);

		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jp_TinhTrangToa.removeAll();
				jp_TinhTrangToa.revalidate();
				jp_TinhTrangToa.repaint();
				
				jp_TinhTrangGhe.removeAll();
				jp_TinhTrangGhe.revalidate();
				jp_TinhTrangGhe.repaint();

				lblMaToa.setText("");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				lbl_NgayDi_1.setText(sdf.format(chooserNgayDi.getDate()));
				lbl_Ga_1.setText(txt_GaDi.getText() + " - " + txt_GaDen.getText());
				jp_ThongTinChuyenTau.removeAll();
				String gaDi = txt_GaDi.getText();
				String gaDen = txt_GaDen.getText();
				boolean isKhuHoi = rdbtn_KhuHoi.isSelected();
				LocalDate ngayDi = chooserNgayDi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				if (isKhuHoi) {
					chooserNgayVe.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				}

				ArrayList<ChuyenTau> dsTauHienThi = new ArrayList<ChuyenTau>();
				for (ChuyenTau chuyenTau : dsChuyenTau) {
					if ((ga_dao.getGaTheoMaGa(chuyenTau.getGaDi().getMaGa()).getDiaChi().equals(gaDi))
							&& (chuyenTau.getNgayDi().equals(ngayDi))) {
						for (Ga gaDung : chuyenTau.getTramDung()) {
							if (gaDen.equals(gaDung.getDiaChi()))
								dsTauHienThi.add(chuyenTau);
						}
						if (gaDen.equals(ga_dao.getGaTheoMaGa(chuyenTau.getGaDen().getMaGa()).getDiaChi()))
							dsTauHienThi.add(chuyenTau);
					}
				}
				int x = 0, y = 0;
				for (ChuyenTau chuyenTau : dsTauHienThi) {
					// Tạo ChuyenTau_JPanel ban đầu với tham số false
					ChuyenTau_JPanel pChuyenTau = new ChuyenTau_JPanel(chuyenTau);
					pChuyenTau.setBounds(x, y, 123, 122);
					// su kien
					suKienTrenChuyen(pChuyenTau, chuyenTau);
					jp_ThongTinChuyenTau.add(pChuyenTau);
					x += 127; // Điều chỉnh vị trí cho panel tiếp theo
				}

				jp_ThongTinChuyenTau.revalidate();
				jp_ThongTinChuyenTau.repaint();
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(73, 278, 85, 27);
		jp_Content_ThongTin.add(btnTim);

		txt_GaDi = new JTextField();
		txt_GaDi.setText("Nhập ga đi");
		txt_GaDi.setHorizontalAlignment(SwingConstants.LEFT);
		txt_GaDi.setForeground(SystemColor.textInactiveText);
		txt_GaDi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_GaDi.setColumns(10);
		txt_GaDi.setBounds(21, 26, 202, 27);
		jp_Content_ThongTin.add(txt_GaDi);
		chonGa(txt_GaDi);
		focusTxtField(txt_GaDi, "Nhập ga đi");

		txt_GaDen = new JTextField();
		txt_GaDen.setText("Nhập ga đến");
		txt_GaDen.setHorizontalAlignment(SwingConstants.LEFT);
		txt_GaDen.setForeground(SystemColor.textInactiveText);
		txt_GaDen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_GaDen.setColumns(10);
		txt_GaDen.setBounds(21, 78, 202, 27);
		jp_Content_ThongTin.add(txt_GaDen);
		chonGa(txt_GaDen);
		focusTxtField(txt_GaDen, "Nhập ga đến");

		rdbtn_MotChieu = new JRadioButton("Một Chiều");
		buttonGroup.add(rdbtn_MotChieu);
		rdbtn_MotChieu.setBounds(21, 130, 85, 21);
		jp_Content_ThongTin.add(rdbtn_MotChieu);

		rdbtn_KhuHoi = new JRadioButton("Khứ Hồi");
		buttonGroup.add(rdbtn_KhuHoi);
		rdbtn_KhuHoi.setBounds(108, 130, 85, 21);
		jp_Content_ThongTin.add(rdbtn_KhuHoi);

		rdbtn_MotChieu.setSelected(true);

		chooserNgayDi = new JDateChooser();
		chooserNgayDi.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chooserNgayDi.setBounds(21, 180, 202, 27);
		chooserNgayDi.setDateFormatString("dd/MM/yyyy");
		jp_Content_ThongTin.add(chooserNgayDi);
		((JTextField) chooserNgayDi.getDateEditor().getUiComponent()).setEditable(false);

		// Thêm listener để kiểm tra ngày chọn đi
		chooserNgayDi.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				// Lấy ngày hôm nay với thời gian thiết lập là 00:00:00
				Calendar todayCal = Calendar.getInstance();
				todayCal.set(Calendar.HOUR_OF_DAY, 0);
				todayCal.set(Calendar.MINUTE, 0);
				todayCal.set(Calendar.SECOND, 0);
				todayCal.set(Calendar.MILLISECOND, 0);
				Date today = todayCal.getTime();

				if (chooserNgayDi.getDate() != null && chooserNgayDi.getDate().before(today)) {
					JOptionPane.showMessageDialog(null,
							"Ngày không hợp lệ! Vui lòng chọn ngày không trước ngày hôm nay.", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					chooserNgayDi.setDate(null); // Xóa ngày đã chọn
				}
			}
		});

		chooserNgayVe = new JDateChooser();
		chooserNgayVe.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chooserNgayVe.setBounds(21, 240, 202, 27);
		chooserNgayVe.setDateFormatString("dd/MM/yyyy");
		chooserNgayVe.setEnabled(false);
		jp_Content_ThongTin.add(chooserNgayVe);
		((JTextField) chooserNgayVe.getDateEditor().getUiComponent()).setEditable(false);

		// Thêm listener để thay đổi trạng thái của chooser ngày về
		rdbtn_KhuHoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooserNgayVe.setEnabled(true); // Kích hoạt chooser ngày về khi chọn Khứ Hồi
			}
		});

		rdbtn_MotChieu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooserNgayVe.setEnabled(false); // Vô hiệu hóa chooser ngày về khi chọn Một Chiều
				chooserNgayVe.setDate(null); // Xóa ngày đã chọn
			}
		});

		// Thêm listener để kiểm tra ngày chọn về
		chooserNgayVe.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				Date ngayDi = chooserNgayDi.getDate();

				// Kiểm tra nếu chọn ngày về khi khứ hồi được chọn
				if (chooserNgayVe.getDate() != null) {
					// Kiểm tra nếu ngày đi đã được chọn
					if (ngayDi == null) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày đi trước khi chọn ngày về.",
								"Thông báo", JOptionPane.WARNING_MESSAGE);
						chooserNgayVe.setDate(null); // Xóa ngày đã chọn
						return; // Thoát khỏi phương thức
					}

					// Kiểm tra nếu ngày về trước ngày đi
					if (chooserNgayVe.getDate().before(ngayDi)) {
						JOptionPane.showMessageDialog(null, "Ngày không hợp lệ! Vui lòng chọn ngày sau ngày đi.",
								"Thông báo", JOptionPane.WARNING_MESSAGE);
						chooserNgayVe.setDate(null); // Xóa ngày đã chọn
					}
				}
			}
		});

		JLabel lbl_GaDi = new JLabel("Ga Đi");
		lbl_GaDi.setBounds(24, 10, 45, 13);
		jp_Content_ThongTin.add(lbl_GaDi);

		JLabel lbl_GaDen = new JLabel("Ga Đến");
		lbl_GaDen.setBounds(21, 63, 45, 13);
		jp_Content_ThongTin.add(lbl_GaDen);

		JLabel lbl_LuaChon = new JLabel("Lựa chọn");
		lbl_LuaChon.setBounds(24, 111, 58, 13);
		jp_Content_ThongTin.add(lbl_LuaChon);

		JLabel lbl_ChonNgayDi = new JLabel("Ngày đi");
		lbl_ChonNgayDi.setBounds(21, 157, 45, 13);
		jp_Content_ThongTin.add(lbl_ChonNgayDi);

		JLabel lbl_ChonNgayVe = new JLabel("Ngày về");
		lbl_ChonNgayVe.setBounds(21, 217, 48, 13);
		jp_Content_ThongTin.add(lbl_ChonNgayVe);

		JPanel jp_Header_ThongTin = new JPanel();
		jp_Header_ThongTin.setLayout(null);
		jp_Header_ThongTin.setBackground(new Color(51, 102, 153));
		jp_Header_ThongTin.setBounds(0, 0, 244, 32);
		jp_timKiem.add(jp_Header_ThongTin);

		JLabel downIconLabel = new JLabel((Icon) null);
		downIconLabel.setBounds(0, 0, 30, 35);
		jp_Header_ThongTin.add(downIconLabel);

		JLabel lbl_tieuDeTK = new JLabel("Thông tin chuyến tàu");
		lbl_tieuDeTK.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieuDeTK.setForeground(Color.WHITE);
		lbl_tieuDeTK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTK.setBounds(0, 0, 222, 35);
		jp_Header_ThongTin.add(lbl_tieuDeTK);

		JPanel jp_GioVe = new JPanel();
		jp_GioVe.setLayout(null);
		jp_GioVe.setBackground(Color.WHITE);
		jp_GioVe.setBounds(10, 369, 244, 191);
		add(jp_GioVe);

		JPanel jp_Content_GioVe = new JPanel();
		jp_Content_GioVe.setLayout(null);
		jp_Content_GioVe.setBackground(SystemColor.controlHighlight);
		jp_Content_GioVe.setBounds(0, 31, 244, 160);
		jp_GioVe.add(jp_Content_GioVe);

		JButton btnMua = new JButton("Mua");
		btnMua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BanVeNhapThongTin_Gui banVeNhapThongTin_Gui = new BanVeNhapThongTin_Gui(BanVe_GUI.this);
				banVeNhapThongTin_Gui.setVisible(true);
			}
		});
		
		btnMua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMua.setBounds(149, 123, 85, 27);
		jp_Content_GioVe.add(btnMua);

		JPanel jp_DanhSachVe = new JPanel();
		jp_DanhSachVe.setLayout(null);
		jp_DanhSachVe.setBounds(0, 0, 244, 122);
		jp_Content_GioVe.add(jp_DanhSachVe);

		JLabel lbl_Chieu = new JLabel("Chiều đi");
		lbl_Chieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Chieu.setBounds(93, 2, 51, 23);
		jp_DanhSachVe.add(lbl_Chieu);

		// JPanel chứa các vé
		jp_VeMua = new JPanel();
		jp_VeMua.setLayout(new BoxLayout(jp_VeMua, BoxLayout.Y_AXIS));

		// Tạo JScrollPane cho jp_VeMua
		JScrollPane scrollPane = new JScrollPane(jp_VeMua);
		scrollPane.setBounds(0, 30, 244, 92);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		jp_DanhSachVe.add(scrollPane);
		
		JPanel jp_Header_GioVe = new JPanel();
		jp_Header_GioVe.setLayout(null);
		jp_Header_GioVe.setBackground(new Color(51, 102, 153));
		jp_Header_GioVe.setBounds(0, 0, 244, 32);
		jp_GioVe.add(jp_Header_GioVe);

		JLabel downIconLabel_1 = new JLabel((Icon) null);
		downIconLabel_1.setBounds(0, 0, 30, 35);
		jp_Header_GioVe.add(downIconLabel_1);

		JLabel lbl_tieuDeTK_GioVe = new JLabel("Giỏ Vé");
		lbl_tieuDeTK_GioVe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieuDeTK_GioVe.setForeground(Color.WHITE);
		lbl_tieuDeTK_GioVe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTK_GioVe.setBounds(61, 0, 121, 32);
		jp_Header_GioVe.add(lbl_tieuDeTK_GioVe);

		lblMaToa = new JLabel();
		lblMaToa.setBounds(721, 267, 272, 23);
		add(lblMaToa);
		lblMaToa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaToa.setHorizontalAlignment(SwingConstants.CENTER);

		// Thêm MouseListener vào contentPane
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Mất focus của txtUser và txtPassword khi nhấp chuột ra ngoài
				txt_GaDi.transferFocus();
				txt_GaDen.transferFocus();
			}
		});
	}

	private void suKienTrenChuyen(ChuyenTau_JPanel pChuyenTau, ChuyenTau chuyenTau) {
		// Thêm MouseListener để thay đổi con trỏ khi di chuột vào panel
		pChuyenTau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pChuyenTau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pChuyenTau.setCursor(Cursor.getDefaultCursor());
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				Toa_JPanel toaDau = new Toa_JPanel(chuyenTau.getMaTau(), 1);
				toaDau.setBounds(0, 0, 100, 72);

				// Loại bỏ panel cũ và thêm panel mới vào container
				jp_TinhTrangToa.removeAll();
				jp_TinhTrangToa.add(toaDau);

				// Cập nhật giao diện
				jp_TinhTrangToa.revalidate();
				jp_TinhTrangToa.repaint();

				ChuyenTau chuyenTau1 = chuyenTau_dao.getChuyenTauTheoMaTau(chuyenTau.getMaTau());
				int x = 102, y = 0, count = 1;
				for (Toa toa : chuyenTau1.getDsToa()) {
					Toa_JPanel pToa;
					boolean isHetSlot = toa.getDsGhe().stream().anyMatch(ghe -> !ghe.isTrangThai());
					// Tạo Toa_JPanel
					if (isHetSlot) {
						pToa = new Toa_JPanel(count++ + "", 5);
					} else if (toa.getLoaiToa().equals("VIP")) {
						pToa = new Toa_JPanel(count++ + "", 2);
					} else if (toa.getLoaiToa().equals("Giường nằm")) {
						pToa = new Toa_JPanel(count++ + "", 3);
					} else {
						pToa = new Toa_JPanel(count++ + "", 4);
					}
					pToa.setBounds(x, y, 100, 72);
					// su kien
					suKienTrenToa(pToa, toa);
					jp_TinhTrangToa.add(pToa);
					x += 102; // Điều chỉnh vị trí cho panel tiếp theo
				}

				jp_ThongTinChuyenTau.revalidate();
				jp_ThongTinChuyenTau.repaint();

				// Xử lý sự kiện khi click vào panel: thay thế bằng panel mới
				ChuyenTau_JPanel pChuyenTauMoi = new ChuyenTau_JPanel(chuyenTau);
				pChuyenTauMoi.setBounds(pChuyenTau.getBounds()); // Giữ nguyên vị trí và kích thước của panel cũ

				// Gán lại sự kiện cho panel mới
				suKienTrenChuyen(pChuyenTauMoi, chuyenTau);

				// Loại bỏ panel cũ và thêm panel mới vào container
				jp_ThongTinChuyenTau.remove(pChuyenTau);
				jp_ThongTinChuyenTau.add(pChuyenTauMoi);

				// Cập nhật giao diện
				jp_ThongTinChuyenTau.revalidate();
				jp_ThongTinChuyenTau.repaint();
			}
		});
	}

	private void suKienTrenToa(Toa_JPanel pToa, Toa toa) {
		pToa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pToa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pToa.setCursor(Cursor.getDefaultCursor());
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				lblMaToa.setText("Toa số " + pToa.getStrLabel() + ": " + toa.getLoaiToa());

				jp_TinhTrangGhe.removeAll();

				int x = 35, y = 35, count = 1;
				for (Ghe ghe : toa.getDsGhe()) {
					ImageIcon containerIcon;
					if (!ghe.isTrangThai() || ktDaDatTam(ghe)){
						containerIcon = new ImageIcon(getClass().getResource("/img/Ghe_0.png"));
					}  else {
						containerIcon = new ImageIcon(getClass().getResource("/img/Ghe_1.png"));
					}
					Image scaledContainerIcon = containerIcon.getImage().getScaledInstance(26, 42, Image.SCALE_SMOOTH);

					// Tạo một JPanel để chứa cả hình ảnh và số ghế
					JPanel pGhe = new JPanel();
					pGhe.setLayout(null);
					pGhe.setBounds(x, y, 26, 42);

					// JLabel cho hình ảnh
					JLabel containerIconLabel = new JLabel(new ImageIcon(scaledContainerIcon));
					containerIconLabel.setBounds(0, 0, 26, 42); // Đặt kích thước cho hình ảnh

					// JLabel cho số ghế
					JLabel countLabel = new JLabel(String.valueOf(count));
					countLabel.setForeground(Color.BLACK);
					countLabel.setFont(new Font("Arial", Font.BOLD, 12));
					countLabel.setHorizontalAlignment(SwingConstants.CENTER);
					countLabel.setVerticalAlignment(SwingConstants.CENTER);
					countLabel.setBounds(2, 0, 26, 42);

					pGhe.add(countLabel);
					pGhe.add(containerIconLabel);

					suKienTrenGhe(containerIconLabel, ghe);
					
					// Thêm panel vào jp_TinhTrangGhe
					jp_TinhTrangGhe.add(pGhe);
					count++;

					// Điều chỉnh vị trí cho panel tiếp theo
					if (count % 4 == 1) {
						x += 48;
						y -= 171;
					} else if (count % 4 == 3) {
						x += 0;
						y += 73;
					} else {
						x += 0;
						y += 49;
					}
					jp_TinhTrangGhe.add(pGhe);
				}

				// Cập nhật giao diện
				jp_TinhTrangGhe.revalidate();
				jp_TinhTrangGhe.repaint();

				// Xử lý sự kiện khi click vào panel: thay thế bằng panel mới
				Toa_JPanel pToaMoi = new Toa_JPanel(pToa.getStrLabel(), pToa.getLoaiToa());
				pToaMoi.setBounds(pToa.getBounds()); // Giữ nguyên vị trí và kích thước của panel cũ

				// Gán lại sự kiện cho panel mới
				suKienTrenToa(pToaMoi, toa);

				// Loại bỏ panel cũ và thêm panel mới vào container
				jp_TinhTrangToa.remove(pToa);
				jp_TinhTrangToa.add(pToaMoi);

				// Cập nhật giao diện
				jp_TinhTrangToa.revalidate();
				jp_TinhTrangToa.repaint();
			}
		});
	}

	private void suKienTrenGhe(JLabel gheLabel, Ghe ghe) {
		// Ban đầu gán hình ảnh cho ghế (có thể là Ghe_0 hoặc Ghe_1)
		gheLabel.addMouseListener(new MouseAdapter() {
			// Biến để lưu trữ trạng thái hình ảnh hiện tại
			private boolean isGhe1 = ghe.isTrangThai(); // Trạng thái ban đầu của ghế

			@Override
			public void mouseEntered(MouseEvent e) {
				gheLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				gheLabel.setCursor(Cursor.getDefaultCursor());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Chỉ cho phép tương tác nếu trạng thái ban đầu của ghế là true
				if (ghe.isTrangThai()) {
					// Thay đổi trạng thái hình ảnh giữa Ghe_1 và Ghe_0
					ImageIcon newIcon;
					if (isGhe1 || ktDaDatTam(ghe)) {
						newIcon = new ImageIcon(getClass().getResource("/img/Ghe_1.png"));
						// Nếu đang chuyển về trạng thái chưa đặt ghế, hãy loại bỏ vé vừa thêm
						dsVeDatTam.removeIf(v -> (v.getSoGhe().getSoGhe() == ghe.getSoGhe())
								&& v.getToa().getMaToa().equals(ghe.getToa().getMaToa()));
					} else {
						newIcon = new ImageIcon(getClass().getResource("/img/Ghe_0.png"));
						// Tạo vé mới
						String maVe = ve_DAO.generateMaVe();
						Toa toa = toa_DAO.getToaTheoMaToa(ghe.getToa().getMaToa());
						ChuyenTau chuyenTau = chuyenTau_dao.getChuyenTauTheoMaTau(toa.getMaTau().getMaTau());
						LocalDate ngayDi = chuyenTau.getNgayDi();
						LocalTime gioDi = chuyenTau.getGioDi();
						Ga gaDi = chuyenTau.getGaDi();
						Ga gaDen = chuyenTau.getTramDung().stream()
								.filter(ga -> ga.getDiaChi().equals(txt_GaDen.getText())).findFirst().orElse(chuyenTau.getGaDen());
						String hang = toa.getLoaiToa();
						boolean trangThai = false;
						Ve ve = new Ve(maVe, chuyenTau, toa, ghe, null, ngayDi, gioDi, gaDi, gaDen, hang, null,
								trangThai, null);
						dsVeDatTam.add(ve);
					}
					// Cập nhật trạng thái (đảo chiều)
					isGhe1 = !isGhe1;

					// Cập nhật icon mới cho JLabel
					Image scaledIcon = newIcon.getImage().getScaledInstance(26, 42, Image.SCALE_SMOOTH);
					gheLabel.setIcon(new ImageIcon(scaledIcon));

					// Cập nhật giao diện
					jp_ThongTinChuyenTau.revalidate();
					jp_ThongTinChuyenTau.repaint();
					
					//Tạo panel Vé
					jp_VeMua.removeAll();
					for (Ve ve: dsVeDatTam) {
						Ve_JPanel pVe = new Ve_JPanel(ve, dsVeDatTam, jp_VeMua);
						jp_VeMua.add(pVe);
					}
					// Điều chỉnh kích thước jp_VeMua dựa trên số lượng vé
					jp_VeMua.setPreferredSize(new Dimension(jp_VeMua.getWidth(), dsVeDatTam.size()*70)); // Điều chỉnh chiều cao tùy vào kích thước vé

					// Làm mới giao diện
					jp_VeMua.revalidate();
					jp_VeMua.repaint();
					
				} else {
					// Nếu ghế không có trạng thái true ban đầu, không làm gì
					gheLabel.setCursor(Cursor.getDefaultCursor());
				}
			}
		});
	}

	private void focusTxtField(JTextField txtField, String str) {
		txtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtField.getText().equals(str)) {
					txtField.setText("");
					txtField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtField.getText().isEmpty()) {
					txtField.setForeground(SystemColor.textInactiveText);
					txtField.setText(str);
				}
			}
		});
	}

	private void chonGa(JTextField txt_Ga) {
		// Tạo JPopupMenu để hiển thị gợi ý
		JPopupMenu suggestionMenu = new JPopupMenu();

		// Hàm cập nhật gợi ý khi người dùng nhập vào text field
		txt_Ga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String input = txt_Ga.getText();
				suggestionMenu.removeAll(); // Xóa các gợi ý cũ

				if (!input.isEmpty()) {
					int count = 0; // Biến đếm số gợi ý đã thêm
					// Lọc danh sách ga theo từ khóa người dùng nhập
					for (Ga ga : dsGa) {
						if (ga.getDiaChi().toLowerCase().startsWith(input.toLowerCase())) {
							JMenuItem item = new JMenuItem(ga.getDiaChi());
							item.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									txt_Ga.setText(item.getText());
									suggestionMenu.setVisible(false); // Ẩn gợi ý sau khi chọn
								}
							});
							suggestionMenu.add(item);
							count++; // Tăng biến đếm
						}
						if (count >= 5) { // Kiểm tra nếu đã có 5 gợi ý
							break; // Thoát vòng lặp nếu đã đủ 5 gợi ý
						}
					}
				}

				// Hiển thị danh sách gợi ý nếu có ít nhất một gợi ý
				if (suggestionMenu.getComponentCount() > 0) {
					suggestionMenu.show(txt_Ga, 0, txt_Ga.getHeight());
					txt_Ga.requestFocus(); // Đặt lại focus cho JTextField
				} else {
					suggestionMenu.setVisible(false); // Ẩn nếu không có gợi ý
				}
			}
		});
	}
	
	private boolean ktDaDatTam(Ghe ghe) {
		for (Ve ve: dsVeDatTam) {
			if (ve.getChuyenTau().getMaTau().equals(toa_DAO.getToaTheoMaToa(ghe.getToa().getMaToa()).getMaTau().getMaTau()))
				if (ve.getToa().getMaToa().equals(ghe.getToa().getMaToa()))
					if (ve.getSoGhe().getSoGhe() == ghe.getSoGhe())
						return true;
		}
		return false;
	}

	public ArrayList<Ve> getDsVeDatTam() {
		return dsVeDatTam;
	}
}
