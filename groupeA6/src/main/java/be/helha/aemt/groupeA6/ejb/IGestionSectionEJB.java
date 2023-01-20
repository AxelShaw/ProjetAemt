package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Section;
import be.helha.aemt.groupeA6.entities.UE;
import jakarta.ejb.Remote;

public interface IGestionSectionEJB {
	public List<Section> findAll();
	public Section findById(int id);
	public Section add(Section s);
	public Section remove(Section s);
	public Section update(Section s);
}
