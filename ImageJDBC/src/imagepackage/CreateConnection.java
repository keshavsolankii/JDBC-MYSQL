package imagepackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	private static Connection con;

	public static Connection getConnection() {
		try {
			if (con == null) {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keshav", "root", "root");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args)
	{
		
	}
}
