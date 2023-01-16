package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.AttributionDAO;
import be.helha.aemt.groupeA6.entities.Attribution;

public class GestionAttributionEJB implements IGestionAttributionEJB {
	
	private AttributionDAO daoAttribution;

	@Override
	public List<Attribution> findAll() {
		return daoAttribution.findAll();
	}

	@Override
	public Attribution findById(int id) {
		return daoAttribution.findById(id);
	}

	@Override
	public Attribution add(Attribution a) {
		return daoAttribution.add(a);
	}

	@Override
	public Attribution remove(Attribution a) {
		return daoAttribution.remove(a);
	}

	//@Override
/*	public Attribution update(Attribution a1, Attribution a2) {
		return daoAttribution.update(a1, a2);
	}*/

}
