package be.helha.aemt.groupeA6.entities;

import java.io.Serializable;import java.util.Objects;

import be.helha.aemt.groupeA6.dao.DDE;
import be.helha.aemt.groupeA6.dao.DDOM;
import be.helha.aemt.groupeA6.dao.Role;
import be.helha.aemt.groupeA6.dao.S;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String departement;
	
	private String role;

	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String nom, String prenom, String email, String password, String departement, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.departement = departement;
		this.role = role;
	}

	public int getPerm() {
		Role r;
		if (role.equals("DDOM")) {
			r = new DDOM();
		} else if (role.equals("DDE")) {
			r = new DDE();
		} else {
			r = new S();
		}
		
		return r.getPerm();
	}
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", departement=" + departement + ", role=" + role + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getDepartement() {
		return departement;
	}
}
