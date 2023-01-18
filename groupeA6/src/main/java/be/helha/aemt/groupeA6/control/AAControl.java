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
		AA aa = new AA(anneeAcademiqueAjout, codeAjout, intituleAjout, creditAjout, heureAjout, heureQ1Ajout, heureQ2Ajout, nombreGroupeAjout, nombreEtudiantAjout, fractionAjout);
		this.anneeAcademiqueAjout=0;
		this.codeAjout="";
		this.intituleAjout="";
		this.creditAjout=0;
		this.heureAjout=0;
		this.heureQ1Ajout=0;
		this.heureQ2Ajout=0;
		this.nombreGroupeAjout=0;
		this.nombreEtudiantAjout=0;
		this.fractionAjout=Fraction.MA;
		beanGestion.add(aa);
		return "listAa.xhtml";
	}
	
	public String doDelete(AA aa) {
		init();
		beanGestion.remove(aa);
		return "listeUe.xhtml";
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
		return "updateAa.xhtml";
	}

	public String doUpdate() {
		init();
		AA aa = new AA(anneeAcademiqueUpdate, codeUpdate, intituleUpdate, creditUpdate, heureUpdate, heureQ1Update, heureQ2Update, nombreGroupeUpdate, nombreEtudiantUpdate, fractionUpdate);
		aa.setId(idUpdate);
		beanGestion.update(aa);
		return "listUe.xhtml";
	}

}
