package be.helha.aemt.groupeA6.entities;

public enum Fraction{
	MA(480),
	MFP(750);
	  
	private final int fraction;

	private Fraction(int fraction) {
	  this.fraction = fraction;
	}
    public int getValue() {
        return fraction;
    }
}
