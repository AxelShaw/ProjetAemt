package be.helha.aemt.groupeA6.ejb;

import java.util.List;
import be.helha.aemt.groupeA6.dao.MissionDAO;
import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionMissionEJB implements IGestionMissionEJB {

	
	@EJB
	private MissionDAO daoMission;
	
	@Override
	public List<Mission> findAll(String name) {
		return daoMission.findAll(name);
	}

	@Override
	public Mission findById(int id) throws NotFoundException {
		return daoMission.findById(id);
	}

	@Override
	public Mission add(Mission m) throws NotFoundException{
		return daoMission.add(m);
	}

	@Override
	public Mission remove(Mission m) throws NotFoundException{
		return daoMission.remove(m);
	}

	@Override
	public Mission update(Mission m) {
		return daoMission.update(m);
	}

}
