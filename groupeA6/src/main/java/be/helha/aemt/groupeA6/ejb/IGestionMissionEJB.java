package be.helha.aemt.groupeA6.ejb;

import java.util.List;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.Remote;

public interface IGestionMissionEJB {
	public List<Mission> findAll(String name);
	public Mission findById(int id) throws NotFoundException;
	public Mission add(Mission m) throws NotFoundException;
	public Mission remove(Mission m) throws NotFoundException;
	public Mission update(Mission m);
}