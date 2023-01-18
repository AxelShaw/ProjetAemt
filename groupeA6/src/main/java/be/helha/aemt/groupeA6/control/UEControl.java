package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionEnseignantEJB;
import be.helha.aemt.groupeA6.ejb.IGestionUEEJB;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Departement;
import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Section;
import be.helha.aemt.groupeA6.entities.UE;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class UEControl implements Serializable{
	
//	utiliser le serveur pour une reference de EJB
//	supprimer l'annotation @Remote de IGestionEnseignant
	private IGestionUEEJB beanGestion;
	
	private int anneeAcademiqueAjout;
	private String blocAjout;
	private String codeAjout;
	private int creditAjout;
	private String intituleAjout;
	private Departement departementAjout;
	private Section sectionAjout;
	private List<AA> aasAjout;
	private int idAjout;

	private int anneeAcademiqueUpdate;
	private String blocUpdate;
	private String codeUpdate;
	private int creditUpdate;
	private String intituleUpdate;
	private Departement departementUpdate;
	private Section sectionUpdate;
	private List<AA> aasUpdate;
	private int idUpdate;
	
	public UEControl() {
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanGestion = (IGestionUEEJB) ctx.lookup("java:global/groupeA6/GestionUEEJB!be.helha.aemt.groupeA6.ejb.IGestionUEEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<UE> doFindAll() {
		init();
		return beanGestion.findAll();
	}
	
	public UE doFindById() {
		init();
		return beanGestion.findById(idAjout);
	}
	
	public String doAdd() {
		init();
		UE e = new UE(anneeAcademiqueAjout, null, null, blocAjout, codeAjout, intituleAjout, creditAjout, null);
		this.anneeAcademiqueAjout = 0;
		this.blocAjout = "";
		this.codeAjout = "";
		this.intituleAjout = "";
		this.creditAjout = 0;
		beanGestion.add(e);
		return "listEnseignant.xhtml";
	}
	
	public String doDelete(UE e) {
		init();
		beanGestion.remove(e);
		return "listEnseignant.xhtml";
	}
	
	public String doGoToUpdate(UE e) {
		init();
		this.idUpdate = e.getId();
		this.anneeAcademiqueUpdate = e.getAnneeAcademique();
		this.sectionUpdate = e.getSection();
		this.blocUpdate = e.getBloc();
		this.codeUpdate = e.getCode();
		this.intituleUpdate = e.getIntitule();
		this.creditUpdate = e.getCredit();
		return "updateEnseignant.xhtml";
	}

	/*public String doUpdate() {
		init();
		UE e = new UE(anneeAcademiqueAjout, null, null, blocAjout, codeAjout, intituleAjout, creditAjout, null);
		e.setId(idUpdate);
		beanGestion.update(e);
		return "listEnseignant.xhtml";
	}*/

}
