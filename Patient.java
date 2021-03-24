import java.time.LocalDateTime; // import the LocalDateTime Class
import java.time.LocalDate; // import the LocalDate Class
import java.time.format.DateTimeFormatter; // import the DateTimeFormatter Class

class Patient{
	private String firstName;
	private String lastName;
	private int pid;
	private String email;
	private String conditions;
	private String treatments;
	private LocalDateTime todayDateTime;
	private DateTimeFormatter formattedTodayDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
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
}

