public enum Classified {
	TRUE(1),
	FALSE(0);
	
	private final int value;
	Classified(final int newValue){
		value = newValue;
	}
	
	public int getValue() {
		return value;
	}
}
