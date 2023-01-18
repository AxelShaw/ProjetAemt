package be.helha.aemt.groupeA6.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mission implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int anneeAcademique;
	private String intitule;
	private Integer heures;
	

	public Mission(int anneeAcademique,String intitule,int heures)
	{
		this.anneeAcademique = anneeAcademique;
		this.intitule = intitule;
		this.heures = heures;
	}
	public Mission() {
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mission other = (Mission) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(Integer anneeAcademique) {
		this.anneeAcademique = anneeAcademique;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Integer getHeures() {
		return heures;
	}

	public void setHeures(Integer heures) {
		this.heures = heures;
	}

}

