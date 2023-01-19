package be.helha.aemt.groupeA6.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Enseignant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private String mail;
	private String remarque;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Attribution attribution;
	
	public Enseignant() {
		super();
	}
	
	public Enseignant(String nom, String prenom, String mail, String remarque, Attribution attribution) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.remarque = remarque;
		this.attribution = attribution;
	}
	
	public void addAttribution(Attribution a) {
		attribution = a;
	}

	@Override
	public String toString() {
		return "\nid=" + id + ", nom=" + nom + ", email=" + mail;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enseignant other = (Enseignant) obj;
		return Objects.equals(mail, other.mail) && Objects.equals(id, other.id) && Objects.equals(nom, other.nom);
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Attribution getAttribution() {
		return attribution;
	}

	public void setAttribution(Attribution attribution) {
		this.attribution = attribution;
	}
	
	
}
