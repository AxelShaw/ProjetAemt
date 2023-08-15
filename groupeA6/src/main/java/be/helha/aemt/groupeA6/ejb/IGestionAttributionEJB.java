package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Attribution;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;

public interface IGestionAttributionEJB {
	public List<Attribution> findAll();
	public Attribution findById(int id) throws NotFoundException;
	public Attribution add(Attribution a) throws NotFoundException;
	public Attribution remove(Attribution a) throws NotFoundException;
	public Attribution update(Attribution a1, Attribution a2) throws NotFoundException; 
	public List<AA> findAllAAAttribues();
	public List<Mission> findAllMissionAttribues();
}
