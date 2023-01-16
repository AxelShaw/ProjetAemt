package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Attribution;

public interface IGestionAttributionEJB {
	public List<Attribution> findAll();
	public Attribution findById(int id);
	public Attribution add(Attribution a);
	public Attribution remove(Attribution a);
	public Attribution update(Attribution a1, Attribution a2);
}
