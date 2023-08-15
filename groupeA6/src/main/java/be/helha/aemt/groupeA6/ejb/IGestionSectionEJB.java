package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Section;
import be.helha.aemt.groupeA6.entities.UE;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.Remote;

public interface IGestionSectionEJB {
	public List<Section> findAll(String name);
	public Section findById(int id) throws NotFoundException;
	public Section add(Section s) throws NotFoundException;
	public Section remove(Section s) throws NotFoundException;
	public Section update(Section s) throws NotFoundException;
}
