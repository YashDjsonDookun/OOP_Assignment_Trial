public enum Clearance_Level {
	ZERO(0), // Lowest Clearance Level
	ONE(1),
	TWO(2);	 // Highest Clearance Level
	
	private final int value;
	
	Clearance_Level(final int newValue){
		value = newValue;
	}
	
	public int getValue() {
		return value;
	}
}
