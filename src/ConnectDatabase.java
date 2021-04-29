import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectDatabase{
	//Set Database Credentials
	private static final String URL = "jdbc:mysql://localhost/mentcare_trial";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";

	private static String msg ="";

 	static Connection conn = null;

	public static void DB_Connect(){
		try{
			// Establish Connection
			conn = DriverManager.getConnection(URL,DB_USERNAME,DB_PASSWORD);
		}
		catch (SQLException e){
			// Print Error Message
			JOptionPane.showMessageDialog(null, "Oops, Unable to Establish Connection with Database.");
			System.exit(0);
		}
	}
	
	public static void DB_Close_Connection(Connection conn, ResultSet rs, Statement st) {
		try {
			conn.close();
			st.close();
			st.close();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Oops! Unable to Close Database Connection...");
		}
	}
}