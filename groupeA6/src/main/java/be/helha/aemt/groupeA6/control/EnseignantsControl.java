package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionEnseignantEJB;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Attribution;
import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Mission;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class EnseignantsControl implements Serializable {
	
	private IGestionEnseignantEJB beanGestion;
	
	private String nomAjout;
	private String prenomAjout;
	private String mailAjout;
	private String remarqueAjout;
	private int idAjout;
	
	private String nomUpdate;
	private String prenomUpdate;
	private String mailUpdate;
	private String remarqueUpdate;
	private int idUpdate;
	
	private List<AA> aas;
	private List<Mission> missions;
	
	private List<Enseignant> list;
	
	private Integer idChoix;
	
	private String name;
	
	public EnseignantsControl() {
		list = new ArrayList<>();
		init();
		list = beanGestion.findAll(name);
	}

	public void init() {
		Context ctx;
		try {
			ctx = new InitialContext();
			beanGestion = (IGestionEnseignantEJB) ctx.lookup("java:global/groupeA6/GestionEnseignantEJB!be.helha.aemt.groupeA6.ejb.IGestionEnseignantEJB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Enseignant> doFindAll() {
		init();
		list = beanGestion.findAll(name);
		return list;
	}
	
	public Enseignant doFindById() {
		init();
		return beanGestion.findById(idAjout);
	}
	
	public Enseignant doFindById(Integer id) {
		init();
		return beanGestion.findById(id);
	}
	
	
	
	public String doAdd() {
		init();
		Enseignant e = new Enseignant(nomAjout, prenomAjout, mailAjout, remarqueAjout,null);
		this.nomAjout = "";
		this.prenomAjout = "";
		this.mailAjout = "";
		this.remarqueAjout = "";
		Attribution a = new Attribution(2023,aas,missions);
		e.addAttribution(a);
		beanGestion.add(e);
		return "listEnseignant.xhtml";
	}
	
	public String doDelete(Enseignant e) {
		init();
		beanGestion.remove(e);
		
		return "listEnseignant.xhtml";
	}
	
	public String doFindMailById(Integer id){
		init();

		int temp = 0;
		Enseignant res = beanGestion.findById(id);
		
		String contenu = "Liste des AA : \n";
		
		for(int i = 0; i<res.getAttribution().getAas().size();i++) {
			contenu = contenu + res.getAttribution().getAas().get(i).toString() +"\n";
		}
		
		String contenu2 = "Liste des Missions : \n";
		
		for(int i = 0; i<res.getAttribution().getMissions().size();i++) {
			contenu2 = contenu2 + res.getAttribution().getMissions().get(i).toString();
		}

		MailControl.sendMail(res.getMail(), contenu, contenu2);
		return "listEnseignant.xhtml";
	}
	
	public String doGoToUpdate(Enseignant e) {
		init();
		this.idUpdate = e.getId();
		this.nomUpdate = e.getNom();
		this.prenomUpdate = e.getPrenom();
		this.mailUpdate = e.getMail();
		this.remarqueUpdate = e.getRemarque();
		return "updateEnseignant.xhtml";
	}

	public String doUpdate() {
		init();
		Enseignant e = new Enseignant(nomUpdate, prenomUpdate, mailUpdate, remarqueUpdate,null);
		e.setId(idUpdate);
		beanGestion.update(e);
		return "listEnseignant.xhtml";
	}

	public String doChoixEns(Enseignant e) {
		init();
		this.idChoix = e.getId();
		return "choixEnseignantMission.xhtml";
	}
	
	public String doChoixEns2(Enseignant e) {
		init();
		this.idChoix = e.getId();
		return "choixEnseignantAA.xhtml";
	}
	
	public String addMission(Mission m) {
		init();
		Enseignant s = doFindById(idChoix);
		s.getAttribution().addMission(m);
		beanGestion.add(s);
		return "Section.xhtml";
	}
	
	public String addAA(AA a) {
		init();
		Enseignant s = doFindById(idChoix);
		s.getAttribution().addAA(a);
		beanGestion.add(s);
		return "Section.xhtml";
	}
	
	

	
	public String getNomAjout() {
		return nomAjout;
	}

	public void setNomAjout(String nomAjout) {
		this.nomAjout = nomAjout;
	}

	public String getPrenomAjout() {
		return prenomAjout;
	}

	public void setPrenomAjout(String prenomAjout) {
		this.prenomAjout = prenomAjout;
	}

	public String getMailAjout() {
		return mailAjout;
	}

	public void setMailAjout(String mailAjout) {
		this.mailAjout = mailAjout;
	}

	public String getRemarqueAjout() {
		return remarqueAjout;
	}

	public void setRemarqueAjout(String remarqueAjout) {
		this.remarqueAjout = remarqueAjout;
	}

	public int getIdAjout() {
		return idAjout;
	}

	public void setIdAjout(int idAjout) {
		this.idAjout = idAjout;
	}

	public String getNomUpdate() {
		return nomUpdate;
	}

	public void setNomUpdate(String nomUpdate) {
		this.nomUpdate = nomUpdate;
	}

	public String getPrenomUpdate() {
		return prenomUpdate;
	}

	public void setPrenomUpdate(String prenomUpdate) {
		this.prenomUpdate = prenomUpdate;
	}

	public String getMailUpdate() {
		return mailUpdate;
	}

	public void setMailUpdate(String mailUpdate) {
		this.mailUpdate = mailUpdate;
	}

	public String getRemarqueUpdate() {
		return remarqueUpdate;
	}

	public void setRemarqueUpdate(String remarqueUpdate) {
		this.remarqueUpdate = remarqueUpdate;
	}

	public int getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(int idUpdate) {
		this.idUpdate = idUpdate;
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

	public Integer getIdChoix() {
		return idChoix;
	}

	public void setIdChoix(Integer idChoix) {
		this.idChoix = idChoix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Enseignant> getList() {
		return list;
	}

	public void setList(List<Enseignant> list) {
		this.list = list;
	}
	
}
