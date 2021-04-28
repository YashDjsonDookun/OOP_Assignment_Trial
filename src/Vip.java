public enum Vip {
	TRUE(1),
	FALSE(0);
	
	private final int value;
	Vip(final int newValue){
		value = newValue;
	}
	
	public int getValue() {
		return value;
	}
}
