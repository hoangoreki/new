package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
	public static  Connection getConnection() throws SQLException{
		try {
			Connection cons = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cons = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=ShopSach;user=sa;password=123456;encrypt=true;trustServerCertificate=true;");
			return cons;
		}catch(ClassNotFoundException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE,null,ex);
		}
		return null;
	}
	public static void main(String[] args)throws SQLException {
		Connection c = getConnection();
		System.out.print(c.toString());
		c.close();
	}
}
