package Data;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private String hostName = "127.0.0.1:1433";
//    private String dbName = "ShopSach";
//    private String username = "sa";
//    private String password = "123456";
//
//    private String connectionURL = "jdbc:sqlserver://"+hostName + ";databaseName=" + dbName 
//    		+ ";user=" + username + ";password=" + password + ";encrypt=true;trustServerCertificate=true;";
//
//    public  Connection connect(){
//        //Tạo đối tượng Connection
//        Connection conn = null;
//
//        try {
//        	System.out.println("Connect url: " + connectionURL);
//            conn = DriverManager.getConnection(connectionURL);
//            System.out.println("Kết nối thành công");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
// 
//        return conn;
//    }
//	public static void main(String[] args) throws SQLException {
//		DBConnect dbconn = new DBConnect();
//		Connection conn = dbconn.connect();
//	}
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
