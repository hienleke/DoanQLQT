package tier_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_Tier.Ketnoicsdl;
import entitys.Nhanvien;

public class Nhanvien_DAO {
	Nhanvien_DAO() {

	}
	public boolean  them1nhanvien(Nhanvien x)
	{
		int n=0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("insert into Nhanvien values (?,?)");
			sta.setString(1, x.getMa());
			sta.setString(2, x.getTen());
			n=sta.executeUpdate();
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
	public boolean  xoa1nhanvien(String id)
	{
		int n=0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("delete from  Nhanvien  where MANHANVIEN = ?");
			sta.setString(1, id);
			n=sta.executeUpdate();
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
	public boolean capnhat(Nhanvien x)
	{
		int n=0;
		Connection con = Ketnoicsdl.thietlapketnoi();
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("update Nhanvien set Manhanvien= ?, Tennhanvien=?  where MANHANVIEN = ?");
			sta.setString(1,x.getMa());
			sta.setString(2, x.getTen());
			sta.setString(3, x.getMa());
			n=sta.executeUpdate();
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
	public ArrayList<Nhanvien> getdatafromnhanvientable()
	{
		ArrayList<Nhanvien> ds = new ArrayList<>();
		Connection con  = Ketnoicsdl.thietlapketnoi();
		Statement sta;
		try {
			sta = con .createStatement();
			ResultSet rs = sta.executeQuery("Select *  from Nhanvien");
			
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				ds.add(new Nhanvien(ma, ten));
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

}
