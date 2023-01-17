package be.helha.aemt.groupeA6.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departement implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Section> sections;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Mission> missions;
	
	
	
	public Departement(String nom, List<Section> sections, List<Mission> missions) {
		this.nom = nom;
		this.sections = new ArrayList<>(); 
		this.missions = new ArrayList<>();
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
