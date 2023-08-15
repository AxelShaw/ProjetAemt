package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Utilisateur;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.Remote;

@Remote
public interface IGestionUtilisateurEJB {
	
	public List<Utilisateur> findAll(String name);
	public Utilisateur findById(int id)throws NotFoundException;
	public Utilisateur add(Utilisateur u)throws NotFoundException;
	public Utilisateur remove(Utilisateur u) throws NotFoundException;
	public Utilisateur update(Utilisateur u)throws NotFoundException;
	public String getUsername(String email) throws NotFoundException;
	public int getRole(String email);
}
