package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	Connection c = null;
	
	public DBConnection() {}
	
	public Connection connDb(){
		
		try {
			this.c=DriverManager.getConnection("jdbc:mysql://localhost:3306/patients?user=root&password=180200");
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return c; 
	}
	
}
