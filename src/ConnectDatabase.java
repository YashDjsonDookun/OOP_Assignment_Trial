import java.sql.*;

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
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(URL,DB_USERNAME,DB_PASSWORD);
			// Print message to show successful Connection
			msg = "Database Connection: Established Successfully";
			System.out.println(msg+"\n");
		}
		catch (SQLException e){
			// Print Error Message
			System.err.print("Unexpected Failure!!\nCould not establish connection to DataBase...\n");
			System.err.println("Please check whether the Localhost server was Activated!");
			System.err.println("Error Message: " + e);
			System.exit(0);
		}
	}
	
	public static void DB_Close_Connection(Connection conn, ResultSet rs, Statement st) {
		try {
			conn.close();
			st.close();
			st.close();
			msg = "Database Connection: Closed!";
			System.out.println(msg+"\n");
		}
		catch(SQLException e) {
			
		}
	}
}