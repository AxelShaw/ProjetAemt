package be.helha.aemt.groupeA6.ejb;

import java.util.List;

import be.helha.aemt.groupeA6.dao.MissionDAO;
import be.helha.aemt.groupeA6.entities.Mission;
import jakarta.ejb.EJB;

public class GestionMissionEJB implements IGestionMissionEJB {

	
	@EJB
	private MissionDAO daoMission;
	
	@Override
	public List<Mission> findAll() {
		return daoMission.findAll();
	}

	@Override
	public Mission findById(int id) {
		return daoMission.findById(id);
	}

	@Override
	public Mission add(Mission m) {
		return daoMission.add(m);
	}

	@Override
	public Mission remove(Mission m) {
		return daoMission.remove(m);
	}

	@Override
	public Mission update(Mission m) {
		return daoMission.update(m);
	}

}
