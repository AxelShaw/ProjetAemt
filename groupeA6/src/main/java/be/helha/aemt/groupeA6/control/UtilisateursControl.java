package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionEnseignantEJB;
import be.helha.aemt.groupeA6.ejb.IGestionUtilisateurEJB;
import be.helha.aemt.groupeA6.entities.Departement;
import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Role;
import be.helha.aemt.groupeA6.entities.Utilisateur;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class UtilisateursControl implements Serializable {
	
	private IGestionUtilisateurEJB beanGestion;
	

	
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String departement;
	private Role role;
	private String RoleE;
	
	private int id;
	
	
	public UtilisateursControl() {
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanGestion = (IGestionUtilisateurEJB) ctx.lookup("java:global/groupeA6/GestionUtilisateurEJB!be.helha.aemt.groupeA6.ejb.IGestionUtilisateurEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Utilisateur> doFindAll() {
		init();
		return beanGestion.findAll();
	}
	
	public Utilisateur doFindById() {
		init();
		return beanGestion.findById(id);
	}
	
	public Utilisateur doAdd() {
		init();
		Utilisateur u = new Utilisateur(nom, prenom, email, password,departement,RoleE);
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.password = "";
		this.departement = "";
		this.RoleE = role.S.name();
		return beanGestion.add(u);
	}
	
	public Utilisateur doDelete(Utilisateur u) {
		init();
		return beanGestion.remove(u);
	}
	
	

	//Getters and setters
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

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getRoleE() {
		return RoleE;
	}

	public void setRoleE(String roleE) {
		RoleE = roleE;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
