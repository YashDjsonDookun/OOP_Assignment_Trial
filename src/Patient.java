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
	private Vip vip;
	private Classified classified;
	private String dateRegistered;
	private String lastConsultation;

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
	
	public Vip getVip() {
		return vip;
	}
	
	public Classified getClassified() {
		return classified;
	}
	
	public String getDateRegistered() {
		return dateRegistered;
	}
	
	public String getLastConsultation() {
		return lastConsultation;
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
	
	public void setVip(Vip vip) {
		this.vip = vip;
	}
	
	public void setClassified(Classified classified) {
		this.classified = classified;
	}
	
	public void setDateRegistered(String dateRegisterd) {
		this.dateRegistered = dateRegisterd;
	}
	
	public void setLastConsultation(String lastConsultation) {
		this.lastConsultation = lastConsultation;
	}

	/*** PATIENT REGISTRATION ***/
	static Patient RegisterPatient(String firstName, String lastName, String email, String address, String dateOfBirth, String phoneNumber, String gender, String assignedDoctor, String conditions, String treatments, String selfharm_violence, String vip_classified, String dateRegistered){
		Patient newPatient = new Patient();

		newPatient.setFirstName(firstName);
		newPatient.setLastName(lastName);
		newPatient.setEmail(email);
		newPatient.setAddress(address);
		newPatient.setDateOfBirth(LocalDate.parse(dateOfBirth));
		newPatient.setPhoneNumber(Integer.parseInt(phoneNumber));
		if (gender.equals("MALE")) {
			newPatient.setGender(Gender.MALE);
		}
		else {
			newPatient.setGender(Gender.FEMALE);
		}
		newPatient.setAssignedDoctor(assignedDoctor);
		newPatient.setConditions(conditions);
		newPatient.setTreatments(treatments);
		if (selfharm_violence.equals("YES")) {
			newPatient.setSelfHarm_violence(SelfHarm_Violence.YES);
		}else {
			newPatient.setSelfHarm_violence(SelfHarm_Violence.NO);
		}
		
		if (vip_classified.equals("N/A")) {
			newPatient.setVip(Vip.FALSE);
			newPatient.setClassified(Classified.FALSE);
		}
		else if (vip_classified.equals("VIP")){
			newPatient.setVip(Vip.TRUE);
			newPatient.setClassified(Classified.FALSE);
		}
		else {
			newPatient.setVip(Vip.TRUE);
			newPatient.setClassified(Classified.TRUE);
		}
		newPatient.setDateRegistered(dateRegistered);	
		newPatient.setLastConsultation(dateRegistered);

		AddPatientInDB(newPatient);
		return newPatient;
	}

	/*** PATIENT REGISTRATION SUMMARY ***/
	static void PatientSummaryRegistration(Patient patient) {
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

		SummaryText(patient);
	}
	
	/* PATIENT SUMMARY */
	static void PatientSummary(int id) {
		Patient patient = new Patient();
		String query = "SELECT * FROM `Patients` WHERE `pid` ='" + id + "';";
		SummaryText(patient);
	}
	
	/* SUMMARY TEXT */
	static void SummaryText(Patient patient) {
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
		System.out.println("* Assigned Doctor                 : "+ patient.getAssignedDoctor());
		System.out.println("* Conditions                      : "+ patient.getConditions());
		System.out.println("* Treatments                      : "+ patient.getTreatments());
		System.out.println("* History of Self-Harm/Violence?  : "+ patient.getSelfHarm_violence());
		System.out.println("* VIP                             : "+ patient.getVip());
		System.out.println("* CLASSIFIED                      : "+ patient.getClassified());
		System.out.println("* Date Registered                 : "+ patient.getDateRegistered());
		System.out.println("* Last Consultation               : "+ patient.getLastConsultation());
		System.out.println("************************************************************\n");
	}

	/*** ADD NEW PATIENT IN DATABASE ***/
	static void AddPatientInDB(Patient patient){
		try {
			System.out.println("\nInserting new Patient into DB...");

			String query = "Insert into Patients (firstName, LastName, email, Address, DOB, phoneNumber, gender, assignedDoctor, conditions, treatments, selfHarm_violence, dateRegistered, lastConsultation, vip, classified)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			
			ConnectDatabase.DB_Connect();
			
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
			preparedStmt.setString(12, ""+ patient.getDateRegistered());
			preparedStmt.setString(13, ""+ patient.getLastConsultation());
			preparedStmt.setString(14, ""+ patient.getVip().getValue());
			preparedStmt.setString(15, ""+ patient.getClassified().getValue());

			preparedStmt.execute();
			System.out.println("\nPatient Registration Successful!");

			PatientSummaryRegistration(patient);
		}
		catch (Exception e){
			System.err.println("ERROR!!");
      		System.err.println(e.getMessage());
		}
	}
}

