package data_Tier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ketnoicsdl {
	static Connection con = null;
	
   public static Connection thietlapketnoi(){
	 
	try {
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String URL="jdbc:sqlserver://JAVADEV\\SQLEXPRESS:1433;databaseName=QLQT;integratedSecurity=true";
		con =DriverManager.getConnection(URL,"sa","123");
		System.out.println("Ket  noi thanh cong");
		
		
	} catch (Exception e) {
		System.out.println("ket noi that bai ");
		System.out.println(e.getMessage()+e.getClass() );
		
	}
	return con;
	
}
   public static void dongketnoi() {
		try {
			con.close();
			System.out.println("Dong ket noi thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
	}
}
   



