package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionSectionEJB;
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
	
	private IGestionUEEJB beanGestion;
	private IGestionSectionEJB beanSectionGestion;
	
	private Section s;
	
	
	private int anneeAcademiqueAjout;
	private int blocAjout = 1;
	private String codeAjout;
	private int creditAjout;
	private String intituleAjout;
	private Departement departementAjout;
	private Section sectionAjout;
	private List<AA> aasAjout;
	private int idAjout;

	private int anneeAcademiqueUpdate;
	private int blocUpdate;
	private String codeUpdate;
	private int creditUpdate;
	private String intituleUpdate;
	private Departement departementUpdate;
	private Section sectionUpdate;
	private List<AA> aasUpdate;
	private int idUpdate;
	
	private List<UE> list;
		
	private int blocFilter;
	
	private int idChoix;
	
	public UEControl() {
		list = new ArrayList<>();
		init();
		list = beanGestion.findAll(blocFilter);
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanGestion = (IGestionUEEJB) ctx.lookup("java:global/groupeA6/GestionUEEJB!be.helha.aemt.groupeA6.ejb.IGestionUEEJB");
			beanSectionGestion = (IGestionSectionEJB) ctx.lookup("java:global/groupeA6/GestionSectionEJB!be.helha.aemt.groupeA6.ejb.IGestionSectionEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<UE> doFindAll() {
		init();
		list = beanGestion.findAll(blocFilter);
		return list;
	}
	
	public UE doFindById() {
		init();
		return beanGestion.findById(idAjout);
	}
	
	public String doAdd() {
		init();
		UE ue = new UE(anneeAcademiqueAjout, sectionAjout, departementAjout, blocAjout, codeAjout, intituleAjout, creditAjout, aasAjout);
		this.anneeAcademiqueAjout = 0;
		this.sectionAjout = null;
		this.departementAjout = null;
		this.blocAjout = 1;
		this.codeAjout = "";
		this.intituleAjout = "";
		this.creditAjout = 0;
		this.aasAjout = null;
		ue.addSection(s);
		beanGestion.add(ue);
		return "listUe.xhtml";
	}
	
	public String doDelete(UE ue) {
		init();
		beanGestion.remove(ue);
		return "listeUe.xhtml";
	}
	
	public String doGoToUpdate(UE ue) {
		init();
		this.idUpdate = ue.getId();
		this.anneeAcademiqueUpdate = ue.getAnneeAcademique();
		this.sectionUpdate = ue.getSection();
		this.departementUpdate = ue.getDepartement();
		this.blocUpdate = ue.getBloc();
		this.codeUpdate = ue.getCode();
		this.intituleUpdate = ue.getIntitule();
		this.creditUpdate = ue.getCredit();
		this.aasUpdate = ue.getAas();
		return "updateUe.xhtml";
	}

	public String doUpdate() {
		init();
		UE e = new UE(anneeAcademiqueUpdate, sectionUpdate, departementUpdate, blocUpdate, codeUpdate, intituleUpdate, creditUpdate, aasUpdate);
		e.setId(idUpdate);
		beanGestion.update(e);
		return "listUe.xhtml";
	}
	
	public String doChoixUe(UE e) {
		init();
		this.idChoix = e.getId();
		return "choixAaUe.xhtml";
	}
	
	public void doChoixSec(Section e) {
		s = e;
	}
	
	public String addAA(AA a) {
		init();
		UE s = doFindById(idChoix);
		s.addAA(a);
		beanGestion.add(s);
		return "groupeA6.xhtml";
	}
	
	public UE doFindById(Integer id) {
		init();
		return beanGestion.findById(id);
	}

	public int getAnneeAcademiqueAjout() {
		return anneeAcademiqueAjout;
	}

	public void setAnneeAcademiqueAjout(int anneeAcademiqueAjout) {
		this.anneeAcademiqueAjout = anneeAcademiqueAjout;
	}

	public int getBlocAjout() {
		return blocAjout;
	}

	public void setBlocAjout(int blocAjout) {
		this.blocAjout = blocAjout;
	}

	public String getCodeAjout() {
		return codeAjout;
	}

	public void setCodeAjout(String codeAjout) {
		this.codeAjout = codeAjout;
	}

	public int getCreditAjout() {
		return creditAjout;
	}

	public void setCreditAjout(int creditAjout) {
		this.creditAjout = creditAjout;
	}

	public String getIntituleAjout() {
		return intituleAjout;
	}

	public void setIntituleAjout(String intituleAjout) {
		this.intituleAjout = intituleAjout;
	}

	public Departement getDepartementAjout() {
		return departementAjout;
	}

	public void setDepartementAjout(Departement departementAjout) {
		this.departementAjout = departementAjout;
	}

	public Section getSectionAjout() {
		return sectionAjout;
	}

	public void setSectionAjout(Section sectionAjout) {
		this.sectionAjout = sectionAjout;
	}

	public List<AA> getAasAjout() {
		return aasAjout;
	}

	public void setAasAjout(List<AA> aasAjout) {
		this.aasAjout = aasAjout;
	}

	public int getIdAjout() {
		return idAjout;
	}

	public void setIdAjout(int idAjout) {
		this.idAjout = idAjout;
	}

	public int getAnneeAcademiqueUpdate() {
		return anneeAcademiqueUpdate;
	}

	public void setAnneeAcademiqueUpdate(int anneeAcademiqueUpdate) {
		this.anneeAcademiqueUpdate = anneeAcademiqueUpdate;
	}

	public int getBlocUpdate() {
		return blocUpdate;
	}

	public void setBlocUpdate(int blocUpdate) {
		this.blocUpdate = blocUpdate;
	}

	public String getCodeUpdate() {
		return codeUpdate;
	}

	public void setCodeUpdate(String codeUpdate) {
		this.codeUpdate = codeUpdate;
	}

	public int getCreditUpdate() {
		return creditUpdate;
	}

	public void setCreditUpdate(int creditUpdate) {
		this.creditUpdate = creditUpdate;
	}

	public String getIntituleUpdate() {
		return intituleUpdate;
	}

	public void setIntituleUpdate(String intituleUpdate) {
		this.intituleUpdate = intituleUpdate;
	}

	public Departement getDepartementUpdate() {
		return departementUpdate;
	}

	public void setDepartementUpdate(Departement departementUpdate) {
		this.departementUpdate = departementUpdate;
	}

	public Section getSectionUpdate() {
		return sectionUpdate;
	}

	public void setSectionUpdate(Section sectionUpdate) {
		this.sectionUpdate = sectionUpdate;
	}

	public List<AA> getAasUpdate() {
		return aasUpdate;
	}

	public void setAasUpdate(List<AA> aasUpdate) {
		this.aasUpdate = aasUpdate;
	}

	public int getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(int idUpdate) {
		this.idUpdate = idUpdate;
	}

	public int getBlocFilter() {
		return blocFilter;
	}

	public void setBlocFilter(int blocFilter) {
		this.blocFilter = blocFilter;
	}

	public List<UE> getList() {
		return list;
	}

	public void setList(List<UE> list) {
		this.list = list;
	}
	
}
