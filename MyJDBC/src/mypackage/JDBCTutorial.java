package mypackage;

public class JDBCTutorial {
		public static void main(String[] args)
		{
			DatabaseCRUD ob = new DatabaseCRUD();
//			ob.createTable();
//			ob.createData(103, "Ragesh", "ragesh@gmail.com");
			ob.readData();
//			ob.updateData(103, "Vansh");
			ob.deleteData(102);
			ob.readData();
		}
}
