package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionMissionEJB;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class MissionControl implements Serializable {
	
	private IGestionMissionEJB beanGestion;
	
	private int anneeAcademiqueAjout;
	private String intituleAjout;
	private int heuresAjout;
	private int idAjout;
	
	private int anneeAcademiqueUpdate;
	private String intituleUpdate;
	private int heuresUpdate;
	private int idUpdate;
	
	private String name;
	
	public MissionControl() {
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanGestion = (IGestionMissionEJB) ctx.lookup("java:global/groupeA6/GestionMissionEJB!be.helha.aemt.groupeA6.ejb.IGestionMissionEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Mission> doFindAll() {
		init();
		return beanGestion.findAll(name);
	}
	
	public List<Mission> doFindNonAttribues() {
		init();
		AttributionsControl atr = new AttributionsControl();
		List<Mission> l = beanGestion.findAll(name);
		l.removeAll(atr.doFindAllMissionAttribues());
		return l;
	}
	
	public Mission doFindById() throws NotFoundException{
		init();
		return beanGestion.findById(idAjout);
	}
	
	public String doAdd() throws NotFoundException{
		init();
		Mission e = new Mission(anneeAcademiqueAjout, intituleAjout, heuresAjout);
		this.anneeAcademiqueAjout = 0;
		this.intituleAjout = "";
		this.heuresAjout = 0;
		beanGestion.add(e);
		return "listMission.xhtml";
	}
	
	public String doDelete(Mission e) throws NotFoundException{
		init();
		beanGestion.remove(e);
		return "listMission.xhtml";
	}
	
	public String doGoToUpdate(Mission e) {
		init();
		this.idUpdate = e.getId();
		this.anneeAcademiqueUpdate = e.getAnneeAcademique();
		this.intituleUpdate = e.getIntitule();
		this.heuresUpdate = e.getHeures();
		return "updateMission.xhtml";
	}

	public String doUpdate() {
		init();
		Mission e = new Mission(anneeAcademiqueUpdate, intituleUpdate, heuresUpdate);
		e.setId(idUpdate);
		beanGestion.update(e);
		return "listMission.xhtml";
	}
	
	
	
	public IGestionMissionEJB getBeanGestion() {
		return beanGestion;
	}

	public void setBeanGestion(IGestionMissionEJB beanGestion) {
		this.beanGestion = beanGestion;
	}

	public int getAnneeAcademiqueAjout() {
		return anneeAcademiqueAjout;
	}

	public void setAnneeAcademiqueAjout(int anneeAcademiqueAjout) {
		this.anneeAcademiqueAjout = anneeAcademiqueAjout;
	}

	public String getIntituleAjout() {
		return intituleAjout;
	}

	public void setIntituleAjout(String intituleAjout) {
		this.intituleAjout = intituleAjout;
	}

	public Integer getHeuresAjout() {
		return heuresAjout;
	}

	public void setHeuresAjout(Integer heuresAjout) {
		this.heuresAjout = heuresAjout;
	}

	public int getAnneeAcademiqueUpdate() {
		return anneeAcademiqueUpdate;
	}

	public void setAnneeAcademiqueUpdate(int anneeAcademiqueUpdate) {
		this.anneeAcademiqueUpdate = anneeAcademiqueUpdate;
	}

	public String getIntituleUpdate() {
		return intituleUpdate;
	}

	public void setIntituleUpdate(String intituleUpdate) {
		this.intituleUpdate = intituleUpdate;
	}

	public Integer getHeuresUpdate() {
		return heuresUpdate;
	}

	public void setHeuresUpdate(Integer heuresUpdate) {
		this.heuresUpdate = heuresUpdate;
	}

	public int getIdAjout() {
		return idAjout;
	}

	public void setIdAjout(int idAjout) {
		this.idAjout = idAjout;
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
