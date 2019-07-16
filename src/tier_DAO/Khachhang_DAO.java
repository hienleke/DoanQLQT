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
import entitys.Khachhang;

public class Khachhang_DAO {
	public Khachhang_DAO()
	{
		
	}
	public ArrayList<Khachhang> getdatefromkhachhangtable()
	{
		ArrayList<Khachhang> ds = new ArrayList<Khachhang>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("Select distinct(ten) from khachhang");
			while(rs.next())
			{
				String ma =rs.getString(1);
				String ten=rs.getString(2);
				String sdt = rs.getString(3);
				ds.add(new Khachhang(ma,ten,sdt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ds;
		
	}
	public boolean  themkhachhang(Khachhang add)
	{
		Connection con  = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("insert into Khachhang values (?,?,?)");
			sta.setString(1, add.getMa());
			sta.setString(2, add.getTen());
			sta.setString(3, add.getSdt());
			sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return  true;
		
	}
	public boolean xoa (String id)
	{
		Connection con =Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("delete from khachhang where id =?");
			sta.setString(1, id);
			sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return true;
		
	}
	public boolean capnhat (Khachhang x)
	{
		Connection con  = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("update  Khachhang set values (?,?,?) where makh= ?");
			sta.setString(1, x.getMa());
			sta.setString(2, x.getTen());
			sta.setString(3,x.getSdt());
			sta.setString(4, x.getMa());
			sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return  true;
		
	}
	public ArrayList<String> getmakh ()
	{
		ArrayList<String > ds = new ArrayList<>();
		Connection  con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("Select makh from khachhang");
			
			while(rs.next())
			{
				
				String makh= rs.getString(1);
				ds.add(makh);
			
		
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return ds;
	}
	public int getluongkhachhangtheongay(LocalDate l)
	{
		int luongkh =0;
		Connection con =  Ketnoicsdl.thietlapketnoi();
		try {
			//PreparedStatement sta= con.prepareStatement("select count(*) from hoadon where [NGAYLAP] =  (SELECT CONVERT(date, getdate())) and (KHACHHANG != 'KH11111' or KHACHHANG is null)");
			//sta.setDate(1, Date.valueOf(l));
			Statement sta= con.createStatement();
			//ResultSet rs  =sta.executeQuery();
			ResultSet rs =sta.executeQuery("select count(*) from hoadon where [NGAYLAP] =  (SELECT CONVERT(date, getdate())) and (KHACHHANG != 'KH11111' or KHACHHANG is null)");
			luongkh=rs.getInt(0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return luongkh;
				
	}
	public ArrayList<String> getdsten()
	{
		ArrayList<String> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("Select distinct(ten) from khachhang");
			while(rs.next())
			{
				
				String ten=rs.getString(1);
				
				ds.add(ten);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ds;
		
	}
	public int laysolanmuatheoten(String ten)
	{
		int sl=0;
		Connection con =Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("select ten ,count(ten) from khachhang kh join hoadon hd on kh.makh =hd.khachhang where  ten = ? group by ten");
			sta.setString(1, ten);
			ResultSet rs = sta.executeQuery();
			while(rs.next())
			sl = rs.getInt(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return sl;
	}
	
	
			
			public double laytientheoten(String ten)
	{
		double sl=0;
		Connection con =Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("select ten,sum(THANHTIEN) from khachhang kh join hoadon hd on kh.makh =hd.khachhang  where ten = ? group by ten");
			sta.setString(1, ten);
			ResultSet rs = sta.executeQuery();
			while(rs.next())
			sl = rs.getDouble(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return sl;
	}
			public ArrayList<Khachhang> getdatetensdt()
			{
				ArrayList<Khachhang> ds = new ArrayList<Khachhang>();
				Connection con = Ketnoicsdl.thietlapketnoi();
				Statement sta;
				try {
					sta = con.createStatement();
					ResultSet rs = sta.executeQuery("Select distinct ten, sdt from khachhang");
					while(rs.next())
					{
					
						String ten=rs.getString(1);
						String sdt = rs.getString(2);
						ds.add(new Khachhang(ten,sdt));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return ds;
				
			}
}
