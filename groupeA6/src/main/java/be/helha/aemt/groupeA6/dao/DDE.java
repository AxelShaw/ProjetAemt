package be.helha.aemt.groupeA6.dao;

public class DDE implements Role {
	private static int permission;
	
	public DDE() {
		permission = 1;
	}

	@Override
	public int getPerm() {
		return permission;
	}
}
