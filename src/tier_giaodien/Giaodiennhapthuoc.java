package tier_giaodien;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entitys.Hoadon;
import entitys.Khachhang;
import entitys.Nhanvien;
import entitys.Thuoc;
import tier_DAO.CT_hoadonDAO;
import tier_DAO.Hoadon_DAO;
import tier_DAO.Khachhang_DAO;
import tier_DAO.Thuoc_DAO;
import java.awt.SystemColor;

public class Giaodiennhapthuoc extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private TablemodelThuoc thuocmodel;
	private JTextField textField;
	private Choice choice;
	private DefaultListModel<String> dfl;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                    
					Giaodiennhapthuoc frame = new Giaodiennhapthuoc();
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
	public Giaodiennhapthuoc() {
	
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
		mntmKtThc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = JOptionPane.showConfirmDialog(null, "Bạn có muống đóng chương trình");
				if (k==0)
					System.exit(1);
				
			}
		});
		mntmKtThc.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\Cross-icon.png"));
		menu.add(mntmKtThc);

		JMenuItem mntmQunLBn = new JMenuItem("Quản lí Bán hàng");
		mntmQunLBn.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\shopping-cart-icon.png"));
		
		


		thuocmodel = new TablemodelThuoc();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin chi ti\u1EBFt",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_2.setBounds(15, 109, 328, 510);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		ButtonGroup bgroup = new ButtonGroup();

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.BLACK);
		panel_3.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch thu\u1ED1c nh\u1EADp v\u00E0o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		panel_3.setBounds(358, 109, 695, 510);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 138, 612, 228);
		panel_3.add(scrollPane);

		dfl = new DefaultListModel<>();
		JList list = new JList(dfl);

		scrollPane.setViewportView(list);

		JButton btnThmVo = new JButton("Thêm vào");
		btnThmVo.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\magnifying-glass-icon.png"));

		btnThmVo.setHorizontalAlignment(SwingConstants.LEFT);
		btnThmVo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnThmVo.setBackground(Color.LIGHT_GRAY);
		btnThmVo.setBounds(32, 62, 115, 29);
		panel_3.add(btnThmVo);

		textField = new JTextField();

		textField.setBounds(454, 96, 76, 26);
		panel_3.add(textField);
		textField.setColumns(10);

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				textField.setText(String.valueOf(value));
			}
		});
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(454, 34, 190, 20);
		panel_3.add(lblNewLabel_1);
		slider.setValue(0);
		slider.setBounds(454, 62, 190, 26);
		panel_3.add(slider);

		JLabel lblSLng = new JLabel("Số lượng ");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSLng.setBounds(360, 64, 69, 20);
		panel_3.add(lblSLng);
	

		JButton btnBRa = new JButton("Bỏ ra");
		btnBRa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = list.getSelectedIndex();
				if (k < 0) {
					lblNewLabel_1.setText("Chọn 1 mục để  bỏ ra");
					return;
				} else {
					dfl.remove(k);
				}
			}
		});
		btnBRa.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\Database-Remove-icon.png"));
		btnBRa.setHorizontalAlignment(SwingConstants.LEFT);
		btnBRa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBRa.setBackground(Color.LIGHT_GRAY);
		btnBRa.setBounds(32, 103, 115, 29);
		panel_3.add(btnBRa);

		choice = new Choice();
		updatechoice();

		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String ten = choice.getSelectedItem().trim();
				Thuoc_DAO tdao = new Thuoc_DAO();
				lblNewLabel_1.setText("");
				int maxium = tdao.getsltonbyten(ten);
				list.clearSelection();
				slider.setMaximum(maxium);
				slider.setValue(0);

			}
		});

		choice.setBounds(183, 62, 120, 26);
		panel_3.add(choice);
		JLabel lblGiTr = new JLabel("Giá trị");
		lblGiTr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGiTr.setBounds(360, 100, 69, 20);
		panel_3.add(lblGiTr);

		JButton btnTinHnhBn = new JButton("Tiến hành nhập thuốc vào kho");
		btnTinHnhBn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("");
				
				int conf = JOptionPane.showConfirmDialog(null, "Xác nhận nhập thuốc vào kho thuốc?");
			
					if (conf == 0) {
							Khachhang kh = new Khachhang("KH11111");
							int k = dfl.getSize();
							double thanhtien =0;
							Hoadon_DAO hdao = new Hoadon_DAO();
							ArrayList<String> ds = hdao.getmahoadon();

							int ma;
							do {
								Random r = new Random();
								ma = r.nextInt(99999);
							} while (ds.contains("HD"+String.valueOf(ma)));

							CT_hoadonDAO ctdao = new CT_hoadonDAO();
							Hoadon hd = new Hoadon("HD" + String.valueOf(ma), LocalDate.now(), new Nhanvien("NV12345"),
									kh);
							hdao.themhoadon(hd);

							for (int i = 0; i < k; i++) {
								list.setSelectedIndex(0);
								String ten = choice.getSelectedItem().trim();
								int sl = Integer.valueOf(textField.getText().trim());
								Thuoc_DAO tdao = new Thuoc_DAO();

								boolean xn = tdao.capnhatsoluongtheoten(ten, -sl);
								if (xn) {
									ctdao.them("HD" + String.valueOf(ma), tdao.getmathuocthuocbyten(ten), sl);
									lblNewLabel_1.setText("Đã cập nhật thành công vào kho");
									thanhtien+=sl*tdao.gettientheoma(tdao.getmathuocthuocbyten(ten));
									btnBRa.doClick();
								} else
									lblNewLabel_1.setText("Cập nhật không thành công");

							}
							
							hdao.capnhaththanhtienchohoadon(thanhtien, "HD" + String.valueOf(ma));
						


					} else if (conf == 1 || conf == 2)
						return;
				

			}
		});
		btnTinHnhBn.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\cart-go-icon.png"));
		btnTinHnhBn.setHorizontalAlignment(SwingConstants.LEFT);
		btnTinHnhBn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTinHnhBn.setBackground(Color.LIGHT_GRAY);
		btnTinHnhBn.setBounds(32, 390, 226, 29);
		panel_3.add(btnTinHnhBn);

		btnThmVo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String add = "Tên thuốc :  " + choice.getSelectedItem() + "     Số lượng:  " + textField.getText();

				String batdau = "Tên thuốc :  ";
				int index1 = batdau.length();
				String kt = "Tên thuốc :  " + choice.getSelectedItem();
				int index2 = kt.length() + 1;
				System.out.println(dfl.size());
				int k = list.getSelectedIndex();
				if (k < 0) {
					for (int i = 0; i < dfl.getSize(); i++) {

						if (dfl.getElementAt(i).indexOf(choice.getSelectedItem()) >= 0) {
							lblNewLabel_1.setText("Thuốc đã có trong danh sách");
							return;
						}

					}
					lblNewLabel_1.setText("");
					dfl.addElement(add);
				} else {
					for (int i = 0; i < dfl.getSize(); i++) {

						if (dfl.getElementAt(i).indexOf(choice.getSelectedItem()) >= 0) {

							lblNewLabel_1.setText("Thay đổi số lượng thành công");
							dfl.setElementAt(add, i);
							return;
						}

					}

				}
			}

		});
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				String chuoi = (String) list.getSelectedValue();
				Thuoc_DAO tdao = new Thuoc_DAO();
				int kiemtra = -1;
				ArrayList<Thuoc> ds = tdao.getdatafromThuoctable();
				int k = list.getSelectedIndex();

				if (k >= 0) {
					for (int i = 0; i < ds.size(); i++) {
						kiemtra = chuoi.indexOf(ds.get(i).getTenthuoc());
						if (kiemtra != -1) {
							String x = "Tên thuốc :  " + ds.get(i).getTenthuoc() + "     Số lượng:  ";
							String sl = chuoi.substring(x.length(), chuoi.length());
							System.out.println(Integer.valueOf(sl));
							choice.select(i);
							slider.setValue(Integer.valueOf(sl));
						}

					}

				}

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

	public void updatechoice() {
		Thuoc_DAO tdao = new Thuoc_DAO();

		ArrayList<String> ds = tdao.gettenthuoc();
		for (String x : ds)
			choice.add(x);
	}



	
}
