package be.helha.aemt.groupeA6.dao;

public class DDOM implements Role {
	private static int permission;
	
	public DDOM() {
		permission = 2;
	}

	@Override
	public int getPerm() {
		return permission;
	}
}
