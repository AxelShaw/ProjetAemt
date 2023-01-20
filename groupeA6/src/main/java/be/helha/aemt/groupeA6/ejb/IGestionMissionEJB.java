package be.helha.aemt.groupeA6.ejb;

import java.util.List;
import be.helha.aemt.groupeA6.entities.Mission;
import jakarta.ejb.Remote;

public interface IGestionMissionEJB {
	public List<Mission> findAll();
	public Mission findById(int id);
	public Mission add(Mission m);
	public Mission remove(Mission m);
	public Mission update(Mission m);
}