package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionAAEJB;
import be.helha.aemt.groupeA6.ejb.IGestionUEEJB;
import be.helha.aemt.groupeA6.entities.UE;
import be.helha.aemt.groupeA6.exceptions.NotCompleteException;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Attribution;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AAControl implements Serializable {
	
	private IGestionAAEJB beanGestion;
	
	//Ajout
	private int idAjout;
	private int anneeAcademiqueAjout;
	private String codeAjout;
	private String intituleAjout;
	private int creditAjout;
	private int heureAjout;
	private int heureQ1Ajout;
	private int heureQ2Ajout;
	private int nombreGroupeAjout;
	private Integer nombreEtudiantAjout;
	
	private int fractionAjout;
	
	//Update
	private Integer idUpdate;
	private Integer anneeAcademiqueUpdate;
	private String codeUpdate;
	private String intituleUpdate;
	private Integer creditUpdate;
	private Integer heureUpdate;
	private Integer heureQ1Update;
	private Integer heureQ2Update;
	private Integer nombreGroupeUpdate;
	private Integer nombreEtudiantUpdate;
	private int fractionUpdate;
	
	private String name;
	
	public AAControl() {
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanGestion = (IGestionAAEJB) ctx.lookup("java:global/groupeA6/GestionAAEJB!be.helha.aemt.groupeA6.ejb.IGestionAAEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<AA> doFindAll() {
		init();
		return beanGestion.findAll(name);
	}
	
	public List<AA> doFindNonAttribues() {
		init();
		AttributionsControl atr = new AttributionsControl();
		List<AA> l = beanGestion.findAll(name);
		l.removeAll(atr.doFindAllAAAttribues());
		return l;
	}
	
	public AA doFindById() throws NotFoundException {
		init();
		return beanGestion.findById(idAjout);
	}
	
	public String doAdd() throws NotCompleteException, NotFoundException {
	    init();
	    
	    if (anneeAcademiqueAjout == 0 || codeAjout.isEmpty() || intituleAjout.isEmpty() || creditAjout == 0 ||
	        heureAjout == 0 || nombreGroupeAjout == 0 || nombreEtudiantAjout == 0 || fractionAjout == 0) {
	        throw new NotCompleteException();
	    }
	    
	    AA a = new AA(anneeAcademiqueAjout, codeAjout, intituleAjout, creditAjout, heureAjout, heureQ1Ajout, heureQ2Ajout, nombreGroupeAjout, nombreEtudiantAjout, fractionAjout);
	    
	    this.anneeAcademiqueAjout = 0;
	    this.codeAjout = "";
	    this.intituleAjout = "";
	    this.creditAjout = 0;
	    this.heureAjout = 0;
	    this.heureQ1Ajout = 0;
	    this.heureQ2Ajout = 0;
	    this.nombreGroupeAjout = 0;
	    this.nombreEtudiantAjout = 0;
	    this.fractionAjout = 0;
	    
	    beanGestion.add(a);
	    return "listAA.xhtml";
	}
	
	public String doDelete(AA a) throws NotFoundException {
		init();
		beanGestion.remove(a);
		return "listAA.xhtml";
	}
	
	public String doGoToUpdate(AA aa) throws NotCompleteException {
		init();
		

		
		this.idUpdate = aa.getId();
		this.anneeAcademiqueUpdate=aa.getAnneeAcademique();
		this.codeUpdate=aa.getCode();
		this.intituleUpdate=aa.getIntitule();
		this.creditUpdate=aa.getCredit();
		this.heureUpdate=aa.getHeure();
		this.heureQ1Update=aa.getHeureQ1();
		this.heureQ2Update=aa.getHeureQ2();
		this.nombreGroupeUpdate=aa.getNombreGroupe();
		this.nombreEtudiantUpdate=aa.getNombreEtudiant();
		this.fractionUpdate=aa.getFraction();
		return "updateAA.xhtml";
	}

	public String doUpdate() throws NotFoundException, NotCompleteException {
		init();
		
	    if (anneeAcademiqueUpdate == 0 || codeUpdate.isEmpty() || intituleUpdate.isEmpty() || creditUpdate == 0 ||
	    		heureUpdate == 0 || nombreGroupeUpdate == 0 || nombreEtudiantUpdate == 0 || fractionUpdate == 0) {
		        throw new NotCompleteException();
		    }
		
		AA aa = new AA(anneeAcademiqueUpdate, codeUpdate, intituleUpdate, creditUpdate, heureUpdate, heureQ1Update, heureQ2Update, nombreGroupeUpdate, nombreEtudiantUpdate, fractionUpdate);
		aa.setId(idUpdate);
		beanGestion.update(aa);
		return "listAA.xhtml";
	}

	public Integer getIdAjout() {
		return idAjout;
	}

	public void setIdAjout(Integer idAjout) {
		this.idAjout = idAjout;
	}

	public Integer getAnneeAcademiqueAjout() {
		return anneeAcademiqueAjout;
	}

	public void setAnneeAcademiqueAjout(Integer anneeAcademiqueAjout) {
		this.anneeAcademiqueAjout = anneeAcademiqueAjout;
	}

	public String getCodeAjout() {
		return codeAjout;
	}

	public void setCodeAjout(String codeAjout) {
		this.codeAjout = codeAjout;
	}

	public String getIntituleAjout() {
		return intituleAjout;
	}

	public void setIntituleAjout(String intituleAjout) {
		this.intituleAjout = intituleAjout;
	}

	public Integer getCreditAjout() {
		return creditAjout;
	}

	public void setCreditAjout(Integer creditAjout) {
		this.creditAjout = creditAjout;
	}

	public Integer getHeureAjout() {
		return heureAjout;
	}

	public void setHeureAjout(Integer heureAjout) {
		this.heureAjout = heureAjout;
	}

	public Integer getHeureQ1Ajout() {
		return heureQ1Ajout;
	}

	public void setHeureQ1Ajout(Integer heureQ1Ajout) {
		this.heureQ1Ajout = heureQ1Ajout;
	}

	public Integer getHeureQ2Ajout() {
		return heureQ2Ajout;
	}

	public void setHeureQ2Ajout(Integer heureQ2Ajout) {
		this.heureQ2Ajout = heureQ2Ajout;
	}

	public Integer getNombreGroupeAjout() {
		return nombreGroupeAjout;
	}

	public void setNombreGroupeAjout(Integer nombreGroupeAjout) {
		this.nombreGroupeAjout = nombreGroupeAjout;
	}

	public Integer getNombreEtudiantAjout() {
		return nombreEtudiantAjout;
	}

	public void setNombreEtudiantAjout(Integer nombreEtudiantAjout) {
		this.nombreEtudiantAjout = nombreEtudiantAjout;
	}

	public int getFractionAjout() {
		return fractionAjout;
	}

	public void setFractionAjout(int fractionAjout) {
		this.fractionAjout = fractionAjout;
	}

	public Integer getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(Integer idUpdate) {
		this.idUpdate = idUpdate;
	}

	public Integer getAnneeAcademiqueUpdate() {
		return anneeAcademiqueUpdate;
	}

	public void setAnneeAcademiqueUpdate(Integer anneeAcademiqueUpdate) {
		this.anneeAcademiqueUpdate = anneeAcademiqueUpdate;
	}

	public String getCodeUpdate() {
		return codeUpdate;
	}

	public void setCodeUpdate(String codeUpdate) {
		this.codeUpdate = codeUpdate;
	}

	public String getIntituleUpdate() {
		return intituleUpdate;
	}

	public void setIntituleUpdate(String intituleUpdate) {
		this.intituleUpdate = intituleUpdate;
	}

	public Integer getCreditUpdate() {
		return creditUpdate;
	}

	public void setCreditUpdate(Integer creditUpdate) {
		this.creditUpdate = creditUpdate;
	}

	public Integer getHeureUpdate() {
		return heureUpdate;
	}

	public void setHeureUpdate(Integer heureUpdate) {
		this.heureUpdate = heureUpdate;
	}

	public Integer getHeureQ1Update() {
		return heureQ1Update;
	}

	public void setHeureQ1Update(Integer heureQ1Update) {
		this.heureQ1Update = heureQ1Update;
	}

	public Integer getHeureQ2Update() {
		return heureQ2Update;
	}

	public void setHeureQ2Update(Integer heureQ2Update) {
		this.heureQ2Update = heureQ2Update;
	}

	public Integer getNombreGroupeUpdate() {
		return nombreGroupeUpdate;
	}

	public void setNombreGroupeUpdate(Integer nombreGroupeUpdate) {
		this.nombreGroupeUpdate = nombreGroupeUpdate;
	}

	public Integer getNombreEtudiantUpdate() {
		return nombreEtudiantUpdate;
	}

	public void setNombreEtudiantUpdate(Integer nombreEtudiantUpdate) {
		this.nombreEtudiantUpdate = nombreEtudiantUpdate;
	}

	public int getFractionUpdate() {
		return fractionUpdate;
	}

	public void setFractionUpdate(int fractionUpdate) {
		this.fractionUpdate = fractionUpdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
