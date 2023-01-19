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
import be.helha.aemt.groupeA6.entities.UE;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class SectionsControl implements Serializable {
	

	private IGestionSectionEJB beanSectionGestion;
	
	private Integer id;
	private String nom;
    private List<Mission> missions;
    
    private Integer idU;
	private String nomU;
	private List<Mission> missionsU;
	
	private Integer idChoix;

	
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
	
	public Section doFindById(Integer id) {
		init();
		return beanSectionGestion.findById(id);
	}
	
	public String doAdd() {
		init();
		Section s = new Section(nom, missions);
		this.nom = "";
		this.missions = null;
		beanSectionGestion.add(s);
		return "listSection.xhtml";
	}

	public String doUpdate() {
		init();
		Section e = new Section(nomU, null);
		e.setId(idU);
		beanSectionGestion.update(e);
		return "listSection.xhtml";
	}
	
	public String doGoToUpdate(Section s ) {
		init();
		this.idU = s.getId();
		this.nom = s.getNom();
		this.missionsU = s.getMissions();
		return "updateSection.xhtml";
	}
	
	public Section doDelete(Section e) {
		init();
		return beanSectionGestion.remove(e);
	}
	
	public String doChoixSec(Section s) {
		init();
		this.idChoix = s.getId();
		return "choixMissionSection.xhtml";
	}
	
	public String addMission(Mission m) {
		init();
		Section s = doFindById(idChoix);
		s.addMission(m);
		beanSectionGestion.add(s);
		return "Section.xhtml";
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

	public Integer getIdU() {
		return idU;
	}

	public void setIdU(Integer idU) {
		this.idU = idU;
	}

	public String getNomU() {
		return nomU;
	}

	public void setNomU(String nomU) {
		this.nomU = nomU;
	}

	public List<Mission> getMissionsU() {
		return missionsU;
	}

	public void setMissionsU(List<Mission> missionsU) {
		this.missionsU = missionsU;
	}

	public Integer getIdChoix() {
		return idChoix;
	}

	public void setIdChoix(Integer idChoix) {
		this.idChoix = idChoix;
	}
	
	

}
