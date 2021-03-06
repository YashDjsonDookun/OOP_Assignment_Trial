import java.time.LocalDate; // import the LocalDate Class

import javax.swing.JOptionPane;

import java.sql.*;

class Patient extends Person{
	private int pid;
	private String conditions;
	private String treatments;
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
	protected void setPid(int pid) {
		this.pid = pid;
	}

	protected void setConditions(String conditions) {
		this.conditions = conditions;
	}

	protected void setTreatments(String treatments) {
		this.treatments = treatments;
	}

	protected void setAssignedDoctor(String assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}

	protected void setSelfHarm_violence(SelfHarm_Violence selfHarm_violence) {
		this.selfHarm_violence = selfHarm_violence;
	}
	
	protected void setVip(Vip vip) {
		this.vip = vip;
	}
	
	protected void setClassified(Classified classified) {
		this.classified = classified;
	}
	
	protected void setDateRegistered(String dateRegisterd) {
		this.dateRegistered = dateRegisterd;
	}
	
	protected void setLastConsultation(String lastConsultation) {
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
			ConnectDatabase.DB_Close_Connection(ConnectDatabase.conn, null, preparedStmt);

		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Patient Registration Failed!");
		}
	}
}

