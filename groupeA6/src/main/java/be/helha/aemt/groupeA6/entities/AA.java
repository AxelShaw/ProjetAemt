package be.helha.aemt.groupeA6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer anneeAcademique;
	private String code;
	private String intitule;
	private Integer credit;
	private Integer heure;
	private Integer heureQ1;
	private Integer heureQ2;
	private Integer nombreGroupe;
	private Integer nombreEtudiant;
	public enum Fraction{
		MA(480),
		MFP(750);
		  
		private final Integer fraction;

		private Fraction(int i) {
		  this.fraction = i;
		}
	}
	private Fraction fraction;
	
	public AA(int anAc,String code,String inti,int cred,int hour,int h1,int h2, int nbG,int nbE,Fraction f)
	{
		anneeAcademique = anAc;
		this.code = code;
		intitule = inti;
		credit = cred;
		heure = hour;
		heureQ1 = h1;
		heureQ2 = h2;
		nombreGroupe = nbG;
		nombreEtudiant = nbE;
		fraction=f;
	}
	public AA() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anneeAcademique == null) ? 0 : anneeAcademique.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
		result = prime * result + ((fraction == null) ? 0 : fraction.hashCode());
		result = prime * result + ((heure == null) ? 0 : heure.hashCode());
		result = prime * result + ((heureQ1 == null) ? 0 : heureQ1.hashCode());
		result = prime * result + ((heureQ2 == null) ? 0 : heureQ2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((nombreEtudiant == null) ? 0 : nombreEtudiant.hashCode());
		result = prime * result + ((nombreGroupe == null) ? 0 : nombreGroupe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AA))
			return false;
		AA other = (AA) obj;
		if (anneeAcademique == null) {
			if (other.anneeAcademique != null)
				return false;
		} else if (!anneeAcademique.equals(other.anneeAcademique))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		if (fraction != other.fraction)
			return false;
		if (heure == null) {
			if (other.heure != null)
				return false;
		} else if (!heure.equals(other.heure))
			return false;
		if (heureQ1 == null) {
			if (other.heureQ1 != null)
				return false;
		} else if (!heureQ1.equals(other.heureQ1))
			return false;
		if (heureQ2 == null) {
			if (other.heureQ2 != null)
				return false;
		} else if (!heureQ2.equals(other.heureQ2))
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
		if (nombreEtudiant == null) {
			if (other.nombreEtudiant != null)
				return false;
		} else if (!nombreEtudiant.equals(other.nombreEtudiant))
			return false;
		if (nombreGroupe == null) {
			if (other.nombreGroupe != null)
				return false;
		} else if (!nombreGroupe.equals(other.nombreGroupe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AA [id=" + id + ", anneeAcademique=" + anneeAcademique + ", code=" + code + ", intitule=" + intitule
				+ ", credit=" + credit + ", heure=" + heure + ", heureQ1=" + heureQ1 + ", heureQ2=" + heureQ2
				+ ", nombreGroupe=" + nombreGroupe + ", nombreEtudiant=" + nombreEtudiant + ", fraction=" + fraction
				+ "]";
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getHeure() {
		return heure;
	}

	public void setHeure(Integer heure) {
		this.heure = heure;
	}

	public Integer getHeureQ1() {
		return heureQ1;
	}

	public void setHeureQ1(Integer heureQ1) {
		this.heureQ1 = heureQ1;
	}

	public Integer getHeureQ2() {
		return heureQ2;
	}

	public void setHeureQ2(Integer heureQ2) {
		this.heureQ2 = heureQ2;
	}

	public Integer getNombreGroupe() {
		return nombreGroupe;
	}

	public void setNombreGroupe(Integer nombreGroupe) {
		this.nombreGroupe = nombreGroupe;
	}

	public Integer getNombreEtudiant() {
		return nombreEtudiant;
	}

	public void setNombreEtudiant(Integer nombreEtudiant) {
		this.nombreEtudiant = nombreEtudiant;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

}

