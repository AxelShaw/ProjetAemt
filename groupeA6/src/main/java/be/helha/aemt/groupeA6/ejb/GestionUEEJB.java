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
	public List<UE> findAll() {
		return daoUE.findAll();
	}

	@Override
	public UE findById(int id) {
		return daoUE.findById(id);
	}

	@Override
	public UE add(UE e) {
		return daoUE.add(e);
	}

	@Override
	public UE remove(UE e) {
		return daoUE.remove(e);
	}

	@Override
	public UE update(UE e1, UE e2) {
		return daoUE.update(e1, e2);
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
