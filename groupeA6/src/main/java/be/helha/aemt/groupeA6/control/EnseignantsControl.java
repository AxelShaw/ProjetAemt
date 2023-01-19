package be.helha.aemt.groupeA6.control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

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
	
	public String doAdd() {
		init();
		Enseignant e = new Enseignant(nomAjout, prenomAjout, mailAjout, remarqueAjout,null);
		this.nomAjout = "";
		this.prenomAjout = "";
		this.mailAjout = "";
		this.remarqueAjout = "";
		beanGestion.add(e);
		return "listEnseignant.xhtml";
	}
	
	public String doDelete(Enseignant e) {
		init();
		beanGestion.remove(e);
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
	
	public void doPrintPDF(Enseignant e)
	{
		try {
			PdfWriter writer = new PdfWriter("enseignant.pdf");
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			PdfFont text = PdfFontFactory.createFont(FontConstants.TIMES);
			PdfFont titles = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
			document.add(new Paragraph("Nom: ").setFont(titles)
						.add(new Paragraph(e.getNom().toUpperCase())).setFont(text)
						.add(new Paragraph(e.getPrenom())).setFont(text))
				.add(new Paragraph("Mail: ").setFont(titles)
						.add(e.getMail()).setFont(text))
				.add(new Paragraph("Remarque: ").setFont(titles)
						.add(e.getRemarque()).setFont(text));
			Runtime.getRuntime().exec("enseignant.pdf");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
