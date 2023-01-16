package be.helha.aemt.groupeA6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer anneeAcademique;
	private String intitule;
	private Integer heures;
	
	public Mission(int anAc,String inti,int hour)
	{
		anneeAcademique = anAc;
		intitule = inti;
		heures = hour;
	}
	public Mission() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anneeAcademique == null) ? 0 : anneeAcademique.hashCode());
		result = prime * result + ((heures == null) ? 0 : heures.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Mission))
			return false;
		Mission other = (Mission) obj;
		if (anneeAcademique == null) {
			if (other.anneeAcademique != null)
				return false;
		} else if (!anneeAcademique.equals(other.anneeAcademique))
			return false;
		if (heures == null) {
			if (other.heures != null)
				return false;
		} else if (!heures.equals(other.heures))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mission [id=" + id + ", anneeAcademique=" + anneeAcademique + ", intitule=" + intitule
				+ ", credit=" + ", heures=" + heures + "]";
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

