package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionSectionEJB;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.entities.Section;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class SectionsControl implements Serializable {
	

	private IGestionSectionEJB beanSectionGestion;
	
	private Integer id;
	private String nom;
    private List<Mission> missions;


	
	public SectionsControl() {
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanSectionGestion = (IGestionSectionEJB) ctx.lookup("java:global/groupeA6/GestionSectionEJB!be.helha.aemt.groupeA6.ejb.IGestionSectionEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Section> doFindAll() {
		init();
		return beanSectionGestion.findAll();
	}
	
	public Section doFindById() {
		init();
		return beanSectionGestion.findById(id);
	}
	
	public Section doAdd() {
		init();
		Section s = new Section(nom, missions);
		this.nom = "";
		this.missions = new ArrayList<>();
		return beanSectionGestion.add(s);
	}
	
	public Section doDelete(Section e) {
		init();
		return beanSectionGestion.remove(e);
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

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	


}
