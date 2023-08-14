package be.helha.aemt.groupeA6.control;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@SessionScoped
public class NavigationControl implements Serializable {
	
	private Boolean enseignantFlag = false;
	private Boolean ueFlag = false;
	private Boolean aaFlag = false;
	private Boolean sectionFlag = false;
	private Boolean missionFlag = false;
	private Boolean utilisateurFlag = false;
	
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
	
	public String doListAANonAttribues() {
		return "listAANonAttribues.xhtml";
	}
	
	public String doListMission() {
		return "listMission.xhtml";
	}
	
	public String doListMissionNonAttribues() {
		return "listMissionNonAttribues.xhtml";
	}
	
	public String doListSection() {
		return "listSection.xhtml";
	}

	public void clear() {
		enseignantFlag = false;
		ueFlag = false;
		aaFlag = false;
		sectionFlag = false;
		missionFlag = false;
		utilisateurFlag = false;
	}
	
	public void doEnseignant() {
		clear();
		enseignantFlag = !enseignantFlag;
	}
	
	public void doMission() {
		clear();
		missionFlag = !missionFlag;
	}
	public void doAA() {
		clear();
		aaFlag = !aaFlag;
	}
	
	public void doUe() {
		clear();
		ueFlag = !ueFlag;
	}
	
	public void doSection() {
		clear();
		sectionFlag = !sectionFlag;
	}
	public void doUtilisateur() {
		clear();
		utilisateurFlag = !utilisateurFlag;
	}
	
	public boolean isClear() {
		return !(enseignantFlag || ueFlag || aaFlag || sectionFlag || missionFlag || utilisateurFlag);
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
	
	public String doDetailEnseignant() {
		return "DetailEnseignant.xhtml";
	}
	
	public String doAddSection() {
		return "addSection.xhtml";
	}
	
	public String doListUe() {
		return "listUe.xhtml";
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
	
	public String doChoixEnseignantMission() {
		return "choixEnseignantMission.xhtml";
	}
	
	public String doChoixEnseignantEnseignant() {
		return "choixEnseignantEnseignant.xhtml";
	}
	
	public String doChoixEnseignantEnseignantAA() {
		return "choixEnseignantEnseignantAA.xhtml";
	}

	public Boolean getEnseignantFlag() {
		return enseignantFlag;
	}

	public void setEnseignantFlag(Boolean enseignantFlag) {
		this.enseignantFlag = enseignantFlag;
	}

	public Boolean getUeFlag() {
		return ueFlag;
	}

	public void setUeFlag(Boolean ueFlag) {
		this.ueFlag = ueFlag;
	}

	public Boolean getAaFlag() {
		return aaFlag;
	}

	public void setAaFlag(Boolean aaFlag) {
		this.aaFlag = aaFlag;
	}

	public Boolean getSectionFlag() {
		return sectionFlag;
	}

	public void setSectionFlag(Boolean sectionFlag) {
		this.sectionFlag = sectionFlag;
	}

	public Boolean getMissionFlag() {
		return missionFlag;
	}

	public void setMissionFlag(Boolean missionFlag) {
		this.missionFlag = missionFlag;
	}

	public Boolean getUtilisateurFlag() {
		return utilisateurFlag;
	}

	public void setUtilisateurFlag(Boolean utilisateurFlag) {
		this.utilisateurFlag = utilisateurFlag;
	}
	
	public String doChoixUeUe() {
		return "choixUeUe.xhtml";
	}
}
