package be.helha.aemt.groupeA6.entities;

public enum Role {
	  S("S"),
	  DDE("DDE"),
	  DDOM("DDOM");
	  
	  private String label;

	  private Role(String label) {
	      this.label = label;
	  }

	  public String getLabel() {
	      return label;
	  }
}
