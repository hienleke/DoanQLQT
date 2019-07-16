package tier_giaodien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import entitys.Khachhang;
import tier_DAO.Hoadon_DAO;
import tier_DAO.Khachhang_DAO;
import tier_DAO.Thuoc_DAO;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;



public class thongkekh extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private DefaultListModel<String> dfl1;
	private DefaultListModel<String> dfl;
	private JList list_1;
	private JList list;
    

	



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongkekh frame = new thongkekh();
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
	public thongkekh() {
		setResizable(false);
		dfl = new DefaultListModel<>();
		dfl1 = new DefaultListModel<>();
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
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chi ti\u1EBFt giao d\u1ECBch", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_2.setBounds(530, 115, 576, 421);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 69, 546, 336);
		panel_2.add(scrollPane_1);
		
		list_1 = new JList(dfl1);
		scrollPane_1.setViewportView(list_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kh\u00E1ch h\u00E0ng :", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_3.setLayout(null);
		panel_3.setBounds(32, 115, 417, 421);
		contentPane.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 71, 387, 334);
		panel_3.add(scrollPane);
		updatedatalist();
		list = new JList(dfl);
		scrollPane.setViewportView(list);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.clearSelection();
				dfl1.removeAllElements();
			}
		});
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLmMi.setBackground(Color.LIGHT_GRAY);
		btnLmMi.setBounds(15, 34, 115, 29);
		panel_3.add(btnLmMi);

		JMenuItem mntmQunLBn = new JMenuItem("Quản lí Bán hàng");
		mntmQunLBn.setIcon(new ImageIcon("D:\\Tieu luan\\GUI JAVA\\shopping-cart-icon.png"));
		 ButtonGroup gr = new ButtonGroup();
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
			list.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					int k= list.getSelectedIndex();
					dfl1.removeAllElements();
					if(k>=0)
					{
						Hoadon_DAO hddao= new Hoadon_DAO();
						String x = (String) list.getSelectedValue();
						
						String ds[]=x.split(" ");
						String ketqua=ds[4];
						for (int i = 5; i < ds.length; i++) {
							if(ds[i].equals("SDT"))
								break;
								ketqua+=" "+ ds[i];
							
						}
				
						ArrayList<String> ds1 = hddao.getthongtintheotenkh(ketqua);
						String ten;
						for(int i=0;i<ds1.size();i++)
						{
						
						ten=ds1.get(i);
							if(i!=0)
								
								{
								String dd=ds1.get(i);
								String kq[] = dd.split(" ") ;
								
								String kq1[]=ds1.get(i-1).split(" ");
								/*for (String string : kq1) {
									System.out.println(string + "\n");
								}*/
								System.out.println("ss: "+kq[3] + "-"+ kq1[3]);
								if(kq[3].trim().equalsIgnoreCase(kq1[3].trim()))
								{
								ten= "                                                                                  Tên thuốc: " +  kq[10] + " Số lượng: "+kq[13] ;
								}
							
						}
							dfl1.addElement(ten);
						}
						list_1 = new JList<>(dfl1);
						
						
					}
					
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
	public void  updatedatalist()
	{
		Khachhang_DAO khdao = new Khachhang_DAO();
		ArrayList<Khachhang> ds =  khdao.getdatetensdt();
		for(int i=0;i<ds.size();i++)
			dfl.addElement("Tên khách hàng : "+ds.get(i).getTen() + " SDT : "+ds.get(i).getSdt());
		
	}
}

	

