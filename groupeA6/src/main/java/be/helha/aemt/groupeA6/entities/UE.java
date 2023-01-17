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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class UE implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int anneeAcademique;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Section section;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Departement departement;
	
	private String bloc;
	private String code;
	private String intitule;
	private int credit;
	

	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<AA> aas;
	
	public UE() {
		super();
	}
	
	public UE(int anneeAcademique,Section section ,Departement departement,String bloc, String code, String intitule, int credit, List<AA> aas) {
		super();
		this.anneeAcademique = anneeAcademique;
		this.section = section;
		this.departement = departement;
		this.bloc = bloc;
		this.code = code;
		this.intitule = intitule;
		this.credit = credit;
		aas = new ArrayList<>();
	}



	@Override
	public String toString() {
		return "UE [id=" + id + ", anneeAcademique=" + anneeAcademique + ", section=" + section + ", bloc=" + bloc
				+ ", code=" + code + ", intitule=" + intitule + ", credit=" + credit + ", aas=" + aas + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UE other = (UE) obj;
		return Objects.equals(id, other.id) && Objects.equals(code, other.code);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(int anneeAcademique) {
		this.anneeAcademique = anneeAcademique;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getBloc() {
		return bloc;
	}

	public void setBloc(String bloc) {
		this.bloc = bloc;
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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}



}
