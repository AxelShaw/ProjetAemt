package be.helha.aemt.groupeA6.entities;

import java.util.Objects;

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
	
	public AA(int anneeAcademique,String code,String intitule,int credit,int heure,int heureQ1,int heureQ2, int nombreGroupe,int nombreEtudiant,Fraction fractionAjout)
	{
		this.anneeAcademique = anneeAcademique;
		this.code = code;
		this.intitule = intitule;
		this.credit = credit;
		this.heure = heure;
		this.heureQ1 = heureQ1;
		this.heureQ2 = heureQ2;
		this.nombreGroupe = nombreGroupe;
		this.nombreEtudiant = nombreEtudiant;
		this.fraction=fractionAjout;
	}
	public AA() {
		
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AA other = (AA) obj;
		return Objects.equals(code, other.code) && Objects.equals(id, other.id);
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

