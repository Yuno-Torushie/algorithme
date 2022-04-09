package application;

public enum PossibleOperation {

	ADDITION, SOUSTRACTION, MULTIPLICATION, DIVISION;
	
	static public PossibleOperation actionForInt(int i) {
		
		switch (i) {
		case 1: {
			return PossibleOperation.ADDITION;
		} case 2: {
			return PossibleOperation.SOUSTRACTION;
		} case 3: {
			return PossibleOperation.MULTIPLICATION;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + i);
		}
	}
	
}
