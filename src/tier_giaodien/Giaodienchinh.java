package tier_giaodien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entitys.Danhmucthuoc;
import entitys.Nhacungcap;
import entitys.Thuoc;
import tier_DAO.Danhmucthuoc_DAO;
import tier_DAO.Nhacungcap_DAO;
import tier_DAO.Thuoc_DAO;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MenuDragMouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Giaodienchinh extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTable table;
	private TablemodelThuoc thuocmodel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_9;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_5;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giaodienchinh frame = new Giaodienchinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public Giaodienchinh() {
		setResizable(false);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1163, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1157, 74);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(new Color(0, 0, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Hệ thống");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setBounds(214, 0, 231, 42);
		panel_1.add(lblNewLabel);
		
		JLabel lblQunLQuy = new JLabel("Quản lí quầy thuốc");
		lblQunLQuy.setFont(new Font("Arial", Font.BOLD, 16));
		lblQunLQuy.setForeground(new Color(240, 255, 255));
		lblQunLQuy.setBounds(214, 32, 162, 42);
		panel_1.add(lblQunLQuy);
			
			JPanel panel = new JPanel();
			panel.setBounds(14, 12, 43, 62);
			panel_1.add(panel);
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(Color.GRAY);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JMenu menu = new JMenu("");
		menu.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\menu.png"));

		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);
		menuBar.add(menu);

		JMenu mnNewMenu = new JMenu("Quản Lí");
		mnNewMenu.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\applications-icon.png"));
		menu.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Thuốc");
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\Syringe-icon.png"));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Nhà cung cấp");
		mntmNewMenuItem_1.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\industry-icon.png"));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmDanhMc = new JMenuItem("Danh mục");
		mntmDanhMc.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\plaster-icon.png"));
		mnNewMenu.add(mntmDanhMc);

		JMenu mnNewMenu_1 = new JMenu("Bán Hàng");
		mnNewMenu_1.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\shopping-cart-icon.png"));
		menu.add(mnNewMenu_1);

		JMenuItem mntmBnThuc = new JMenuItem("Bán thuốc");
		mntmBnThuc.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\pill-icon.png"));
		mnNewMenu_1.add(mntmBnThuc);

		JMenuItem mntmNhpThuc = new JMenuItem("Nhập thuốc");
		mntmNhpThuc.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\ambunance-1-icon.png"));
		mnNewMenu_1.add(mntmNhpThuc);

		JMenu mnThngK = new JMenu("Thống Kê");
		mnThngK.setIcon(
				new ImageIcon("D:\\Tieu luan\\GUI JAVA\\Mimetypes-gnome-mime-application-vnd-lotus-1-2-3-icon.png"));
		menu.add(mnThngK);

		JMenuItem mntmKhchHng = new JMenuItem("Khách hàng");
		mntmKhchHng.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\User-icon.png"));
		mnThngK.add(mntmKhchHng);

		JMenuItem mntmDoanhThu = new JMenuItem("Doanh thu");
		mntmDoanhThu.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\Statistics-icon.png"));
		mnThngK.add(mntmDoanhThu);

		JMenuItem mntmKtThc = new JMenuItem("Kết Thúc");
		mntmKtThc.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\Cross-icon.png"));
		menu.add(mntmKtThc);

		JMenuItem mntmQunLBn = new JMenuItem("Quản lí Bán hàng");
		mntmQunLBn.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\shopping-cart-icon.png"));
		



		thuocmodel = new TablemodelThuoc();
		table = new JTable(thuocmodel);
	
		table.setBackground(SystemColor.control);
		table.setBounds(0, 0, 1, 1);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(SystemColor.controlText));
		scrollPane.setBounds(371, 109, 771, 354);
		contentPane.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_2.setBounds(15, 109, 322, 510);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Chi ti\u1EBFt thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_3.setBounds(15, 27, 292, 165);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTn = new JLabel("Tên ");
		lblTn.setBounds(15, 58, 21, 14);
		panel_3.add(lblTn);
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Mã ");
		lblNewLabel_1.setBounds(15, 22, 21, 20);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblnGi = new JLabel("Đơn Giá");
		lblnGi.setBounds(132, 16, 48, 20);
		panel_3.add(lblnGi);
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblnV = new JLabel("Đơn vị");
		lblnV.setBounds(132, 47, 36, 20);
		panel_3.add(lblnV);
		lblnV.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblHnSDng = new JLabel("Hạn sử dụng");
		lblHnSDng.setBounds(15, 79, 69, 28);
		panel_3.add(lblHnSDng);
		lblHnSDng.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(40, 22, 82, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(176, 22, 101, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(176, 47, 101, 20);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(40, 47, 82, 20);
		panel_3.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(111, 83, 166, 20);
		panel_3.add(textField_4);
		
		JLabel lblNewLabel_3 = new JLabel("Số lượng tồn kho");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(15, 111, 94, 20);
		panel_3.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_5.setColumns(10);
		textField_5.setBounds(111, 111, 166, 20);
		panel_3.add(textField_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chi ti\u1EBFt nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_4.setBounds(15, 208, 292, 142);
		panel_2.add(panel_4);
		
		JLabel label_1 = new JLabel("Tên ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(15, 69, 21, 14);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("Mã ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(15, 27, 21, 20);
		panel_4.add(label_2);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblaCh.setBounds(15, 99, 45, 20);
		panel_4.add(lblaCh);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_8.setColumns(10);
		textField_8.setBounds(51, 62, 226, 28);
		panel_4.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField_9.setColumns(10);
		textField_9.setBounds(51, 96, 227, 28);
		panel_4.add(textField_9);
		
		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String id = (String) comboBox.getSelectedItem();
				
				Nhacungcap_DAO  mccdao = new Nhacungcap_DAO();
				
				textField_8.setText(mccdao.Timkiem(id).get(0).getTen());
				textField_9.setText(mccdao.Timkiem(id).get(0).getDiachi());
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox.setBounds(51, 23, 226, 28);
		//updatecombobox();
		panel_4.add(comboBox);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chi ti\u1EBFt lo\u1EA1i thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_5.setBounds(15, 355, 292, 139);
		panel_2.add(panel_5);
		
		JLabel label = new JLabel("Tên ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(15, 61, 21, 14);
		panel_5.add(label);
		
		JLabel label_3 = new JLabel("Mã ");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(15, 25, 21, 20);
		panel_5.add(label_3);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_7.setColumns(10);
		textField_7.setBounds(51, 61, 226, 33);
		panel_5.add(textField_7);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String id = (String) comboBox_1.getSelectedItem();
				Danhmucthuoc_DAO dmdao = new Danhmucthuoc_DAO();
				
				textField_7.setText(dmdao.Timkiem(id).get(0).getMadm());
				
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_1.setBounds(51, 22, 226, 33);
		panel_5.add(comboBox_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_7.setBounds(371, 479, 771, 124);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField_10.getText().trim();
				Thuoc_DAO tdao = new Thuoc_DAO();
				ArrayList<Thuoc> ds = tdao.timkiem(id);
				ArrayList<Thuoc> ds1 = tdao.getdatafromThuoctable();
				
				if(ds.size()<0)
					lblNewLabel_2.setText("Không tìm thấy");
				else 
				{
					thuocmodel = new  TablemodelThuoc(ds);
					table.setModel(thuocmodel);
				}
				
			}
		});
		btnTmKim.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\find.png"));
		btnTmKim.setBackground(Color.LIGHT_GRAY);
		btnTmKim.setHorizontalAlignment(SwingConstants.LEFT);
		btnTmKim.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTmKim.setBounds(15, 78, 115, 29);
		panel_7.add(btnTmKim);
		
		textField_10 = new JTextField();
		textField_10.setBounds(169, 78, 262, 28);
		panel_7.add(textField_10);
		textField_10.setColumns(10);
		
		 lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(462, 80, 294, 20);
		panel_7.add(lblNewLabel_2);
		
		JButton btnThm = new JButton("Thêm");
		
		btnThm.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\magnifying-glass-icon.png"));
		btnThm.setHorizontalAlignment(SwingConstants.LEFT);
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnThm.setBackground(Color.LIGHT_GRAY);
		btnThm.setBounds(15, 32, 115, 29);
		panel_7.add(btnThm);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\delete.png"));
		btnXa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnXa.setBackground(Color.LIGHT_GRAY);
		btnXa.setBounds(169, 32, 115, 29);
		panel_7.add(btnXa);
		btnXa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n= table.getSelectedRow() ;
				if (n<0)
				{
					lblNewLabel_2.setText("Vui lòng chọn dòng trên bảng để xóa");
				}
				else
				{
					lblNewLabel_2.setText("");
					Thuoc t = getdatafrominput();
					Thuoc_DAO tdao= new Thuoc_DAO();
					
					if(t!=null)
					{	if(tdao.xoa(t.getMa()))
							{
							lblNewLabel_2.setText("Xóa thành công");
							thuocmodel = new TablemodelThuoc();
							table.setModel(thuocmodel);
							}
							
					else lblNewLabel_2.setText("Xóa không thành công không thành công");}
					
					
				}
				
				
			}
				
			
		});
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n= table.getSelectedRow() ;
				if (n<0)
				{
					lblNewLabel_2.setText("Vui lòng chọn 1 dòng trên bảng để cập nhật");
				}
				else
				{
					lblNewLabel_2.setText("");
					Thuoc t = getdatafrominput();
					Thuoc_DAO tdao= new Thuoc_DAO();
					if(t!=null)
					{	if(tdao.Capnhat(t))
							{
							lblNewLabel_2.setText("Cập nhật thành công");
							thuocmodel = new TablemodelThuoc();
							table.setModel(thuocmodel);
							}
							
					else lblNewLabel_2.setText("Cập nhật không thành công");}
					
					
				}
				
				
			}
		});
		btnCpNht.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\update.png"));
		btnCpNht.setHorizontalAlignment(SwingConstants.LEFT);
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCpNht.setBackground(Color.LIGHT_GRAY);
		btnCpNht.setBounds(317, 33, 115, 29);
		panel_7.add(btnCpNht);
		
		JButton btnXaTrng = new JButton("Làm mới");
		btnXaTrng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField.setEditable(true);
				table.clearSelection();
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_10.setText("");
				textField_5.setText("");
				textField.setEditable(true);
				getdataforcombobox();
				thuocmodel = new TablemodelThuoc();
				table.setModel(thuocmodel);
			}
		});
		getdataforcombobox();
		
		btnXaTrng.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\empty.png"));
		btnXaTrng.setHorizontalAlignment(SwingConstants.LEFT);
		btnXaTrng.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnXaTrng.setBackground(Color.LIGHT_GRAY);
		btnXaTrng.setBounds(462, 35, 115, 29);
		panel_7.add(btnXaTrng);
		
		JButton btnLcThucHt = new JButton("Lọc thuốc hết hạn");
		btnLcThucHt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thuoc_DAO tdao = new  Thuoc_DAO();
			
				ArrayList<Thuoc> ds = tdao.timkiemhethan();
				ArrayList<Thuoc> ds1 = tdao.getdatafromThuoctable();
				
				if(ds.size()<0)
					lblNewLabel_2.setText("Không tìm thấy");
				else 
				{
					thuocmodel = new  TablemodelThuoc(ds);
					table.setModel(thuocmodel);
				}
				
			}
		});
		btnLcThucHt.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\Calendar-icon.png"));
		btnLcThucHt.setHorizontalAlignment(SwingConstants.LEFT);
		btnLcThucHt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLcThucHt.setBackground(Color.LIGHT_GRAY);
		btnLcThucHt.setBounds(592, 35, 164, 29);
		panel_7.add(btnLcThucHt);
		
		btnThm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Thuoc t = getdatafrominput();
				boolean k = false  ;
				if(t!=null)
				{
					Thuoc_DAO tdao = new Thuoc_DAO();
					k = tdao.themthuoc(t);
				}
					if (k) {
						
						
						lblNewLabel_2.setText("Thêm thành công");
						thuocmodel = new TablemodelThuoc();
						table.setModel(thuocmodel);
						textField.setEditable(true);
						
					}
					else  {lblNewLabel_2.setText("Thêm không thành công");
					textField.setEditable(true);}
						
				
			}
		});
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow(); //Lấy dòng được chọn
				fillForm(row); //Hiển thị trên các components
				textField.setEditable(false);
				
			}
		});
		
		mntmBnThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Giaodienbanthuoc gd = new Giaodienbanthuoc();
				//gd.setVisible(false);
			dispose();
			}
		});
		
		mntmNhpThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Giaodiennhapthuoc gd = new  Giaodiennhapthuoc();
			//	gd.setVisible(false);
				dispose();
			}
		});
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Giaodienchinh gd = new Giaodienchinh();
				gd.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Giaodienqlnhacungcap gd = new Giaodienqlnhacungcap();
				gd.setVisible(true);
				dispose();
			}
		});
		mntmDanhMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Giaodienquanlidanhmuc gd = new Giaodienquanlidanhmuc();
				gd.setVisible(true);
				dispose();
			}
		});
		mntmKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongkekh gd = new thongkekh();
				gd.setVisible(true);
				dispose();
			
			}
		});
		mntmDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Giaodienthongkedoanhthu gd = new Giaodienthongkedoanhthu();
				gd.setVisible(true);
				dispose();
			}
		});
		mntmKtThc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = JOptionPane.showConfirmDialog(null, "Bạn có muống đóng chương trình");
				if (k==0)
					System.exit(1);
				
			}
		});
		setVisible(true);
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public void fillForm(int row)
	{
		if(row != -1){
			String ma= (String) table.getValueAt(row, 0);
			Thuoc_DAO d = new Thuoc_DAO();
			Nhacungcap_DAO nccdao = new Nhacungcap_DAO();
			Danhmucthuoc_DAO dmtdao = new Danhmucthuoc_DAO();
			ArrayList<Thuoc> ds = d.timkiem(ma);
			
			
			if(ds!=null)
			{
				Thuoc t = ds.get(0);
				textField.setText(t.getMa());
				textField_1.setText(String.valueOf(t.getDongia()));
				textField_3.setText(t.getTenthuoc());
				textField_2.setText(t.getDonvi());
				textField_4.setText(t.getHansudung().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				//textField_5.setText(t.getNhacungcap().getMa());
				updatecombobox(t.getNhacungcap().getMa());
				ArrayList<Nhacungcap> ds1 = nccdao.Timkiem(t.getNhacungcap().getMa());
			
				textField_8.setText(ds1.get(0).getTen());
				textField_9.setText(ds1.get(0).getDiachi());
				ArrayList<Danhmucthuoc> ds2 = dmtdao.Timkiem(t.getDmt().getMadm());
				textField_7.setText(ds2.get(0).getMadm());
				updatecombobox_1(t.getDmt().getMadm());
				textField_5.setText(String.valueOf(t.getSltonkho()));
				
				//textField_6.setText(ds2.get(0).getLoaithuoc());
				
			}
				
		}
	}
	public void  updatecombobox(String id)
	{
		Nhacungcap_DAO nccdao = new Nhacungcap_DAO();
		ArrayList<Nhacungcap> dsncc = nccdao.getdatafromnhacungcap();
		String dsmancc[] = new String[dsncc.size()];
		int k=0,vt = 0;
		for (int i=0;i<dsmancc.length;i++)
				{
					if(dsncc.get(i).getMa().equalsIgnoreCase(id))
						vt=i;
					dsmancc[i]=dsncc.get(i).getMa();
				}
		comboBox.setModel(new DefaultComboBoxModel<String>(dsmancc));
		comboBox.setSelectedIndex(vt);
			
	}
	
	public void  updatecombobox_1(String id)
	{
		Danhmucthuoc_DAO dmtdao = new Danhmucthuoc_DAO();
		ArrayList<Danhmucthuoc>  dsncc = dmtdao.getdatafromnhacungcap();
		
		String dsmancc[] = new String[dsncc.size()];
		int k=0,vt = 0;
		for (int i=0;i<dsmancc.length;i++)
				{
					if(dsncc.get(i).getLoaithuoc().equalsIgnoreCase(id))
						vt=i;
					dsmancc[i]=dsncc.get(i).getLoaithuoc();
				}
		comboBox_1.setModel(new DefaultComboBoxModel<String>(dsmancc));
		comboBox_1.setSelectedIndex(vt);
			
	}
	public Thuoc getdatafrominput()
	{
		String mathuoc = textField.getText().trim();
		String tenthuoc=textField_3.getText().trim();
		String hansudung=textField_4.getText().trim();
		String dongia=textField_1.getText().trim();
		String donvi =textField_2.getText().trim();
		LocalDate localDate =LocalDate.now() ;
		String slton = textField_5.getText().trim();
		int sl =0;
		if(!mathuoc.matches("TH[0-9]{5}"))
		{
			lblNewLabel_2.setText("Mã thuốc phải bắt đầu bằng kí tự TH theo sau là 5 chữ số");
			textField.requestFocus();
			return null;
		}
		if(!tenthuoc.matches("([a-zA-Z0-9']+[ ]?)+"))
		{
			lblNewLabel_2.setText("Tên thuốc gồm kí số hoặc'cách nhau bởi khoảng trắng");
			textField_3.requestFocus();
			return null;
		}
		if(!donvi.matches("([a-zA-Z0-9']+[ ]?)+"))
		{
			lblNewLabel_2.setText("Đơn vị  gồm kí số hoặc'cách nhau bởi khoảng trắng");
			textField_2.requestFocus();
			return null;
		}
		if(!dongia.matches("(\\d)+|([\\d.])+"))
				{
				lblNewLabel_2.setText("Đơn giá là chuỗi các chữ số ");
				textField_1.requestFocus();
				return null;
				
				}
		else if (Double.valueOf(dongia)<0) {
			lblNewLabel_2.setText("Đơn giá phải là số nguyên dương");
			return null;
		}
		if(!hansudung.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$"))	
		{
				lblNewLabel_2.setText("Ngày tháng năm  phải có  dạng dd/mm/yyy");
				textField_4.requestFocus();
				return null;
					
		}
		else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			 localDate = LocalDate.parse(hansudung, formatter);
		
			if(localDate.isBefore(LocalDate.now()))
			{
				
				lblNewLabel_2.setText("Hạn sử dụng phải sau ngày hiện tại");
				textField_4.requestFocus();
				return null;
				
			}
		}
		if(!slton.matches("(\\d)+"))
		{
			lblNewLabel_2.setText("Số lượng tồn kho phải là chuỗi chữ số");
			textField_5.requestFocus();
			return null;
			
		}
		else 
		{
			sl = Integer.valueOf(slton);
			if(sl<0)
				return null;
		}
		return new Thuoc(mathuoc, donvi, tenthuoc, new Nhacungcap((String)comboBox.getSelectedItem()), localDate, new Danhmucthuoc((String)comboBox_1.getSelectedItem()), Double.valueOf(dongia),sl);
		
	}
	public void getdataforcombobox()
	{
		Danhmucthuoc_DAO dmtdao = new Danhmucthuoc_DAO();
		ArrayList<Danhmucthuoc>  dsncc = dmtdao.getdatafromnhacungcap();
		
		String dsmancc[] = new String[dsncc.size()];
		int k=0,vt = 0;
		for (int i=0;i<dsmancc.length;i++)
				{
				
					
					dsmancc[i]=dsncc.get(i).getLoaithuoc();
				}
		comboBox_1.setModel(new DefaultComboBoxModel<String>(dsmancc));
		comboBox_1.setSelectedIndex(0);
		
		
		Nhacungcap_DAO nccdao = new Nhacungcap_DAO();
		ArrayList<Nhacungcap> dsncc1 = nccdao.getdatafromnhacungcap();
		String dsmancc1[] = new String[dsncc1.size()];

		for (int i=0;i<dsmancc1.length;i++)
				{
					
					dsmancc1[i]=dsncc1.get(i).getMa();
				}
		comboBox.setModel(new DefaultComboBoxModel<String>(dsmancc1));
		comboBox.setSelectedIndex(0);
		
	
	}
}
