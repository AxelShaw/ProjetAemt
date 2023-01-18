package be.helha.aemt.groupeA6.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Mission> missions;
	
	public Section(String nom, List<Mission> missions) {
		this.nom = nom;
		this.missions= new ArrayList<>();
	}
	public Section() {
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", nom=" + nom + ", missions=" + missions + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Section))
			return false;
		Section other = (Section) obj;
		return Objects.equals(id, other.id) && Objects.equals(missions, other.missions)
				&& Objects.equals(nom, other.nom);
	}
	
	public void addMission(Mission m) {
		missions.add(m);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Mission> getMissions(){
		return missions;
	}
}
