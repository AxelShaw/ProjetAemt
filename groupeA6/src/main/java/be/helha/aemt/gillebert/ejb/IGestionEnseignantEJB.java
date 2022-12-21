package be.helha.aemt.gillebert.ejb;

import java.util.List;

import be.helha.aemt.gillebert.entities.Enseignant;
import jakarta.ejb.Remote;

public interface IGestionEnseignantEJB {
		
	public List<Enseignant> findAll();
	public Enseignant findById(int id);
	public Enseignant add(Enseignant e);
	public Enseignant remove(Enseignant e);
	public Enseignant update(Enseignant e1, Enseignant e2);
}
