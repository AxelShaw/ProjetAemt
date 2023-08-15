package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.AttributionDAO;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Attribution;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionAttributionEJB implements IGestionAttributionEJB {
	
	@EJB
	private AttributionDAO daoAttribution;

	@Override
	public List<Attribution> findAll() {
		return daoAttribution.findAll();
	}

	@Override
	public Attribution findById(int id) throws NotFoundException {
		return daoAttribution.findById(id);
	}

	@Override
	public Attribution add(Attribution a) throws NotFoundException{
		return daoAttribution.add(a);
	}

	@Override
	public Attribution remove(Attribution a) throws NotFoundException{
		return daoAttribution.remove(a);
	}

	//@Override
	public Attribution update(Attribution a1, Attribution a2) throws NotFoundException{
		return daoAttribution.update(a1, a2);
	}
	
	public List<AA> findAllAAAttribues() {
		return daoAttribution.findAllAAAttribues();
	}

	public List<Mission> findAllMissionAttribues() {
		return daoAttribution.findAllMissionAttribues();
	}
}
