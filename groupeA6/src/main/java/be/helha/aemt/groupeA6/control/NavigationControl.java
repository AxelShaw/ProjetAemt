package be.helha.aemt.groupeA6.control;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

// scope == durée d'activité du controller (session, requete)
@Named
@SessionScoped
public class NavigationControl implements Serializable {
	
	private String nom;
	
	public String doNext() {
		return "next.xhtml";
	}
	
	public String doList() {
		return "list.xhtml";
	}

	public String doAdd() {
		return "add.xhtml";
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}

//test2
