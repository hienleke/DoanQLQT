package tier_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_Tier.Ketnoicsdl;
import entitys.Nhacungcap;

public class Nhacungcap_DAO {
	public Nhacungcap_DAO() {

	}
	
	

	public ArrayList<Nhacungcap> getdatafromnhacungcap() {
		
		ArrayList<Nhacungcap> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("Select * from ncc");
			while (rs.next()) {
				String ma = rs.getString(3);
				String ten = rs.getString(1);
				String diachi = rs.getString(2);
				ds.add(new Nhacungcap(ma, ten, diachi));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;

	}
	public ArrayList<Nhacungcap> Timkiem(String id) {
		
		ArrayList<Nhacungcap> ds = new ArrayList<>();
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("Select * from ncc where ma like '%"+id+"%'");
		
			ResultSet rs = sta.executeQuery();
			
			while (rs.next()) {
				String ma = rs.getString(3);
				String ten = rs.getString(1);
				String diachi = rs.getString(2);
				ds.add(new Nhacungcap(ma, ten, diachi));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		return ds;

	}
	public boolean them (Nhacungcap add)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		int n=0;
		try {
			sta = con .prepareStatement("insert into ncc values(?,?,?)");
			
			sta.setString(3, add.getMa());
			sta.setString(1, add.getTen());
			sta.setString(2 ,add.getDiachi());
			 n = sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(n>0)
			return true;
			return false;
		
	}
	
	public boolean capnhat (Nhacungcap add)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n=0;
		PreparedStatement sta;
		try {
			sta = con .prepareStatement("update ncc set TENNCC=?, DIACHI =?, MA=? where ma = ? ");
			
				sta.setString(3, add.getMa());
				sta.setString(1, add.getTen());
				sta.setString(2 ,add.getDiachi());
				sta.setString(4 ,add.getMa());
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
	public boolean xoa (String id)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n=0;
		PreparedStatement sta;
		try {
			sta = con .prepareStatement("delete from ncc  where ma = ?");
			
				sta.setString(1, id);
				 n = sta.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(n>0)
			return true;
		return false;
	}
}
