package be.helha.aemt.groupeA6.control;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@SessionScoped
public class NavigationControl implements Serializable {
	
	public String doGroupeA6() {
		return "groupeA6.xhtml";
	}
	
	public String doAddEnseignant() {
		return "addEnseignant.xhtml";
	}
	public String doAddAA() {
		return "addAA.xhtml";
	}
	
	public String doListEnseignant() {
		return "listEnseignant.xhtml";
	}
	public String doListUtilisateur() {
		return "listUtilisateur.xhtml";
	}
	public String doListAA() {
		return "listAA.xhtml";
	}
	
	public String doListMission() {
		return "listMission.xhtml";
	}
	
	public String doListSection() {
		return "listSection.xhtml";
	}


	public String doEnseignant() {
		return "Enseignant.xhtml";
	}
	
	public String doMission() {
		return "Mission.xhtml";
	}
	public String doAA() {
		return "AA.xhtml";
	}
	
	public String doSection() {
		return "Section.xhtml";
	}
	public String doUtilisateur() {
		return "Utilisateur.xhtml";
	}
	
	public String doAddMission() {
		return "addMission.xhtml";
	}
	public String doAddUtilisateur() {
		return "addUtilisateur.xhtml";
	}
	public String doDetailSection() {
		return "DetailSection.xhtml";
	}
	
	public String doAddSection() {
		return "addSection.xhtml";
	}
	
	public String doListUe() {
		return "listUe.xhtml";
	}
	
	public String doUe() {
		return "Ue.xhtml";
	}
	
	public String doAddUe() {
		return "addUe.xhtml";
	}
	
	public String doChoixSectionSection() {
		return "choixSectionSection.xhtml";
	}
	
	public String doChoixSectionMission() {
		return "choixMissionSection.xhtml";
	}
}
