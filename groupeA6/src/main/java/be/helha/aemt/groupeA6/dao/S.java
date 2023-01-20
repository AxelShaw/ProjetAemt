package be.helha.aemt.groupeA6.dao;

public class S implements Role {
	private static int permission;
	
	public S() {
		permission = 0;
	}

	@Override
	public int getPerm() {
		return permission;
	}
}
