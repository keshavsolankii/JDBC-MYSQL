package imagepackage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.JFileChooser;
import java.sql.Connection;

public class UploadImage {
	public void uploadImage()
	{
		try {
			Connection con = CreateConnection.getConnection();
			String query = "insert into image(pic) values(?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			JFileChooser jfc = new JFileChooser();
			
			jfc.showOpenDialog(null);
			
			File file = jfc.getSelectedFile();
			FileInputStream fis = new FileInputStream(file);
			
			ps.setBinaryStream(1, fis, fis.available());
			ps.executeUpdate();
			
			System.out.println("Image uploaded successfully!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		UploadImage ui = new UploadImage();
		ui.uploadImage();
	}
}
