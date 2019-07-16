package tier_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_Tier.Ketnoicsdl;
import entitys.Danhmucthuoc;
import entitys.Nhacungcap;
import entitys.Danhmucthuoc;

public class Danhmucthuoc_DAO {
	public Danhmucthuoc_DAO()
	{
		
	}
public ArrayList<Danhmucthuoc> getdatafromnhacungcap() {
		
		ArrayList<Danhmucthuoc> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("Select * from danhmuc");
			while (rs.next()) {
				String ma = rs.getString(2);
				String ten = rs.getString(1);
				
				ds.add(new Danhmucthuoc(ma, ten));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;

	}
	public ArrayList<Danhmucthuoc> Timkiem(String id) {
		
		ArrayList<Danhmucthuoc> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("Select * from danhmuc where madm like '%"+id+"%'");
	
			ResultSet rs = sta.executeQuery();
			
			while (rs.next()) {
				String ma = rs.getString(2);
				String ten = rs.getString(1);

				ds.add(new Danhmucthuoc(ma, ten));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;

	}
	public boolean capnhat (Danhmucthuoc add)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n=0;
		PreparedStatement sta;
		try {
			sta = con .prepareStatement("update  Danhmuc set TENDM=?, MADM=? where MADM = ? ");
			
				sta.setString(3,add.getMadm());
				sta.setString(1, add.getLoaithuoc());
				sta.setString(2 ,add.getMadm());
			
				
				 n = sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			finally {
				Ketnoicsdl.dongketnoi();
			}
		
		
		if(n>0)
			return true;
		return false;
	}
	public boolean them (Danhmucthuoc add)
	{
		int n =0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("insert into Danhmuc values (?,?)");
			sta.setString(1, add.getLoaithuoc());
			sta.setString(2, add.getMadm());
			n=sta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (n>0)
			return true;
		return false;
	}
	public boolean xoa(String ma)
	{
		int n =0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("delete from Danhmuc where MADM=?");
			sta.setString(1, ma);
	
			n=sta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (n>0)
			return true;
		return false;
	}
	
}
