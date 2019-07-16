package tier_giaodien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entitys.Danhmucthuoc;
import entitys.Danhmucthuoc;
import entitys.Danhmucthuoc;
import tier_DAO.Danhmucthuoc_DAO;
import tier_DAO.Danhmucthuoc_DAO;
import tier_DAO.Danhmucthuoc_DAO;

public class Giaodienquanlidanhmuc extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTable table;
	private tablemodelqldanhmuc thuocmodel;
	private JTextField textField_3;
	private JTextField textField_10;
	private JLabel lblNewLabel_2;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giaodienquanlidanhmuc frame = new Giaodienquanlidanhmuc();
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
	public Giaodienquanlidanhmuc() {
	
		setResizable(false);

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
		

		thuocmodel = new tablemodelqldanhmuc();
		table = new JTable(thuocmodel);
		table.setBackground(SystemColor.control);
		table.setBounds(0, 0, 1, 1);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(SystemColor.controlText));
		scrollPane.setBounds(371, 109, 771, 354);
		contentPane.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin chi ti\u1EBFt",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_2.setBounds(15, 109, 322, 510);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chi ti\u1EBFt Lo\u1EA1i thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_3.setBounds(15, 27, 292, 169);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTn = new JLabel("Tên ");
		lblTn.setBounds(15, 69, 33, 27);
		panel_3.add(lblTn);
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("Mã ");
		lblNewLabel_1.setBounds(15, 25, 21, 20);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(51, 75, 226, 27);
		panel_3.add(textField_3);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setColumns(10);
		textField.setBounds(51, 22, 226, 27);
		panel_3.add(textField);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ch\u1EE9c n\u0103ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_7.setBounds(371, 479, 771, 124);
		contentPane.add(panel_7);
		panel_7.setLayout(null);

		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField_10.getText().trim();
				Danhmucthuoc_DAO tdao = new Danhmucthuoc_DAO();
				ArrayList<Danhmucthuoc> ds = tdao.Timkiem(id);
				ArrayList<Danhmucthuoc> ds1 = tdao.getdatafromnhacungcap();

				if (ds.size() < 0)
					lblNewLabel_2.setText("Không tìm thấy");
				else {
					thuocmodel = new tablemodelqldanhmuc(ds);
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
				int n = table.getSelectedRow();
				if (n < 0) {
					lblNewLabel_2.setText("Vui lòng chọn dòng trên bảng để xóa");
				} else {
					lblNewLabel_2.setText("");
					Danhmucthuoc t = getdatafrominput();
					Danhmucthuoc_DAO tdao = new Danhmucthuoc_DAO();

					if (t != null) {
						if (tdao.xoa(t.getMadm())) {
							lblNewLabel_2.setText("Xóa thành công");
							thuocmodel = new tablemodelqldanhmuc();
							table.setModel(thuocmodel);
						}

						else
							lblNewLabel_2.setText("Xóa không thành công");
					}

				}

			}

		});

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = table.getSelectedRow();
				if (n < 0) {
					lblNewLabel_2.setText("Vui lòng chọn 1 dòng trên bảng để cập nhật");
				} else {
					lblNewLabel_2.setText("");
					Danhmucthuoc t = getdatafrominput();
					Danhmucthuoc_DAO tdao = new Danhmucthuoc_DAO();
					if (t != null) {
						if (tdao.capnhat(t)) {
							lblNewLabel_2.setText("Cập nhật thành công");
							thuocmodel = new tablemodelqldanhmuc();
							table.setModel(thuocmodel);
						}

						else
							lblNewLabel_2.setText("Cập nhật không thành công");
					}

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

				textField_3.setText("");
		
				textField_10.setText("");
				textField.setEditable(true);

				thuocmodel = new tablemodelqldanhmuc();
				table.setModel(thuocmodel);
			}
		});

		btnXaTrng.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\empty.png"));
		btnXaTrng.setHorizontalAlignment(SwingConstants.LEFT);
		btnXaTrng.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnXaTrng.setBackground(Color.LIGHT_GRAY);
		btnXaTrng.setBounds(462, 35, 115, 29);
		panel_7.add(btnXaTrng);

		btnThm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Danhmucthuoc t = getdatafrominput();

				boolean k = false;
				if (t != null) {
					Danhmucthuoc_DAO tdao = new Danhmucthuoc_DAO();
					k = tdao.them(t);

					if (k) {

						lblNewLabel_2.setText("Thêm thành công");
						thuocmodel = new tablemodelqldanhmuc();
						table.setModel(thuocmodel);
						textField.setEditable(true);
						textField.setEditable(true);

					} else {
						lblNewLabel_2.setText("Thêm không thành công");
						textField.setEditable(true);
						textField.setEditable(true);
					}
				}

			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow(); // Lấy dòng được chọn
				fillForm(row); // Hiển thị trên các components
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

	public void fillForm(int row) {
		if (row != -1) {
			String ma = (String) table.getValueAt(row, 0);
			System.out.println(ma);
			Danhmucthuoc_DAO d = new Danhmucthuoc_DAO();
		
		
			ArrayList<Danhmucthuoc> ds = d.Timkiem(ma);
		

			if (ds.size() >0 ) {
				Danhmucthuoc t = ds.get(0);
				textField_3.setText(t.getMadm());

				textField.setText(t.getLoaithuoc());

			

		

			}

		}
	}

	public Danhmucthuoc getdatafrominput() {
		String ma = textField.getText().trim();
		String ten = textField_3.getText().trim();
	

		if (!ma.matches("DM[0-9]{5}")) {

			lblNewLabel_2.setText("Mã Danh mục phải bắt đầu bằng kí tự NCC theo sau là 5 chữ số");
			textField.requestFocus();
			return null;
		}

		if (!ten.matches(
				"([ẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴắằẳẵặăấầẩẫậâáàãảạđếềểễệêéèẻẽẹíìỉĩịốồổỗộôớờởỡợơóòõỏọứừửữựưúùủũụýỳỷỹỵa-zA-Z0-9']+[ ]?)+")) {
			lblNewLabel_2.setText("Tên loại thuốc gồm kí số hoặc'cách nhau bởi khoảng trắng");
			textField_3.requestFocus();
			return null;

		}
		
	
		return new Danhmucthuoc(ten, ma);

	}
}
