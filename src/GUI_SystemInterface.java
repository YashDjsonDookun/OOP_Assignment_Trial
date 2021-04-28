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
		JPanel Panel_CreatePatient = new JPanel();
		
		Panel Panel_InputPatientFirstName = new Panel();
		Panel Panel_InputPatientLastName = new Panel();
		Panel Panel_InputPatientEmail = new Panel();
		Panel Panel_InputPatientAddress = new Panel();
		Panel Panel_InputPatientAssignedDoc = new Panel();
		Panel Panel_InputPatientDOB = new Panel();
		Panel Panel_InputPatientGender = new Panel();
		
		JLabel lbl_TitleLabel = new JLabel("Mentcare System");
		JLabel lbl_DoctorInfo = new JLabel("     Doctor Info:         ");
		JLabel lbl_Date = new JLabel("        Date:  "+LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"     ");
		JLabel lblNewLabel = new JLabel("");
		JLabel lbl_Create_Patient = new JLabel("     Create New Patient     ");
		JLabel lblNewLabel_1 = new JLabel("");
		JLabel lbl_InputPatientFirstName = new JLabel("First Name:");
		JLabel lbl_InputPatientLastName = new JLabel("Last Name:");
		JLabel lbl_InputPatientEmail = new JLabel("Email:");
		JLabel lbl_InputPatientAddress = new JLabel("Address:");
		JLabel lbl_InputPatientAddress_1 = new JLabel("DOB (Format: YYYY-MM-DD):");
		JLabel lbl_InputPatientGender = new JLabel("Gender:");
		JLabel lbl_InputPatientAssignedDoc = new JLabel("Assigned Doctor:");
		
		JTextField txt_DoctorID = new JTextField();
		JTextField txtDoctorFirstName = new JTextField();
		JTextField txtDoctorLastName = new JTextField();
		JTextField txt_Category = new JTextField();
		JTextField txt_ClearanceLevel = new JTextField();
		JTextField txt_InputPatientFirstName = new JTextField();
		JTextField txt_InputPatientLastName = new JTextField();
		JTextField txt_InputPatientEmail = new JTextField();
		JTextField txt_InputPatientAddress = new JTextField();
		JTextField txt_InputPatientDOB = new JTextField();
		JTextField txt_InputPatientAssignedDoc = new JTextField();
		
		FlowLayout fl_Panel_InputPatientFirstName = (FlowLayout) Panel_InputPatientFirstName.getLayout();
		FlowLayout flowLayout_1 = (FlowLayout) Panel_InputPatientLastName.getLayout();
		FlowLayout flowLayout = (FlowLayout) Panel_InputPatientEmail.getLayout();
		FlowLayout flowLayout_2 = (FlowLayout) Panel_InputPatientDOB.getLayout();
		FlowLayout flowLayout_3 = (FlowLayout) Panel_InputPatientGender.getLayout();
		FlowLayout flowLayout_4 = (FlowLayout) Panel_InputPatientAssignedDoc.getLayout();
			
		JComboBox comboBox_Gender_Options = new JComboBox();
		
		/*
		 * Add Components To Frame
		 */
		frame.getContentPane().add(Panel_Title, BorderLayout.NORTH);
		frame.getContentPane().add(Panel_CreatePatient, BorderLayout.WEST);
		
		/*
		 * Panel Properties
		 */

		Panel_Title.setLayout(new BorderLayout(0, 0));
		

		Panel_DoctorInfo.setLayout(new GridLayout(5, 0, 0, 2));
		

		Panel_CreatePatient.setLayout(new GridLayout(19, 0, 5, 5));
		
		/*
		 * Add Components To Panels
		 */

		Panel_Title.add(lbl_TitleLabel, BorderLayout.NORTH);
		Panel_Title.add(lbl_DoctorInfo, BorderLayout.WEST);
		Panel_Title.add(lbl_Date, BorderLayout.EAST);
		Panel_Title.add(Panel_DoctorInfo, BorderLayout.CENTER);
		

		Panel_DoctorInfo.add(txt_DoctorID);
		Panel_DoctorInfo.add(txtDoctorFirstName);
		Panel_DoctorInfo.add(txtDoctorLastName);
		Panel_DoctorInfo.add(txt_Category);
		Panel_DoctorInfo.add(txt_ClearanceLevel);
		

		Panel_CreatePatient.add(lblNewLabel);
		Panel_CreatePatient.add(lbl_Create_Patient);
		Panel_CreatePatient.add(lblNewLabel_1);
		Panel_CreatePatient.add(Panel_InputPatientFirstName);
		Panel_CreatePatient.add(Panel_InputPatientLastName);
		Panel_CreatePatient.add(Panel_InputPatientEmail);
		Panel_CreatePatient.add(Panel_InputPatientAddress);
		Panel_CreatePatient.add(Panel_InputPatientDOB);
		Panel_CreatePatient.add(Panel_InputPatientGender);
		Panel_CreatePatient.add(Panel_InputPatientAssignedDoc);
		
		Panel_InputPatientFirstName.add(lbl_InputPatientFirstName);
		Panel_InputPatientFirstName.add(txt_InputPatientFirstName);
		
		Panel_InputPatientLastName.add(lbl_InputPatientLastName);
		Panel_InputPatientLastName.add(txt_InputPatientLastName);
		
		Panel_InputPatientEmail.add(lbl_InputPatientEmail);
		Panel_InputPatientEmail.add(txt_InputPatientEmail);
		
		Panel_InputPatientAddress.add(lbl_InputPatientAddress);
		Panel_InputPatientAddress.add(txt_InputPatientAddress);
		
		Panel_InputPatientDOB.add(txt_InputPatientDOB);
		Panel_InputPatientDOB.add(lbl_InputPatientAddress_1);
		
		Panel_InputPatientGender.add(lbl_InputPatientGender);
		Panel_InputPatientGender.add(comboBox_Gender_Options);
		
		Panel_InputPatientAssignedDoc.add(lbl_InputPatientAssignedDoc);
		Panel_InputPatientAssignedDoc.add(txt_InputPatientAssignedDoc);
		
		/*
		 * Components Properties 
		 */
		AssignDoctorInfo(getDoctorID_Parameter, txt_DoctorID, txtDoctorFirstName, txtDoctorLastName, txt_Category, txt_ClearanceLevel);
		
		lbl_TitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lbl_TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);		
		
		lbl_DoctorInfo.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_DoctorInfo.setHorizontalAlignment(SwingConstants.TRAILING);

		lbl_Date.setFont(new Font("Arial", Font.PLAIN, 19));

		txt_DoctorID.setEditable(false);
		txt_DoctorID.setColumns(10);
		
		txtDoctorFirstName.setEditable(false);
		txtDoctorFirstName.setColumns(10);
		
		txtDoctorLastName.setEditable(false);
		txtDoctorLastName.setColumns(10);

		txt_Category.setEditable(false);
		txt_Category.setColumns(10);
		
		txt_ClearanceLevel.setEditable(false);
		txt_ClearanceLevel.setColumns(10);
		
		lbl_Create_Patient.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Create_Patient.setVerticalAlignment(SwingConstants.TOP);
		
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		
		fl_Panel_InputPatientFirstName.setAlignment(FlowLayout.LEFT);
	
		txt_InputPatientFirstName.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_InputPatientFirstName.setColumns(25);
		
		lbl_InputPatientFirstName.setLabelFor(txt_InputPatientFirstName);
		lbl_InputPatientFirstName.setFont(new Font("Arial", Font.PLAIN, 17));
		
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		lbl_InputPatientLastName.setFont(new Font("Arial", Font.PLAIN, 17));
		
		txt_InputPatientLastName.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_InputPatientLastName.setColumns(25);
		
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		lbl_InputPatientEmail.setFont(new Font("Arial", Font.PLAIN, 17));
		
		lbl_InputPatientEmail.setLabelFor(txt_InputPatientEmail);
		txt_InputPatientEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_InputPatientEmail.setColumns(25);
		
		lbl_InputPatientAddress.setFont(new Font("Arial", Font.PLAIN, 17));
		
		lbl_InputPatientAddress.setLabelFor(txt_InputPatientAddress);
		txt_InputPatientAddress.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_InputPatientAddress.setColumns(40);
		
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		lbl_InputPatientAddress_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_InputPatientAddress_1.setFont(new Font("Arial", Font.PLAIN, 17));
		
		
		lbl_InputPatientAddress_1.setLabelFor(txt_InputPatientDOB);
		txt_InputPatientDOB.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_InputPatientDOB.setColumns(10);
		
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		
		lbl_InputPatientGender.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_InputPatientGender.setFont(new Font("Arial", Font.PLAIN, 17));
		
		comboBox_Gender_Options.setModel(new DefaultComboBoxModel(Gender.values()));
		
		flowLayout_4.setAlignment(FlowLayout.LEFT);

		lbl_InputPatientAssignedDoc.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_InputPatientAssignedDoc.setFont(new Font("Arial", Font.PLAIN, 17));
		
		txt_InputPatientAssignedDoc.setEditable(false);
		txt_InputPatientAssignedDoc.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_InputPatientAssignedDoc.setColumns(11);
		
		
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
