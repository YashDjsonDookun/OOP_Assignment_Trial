//import java.time.LocalDateTime; // import the LocalDateTime Class
import java.time.LocalDate; // import the LocalDate Class
//import java.time.format.DateTimeFormatter; // import the DateTimeFormatter Class
import java.util.Scanner;

class Patient{
	private String firstName;
	private String lastName;
	private int pid;
	private String email;
	private String conditions;
	private String treatments;
	//private LocalDateTime todayDateTime;
	//private DateTimeFormatter formattedTodayDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private String assignedDoctor;
	private LocalDate dateOfBirth;
	private Gender gender;
	private String address;
	private int phoneNumber;
	private SelfHarm_Violence selfHarm_violence;

	/** GETTERS **/
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getPid() {
		return pid;
	}

	public String getEmail() {
		return email;
	}

	public String getConditions() {
		return conditions;
	}

	public String getTreatments() {
		return treatments;
	}

//	public LocalDateTime getTodayDateTime() {
//		return todayDateTime;
//	}
//
//	public DateTimeFormatter getFormattedTodayDateTime() {
//		return formattedTodayDateTime;
//	}

	public String getAssignedDoctor() {
		return assignedDoctor;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public SelfHarm_Violence getSelfHarm_violence() {
		return selfHarm_violence;
	}

	/** SETTERS **/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public void setTreatments(String treatments) {
		this.treatments = treatments;
	}

//	public void setTodayDateTime(LocalDateTime todayDateTime) {
//		this.todayDateTime = todayDateTime;
//	}
//
//	public void setFormattedTodayDateTime(DateTimeFormatter formattedTodayDateTime) {
//		this.formattedTodayDateTime = formattedTodayDateTime;
//	}

	public void setAssignedDoctor(String assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSelfHarm_violence(SelfHarm_Violence selfHarm_violence) {
		this.selfHarm_violence = selfHarm_violence;
	}

	/*** PATIENT REGISTRATION ***/
	static Patient RegisterPatient(){
		Patient newPatient = new Patient();
		Scanner input = new Scanner(System.in);

		System.out.println("\n*********************************************");
		System.out.println("PATIENT REGISTRATION.. FILL IN DETAILS BELOW");
		System.out.println("*********************************************");

		System.out.print("FirstName: ");
		String firstName = input.nextLine();
		newPatient.setFirstName(firstName);

		System.out.print("LastName: ");
		String lastName = input.nextLine();
		newPatient.setLastName(lastName);

		newPatient.setPid(1810111);

		System.out.print("DOB, format YYYY-MM-DD : ");
		String dateOfBirth = input.nextLine();
		newPatient.setDateOfBirth(LocalDate.parse(dateOfBirth));

		System.out.print("Email: ");
		String email = input.nextLine();
		newPatient.setEmail(email);

		System.out.print("Address: ");
		String address = input.nextLine();
		newPatient.setAddress(address);

		System.out.print("Phone Number: ");
		String phoneNumber = input.nextLine();
		newPatient.setPhoneNumber(Integer.parseInt(phoneNumber));

		System.out.print("Gender {f/F = female; m/M = male}: ");
		char gender = input.nextLine().charAt(0);
		if (gender == 'f' || gender == 'F'){
			newPatient.setGender(Gender.FEMALE);
		}
		else if (gender == 'm' || gender == 'M') {
			newPatient.setGender(Gender.MALE);
		}
		else {
			newPatient.setGender(null);
		}

		System.out.print("Assigned Doc: ");
		String assignedDoctor = input.nextLine();
		newPatient.setAssignedDoctor(assignedDoctor);

		System.out.print("Suffering from: ");
		String conditions = input.nextLine();
		newPatient.setConditions(conditions);

		System.out.print("Undergoing Treatments: ");
		String treatments = input.nextLine();
		newPatient.setTreatments(treatments);

		System.out.print("History of Self-Harm/Violence?\n {y/Y = Yes; n/N = No}: ");
		char selfHarm_violence = input.nextLine().charAt(0);
		if (selfHarm_violence == 'n' || selfHarm_violence == 'N'){
			newPatient.setSelfHarm_violence(SelfHarm_Violence.NO);
		}
		else if (selfHarm_violence == 'y' || selfHarm_violence == 'Y') {
			newPatient.setSelfHarm_violence(SelfHarm_Violence.YES);
		}
		else {
			newPatient.setSelfHarm_violence(null);
		}

		input.close();
		return newPatient;
	}

	/*** PATIENT REGISTRATION SUMMARY ***/
	static void PatientSummary(Patient patient) {
		System.out.println("\n************************************************************");
		System.out.println("* REGISTRATION SUMMARY");
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
		System.out.println("************************************************************\n");
	}
}

