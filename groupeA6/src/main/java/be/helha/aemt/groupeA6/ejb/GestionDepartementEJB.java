package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.DepartementDAO;
import be.helha.aemt.groupeA6.entities.Departement;
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
	public Departement findById(int id) {
		return daoDepartement.findById(id);
	}

	@Override
	public Departement add(Departement d) {
		return daoDepartement.add(d);
	}

	@Override
	public Departement remove(Departement d) {
		return daoDepartement.remove(d);
	}


}
