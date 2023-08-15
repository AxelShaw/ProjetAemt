package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.Remote;

public interface IGestionEnseignantEJB {
		
	public List<Enseignant> findAll(String name);
	public Enseignant findById(int id) throws NotFoundException;
	public Enseignant add(Enseignant e) throws NotFoundException;
	public Enseignant remove(Enseignant e) throws NotFoundException;
	public Enseignant update(Enseignant e) throws NotFoundException;
}
