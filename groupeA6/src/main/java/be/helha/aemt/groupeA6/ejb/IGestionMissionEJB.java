package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Mission;

public interface IGestionMissionEJB {
	public List<Mission> findAll();
	public Mission findById(int id);
	public Mission add(Mission m);
	public Mission remove(Mission m);
	public Enseignant update(Enseignant e);
}