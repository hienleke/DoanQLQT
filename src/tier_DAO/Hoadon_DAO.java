package tier_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import data_Tier.Ketnoicsdl;
import entitys.Hoadon;
import entitys.Khachhang;
import entitys.Nhanvien;

public class Hoadon_DAO {

	public Hoadon_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Hoadon> getdatafromhoadontable() {
		ArrayList<Hoadon> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("Select * from hoadon");
			while (rs.next()) {
				String ma = rs.getString(1);
				LocalDate ngaylap = rs.getDate(2).toLocalDate();
				String manv = rs.getString(3);
				String makh = rs.getString(4);
				double thanhtien =rs.getFloat(5);
				ds.add(new Hoadon(ma, ngaylap, new Nhanvien(manv), new Khachhang(makh),thanhtien));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return ds;

	}
	public ArrayList<String> getmahoadon() {
		ArrayList<String> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("Select mahoadon from hoadon");
			while (rs.next()) {
				String ma = rs.getString(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return ds;

	}
	public Hoadon timkiem (String id)
	{
		
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		Hoadon ds=null;
		try {
			sta = con.prepareStatement("Select * from hoadon where = ? ");
			sta.setString(1, id);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				LocalDate ngaylap = rs.getDate(2).toLocalDate();
				String manv = rs.getString(3);
				String makh = rs.getString(4);
				ds = new Hoadon(ma, ngaylap, new Nhanvien(manv), new Khachhang(makh));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return ds;
		
	}
	public boolean  themhoadon(Hoadon add)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n=0;
		PreparedStatement sta;
		
		try {
			sta = con.prepareStatement("insert into Hoadon values(?,?,?,?,?)");
			sta.setString(1, add.getMahoadon());
			sta.setDate(2, Date.valueOf(add.getNgaylaphoadon()));
			sta.setString(3, "NV55555");
			sta.setString(4, add.getKh().getMa());
			sta.setDouble(5, add.getTongtien());
			n =sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		if(n>0)
			return true;
		return false;
		
	}
	public boolean capnhaththanhtienchohoadon(double thanhtien,String mahoadon)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n=0;
		try {
			PreparedStatement sta = con.prepareStatement("update Hoadon set thanhtien = '"+ thanhtien+"' where mahoadon='"+mahoadon+"'");
			n=sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(n>0)
			return true;
		
		return false;
	}
	public int laytongsothuocdamua(String ten )
	{
		int sl = 0 ;
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select sum (sldatmua) from HOADON  hd join CT_HOADON ct on ct.MAHOADON=hd.MAHOADON join KHACHHANG kh on kh.MAKH=hd.KHACHHANG where TEN ='"+ten +"'");
			while (rs.next()) {
				sl = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return sl;

	}
	
	public ArrayList<String> getthongtintheotenkh(String ten)
	{
		int k=0;
		ArrayList<String> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		try {
			PreparedStatement sta = con.prepareStatement("select hdon.MAHOADON,ngaylap,SLDATMUA,TENTHUOC,THANHTIEN from khachhang  kh join HOADON hdon  on kh.MAKH= hdon.KHACHHANG  join CT_HOADON cthd  on cthd.MAHOADON=hdon.MAHOADON join thuoc t on cthd.MATHUOC=t.MATHUOC where ten= ?");
			sta.setString(1, ten.trim());
			ResultSet rs = sta.executeQuery();
			while(rs.next())
			{
				
				ds.add("Giao dịch : "+ rs.getString(1) + " Ngày mua: " + rs.getDate(2).toString() +" \n Tên thuốc: " + rs.getString(4) + " Số lượng: " + rs.getInt(3) +" Thành tiền:  "+  rs.getDouble(5) );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
		
	}
	
	

}
