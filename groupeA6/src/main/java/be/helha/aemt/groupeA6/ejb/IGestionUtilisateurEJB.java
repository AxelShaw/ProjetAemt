package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Utilisateur;

public interface IGestionUtilisateurEJB {
	
	public List<Utilisateur> findAll();
	public Utilisateur findById(int id);
	public Utilisateur add(Utilisateur u);
	public Utilisateur remove(Utilisateur u);
	public Utilisateur update(Utilisateur u);
	public String getUsername(String email);
	public int getRole(String email);
}
