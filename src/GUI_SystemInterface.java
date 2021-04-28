import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GUI_SystemInterface {
	
	public GUI_SystemInterface(String getDoctorID_Parameter) {
		/*
		 * Create Frame
		 */
		JFrame frame = new JFrame();
		
		/*
		 * Frame Properties
		 */	
		frame.setTitle("Mentcare System");
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setMinimumSize(new Dimension(900, 808));
		
		/*
		 * Create Components
		 */
		JPanel Panel_Title = new JPanel();
		JPanel Panel_DoctorInfo = new JPanel();
		
		JLabel lbl_TitleLabel = new JLabel("Mentcare System");
		JLabel lbl_DoctorInfo = new JLabel("     Doctor Info:         ");
		JLabel lbl_Date = new JLabel("        Date:  "+LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"     ");
		
		JTextField txt_DoctorID = new JTextField();
		JTextField txtDoctorFirstName = new JTextField();
		JTextField txtDoctorLastName = new JTextField();
		JTextField txt_Category = new JTextField();
		JTextField txt_ClearanceLevel = new JTextField();
		
		/*
		 * Add Components To Frame
		 */
		frame.getContentPane().add(Panel_Title, BorderLayout.NORTH);
		
		/*
		 * Panel Properties
		 */
		// Panel_Title
		Panel_Title.setLayout(new BorderLayout(0, 0));
		
		// Panel_DoctorInfo
		Panel_DoctorInfo.setLayout(new GridLayout(5, 0, 0, 2));
		
		/*
		 * Add Components To Panels
		 */
		// Panel_Title
		Panel_Title.add(lbl_TitleLabel, BorderLayout.NORTH);
		Panel_Title.add(lbl_DoctorInfo, BorderLayout.WEST);
		Panel_Title.add(lbl_Date, BorderLayout.EAST);
		Panel_Title.add(Panel_DoctorInfo, BorderLayout.CENTER);
		
		// Panel_DoctorInfo
		Panel_DoctorInfo.add(txt_DoctorID);
		Panel_DoctorInfo.add(txtDoctorFirstName);
		Panel_DoctorInfo.add(txtDoctorLastName);
		Panel_DoctorInfo.add(txt_Category);
		Panel_DoctorInfo.add(txt_ClearanceLevel);
		
		
		/*
		 * Components Properties 
		 */
		AssignDoctorInfo(getDoctorID_Parameter, txt_DoctorID, txtDoctorFirstName, txtDoctorLastName, txt_Category, txt_ClearanceLevel);
		
		// lbl_TitleLabel
		lbl_TitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lbl_TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);		
		
		// lbl_DoctorInfo
		lbl_DoctorInfo.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_DoctorInfo.setHorizontalAlignment(SwingConstants.TRAILING);
	
		// lbl_Date
		lbl_Date.setFont(new Font("Arial", Font.PLAIN, 19));

		// txt_DoctorID
		txt_DoctorID.setEditable(false);
		txt_DoctorID.setColumns(10);
		
		// txtDoctorFirstName
		txtDoctorFirstName.setEditable(false);
		txtDoctorFirstName.setColumns(10);
		
		// txtDoctorLastName
		txtDoctorLastName.setEditable(false);
		txtDoctorLastName.setColumns(10);
		
		// txt_Category
		txt_Category.setEditable(false);
		txt_Category.setColumns(10);
		
		// txt_ClearanceLevel
		txt_ClearanceLevel.setEditable(false);
		txt_ClearanceLevel.setColumns(10);
	
		/*
		 * Functionality
		 */
		

	}
	
	void AssignDoctorInfo(String docID_Parameter, JTextField docID, JTextField docFirstName, JTextField docLastName, JTextField docCategory, JTextField docClearance_Level) {
		try {
			// Query String
			String query = "SELECT firstName, lastName, category, clearance_level FROM doctors WHERE doctorID='" + docID_Parameter +"';";
			// Open Connection to Database
			ConnectDatabase.DB_Connect();
			ResultSet rs;
			Statement st = ConnectDatabase.conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				docID.setText("DOCTOR_ID                           :           " + docID_Parameter);
				docFirstName.setText("First Name                              :           " + rs.getString(1));
				docLastName.setText("Last Name                              :           " + rs.getString(2));
				docCategory.setText("CATEGORY                             :           " + rs.getString(3));
				docClearance_Level.setText("CLEARANCE LEVEL             :           " + String.valueOf(rs.getInt(4)));
			}
		}
		catch (SQLException e) {
			System.err.println(e);
		}
	}
}
