package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.EnseignantDAO;
import be.helha.aemt.groupeA6.dao.MissionDAO;
import be.helha.aemt.groupeA6.dao.SectionDAO;
import be.helha.aemt.groupeA6.entities.Section;

public class GestionSectionEJB implements IGestionSectionEJB {
	
	private SectionDAO daoSection;

	@Override
	public List<Section> findAll() {
		return daoSection.findAll();
	}

	@Override
	public Section findById(int id) {
		return daoSection.findById(id);
	}

	@Override
	public Section add(Section s) {
		return daoSection.add(s);
	}

	@Override
	public Section remove(Section s) {
		return daoSection.remove(s);
	}

}
