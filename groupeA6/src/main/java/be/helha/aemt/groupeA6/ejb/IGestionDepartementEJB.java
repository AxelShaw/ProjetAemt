package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Departement;

public interface IGestionDepartementEJB {
	public List<Departement> findAll();
	public Departement findById(int id);
	public Departement add(Departement d);
	public Departement remove(Departement d);

}
