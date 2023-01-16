package be.helha.aemt.groupeA6.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enseignant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private String mail;
	private String remarque;
	//private Attribution attribution
	
	public Enseignant() {
		super();
	}
	
	public Enseignant(String nom,String prenom, String mail,String remarque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.remarque = remarque;
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


	
}
