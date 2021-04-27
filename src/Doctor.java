class Doctor extends Person {
	private int doctorID;
	private Clearance_Level clearanceLevel;
	
	public Doctor(int doctorID, Clearance_Level clearanceLevel) {
		this.doctorID = doctorID;
		this.clearanceLevel = clearanceLevel;
	}

	/*** SETTERS ***/

//	public void setDoctorID(int doctorID) {
//		this.doctorID = doctorID;
//	}
//
//	public void setClearanceLevel(Clearance_Level clearanceLevel) {
//		this.clearanceLevel = clearanceLevel;
//	}

	/*** GETTERS ***/
	public int getDoctorID() {
		return doctorID;
	}

	public Clearance_Level getClearanceLevel() {
		return clearanceLevel;
	}
}