package be.helha.aemt.groupeA6.control;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

// scope == durée d'activité du controller (session, requete)
@Named
@SessionScoped
public class NavigationControl implements Serializable {
	
	private String nom;
	
	public String doGroupeA6() {
		return "groupeA6.xhtml";
	}
	
	public String doAddEnseignant() {
		return "addEnseignant.xhtml";
	}
	
	public String doListEnseignant() {
		return "listEnseignant.xhtml";
	}

	public String doEnseignant() {
		return "Enseignant.xhtml";
	}
	
	public String doMission() {
		return "Mission.xhtml";
	}
	
	public String doAddMission() {
		return "addMission.xhtml";
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
