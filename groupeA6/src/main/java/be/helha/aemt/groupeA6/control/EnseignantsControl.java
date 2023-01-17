package be.helha.aemt.groupeA6.control;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import be.helha.aemt.groupeA6.dao.InitDAO;
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
	
	private String nom;
	private String prenom;
	private String mail;
	private String remarque;
	private int id;
	
	private String show;
	
	public EnseignantsControl() {
		init();
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
		// faire appel à la méthode findAll de beanGestion
		return beanGestion.findAll();
	}
	
	public Enseignant doFindById() {
		return beanGestion.findById(id);
	}
	
	public String doDetails(int id) {
		this.id = id;
		return "details.xhtml";
	}
	
	public Enseignant doAdd() {
		// faire appel à la méthode add de beanGestion
		Enseignant e = new Enseignant(nom, prenom, mail, remarque);
		return beanGestion.add(e);
	}
	
	public void doInit() {
		InitDAO init = new InitDAO();
		init.init();
	}

	public void doShow() {
		InitDAO init = new InitDAO();
		show = init.showTables();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
