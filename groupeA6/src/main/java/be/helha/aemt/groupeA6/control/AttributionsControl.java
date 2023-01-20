package be.helha.aemt.groupeA6.control;

import java.io.Serializable;import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionAttributionEJB;
import be.helha.aemt.groupeA6.ejb.IGestionEnseignantEJB;
import be.helha.aemt.groupeA6.ejb.IGestionUtilisateurEJB;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Attribution;
import be.helha.aemt.groupeA6.entities.Departement;
import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.entities.Role;
import be.helha.aemt.groupeA6.entities.Utilisateur;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

@Named
@SessionScoped
public class AttributionsControl implements Serializable {
	
	private IGestionAttributionEJB beanGestionAttribution;
	

	
	private Integer id;
	
	private int anneeAcademique;
	
	private List<AA> aas;
	
	private List<Mission> missions;
	
	
	public AttributionsControl() {
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanGestionAttribution = (IGestionAttributionEJB) ctx.lookup("java:global/groupeA6/GestionAttributionEJB!be.helha.aemt.groupeA6.ejb.IGestionAttributionEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Attribution> doFindAll() {
		init();
		return beanGestionAttribution.findAll();
	}
	
	public Attribution doFindById() {
		init();
		return beanGestionAttribution.findById(id);
	}
	
	public Attribution doAdd() {
		init();
		Attribution a = new Attribution(anneeAcademique, aas,missions);
		return beanGestionAttribution.add(a);
	}
	
	public Attribution doDelete(Attribution a) {
		init();
		return beanGestionAttribution.remove(a);
	}

	//Getters and setters
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
		anneeAcademique = anneeAcademique;
	}

	public List<AA> getAas() {
		return aas;
	}

	public void setAas(List<AA> aas) {
		this.aas = aas;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	




}
