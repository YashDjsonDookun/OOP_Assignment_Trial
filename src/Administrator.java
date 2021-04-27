class Administrator extends Person {
	private int adminID;
	private Clearance_Level clearanceLevel;
	
//	public Administrator(int adminID, Clearance_Level clearanceLevel) {
//		this.adminID = adminID;
//		this.clearanceLevel = clearanceLevel;
//	}
	
	/*** GETTERS ***/
	public int getAdminID() {
		return adminID;
	}
	
	public Clearance_Level getClearanceLevel() {
		return clearanceLevel;
	}
	
	/*** SETTERS ***/

//	public void setAdminID(int adminID) {
//		this.adminID = adminID;
//	}
//	
//	public void setClearanceLevel(Clearance_Level clearanceLevel) {
//		this.clearanceLevel = clearanceLevel;
//	}
}
