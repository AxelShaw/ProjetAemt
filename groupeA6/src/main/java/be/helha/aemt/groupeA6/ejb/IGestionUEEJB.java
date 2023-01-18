package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Section;
import be.helha.aemt.groupeA6.entities.UE;

public interface IGestionUEEJB {
	public List<UE> findAll();
	public UE findById(int id);
	public UE add(UE e);
	public UE remove(UE e);
	public UE update(UE e1, UE e2);
	public List<UE> findBySection(Section s);
	public List<UE> findByAnneeAcademique(int annee);
	public List<UE> findBySectionAndAnneeAcademique(Section s, int annee);
}
