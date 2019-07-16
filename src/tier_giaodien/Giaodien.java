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
import java.awt.FlowLayout;

public class Giaodien extends javax.swing.JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private TablemodelThuoc thuocmodel;
	private DefaultListModel<String> dfl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giaodien frame = new Giaodien();
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

	public Giaodien() {
		this.setLocationRelativeTo(null);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 72, 1157, 569);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(39, 30, 519, 485);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		
		
		JLabel lblChngTrnhQun = new JLabel("Chương trình quản lý quầy thuốc");
		lblChngTrnhQun.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblChngTrnhQun.setBounds(27, 86, 420, 49);
		panel_3.add(lblChngTrnhQun);
		
		JLabel lblLKHin = new JLabel("Lê Kế Hiền");
		lblLKHin.setForeground(new Color(112, 128, 144));
		lblLKHin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblLKHin.setBounds(27, 162, 296, 49);
		panel_3.add(lblLKHin);
		
	
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(588, 30, 542, 495);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Ke Hien Le\\Documents\\Eclipse\\DoanQLQT2\\libs\\Doctor-icon.png"));
		lblNewLabel_2.setBounds(0, 0, 542, 495);
		panel_4.add(lblNewLabel_2);

		JMenuItem mntmQunLBn = new JMenuItem("Quản lí Bán hàng");
		mntmQunLBn.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\shopping-cart-icon.png"));
		
		


		thuocmodel = new TablemodelThuoc();

		ButtonGroup bgroup = new ButtonGroup();

		dfl = new DefaultListModel<>();
	
		mntmBnThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Giaodienbanthuoc gd = new Giaodienbanthuoc();
				gd.setVisible(false);
			setContentPane(gd.getContentPane());
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
}