import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GUI_SystemInterface {
	private JTextField txt_SearchPatientID;
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
		frame.setMinimumSize(new Dimension(1850, 820));
		
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
		Panel Panel_InputPatientConditions = new Panel();
		Panel Panel_InputPatientTreatments = new Panel();
		Panel Panel_InputPatientSelfHarm = new Panel();
		Panel Panel_InputPatientVIP_Classified = new Panel();
		
		JLabel lbl_TitleLabel = new JLabel("Mentcare System");
		JLabel lbl_DoctorInfo = new JLabel("     Doctor Info:         ");
		JLabel lbl_Date = new JLabel("        Date:  "+LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"     ");
		JLabel lblNewLabel = new JLabel("");
		JLabel lbl_Create_Patient = new JLabel("     Create New Patient:     ");
		JLabel lbl_InputPatientFirstName = new JLabel("First Name:");
		JLabel lbl_InputPatientLastName = new JLabel("Last Name:");
		JLabel lbl_InputPatientEmail = new JLabel("Email:");
		JLabel lbl_InputPatientAddress = new JLabel("Address:");
		JLabel lbl_InputPatientAddress_1 = new JLabel("DOB (Format: YYYY-MM-DD):");
		JLabel lbl_InputPatientGender = new JLabel("Gender:");
		JLabel lbl_InputPatientAssignedDoc = new JLabel("Assigned Doctor:");
		JLabel lbl_InputPatientConditions = new JLabel("Conditions:");
		JLabel lbl_InputPatientTreatments = new JLabel("Treatments:");
		JLabel lbl_InputPatientGender_1 = new JLabel("History of SelfHarm/Violence? ");
		JLabel lbl_InputPatientVIP_Classified = new JLabel("VIP/CLASSIFIED:   ");
		
		JTextField txt_DoctorID = new JTextField();
		JTextField txtDoctorFirstName = new JTextField();
		JTextField txtDoctorLastName = new JTextField();
		JTextField txt_Category = new JTextField();
		JTextField txt_ClearanceLevel = new JTextField();
		JTextField txt_InputPatientFirstName = new JTextField();
		JTextField txt_InputPatientLastName = new JTextField();
		JTextField txt_InputPatientEmail = new JTextField();
		JTextField txt_InputPatientAddress = new JTextField();
		JTextField txt_InputPatientAssignedDoc = new JTextField();
		JTextField txt_InputPatientDOB = new JTextField();
		JTextField txt_InputPatientPhoneNumber = new JTextField();
		
		JTextArea txt_InputPatientConditions = new JTextArea();
		JTextArea txt_InputPatientTreatments = new JTextArea();
		
		FlowLayout fl_Panel_InputPatientFirstName = (FlowLayout) Panel_InputPatientFirstName.getLayout();
		FlowLayout flowLayout_1 = (FlowLayout) Panel_InputPatientLastName.getLayout();
		FlowLayout flowLayout = (FlowLayout) Panel_InputPatientEmail.getLayout();
		FlowLayout flowLayout_2 = (FlowLayout) Panel_InputPatientDOB.getLayout();
		FlowLayout flowLayout_3 = (FlowLayout) Panel_InputPatientGender.getLayout();
		FlowLayout flowLayout_4 = (FlowLayout) Panel_InputPatientAssignedDoc.getLayout();
		FlowLayout flowLayout_5 = (FlowLayout) Panel_InputPatientConditions.getLayout();
		FlowLayout flowLayout_8 = (FlowLayout) Panel_InputPatientAddress.getLayout();
		FlowLayout flowLayout_6 = (FlowLayout) Panel_InputPatientTreatments.getLayout();
		FlowLayout flowLayout_7 = (FlowLayout) Panel_InputPatientSelfHarm.getLayout();
		FlowLayout fl_Panel_InputPatientVIP_Classified = (FlowLayout) Panel_InputPatientVIP_Classified.getLayout();
			
		JComboBox<String>comboBox_Gender_Options = new JComboBox<String>();
		JComboBox<String> comboBox_SelfHarm_Options = new JComboBox<String>();
		JComboBox<String> comboBox_VIP_Classified_Options = new JComboBox<String>();
		
		JButton btnCreatePatient = new JButton("Create Patient");
		JButton btnSearchPatient = new JButton("Search Patient");
		JButton btnGenerateReport = new JButton("Generate Report");
		
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
		
		Panel_CreatePatient.setLayout(new GridLayout(15, 0, 5, 5));
		
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
		Panel_CreatePatient.add(Panel_InputPatientFirstName);
		Panel_CreatePatient.add(Panel_InputPatientLastName);
		Panel_CreatePatient.add(Panel_InputPatientEmail);
		Panel_CreatePatient.add(Panel_InputPatientAddress);
		Panel_CreatePatient.add(Panel_InputPatientDOB);
		
		Panel Panel_InputPatientPhoneNumber = new Panel();
		FlowLayout fl_Panel_InputPatientPhoneNumber = (FlowLayout) Panel_InputPatientPhoneNumber.getLayout();
		fl_Panel_InputPatientPhoneNumber.setAlignment(FlowLayout.LEFT);
		Panel_CreatePatient.add(Panel_InputPatientPhoneNumber);
		
		JLabel lbl_InputPatientAddress_1_1 = new JLabel("Phone Number: ");
		lbl_InputPatientAddress_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_InputPatientAddress_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		Panel_InputPatientPhoneNumber.add(lbl_InputPatientAddress_1_1);
		
		lbl_InputPatientAddress_1_1.setLabelFor(txt_InputPatientPhoneNumber);
		txt_InputPatientPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_InputPatientPhoneNumber.setColumns(7);
		
		txt_InputPatientPhoneNumber.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txt_InputPatientPhoneNumber.getText().length() >= 8 )
		            e.consume(); 
		    }  
		});
		
		Panel_InputPatientPhoneNumber.add(txt_InputPatientPhoneNumber);
		Panel_CreatePatient.add(Panel_InputPatientGender);
		Panel_CreatePatient.add(Panel_InputPatientAssignedDoc);
		Panel_CreatePatient.add(Panel_InputPatientConditions);
		Panel_CreatePatient.add(Panel_InputPatientTreatments);
		Panel_CreatePatient.add(Panel_InputPatientSelfHarm);
		Panel_CreatePatient.add(Panel_InputPatientVIP_Classified);
		Panel_CreatePatient.add(btnCreatePatient);
		
		Panel_InputPatientFirstName.add(lbl_InputPatientFirstName);
		Panel_InputPatientFirstName.add(txt_InputPatientFirstName);
		
		Panel_InputPatientLastName.add(lbl_InputPatientLastName);
		Panel_InputPatientLastName.add(txt_InputPatientLastName);
		
		Panel_InputPatientEmail.add(lbl_InputPatientEmail);
		Panel_InputPatientEmail.add(txt_InputPatientEmail);
		
		Panel_InputPatientAddress.add(lbl_InputPatientAddress);
		Panel_InputPatientAddress.add(txt_InputPatientAddress);
		
		Panel_InputPatientDOB.add(lbl_InputPatientAddress_1);
		Panel_InputPatientDOB.add(txt_InputPatientDOB);
		
		Panel_InputPatientGender.add(lbl_InputPatientGender);
		Panel_InputPatientGender.add(comboBox_Gender_Options);
		
		Panel_InputPatientAssignedDoc.add(lbl_InputPatientAssignedDoc);
		Panel_InputPatientAssignedDoc.add(txt_InputPatientAssignedDoc);
		
		Panel_InputPatientConditions.add(lbl_InputPatientConditions);
		Panel_InputPatientConditions.add(txt_InputPatientConditions);
		
		Panel_InputPatientTreatments.add(lbl_InputPatientTreatments);
		Panel_InputPatientTreatments.add(txt_InputPatientTreatments);
		
		Panel_InputPatientSelfHarm.add(lbl_InputPatientGender_1);
		Panel_InputPatientSelfHarm.add(comboBox_SelfHarm_Options);
		
		Panel_InputPatientVIP_Classified.add(lbl_InputPatientVIP_Classified);
		Panel_InputPatientVIP_Classified.add(comboBox_VIP_Classified_Options);
			
		/*
		 * Components Properties 
		 */
		AssignDoctorInfo(getDoctorID_Parameter, txt_InputPatientAssignedDoc,txt_DoctorID, txtDoctorFirstName, txtDoctorLastName, txt_Category, txt_ClearanceLevel);
		
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
		lbl_Create_Patient.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		fl_Panel_InputPatientFirstName.setAlignment(FlowLayout.LEFT);
		
		flowLayout_8.setAlignment(FlowLayout.LEFT);
	
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
		txt_InputPatientDOB.setColumns(7);
		
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
		
		lbl_InputPatientConditions.setLabelFor(txt_InputPatientAssignedDoc);
		lbl_InputPatientConditions.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_InputPatientConditions.setFont(new Font("Arial", Font.PLAIN, 17));
		
		txt_InputPatientConditions.setWrapStyleWord(true);
		txt_InputPatientConditions.setRows(1);
		txt_InputPatientConditions.setColumns(50);
		
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		
		lbl_InputPatientTreatments.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_InputPatientTreatments.setFont(new Font("Arial", Font.PLAIN, 17));
		
		txt_InputPatientTreatments.setWrapStyleWord(true);
		txt_InputPatientTreatments.setRows(1);
		txt_InputPatientTreatments.setColumns(50);
		
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		lbl_InputPatientGender_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_InputPatientGender_1.setFont(new Font("Arial", Font.PLAIN, 17));
		
		comboBox_SelfHarm_Options.setModel(new DefaultComboBoxModel(SelfHarm_Violence.values()));
		
		fl_Panel_InputPatientVIP_Classified.setAlignment(FlowLayout.LEFT);
		
		lbl_InputPatientVIP_Classified.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_InputPatientVIP_Classified.setFont(new Font("Arial", Font.PLAIN, 17));
		
		comboBox_VIP_Classified_Options.setModel(new DefaultComboBoxModel<String>(new String[] {"N/A", "VIP", "CLASSIFIED"}));
		
		btnCreatePatient.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txt_InputPatientDOB.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txt_InputPatientDOB.getText().length() >= 10 )
		            e.consume(); 
		    }  
		});
		
		JTextArea txt_PatientReport = new JTextArea();
		txt_PatientReport.setFont(new Font("Monospaced", Font.PLAIN, 19));
		txt_PatientReport.setBackground(Color.GRAY);
		txt_PatientReport.setWrapStyleWord(true);
		txt_PatientReport.setEditable(false);
		frame.getContentPane().add(txt_PatientReport, BorderLayout.CENTER);
		
		JPanel Panel_SearchPatient = new JPanel();
		frame.getContentPane().add(Panel_SearchPatient, BorderLayout.EAST);
		Panel_SearchPatient.setLayout(new GridLayout(15, 0, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		Panel_SearchPatient.add(lblNewLabel_1);
		
		JLabel lbl_SearchPatient = new JLabel("     Search Patient:     ");
		lbl_SearchPatient.setVerticalAlignment(SwingConstants.TOP);
		lbl_SearchPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SearchPatient.setFont(new Font("Arial", Font.BOLD, 20));
		Panel_SearchPatient.add(lbl_SearchPatient);
		
		Panel Panel_InputPatient_SearchID = new Panel();
		FlowLayout fl_Panel_InputPatient_SearchID = (FlowLayout) Panel_InputPatient_SearchID.getLayout();
		fl_Panel_InputPatient_SearchID.setAlignment(FlowLayout.RIGHT);
		Panel_SearchPatient.add(Panel_InputPatient_SearchID);
		
		JLabel lbl_InputPatientID = new JLabel("Patient ID:");
		lbl_InputPatientID.setFont(new Font("Arial", Font.PLAIN, 17));
		Panel_InputPatient_SearchID.add(lbl_InputPatientID);
		
		txt_SearchPatientID = new JTextField();
		txt_SearchPatientID.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_SearchPatientID.setColumns(25);
		Panel_InputPatient_SearchID.add(txt_SearchPatientID);
		
		
		btnSearchPatient.setFont(new Font("Arial", Font.PLAIN, 16));
		Panel_SearchPatient.add(btnSearchPatient);
		
		btnGenerateReport.setEnabled(false);
		btnGenerateReport.setFont(new Font("Arial", Font.PLAIN, 16));
		Panel_SearchPatient.add(btnGenerateReport);
		
		JButton btnContactPatient = new JButton("Contact Patient");
		btnContactPatient.setEnabled(false);
		btnContactPatient.setFont(new Font("Arial", Font.PLAIN, 16));
		Panel_SearchPatient.add(btnContactPatient);
		
		/*
		 * Functionality
		 */
		
		// Button Create Patient
		btnCreatePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePatient(frame, txt_InputPatientFirstName,txt_InputPatientLastName, txt_InputPatientEmail, txt_InputPatientAddress, txt_InputPatientDOB, txt_InputPatientPhoneNumber,comboBox_Gender_Options, txt_InputPatientAssignedDoc, txt_InputPatientConditions, txt_InputPatientTreatments, comboBox_SelfHarm_Options, comboBox_VIP_Classified_Options);
			}
		});
		
		// Button Search Patient
		btnSearchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPatient(frame, txt_SearchPatientID, txt_PatientReport, txt_ClearanceLevel, btnGenerateReport, btnContactPatient);
			}
		});
		
		// Button Generate Report
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateReport(txt_SearchPatientID, txt_PatientReport, txt_ClearanceLevel, btnContactPatient, btnGenerateReport);
			}
		});
		
	}
	
	void AssignDoctorInfo(String docID_Parameter, JTextField txt_InputPatientAssignedDoc ,JTextField docID, JTextField docFirstName, JTextField docLastName, JTextField docCategory, JTextField docClearance_Level) {
		try {
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
				txt_InputPatientAssignedDoc.setText("Dr. " + rs.getString(2) + ", " + rs.getString(1));
			}
			// Close Connection to Database
			ConnectDatabase.DB_Close_Connection(ConnectDatabase.conn, rs, st);
		}
		catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	void CreatePatient(JFrame frame, JTextField firstName, JTextField lastName, JTextField email, JTextField address, JTextField DOB,JTextField phoneNumber, JComboBox gender, JTextField assignedDoc, JTextArea conditions, JTextArea treatments, JComboBox selfharm_violence, JComboBox vip_classified) {
		String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		try {
			Patient.RegisterPatient(firstName.getText(), lastName.getText(), email.getText(), address.getText(), DOB.getText(), phoneNumber.getText(), gender.getSelectedItem().toString(), assignedDoc.getText(), conditions.getText(), treatments.getText(), selfharm_violence.getSelectedItem().toString(), vip_classified.getSelectedItem().toString(), currentDateTime);
			firstName.setText("");
			lastName.setText("");
			email.setText("");
			address.setText("");
			DOB.setText("");
			phoneNumber.setText("");
			gender.setSelectedIndex(-1);
			conditions.setText("");
			treatments.setText("");
			selfharm_violence.setSelectedIndex(-1);
			vip_classified.setSelectedIndex(-1);
			JOptionPane.showMessageDialog(frame, "Patient Created!", "ALERT",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "Something Went Wrong Somewhere...\nPlease check all your fields again","ERROR!!",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	void SearchPatient(JFrame frame, JTextField pid, JTextArea screenReport, JTextField docClearance_Level, JButton generateButton, JButton contactButton) {
		screenReport.setText("");
		generateButton.setEnabled(false);
		contactButton.setEnabled(false);
		try{
			if (!pid.getText().isBlank()) {
				Integer.parseInt(pid.getText());
				String query = "SELECT pid, firstName, lastName, DOB, assignedDoctor, dateRegistered, vip, classified FROM patients WHERE pid='" + pid.getText() + "'";
				try {
					// Open Connection to Database
					ConnectDatabase.DB_Connect();
					ResultSet rs;
					Statement st = ConnectDatabase.conn.createStatement();
					rs = st.executeQuery(query);
					String vip="";
					String classified="";
					while(rs.next()) {
						if (rs.getString(7).equals("1") && rs.getString(8).equals("1")) {
							vip = Vip.TRUE.toString();
							classified = Classified.TRUE.toString();
							if(docClearance_Level.getText().equals("CLEARANCE LEVEL             :           2")) {
								generateButton.setEnabled(true);
								contactButton.setEnabled(true);
								JOptionPane.showMessageDialog(frame,"Patient flagged as Classified! Be Advised!");
							}
							else {
								JOptionPane.showMessageDialog(frame,"Patient flagged as Classified! Be Advised!\nYou are not Authorized to Generate this Patient's Report or contact him/her!!");
							}
						}
						else if (rs.getString(7).equals("1") && rs.getString(8).equals("0")) {
							vip = Vip.TRUE.toString();
							classified = Classified.FALSE.toString();
							if(docClearance_Level.getText().equals("CLEARANCE LEVEL             :           1") || docClearance_Level.getText().equals("CLEARANCE LEVEL             :           2")) {
								generateButton.setEnabled(true);
								contactButton.setEnabled(true);
								JOptionPane.showMessageDialog(frame,"Patient flagged as VIP! Be Advised!");
							}
							else {
								JOptionPane.showMessageDialog(frame,"Patient flagged as Classified! Be Advised!\nYou are not Authorized to Generate this Patient's Report or contact him/her!!");
							}
						}
						else {
							vip = Vip.FALSE.toString();
							classified = Classified.FALSE.toString();
							generateButton.setEnabled(true);
							contactButton.setEnabled(true);
						}
						screenReport.append(
								  "**************************************************\n*                  PATIENT INFO:                 *\n**************************************************"
								+ "\nPatient ID             :     " + rs.getInt(1)
								+ "\nFirst Name             :     " + rs.getString(2)
								+ "\nLast Name              :     " + rs.getString(3)
								+ "\nDOB                    :     " + rs.getString(4)
								+ "\nAssigned Doctor        :     " + rs.getString(5)
								+ "\nDate Registered        :     " + rs.getString(6)
								+ "\nVIP                    :     " + vip
								+ "\nClassified Patient     :     " + classified
								+ "\n**************************************************\n"
								);
					}
					// Close Connection to Database
					ConnectDatabase.DB_Close_Connection(ConnectDatabase.conn, rs, st);
				}
				catch(SQLException e) {
					System.err.println(e);
				}
			}
		}
		catch(Exception e) {
			GUI_EntryPoint.InvalidID(frame);
		}
	}
	
	void GenerateReport(JTextField patientID, JTextArea screen, JTextField docClearance_Level, JButton generateButton, JButton contactButton) {
		String query = "SELECT *  FROM patients WHERE pid = '" + patientID.getText().toString() + "'";
		screen.setText("");
		try {
			ConnectDatabase.DB_Connect();
			ResultSet rs;
			Statement st = ConnectDatabase.conn.createStatement();
			rs = st.executeQuery(query);
			screen.setFont(new Font("Monospaced", Font.PLAIN, 16));
			while(rs.next()) {
				System.out.println("VIP: " + rs.getString(15));
				System.out.println("Classified: " + rs.getString(15));
				System.out.println("doc clearance: " + docClearance_Level.getText().toString());
				if ((rs.getString(15).equals("1") && rs.getString(16).equals("1") && docClearance_Level.getText().toString().equals("CLEARANCE LEVEL             :           2")) || (rs.getString(15).equals("1") && rs.getString(16).equals("0") && docClearance_Level.getText().toString().equals("CLEARANCE LEVEL             :           1")) || (rs.getString(15).equals("0") && rs.getString(16).equals("0"))) {
				screen.append(
						  "\n*********************************************************************\n*                            PATIENT REPORT:                        *\n*********************************************************************"
						+ "\n*  Patient ID                       :   " + rs.getInt(1)
						+ "\n*  First Name                       :   " + rs.getString(2)
						+ "\n*  Last Name                        :   " + rs.getString(3)	
						+ "\n*  Email                            :   " + rs.getString(4)
						+ "\n*  Address                          :   " + rs.getString(5)
						+ "\n*  DOB                              :   " + rs.getString(6)
						+ "\n*  Phone Number                     :   " + rs.getString(7)
						+ "\n*  Gender                           :   " + rs.getString(8)
						+ "\n*  Assigned Doctor                  :   " + rs.getString(9)
						+ "\n*  Conditions                       :   " + rs.getString(10)
						+ "\n*  Treatments                       :   " + rs.getString(11)
						+ "\n*  History of Self-Harm/Violence?   :   " + rs.getString(12)
						+ "\n*  Date Registered                  :   " + rs.getString(13)
						+ "\n*  Last Consultation                :   " + rs.getString(14)
						+ "\n*********************************************************************"
						);
				}
				else {
					JOptionPane.showMessageDialog(null, "You Are not Allowed To View/Generate A Report For This Patient!", "ALERT", JOptionPane.ERROR_MESSAGE);
					screen.setText("");
					screen.setFont(new Font("Monospaced", Font.PLAIN, 19));
					generateButton.setEnabled(false);
					contactButton.setEnabled(false);
					patientID.setText("");
				}
			}	
		}
		catch(SQLException e) {
			System.err.println(e);
		}
		screen.setFont(new Font("Monospaced", Font.PLAIN, 19));
	}
}
