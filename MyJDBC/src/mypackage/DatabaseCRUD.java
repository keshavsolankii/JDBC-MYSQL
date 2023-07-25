package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseCRUD {
	public void createDatabase()
	{
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String password = "root";

			Connection con = DriverManager.getConnection(url, userName, password);
			Statement st = con.createStatement();
			String query = "create database keshavsolanki";
			st.execute(query);

			System.out.println("Database created successfully!");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void createTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String dbName = "keshavsolanki";
			String password = "root";

			Connection con = DriverManager.getConnection(url+dbName, userName, password);
			Statement st = con.createStatement();
			String query = "create table StudentInfo (sid int(2), name varchar(100),email varchar(100))";
			st.execute(query);

			System.out.println("Table created successfully!");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createData(int roll, String name, String mail) {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String dbName = "keshavsolanki";
			String password = "root";

			Connection con = DriverManager.getConnection(url+dbName, userName, password);
			String query = "insert into StudentInfo (sid, name, email) VALUES (?, ?, ?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, roll);
			pst.setString(2, name);
			pst.setString(3, mail);
			
			pst.execute();
//			pst.executeUpdate(); // works  as same as execute() method
//			pst.executeQuery();  // This method is only used when query returns something
			
			System.out.println("Data created/updated successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readData()
	{
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String dbName = "keshavsolanki";
			String password = "root";

			Connection con = DriverManager.getConnection(url+dbName, userName, password);
			String query = "select * from StudentInfo";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("Roll number : " + rs.getInt(1));
				System.out.println("Name : " + rs.getString(2));
				System.out.println("E-mail : " + rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(int roll, String name) {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String dbName = "keshavsolanki";
			String password = "root";

			Connection con = DriverManager.getConnection(url+dbName, userName, password);
			String query = "update StudentInfo set name = ? where sid = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(2, roll);
			pst.setString(1, name);
			
			pst.execute();
//			pst.executeUpdate(); // works  as same as execute() method
//			pst.executeQuery();  // This method is only used when query returns something
			
			System.out.println("Data updated successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(int roll) {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String dbName = "keshavsolanki";
			String password = "root";

			Connection con = DriverManager.getConnection(url+dbName, userName, password);
			String query = "delete from studentinfo where sid = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, roll);
			
			pst.execute();
			
			System.out.println("Data deleted successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
	}
}
