package be.helha.aemt.groupeA6.entities;

import java.io.Serializable;
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
import jakarta.persistence.OneToOne;

@Entity
public class Attribution implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int AnneeAcademique;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<AA> aas;
	


	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Mission> missions;
	
	
	public Attribution() {
		super();
	}
	
	public Attribution(int AnneeAcademique,List<AA> aas, List<Mission> missions) {
		super();
		this.AnneeAcademique = AnneeAcademique;
		aas = new ArrayList<>();
		missions = new ArrayList<>();
	}
	
	public void addMission(Mission m) {
		missions.add(m);
	}
	
	public void addAA(AA m) {
		aas.add(m);
	}
	
	
	@Override
	public String toString() {
		return "\nid=" + id + ", Annee Academique=" + AnneeAcademique ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attribution other = (Attribution) obj;
		return Objects.equals(id, other.id);
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAnneeAcademique() {
		return AnneeAcademique;
	}

	public void setAnneeAcademique(int anneeAcademique) {
		AnneeAcademique = anneeAcademique;
	}

	public List<AA> getAas() {
		return aas;
	}

	public void setAas(List<AA> aas) {
		this.aas = aas;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}


	
}
