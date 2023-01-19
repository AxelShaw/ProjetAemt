package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Section;
import be.helha.aemt.groupeA6.entities.UE;

public interface IGestionUEEJB {
	public List<UE> findAll(int bFilter, String sFilter, String aFilter);
	public UE findById(int id);
	public UE add(UE ue);
	public UE remove(UE ue);
	public UE update(UE ue);
	public List<UE> findBySection(Section s);
	public List<UE> findByAnneeAcademique(int annee);
	public List<UE> findBySectionAndAnneeAcademique(Section s, int annee);
}
