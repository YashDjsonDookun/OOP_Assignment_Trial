import java.time.LocalDateTime; // import the LocalDateTime Class
import java.time.LocalDate; // import the LocalDate Class
import java.time.format.DateTimeFormatter; // import the DateTimeFormatter Class
import java.util.Scanner;

import java.sql.*;

class Patient extends Person{
	private int pid;
	private String conditions;
	private String treatments;
	// private LocalDateTime todayDateTime = LocalDateTime.now();
	// private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	// private String formattedTodayDateTime = todayDateTime.format(dateTimeFormatter);
	private String assignedDoctor;
	private SelfHarm_Violence selfHarm_violence;

	/** GETTERS **/
	public int getPid() {
		return pid;
	}

	public String getConditions() {
		return conditions;
	}

	public String getTreatments() {
		return treatments;
	}

	public String getAssignedDoctor() {
		return assignedDoctor;
	}

	public SelfHarm_Violence getSelfHarm_violence() {
		return selfHarm_violence;
	}

	/** SETTERS **/
	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public void setTreatments(String treatments) {
		this.treatments = treatments;
	}

	public void setAssignedDoctor(String assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}

	public void setSelfHarm_violence(SelfHarm_Violence selfHarm_violence) {
		this.selfHarm_violence = selfHarm_violence;
	}

	/*** PATIENT REGISTRATION ***/
	static Patient RegisterPatient(){
		Patient newPatient = new Patient();

//		newPatient.setFirstName(firstName);


//		newPatient.setLastName(lastName);


//		newPatient.setDateOfBirth(LocalDate.parse(dateOfBirth));

//		newPatient.setEmail(email);

//		newPatient.setAddress(address);

//		newPatient.setPhoneNumber(Integer.parseInt(phoneNumber));

//			newPatient.setGender(Gender.FEMALE);

//		newPatient.setAssignedDoctor(assignedDoctor);

//		newPatient.setConditions(conditions);

//		newPatient.setTreatments(treatments);

//			newPatient.setSelfHarm_violence(null);

		AddPatientInDB(newPatient);
		return newPatient;
	}

	/*** PATIENT REGISTRATION SUMMARY ***/
	static void PatientSummary(Patient patient) {
		String query = "SELECT pid FROM `Patients` WHERE `DOB` ='" + patient.getDateOfBirth() + "' AND `firstName` = '" + patient.getFirstName() + "' AND `lastName` = '" + patient.getLastName() + "';";
		try {
			ResultSet rs;
			Statement st = ConnectDatabase.conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()){
				patient.setPid(rs.getInt(1));
			}
		}
		catch (SQLException e){
			System.err.println("ERROR!!");
      		System.err.println(e.getMessage());
		}

		System.out.println("\n************************************************************");
		System.out.println("* REGISTRATION SUMMARY:");
		System.out.println("************************************************************");
		System.out.println("* First Name                      : "+ patient.getFirstName());
		System.out.println("* Last Name                       : "+ patient.getLastName());
		System.out.println("* Patient ID                      : "+ patient.getPid());
		System.out.println("* DOB                             : "+ patient.getDateOfBirth());
		System.out.println("* Email                           : "+ patient.getEmail());
		System.out.println("* Address                         : "+ patient.getAddress());
		System.out.println("* Phone Number                    : "+ patient.getPhoneNumber());
		System.out.println("* Gender                          : "+ patient.getGender());
		System.out.println("* Assigned Doctor                 : Dr. "+ patient.getAssignedDoctor());
		System.out.println("* Conditions                      : "+ patient.getConditions());
		System.out.println("* Treatments                      : "+ patient.getTreatments());
		System.out.println("* History of Self-Harm/Violence?  : "+ patient.getSelfHarm_violence());
		System.out.println("* Date Registered                 : "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		System.out.println("************************************************************\n");
	}

	/*** ADD NEW PATIENT IN DATABASE ***/
	static void AddPatientInDB(Patient patient){
		try {
			System.out.println("\nInserting new Patient into DB...");

			String query = "Insert into Patients (firstName, LastName, email, Address, DOB, phoneNumber, gender, assignedDoctor, conditions, treatments, selfHarm_violence, dateRegistered, lastConsultation, vip, classified)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = ConnectDatabase.conn.prepareStatement(query);
			preparedStmt.setString(1, patient.getFirstName());
			preparedStmt.setString(2, patient.getLastName());
			preparedStmt.setString(3, patient.getEmail());
			preparedStmt.setString(4, patient.getAddress());
			preparedStmt.setString(5, ""+ patient.getDateOfBirth());
			preparedStmt.setInt(6, patient.getPhoneNumber());
			preparedStmt.setString(7, ""+ patient.getGender());
			preparedStmt.setString(8, patient.getAssignedDoctor());
			preparedStmt.setString(9, patient.getConditions());
			preparedStmt.setString(10, patient.getTreatments());
			preparedStmt.setString(11, ""+ patient.getSelfHarm_violence());

			LocalDateTime todayDateTime = LocalDateTime.now();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedTodayDateTime = todayDateTime.format(dateTimeFormatter);
			preparedStmt.setString(12, ""+ formattedTodayDateTime);

			preparedStmt.execute();
			System.out.println("\nPatient Registration Successful!");

			PatientSummary(patient);
		}
		catch (Exception e){
			System.err.println("ERROR!!");
      		System.err.println(e.getMessage());
		}
	}
}

