package tier_giaodien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
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

import tier_DAO.Khachhang_DAO;
import tier_DAO.Thuoc_DAO;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;



public class Giaodienthongkedoanhthu extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private DefaultCategoryDataset dataset ;
	private ChartPanel chartPanel ;
	private JRadioButton rdbtnTun;
	private JRadioButton rdbtnThng;
	private JRadioButton rdbtnSLng;
    private  TablemodelThuoc tbm;


	



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giaodienthongkedoanhthu frame = new Giaodienthongkedoanhthu();
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
	public Giaodienthongkedoanhthu() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1163, 681);
		chartPanel =  new ChartPanel(createBarChart());
		chartPanel.setBackground(Color.LIGHT_GRAY);
		chartPanel.setBorder(new LineBorder(Color.BLACK));
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
		
		 chartPanel.setPreferredSize(new java.awt.Dimension(800, 367));
		
		 
		 JPanel panel_2 = new JPanel();
		 panel_2.setBounds(39, 107, 1054, 408);
		 contentPane.add(panel_2);
		 panel_2.add(chartPanel);
		 chartPanel.setLayout(null);
		 
		 JPanel panel_3 = new JPanel();
		 panel_3.setForeground(Color.BLACK);
		 panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		 panel_3.setBounds(39, 521, 1054, 104);
		 contentPane.add(panel_3);
		 panel_3.setLayout(null);
		 ButtonGroup gr = new ButtonGroup();
		 
		 JPanel panel_4 = new JPanel();
		 panel_4.setForeground(Color.LIGHT_GRAY);
		 panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Doanh thu theo:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		 panel_4.setBounds(15, 26, 311, 62);
		 panel_3.add(panel_4);
		 panel_4.setLayout(null);
		 
		 rdbtnTun = new JRadioButton("Ngày");
		 rdbtnTun.setBounds(21, 27, 61, 17);
		 panel_4.add(rdbtnTun);
		 rdbtnTun.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ArrayList<Double>  tienthuocbanra = new ArrayList<>() ;
		 		dataset.clear();
				ArrayList<Double> tienthuocnhapvao = new ArrayList<>();
				Thuoc_DAO tdao = new Thuoc_DAO();

				for(int i=0;i<5;i++)
				{
				
					tienthuocbanra.add(tdao.sotienthuoctrongngay(LocalDate.now().minusDays(i)));
					tienthuocnhapvao.add( tdao.sotienthuocnhapvaotrongngay(LocalDate.now().minusDays(i)));
				}
				for(int i=0 ;i<5;i++)
				{
					
					dataset.addValue(tienthuocbanra.get(i)/1000, "Doanh thu" ,LocalDate.now().minusDays(i).toString());
					dataset.addValue(tienthuocnhapvao.get(i)/1000, "Nhập thuốc" , LocalDate.now().minusDays(i).toString());
					dataset.addValue(tienthuocbanra.get(i)/1000*0.1, "Tiền lãi" , LocalDate.now().minusDays(i).toString());
				}
		 	}
		 });
		 rdbtnTun.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 rdbtnTun.setSelected(true);
		 gr.add(rdbtnTun);
		 
		rdbtnThng = new JRadioButton("Tháng");
		rdbtnThng.setBounds(105, 27, 89, 17);
		panel_4.add(rdbtnThng);
		rdbtnThng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					 dataset.clear();
					
					 ArrayList<Double>  tienthuocbanra1 = new ArrayList<>() ;
						
						ArrayList<Double> tienthuocnhapvao1 = new ArrayList<>();
						Thuoc_DAO tdao1 = new Thuoc_DAO();

						for(int i=0;i<5;i++)
						{
						
							tienthuocbanra1.add(tdao1.sotienthuoctrongthang(LocalDate.now().minusMonths(i)));
							tienthuocnhapvao1.add( tdao1.sotienthuocnhapvaotrongthangy(LocalDate.now().minusMonths(i)));
						}
						for(int i=0 ;i<5;i++)
						{
							
							dataset.addValue(tienthuocbanra1.get(i)/1000, "Doanh thu" ,LocalDate.now().minusMonths(i).getMonth().toString()+"/"+LocalDate.now().minusMonths(i).getYear());
							dataset.addValue(tienthuocnhapvao1.get(i)/1000, "Nhập thuốc" , LocalDate.now().minusMonths(i).getMonth().toString()+"/"+LocalDate.now().minusMonths(i).getYear());
							dataset.addValue(tienthuocbanra1.get(i)/1000*0.1, "Tiền lãi" , LocalDate.now().minusMonths(i).getMonth().toString()+"/"+LocalDate.now().minusMonths(i).getYear());
						}
					
				 	
			}
		});
		rdbtnThng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gr.add(rdbtnThng);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setForeground(Color.LIGHT_GRAY);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thu\u1ED1c theo:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_5.setBounds(341, 26, 348, 62);
		panel_3.add(panel_5);
		
		 rdbtnSLng = new JRadioButton("Số lượng");
		 rdbtnSLng.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		dataset.clear();
		 		JFreeChart jfr = createBarChartthuoc();
		 		jfr.setTitle("asdfsafasf");
		 		chartPanel = new ChartPanel(jfr);
		 		
		 		
		 		
		 	}
		 });
		rdbtnSLng.setSelected(true);
		rdbtnSLng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSLng.setBounds(21, 27, 89, 17);
		panel_5.add(rdbtnSLng);
		gr.add(rdbtnSLng);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setForeground(Color.LIGHT_GRAY);
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kh\u00E1ch h\u00E0ng theo:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel_6.setBounds(704, 26, 335, 62);
		panel_3.add(panel_6);
		
		JRadioButton rdbtnThngXuynMua = new JRadioButton("Thường xuyên mua");
		rdbtnThngXuynMua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataset.clear();
				Khachhang_DAO khdao = new Khachhang_DAO();
				ArrayList<String> ds = khdao.getdsten();
				ArrayList<Integer> dssoluong =   new ArrayList<>();
				for(int i=0 ;i<ds.size();i++)
				{
					dssoluong.add(khdao.laysolanmuatheoten(ds.get(i)));
				}
				for(int i=0 ;i<ds.size();i++)
				{
					dataset.addValue(dssoluong.get(i), "Số lần mua", ds.get(i));
				}
			}
		});
		rdbtnThngXuynMua.setSelected(true);
		rdbtnThngXuynMua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnThngXuynMua.setBounds(21, 27, 178, 17);
		panel_6.add(rdbtnThngXuynMua);
		gr.add(rdbtnThngXuynMua);
		JRadioButton rdbtnChiTrPh = new JRadioButton("Chi trả phí");
		rdbtnChiTrPh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataset.clear();
				Khachhang_DAO khdao = new Khachhang_DAO();
				ArrayList<String> ds = khdao.getdsten();
				ArrayList<Double> dssoluong =   new ArrayList<>();
				for(int i=0 ;i<ds.size();i++)
				{
					dssoluong.add(khdao.laytientheoten(ds.get(i)));
					System.out.println(ds.get(i)+ "  "+dssoluong.get(i) + "\n");
				}
				for(int i=0 ;i<ds.size();i++)
				{
					dataset.addValue(dssoluong.get(i), "Tổng tiền đã mua từ  trước đến nay", ds.get(i));
				}
			}
		});
		rdbtnChiTrPh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnChiTrPh.setBounds(206, 27, 112, 17);
		gr.add(rdbtnChiTrPh);
		panel_6.add(rdbtnChiTrPh);
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
	 private  CategoryDataset createDataset() 
	{
		 dataset = new DefaultCategoryDataset();
		ArrayList<Double>  tienthuocbanra = new ArrayList<>() ;
	
		ArrayList<Double> tienthuocnhapvao = new ArrayList<>();
		Thuoc_DAO tdao = new Thuoc_DAO();

		for(int i=0;i<5;i++)
		{
		
			tienthuocbanra.add(tdao.sotienthuoctrongngay(LocalDate.now().minusDays(i)));
			tienthuocnhapvao.add( tdao.sotienthuocnhapvaotrongngay(LocalDate.now().minusDays(i)));
		}
		for(int i=0 ;i<5;i++)
		{
			
			dataset.addValue(tienthuocbanra.get(i)/1000, "Doanh thu" ,LocalDate.now().minusDays(i).toString());
			dataset.addValue(tienthuocnhapvao.get(i)/1000, "Nhập thuốc" , LocalDate.now().minusDays(i).toString());
			dataset.addValue(tienthuocbanra.get(i)/1000*0.1, "Tiền lãi" , LocalDate.now().minusDays(i).toString());
		}
	
		
		 
		 
		 return dataset;
		
		
	}
	 public  JFreeChart createBarChart() {
	        JFreeChart barChart = ChartFactory.createBarChart(
	                "Biểu đồ so sánh  ".toUpperCase(),
	                "", "Đơn vị ",
	                createDataset(), PlotOrientation.VERTICAL, true, true, false);
	        return barChart;
	    }
	 public  JFreeChart createBarChartthuoc() {
	        JFreeChart barChart1 = ChartFactory.createBarChart(
	                "Biểu đồ so sánh số lượng thuốc ".toUpperCase(),
	                "Tên thuốc", "Số lượng",
	                createDatasetsl(), PlotOrientation.VERTICAL, true, true, false);
	        return barChart1;
	    }
	 private  CategoryDataset createDatasetsl() 
		{
	
		 Thuoc_DAO tdao = new Thuoc_DAO();
			ArrayList<String>  tenthuoc = tdao.gettenthuoc();
		
			ArrayList<Integer> sl = new ArrayList<>();
			

			for(int i=0;i<tenthuoc.size();i++)
			{
				sl.add(tdao.getsltonbyten(tenthuoc.get(i)));
			
			}
			for(int i=0;i<tenthuoc.size();i++)
			{
				
				
				dataset.addValue(sl.get(i), "Số lượng" , tenthuoc.get(i));
		
			}
		
			
			 return dataset;
			
			
		}
}

	

