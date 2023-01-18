package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.SectionDAO;
import be.helha.aemt.groupeA6.entities.Section;

public class GestionSectionEJB implements IGestionSectionEJB {
	
	private SectionDAO daoEnseignant;

	@Override
	public List<Section> findAll() {
		return daoEnseignant.findAll();
	}

	@Override
	public Section findById(int id) {
		return daoEnseignant.findById(id);
	}

	@Override
	public Section add(Section s) {
		return daoEnseignant.add(s);
	}

	@Override
	public Section remove(Section s) {
		return daoEnseignant.remove(s);
	}

}
