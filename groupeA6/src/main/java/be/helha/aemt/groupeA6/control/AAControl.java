package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionAAEJB;
import be.helha.aemt.groupeA6.ejb.IGestionUEEJB;
import be.helha.aemt.groupeA6.entities.UE;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.AA.Fraction;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AAControl implements Serializable {
	
	private IGestionAAEJB beanGestion;
	
	//Ajout
	private Integer idAjout;
	private Integer anneeAcademiqueAjout;
	private String codeAjout;
	private String intituleAjout;
	private Integer creditAjout;
	private Integer heureAjout;
	private Integer heureQ1Ajout;
	private Integer heureQ2Ajout;
	private Integer nombreGroupeAjout;
	private Integer nombreEtudiantAjout;
	private Fraction fractionAjout;
	
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
	private Fraction fractionUpdate;
	
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
		return beanGestion.findAll();
	}
	
	public AA doFindById() {
		init();
		return beanGestion.findById(idAjout);
	}
	
	public String doAdd() {
		init();
		AA a = new AA(anneeAcademiqueAjout, codeAjout, intituleAjout, creditAjout, heureAjout, heureQ1Ajout, heureQ2Ajout, nombreGroupeAjout, nombreEtudiantAjout, fractionAjout);
		this.anneeAcademiqueAjout=0;
		this.codeAjout="";
		this.intituleAjout="";
		this.creditAjout=0;
		this.heureAjout=0;
		this.heureQ1Ajout=0;
		this.heureQ2Ajout=0;
		this.nombreGroupeAjout=0;
		this.nombreEtudiantAjout=0;
		this.fractionAjout=null;
		beanGestion.add(a);
		return "listAA.xhtml";
	}
	
	public String doDelete(AA a) {
		init();
		beanGestion.remove(a);
		return "listAA.xhtml";
	}
	
	public String doGoToUpdate(AA aa) {
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

	public String doUpdate() {
		init();
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

	public Fraction getFractionAjout() {
		return fractionAjout;
	}

	public void setFractionAjout(Fraction fractionAjout) {
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

	public Fraction getFractionUpdate() {
		return fractionUpdate;
	}

	public void setFractionUpdate(Fraction fractionUpdate) {
		this.fractionUpdate = fractionUpdate;
	}
	
	

}
