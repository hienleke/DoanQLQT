package tier_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import data_Tier.Ketnoicsdl;
import entitys.Danhmucthuoc;
import entitys.Nhacungcap;
import entitys.Thuoc;

public class Thuoc_DAO {
	public Thuoc_DAO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Thuoc> getdatafromThuoctable()
	{
		ArrayList<Thuoc> danhsach = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		String sql =" Select * from Thuoc";
		try {
			Statement statement = con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next())
			{
				String ma = rs.getString(4);
				
				String donvi=rs.getString(3);
				
				String tenthuoc=rs.getString(5);
				String mancc=rs.getString(1);
				String madm = rs.getString(6);
				Date hsd = rs.getDate(7);
				LocalDate hansudung = hsd.toLocalDate();
				int slton = rs.getInt(8);
		
				double dongia = rs.getDouble(2);
				//String tenncc=
				//String diachincc=
				Nhacungcap ncc = new Nhacungcap(mancc);
				Danhmucthuoc dmt = new  Danhmucthuoc(madm);
				Thuoc t = new  Thuoc(ma, donvi, tenthuoc, ncc, hansudung,dmt, dongia,slton);
				danhsach.add(t);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return danhsach;
	}
	public boolean  themthuoc(Thuoc add)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n=0;
		PreparedStatement sta ;
		try {
			sta = con.prepareStatement("insert into Thuoc values(?,?,?,?,?,?,?,?)");
			sta.setString(1, add.getNhacungcap().getMa());
			sta.setDouble(2, add.getDongia());
			sta.setString(3, add.getDonvi());
			sta.setString(4, add.getMa());
			sta.setString(5, add.getTenthuoc());
			sta.setString(6,add.getDmt().getMadm());
			sta.setInt(8, add.getSltonkho());
			LocalDate hsd = add.getHansudung();
			
			sta.setDate(7, Date.valueOf(hsd));
			n= sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false ;
			
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		if (n>0)
		return true;
		return false;
		
		
	}
	public ArrayList<Thuoc> timkiem (String id)
	{
		ArrayList<Thuoc> ds = new  ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		try {
			PreparedStatement sta = con.prepareStatement("Select * from Thuoc where TENTHUOC like '%"+ id +"%'" );
			// sta.setString(1, id);
			 ResultSet rs = sta.executeQuery();
			while (rs.next())
			{
				String ma = rs.getString(4);
				
				String donvi=rs.getString(3);
				
				String tenthuoc=rs.getString(5);
				String mancc=rs.getString(1);
				String madm = rs.getString(6);
				Date hsd = rs.getDate(7);
				LocalDate hansudung = hsd.toLocalDate();
				double dongia = rs.getDouble(2);
				//String tenncc=
				//String diachincc=
				Nhacungcap ncc = new Nhacungcap(mancc);
				Danhmucthuoc dmt = new  Danhmucthuoc(madm);
				int slton = rs.getInt(8);
				Thuoc t = new  Thuoc(ma, donvi, tenthuoc, ncc, hansudung,dmt, dongia,slton);
				ds.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return ds;
		
	}
	public ArrayList<Thuoc> timkiemhethan ()
	{
		ArrayList<Thuoc> ds = new  ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		try {
		Statement sta = con.createStatement();
		
			 ResultSet rs = sta.executeQuery("Select * from Thuoc where hansd <  (SELECT FORMAT(GetDate(), 'yyyy-MM-dd'))");
			while (rs.next())
			{
				String ma = rs.getString(4);
				
				String donvi=rs.getString(3);
				
				String tenthuoc=rs.getString(5);
				String mancc=rs.getString(1);
				String madm = rs.getString(6);
				Date hsd = rs.getDate(7);
				LocalDate hansudung = hsd.toLocalDate();
				double dongia = rs.getDouble(2);
				//String tenncc=
				//String diachincc=
				Nhacungcap ncc = new Nhacungcap(mancc);
				Danhmucthuoc dmt = new  Danhmucthuoc(madm);
				int slton = rs.getInt(8);
				Thuoc t = new  Thuoc(ma, donvi, tenthuoc, ncc, hansudung,dmt, dongia,slton);
				ds.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return ds;
		
	}
	public boolean Capnhat(Thuoc add)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n =0 ;
		try {
			PreparedStatement sta = con.prepareStatement(" update Thuoc set [MANCC]= ? ,[DONGIA]=? ,[DONVI]=? ,[TENTHUOC]= ?,[MADM]=?,[HANSD]=?,SLKHO=? where [MATHUOC]=? ");
			
		
			 sta.setString(1, add.getNhacungcap().getMa());
				sta.setDouble(2, add.getDongia());
				sta.setString(3, add.getDonvi());
				sta.setString(8, add.getMa());
				sta.setString(4, add.getTenthuoc());
				sta.setString(5,add.getDmt().getMadm());
				sta.setInt(7, add.getSltonkho());
				LocalDate hsd = add.getHansudung();
				
				sta.setDate(6, Date.valueOf(hsd));
				n= sta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
			if(n>0)
		return true;
			return false;
	}
	public boolean xoa (String id )
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int  n=0;
		try {
			
			PreparedStatement sta = con.prepareStatement("Delete  from Thuoc where MAthuoc =?");
			sta.setString(1, id);
			 n = sta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		if (n>0)
				return true;
		return false;
	}
	/*public static void main(String[] args) {
		Thuoc_DAO d = new Thuoc_DAO();
		
		LocalDate x  = LocalDate.of(2025, 10, 28);
		Thuoc t = new  Thuoc("TH00002", "150gam", "Paracetamo", new Nhacungcap("NCC0002"), x,new Danhmucthuoc("DM00002"), 100000.0);
		//boolean k  =  d.xoa("TH00002");
		 d.themthuoc(t);
		System.out.println(  );
		
	}*/
	public  int getsltonbyten(String ten)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		int sl=0;
		try {
			sta = con.prepareStatement("Select SLkho from thuoc where tenthuoc='"+ten+"'");
			ResultSet rs = sta.executeQuery();
			while(rs.next())
			{
				sl+=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
		return sl;
	}
	public ArrayList<String> gettenthuoc()
	{
		ArrayList<String> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs =sta.executeQuery("Select * from thuoc");
			while(rs.next())
			{
				ds.add(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return ds;
		
	}
	public String getmathuocthuocbyten(String ten)
	{
		String id ="";
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs =sta.executeQuery("Select mathuoc from thuoc where tenthuoc='"+ten+"'");
			while(rs.next())
				id = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		if(id.length()>0)
		return id;
		return null;
		
	}
	public boolean capnhatsoluongtheoten(String  ten , int slmatdi)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n =0 ;
		try {
			PreparedStatement sta = con.prepareStatement(" update Thuoc set SLKHO=SLKHO-("+slmatdi+") where [TENTHUOC]= ? ");
			
		
			 sta.setString(1, ten);
				
				n= sta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
		finally {
			Ketnoicsdl.dongketnoi();
		}
			if(n>0)
		return true;
			return false;
	}
	public double  gettientheoma(String id)
	{
		double tien =0 ;
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs =sta.executeQuery("Select dongia from thuoc where mathuoc='"+id+"'");
			while(rs.next())
				tien = rs.getDouble(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		return tien;
	
	}
	public double sotienthuoctrongngay(LocalDate l)
	{
		 
		double tien = 0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs =sta.executeQuery("select sum([THANHTIEN])from hoadon where NGAYLAP= '"+l.toString()+"' and (khachhang != 'KH11111' or Khachhang is null )");
			while(rs.next())
				tien = rs.getDouble(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		return tien;
		
	}
	public double sotienthuocnhapvaotrongngay(LocalDate l)
	{
		LocalDate local =  LocalDate.now();
		double tien = 0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs =sta.executeQuery("select sum([THANHTIEN])from hoadon where NGAYLAP=  '"+l.toString()+"' and khachhang = 'KH11111'");
			while(rs.next())
				tien = rs.getDouble(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		return tien;
		
	}
	public double sotienthuoctrongthang(LocalDate l)
	{
		 
		double tien = 0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs =sta.executeQuery("select sum([THANHTIEN])from hoadon where month(NGAYLAP)= '"+l.getMonthValue()+"' and (khachhang != 'KH11111' or Khachhang is null )");
			while(rs.next())
				tien = rs.getDouble(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		return tien;
		
	}
	public double sotienthuocnhapvaotrongthangy(LocalDate l)
	{
		LocalDate local =  LocalDate.now();
		double tien = 0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs =sta.executeQuery("select sum([THANHTIEN])from hoadon where month(NGAYLAP)=  '"+l.getMonthValue()+"' and khachhang = 'KH11111'");
			while(rs.next())
				tien = rs.getDouble(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		return tien;
		
	}
	
}
