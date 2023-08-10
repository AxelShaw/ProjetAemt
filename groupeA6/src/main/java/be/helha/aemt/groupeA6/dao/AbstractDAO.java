package be.helha.aemt.groupeA6.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public abstract class AbstractDAO<T> implements IDAO<T>{

	protected static EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
	
	public AbstractDAO() {
		if(emf == null) emf = Persistence.createEntityManagerFactory("groupeA6-JTA");
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	public void close() {
		em.close();
	}
	public static void closeFactory() {
		emf.close();
		emf=null;
	}
	
	public abstract T add(T t);

	public abstract T find(T t);

	public abstract List<T> findAll();

	public abstract T update(T t);

	public abstract T remove(T t);

	public abstract T findById(Integer id);

}
