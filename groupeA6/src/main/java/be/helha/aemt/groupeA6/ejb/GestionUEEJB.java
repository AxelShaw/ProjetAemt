package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.UEDAO;
import be.helha.aemt.groupeA6.entities.Section;
import be.helha.aemt.groupeA6.entities.UE;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionUEEJB implements IGestionUEEJB {
	
	@EJB
	private UEDAO daoUE;

	@Override
	public List<UE> findAll(int bFilter, String name) {
		return daoUE.findAll(bFilter,name);
	}

	@Override
	public UE findById(int id) {
		return daoUE.findById(id);
	}

	@Override
	public UE add(UE ue) {
		return daoUE.add(ue);
	}

	@Override
	public UE remove(UE ue) {
		return daoUE.remove(ue);
	}

	@Override
	public UE update(UE ue) {
		return daoUE.update(ue);
	}

	@Override
	public List<UE> findBySection(Section s) {
		return daoUE.findBySection(s);
	}

	@Override
	public List<UE> findByAnneeAcademique(int annee) {
		return daoUE.findByAnneeAcademique(annee);
	}

	@Override
	public List<UE> findBySectionAndAnneeAcademique(Section s, int annee) {
		return daoUE.findBySectionAndAnneeAcademique(s, annee);
	}

}
