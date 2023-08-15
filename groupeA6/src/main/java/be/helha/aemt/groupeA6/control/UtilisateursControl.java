package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionUtilisateurEJB;
import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.RoleList;
import be.helha.aemt.groupeA6.entities.Utilisateur;
import be.helha.aemt.groupeA6.exceptions.InvalidUserInputException;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	
	private String name;
	
	private String username = "";
	
	public void doUsername() throws NotFoundException {
		username = doGetUsername(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
	}
	
	// Détermine si l'utilisateur connecté a l'autorisation d'accéder au contenu
	public boolean isAllowed(int permNeeded) {
		// Détermine le niveau de permission de l'utilisateur connecté
		int permUser = doGetRole(
		// Recupère l'utilisateur se connectant à l'application
		FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		// Compare le niveau de permission de l'utilisateur avec le niveau de permission requis
		return permUser >= permNeeded;
	}
	
	public UtilisateursControl() {

	}
	
	//deconnection
	public String doLogout() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    
	    // Get all cookies from the request
	    Cookie[] cookies = request.getCookies();
	    
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("JSESSIONID".equals(cookie.getName())) {
	                // Set the max age of the cookie to 0 to invalidate it
	                cookie.setMaxAge(0);
	                
	                // Add the cookie to the response to remove it
	                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	                response.addCookie(cookie);
	                break;
	            }
	        }
	    }
	    
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    try {
	        externalContext.redirect("/groupeA6/");
	    } catch (Exception e) {
	        e.printStackTrace(); // Handle the exception appropriately
	    }
	    return "";
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
		return beanGestion.findAll(name);
	}
	
	public Utilisateur doFindById() throws NotFoundException{
		init();
		return beanGestion.findById(id);
	}
	
	public String doAdd() throws NoSuchAlgorithmException , NotFoundException{
		init();
		setEmailValidation(email);
		if(email==null) {
			return "errorMail.xhtml";
		}
		Utilisateur u = new Utilisateur(nom, prenom, email, HashPasswordControl.hashPassword(password),departement,role);
		
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.password = "";
		
		this.departement = "";
		this.role = "";
		beanGestion.add(u);
		return "listUtilisateur.xhtml";
	}
	
	public void setEmailValidation(String email) {
		if(email.matches("^[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+.)?[a-zA-Z]+.)?(helha).be$")) {
			this.email = email;
			this.emailUpdate = email;
		}
		else  {
			this.email = null;
			this.emailUpdate = null;
		}
	}
	
	public String doDelete(Utilisateur u)throws NotFoundException {
		init();
		beanGestion.remove(u);
		return "listUtilisateur.xhtml";
	}
	
	public String doGetUsername(String email) throws NotFoundException{
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

	public String doUpdate() throws NotFoundException{
		init();
		setEmailValidation(emailUpdate);
		if(this.emailUpdate==null) {
			return "errorMail.xhtml";
		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
