package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionUtilisateurEJB;
import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.RoleList;
import be.helha.aemt.groupeA6.entities.Utilisateur;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Named
@SessionScoped
public class UtilisateursControl implements Serializable {
	
	private IGestionUtilisateurEJB beanGestion;
	
	
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String departement;
	
	private String role;
	
	private String nomUpdate;
	private String prenomUpdate;
	private String emailUpdate;
	private String passwordUpdate;
	private String departementUpdate;
	private String roleUpdate;
	private int idUpdate;
	
	private int id;
	
	private String username = "";
	
	public void doUsername() {
		username = doGetUsername(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
	}
	
	public boolean isAllowed(int permNeeded) {
		int permUser = doGetRole(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		return permUser >= permNeeded;
	}
	
	public UtilisateursControl() {
	}
	
    public RoleList[] getStatuses() {
        return RoleList.values();
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
	
	public String doAdd() {
		init();
		Utilisateur u = new Utilisateur(nom, prenom, email, password,departement,role);
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.password = "";
		this.departement = "";
		this.role = "";
		beanGestion.add(u);
		return "listUtilisateur.xhtml";
	}
	
	public Utilisateur doDelete(Utilisateur u) {
		init();
		return beanGestion.remove(u);
	}
	
	public String doGetUsername(String email) {
		init();
		return beanGestion.getUsername(email);
	}
	
	public int doGetRole(String email) {
		init();
		return beanGestion.getRole(email);
	}
	
	public String doGoToUpdate(Utilisateur u) {
		init();
		this.idUpdate = u.getId();
		this.nomUpdate = u.getNom();
		this.prenomUpdate = u.getPrenom();
		this.emailUpdate = u.getEmail();
		this.passwordUpdate = u.getPassword();
		this.departementUpdate = u.getDepartement();
		this.roleUpdate = u.getRole();
		return "updateUtilisateur.xhtml";
	}

	public String doUpdate() {
		init();
		Utilisateur u = new Utilisateur(nomUpdate, prenomUpdate, emailUpdate, passwordUpdate,departementUpdate,roleUpdate);
		u.setId(idUpdate);
		beanGestion.update(u);
		return "listUtilisateur.xhtml";
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


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNomUpdate() {
		return nomUpdate;
	}

	public void setNomUpdate(String nomUpdate) {
		this.nomUpdate = nomUpdate;
	}

	public String getPrenomUpdate() {
		return prenomUpdate;
	}

	public void setPrenomUpdate(String prenomUpdate) {
		this.prenomUpdate = prenomUpdate;
	}

	public String getEmailUpdate() {
		return emailUpdate;
	}

	public void setEmailUpdate(String emailUpdate) {
		this.emailUpdate = emailUpdate;
	}

	public String getPasswordUpdate() {
		return passwordUpdate;
	}

	public void setPasswordUpdate(String passwordUpdate) {
		this.passwordUpdate = passwordUpdate;
	}

	public String getDepartementUpdate() {
		return departementUpdate;
	}

	public void setDepartementUpdate(String departementUpdate) {
		this.departementUpdate = departementUpdate;
	}

	public String getRoleUpdate() {
		return roleUpdate;
	}

	public void setRoleUpdate(String roleUpdate) {
		this.roleUpdate = roleUpdate;
	}

	public int getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(int idUpdate) {
		this.idUpdate = idUpdate;
	}
}
