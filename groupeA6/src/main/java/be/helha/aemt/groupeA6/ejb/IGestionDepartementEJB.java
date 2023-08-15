package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Departement;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.Remote;

public interface IGestionDepartementEJB {
	public List<Departement> findAll();
	public Departement findById(int id) throws NotFoundException;
	public Departement add(Departement d) throws NotFoundException;
	public Departement remove(Departement d) throws NotFoundException;

}
