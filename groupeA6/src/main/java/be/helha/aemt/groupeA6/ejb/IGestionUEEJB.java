package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Section;
import be.helha.aemt.groupeA6.entities.UE;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.Remote;

public interface IGestionUEEJB {
	public List<UE> findAll(int bFilter, String name);
	public UE findById(int id)throws NotFoundException;
	public UE add(UE ue)throws NotFoundException;
	public UE remove(UE ue)throws NotFoundException;
	public UE update(UE ue) throws NotFoundException;
	public List<UE> findBySection(Section s);
	public List<UE> findByAnneeAcademique(int annee);
	public List<UE> findBySectionAndAnneeAcademique(Section s, int annee);
}
