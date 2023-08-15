package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.entities.AA;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.Remote;

public interface IGestionAAEJB {
	public List<AA> findAll(String name);
	public AA findById(int id) throws NotFoundException;
	public AA add(AA a) throws NotFoundException;
	public AA remove(AA a) throws NotFoundException;
	public AA update(AA a) throws NotFoundException;
}
