package be.helha.aemt.groupeA6.dao;

import java.util.List;

public interface IDAO<T> {
	
	public T add(T t);
	public T find(T t);
	public T findById(Integer id);
	public List<T> findAll();
	public T update(T t);
	public T remove(T t);

}
