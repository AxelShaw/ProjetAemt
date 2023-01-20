package be.helha.aemt.groupeA6.entities;

public enum RoleList {
	  S("S"),
	  DDE("DDE"),
	  DDOM("DDOM");
	  
	  private String label;

	  private RoleList(String label) {
	      this.label = label;
	  }

	  public String getLabel() {
	      return label;
	  }
}
