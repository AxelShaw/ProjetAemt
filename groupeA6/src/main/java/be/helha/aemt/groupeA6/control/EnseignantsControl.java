package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionEnseignantEJB;
import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.entities.Attribution;
import be.helha.aemt.groupeA6.entities.Enseignant;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.exceptions.EmailDuplicateException;
import be.helha.aemt.groupeA6.exceptions.NotCompleteException;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class EnseignantsControl implements Serializable{
	
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
	
	private double heureR;
	
	private List<AA> aas;
	private List<Mission> missions;
	
	private List<Enseignant> list;
	
	private Integer idChoix;
	
	private AA aaSelected;
	
	private Mission misSelected;
	
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
	
	public Enseignant doFindById() throws NotFoundException{
		init();
		return beanGestion.findById(idAjout);
	}
	
	public Enseignant doFindById(Integer id) throws NotFoundException{
		init();
		heureR = 0;
		double temp = 0;
		Enseignant s = beanGestion.findById(id);
		for (int i = 0; i < s.getAttribution().getAas().size(); i++) {
			double fra = s.getAttribution().getAas().get(i).getFraction();
			double heure = s.getAttribution().getAas().get(i).getHeure();
			temp = temp + heure/fra;
		}
		
		for (int i = 0; i < s.getAttribution().getMissions().size(); i++) {
			double heure = s.getAttribution().getMissions().get(i).getHeures();
			temp = temp + heure/1400;
		}
		
		temp = temp * 10;
		temp = Math.round(temp * Math.pow(10,2)) / Math.pow(10,2);
		heureR = temp;
		return beanGestion.findById(id);
	}
	
	

	public String doAdd() throws NotFoundException, EmailDuplicateException,NotCompleteException{

		init();
		setEmailValidation(mailAjout);
		if(mailAjout==null) {
			return "errorMail.xhtml";
		}
		
		if (nomAjout.isEmpty() || prenomAjout.isEmpty()) {
	        throw new NotCompleteException();
	    }
		
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
	
	public String doDelete(Enseignant e) throws NotFoundException{
		init();
		beanGestion.remove(e);
		
		return "listEnseignant.xhtml";
	}
	
	public void setEmailValidation(String email) {
		if(email.matches("^[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+.)?[a-zA-Z]+.)?(helha).be$")) {
			this.mailAjout = email;
			this.mailUpdate = email;
		}else{
			this.mailAjout = null;
			this.mailUpdate = null;
		}
	}

	
	public String doFindMailById(Integer id) throws NotFoundException{
		init();
		
		heureR = 0;
		double temp2 = 0;
		Enseignant s = beanGestion.findById(id);
		for (int i = 0; i < s.getAttribution().getAas().size(); i++) {
			double fra = s.getAttribution().getAas().get(i).getFraction();
			double heure = s.getAttribution().getAas().get(i).getHeure();
			temp2 = temp2 + heure/fra;
		}
		
		for (int i = 0; i < s.getAttribution().getMissions().size(); i++) {
			double heure = s.getAttribution().getMissions().get(i).getHeures();
			temp2 = temp2 + heure/1400;
		}
		
		temp2 = temp2 * 10;
		temp2 = Math.round(temp2 * Math.pow(10,2)) / Math.pow(10,2);
		heureR = temp2;
		

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
		
		contenu2 = contenu2 + heureR + " / 10";

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


	public String doUpdate() throws NotFoundException, EmailDuplicateException,NotCompleteException{

		init();
		setEmailValidation(mailUpdate);
		if(this.mailUpdate==null) {
			return "errorMail.xhtml";
		}
		
		if (nomUpdate.isEmpty() || prenomUpdate.isEmpty()) {
	        throw new NotCompleteException();
	    }
		
		Enseignant e = new Enseignant(nomUpdate, prenomUpdate, mailUpdate, remarqueUpdate,null);
		e.setId(idUpdate);
		beanGestion.update(e);
		return "listEnseignant.xhtml";
	}

	public String selectMission(Mission m) {
		init();
		this.misSelected = m;
		return "choixEnseignantEnseignant.xhtml";
	}
	
	public String addMission(Enseignant e) throws NotFoundException, EmailDuplicateException{
		init();
		e.getAttribution().addMission(misSelected);
		beanGestion.add(e);
		return "groupeA6.xhtml";
	}
	
	public String selectAA(AA a) {
		init();
		this.aaSelected = a;
		return "choixEnseignantEnseignantAA.xhtml";
	}
	
	public String addAA(Enseignant e) throws NotFoundException, EmailDuplicateException{
		init();
		e.getAttribution().addAA(aaSelected);
		beanGestion.add(e);
		return "groupeA6.xhtml";
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

	public double getHeureR() {
		return heureR;
	}

	public void setHeureR(double heureR) {
		this.heureR = heureR;
	}


	
}
