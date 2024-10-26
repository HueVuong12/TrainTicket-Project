package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;

public class BanVeNhapThongTin_Gui extends JPanel implements ActionListener{
	
	private JTable table;
	private JLabel goBackIconLabel;
	private JLabel lbl_quayLai;
	private JPanel jp_KHMV;
	private JTabbedPane tabbedPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_KHMV;
	private JPanel jp_KHSDV;
	
	public BanVeNhapThongTin_Gui(BanVe_GUI banVe_GUI,TrangChu_GUI trangChu) {
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
				trangChu.content.removeAll();
				trangChu.content.add(banVe_GUI);
				trangChu.content.revalidate();
				trangChu.content.repaint();
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(260, 15, 300, 25);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(945, 15, 300, 25);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(945, 53, 300, 25);
		panel_2.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 123, 1335, 259);
		jp_KHMV.add(scrollPane);
		
		table_KHMV = new JTable();
//		table_KHMV.setFont(new Font("Tahoma", Font, 16));
		scrollPane.setViewportView(table_KHMV);
		table_KHMV.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Lê Tấn Phong","Sinh Viên", "Thông tin chỗ", "551,000 VND", "0", "551,000 VND", "Xóa"}
			},
			new String[] {
				"STT", "Khách hàng", "Đối tượng", "Thông tin chỗ", "Giá", "Giảm đối tượng", "Thành tiền", ""
			}
		));
	    table_KHMV.setRowHeight(30); // Set chiều cao hàng
		// Đặt renderer và editor cho nút xóa
        table_KHMV.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        table_KHMV.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
		
        // Tạo JComboBox cho cột "Trạng Thái"
        JComboBox<String> comboBoxKhuyenMai = new JComboBox<>();
        comboBoxKhuyenMai.addItem("Sinh Viên");
        comboBoxKhuyenMai.addItem("Trẻ Em");
        comboBoxKhuyenMai.addItem("Cao Tuổi");

        // Lấy cột "Trạng Thái" từ bảng
        TableColumn khuyenMaiColumn = table_KHMV.getColumnModel().getColumn(2); // 9 là chỉ số của cột "Trạng Thái"
        // Thiết lập JComboBox làm editor cho cột "Trạng Thái"
        khuyenMaiColumn.setCellEditor(new DefaultCellEditor(comboBoxKhuyenMai));
     // Thiết lập renderer cho cột để hiển thị JComboBox
        khuyenMaiColumn.setCellRenderer(new ComboBoxRenderer(comboBoxKhuyenMai));
        
        
        
		jp_KHSDV = new JPanel();
		jp_KHSDV.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Khách hàng mua vé", null, jp_KHSDV, null);
		jp_KHSDV.setLayout(null);
		
	}
	// lớp ComboBoxRenderer như sau để làm renderer cho cột:
	class ComboBoxRenderer extends JComboBox<String> implements TableCellRenderer {
	    public ComboBoxRenderer(JComboBox<String> comboBox) {
	        super();
	        for (int i = 0; i < comboBox.getItemCount(); i++) {
	            this.addItem(comboBox.getItemAt(i));
	        }
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        if (isSelected) {
	            setBackground(table.getSelectionBackground());
	        } else {
	            setBackground(table.getBackground());
	        }
	        setSelectedItem(value);
	        return this;
	    }
	}
	// Editor cho nút xóa
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private JTable table;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("Xóa");
            button.setOpaque(true);
            button.setBackground(Color.RED);
            button.setForeground(Color.WHITE);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        ((DefaultTableModel) table.getModel()).removeRow(row);
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.table = table;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Xóa";
        }

        @Override
        public boolean stopCellEditing() {
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}