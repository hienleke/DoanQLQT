package tier_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_Tier.Ketnoicsdl;

public class CT_hoadonDAO {
	
	public CT_hoadonDAO()
	{
		
	}
	public boolean them (String mahoadon, String mathuoc ,int soluong)
	{
		Connection con = Ketnoicsdl.thietlapketnoi();
		int n ;
		PreparedStatement sta;
		try {
			sta = con.prepareStatement("insert into ct_hoadon values (?,?,?)");
			sta.setString(3, mathuoc);
			sta.setString(2, mahoadon);
			sta.setInt(1, soluong);
			 n = sta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return false;
		}
		if(n>0)
		return true;
		return false;
	}
}
