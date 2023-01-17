package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;

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
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

@Named
@SessionScoped
public class AttributionsControl implements Serializable {
	
	private IGestionAttributionEJB beanGestionAttribution;
	

	
	private Integer id;
	
	private int AnneeAcademique;
	
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
		Attribution a = new Attribution(AnneeAcademique, aas,missions);
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
		return AnneeAcademique;
	}

	public void setAnneeAcademique(int anneeAcademique) {
		AnneeAcademique = anneeAcademique;
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
