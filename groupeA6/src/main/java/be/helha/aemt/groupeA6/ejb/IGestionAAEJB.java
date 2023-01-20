package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.AA;
import jakarta.ejb.Remote;

public interface IGestionAAEJB {
	public List<AA> findAll();
	public AA findById(int id);
	public AA add(AA a);
	public AA remove(AA a);
	public AA update(AA a);
}
