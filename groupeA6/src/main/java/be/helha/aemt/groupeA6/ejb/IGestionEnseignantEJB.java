package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Enseignant;
import jakarta.ejb.Remote;

public interface IGestionEnseignantEJB {
		
	public List<Enseignant> findAll(String name);
	public Enseignant findById(int id);
	public Enseignant add(Enseignant e);
	public Enseignant remove(Enseignant e);
	public Enseignant update(Enseignant e);
}
