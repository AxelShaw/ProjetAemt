package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.DepartementDAO;
import be.helha.aemt.groupeA6.entities.Departement;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionDepartementEJB implements IGestionDepartementEJB {
	
	@EJB
	private DepartementDAO daoDepartement;

	@Override
	public List<Departement> findAll() {
		return daoDepartement.findAll();
	}

	@Override
	public Departement findById(int id) throws NotFoundException {
		return daoDepartement.findById(id);
	}

	@Override
	public Departement add(Departement d) throws NotFoundException {
		return daoDepartement.add(d);
	}

	@Override
	public Departement remove(Departement d) throws NotFoundException{
		return daoDepartement.remove(d);
	}


}
