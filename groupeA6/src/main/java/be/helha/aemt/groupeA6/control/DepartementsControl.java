package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionDepartementEJB;
import be.helha.aemt.groupeA6.entities.Departement;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.entities.Section;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class DepartementsControl implements Serializable {
	

	private IGestionDepartementEJB beanDepartementGestion;
	private int id;
	private String nom;
	

	private List<Section> sections;
	
	private List<Mission> missions;
	
	
	public DepartementsControl() {
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanDepartementGestion = (IGestionDepartementEJB) ctx.lookup("java:global/groupeA6/GestionDepartementEJB!be.helha.aemt.groupeA6.ejb.IGestionDepartementEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Departement> doFindAll() {
		init();
		return beanDepartementGestion.findAll();
	}
	
	public Departement doFindById() {
		init();
		return beanDepartementGestion.findById(id);
	}
	
	public Departement doAdd() {
		init();
		Departement d = new Departement(nom, sections, missions);
		this.nom = "";
		this.sections = new ArrayList<>();
		this.missions = new ArrayList<>();
		return beanDepartementGestion.add(d);
	}
	
	public Departement doDelete(Departement d) {
		init();
		return beanDepartementGestion.remove(d);
	}
	
	
}
