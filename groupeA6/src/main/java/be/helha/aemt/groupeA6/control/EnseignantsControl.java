package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.ejb.IGestionEnseignantEJB;
import be.helha.aemt.groupeA6.entities.Enseignant;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class EnseignantsControl implements Serializable {
	
//	utiliser le serveur pour une reference de EJB
//	supprimer l'annotation @Remote de IGestionEnseignant
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
	
	public EnseignantsControl() {
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
		return beanGestion.findAll();
	}
	
	public Enseignant doFindById() {
		init();
		return beanGestion.findById(idAjout);
	}
	
	public Enseignant doAdd() {
		init();
		Enseignant e = new Enseignant(nomAjout, prenomAjout, mailAjout, remarqueAjout,null);
		this.nomAjout = "";
		this.prenomAjout = "";
		this.mailAjout = "";
		this.remarqueAjout = "";
		return beanGestion.add(e);
	}
	
	public Enseignant doDelete(Enseignant e) {
		init();
		return beanGestion.remove(e);
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

	public Enseignant doUpdate() {
		init();
		Enseignant e = new Enseignant(nomUpdate, prenomUpdate, mailUpdate, remarqueUpdate,null);
		e.setId(idUpdate);
		return beanGestion.update(e);
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

}
