package be.helha.aemt.groupeA6.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Departement implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	//Problèmes avec relations JPA, à rajouter après découverte du problème
	public Departement(String nom) {
		this.nom = nom;
	}
	public Departement() {
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Departement))
			return false;
		Departement other = (Departement) obj;
		return id == other.id && Objects.equals(nom, other.nom);
	}
	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
