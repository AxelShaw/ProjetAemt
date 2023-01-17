package be.helha.aemt.groupeA6.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;

	@OneToMany(mappedBy = "section",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mission> missions = new ArrayList<>();
	
	public Section(String nom) {
		this.nom = nom;
	}
	public Section() {
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", nom=" + nom + ", missions=" + missions + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, missions, nom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Section))
			return false;
		Section other = (Section) obj;
		return Objects.equals(id, other.id) && Objects.equals(missions, other.missions)
				&& Objects.equals(nom, other.nom);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Mission> getMissions(){
		return missions;
	}
	public boolean addMission(Mission m) {
		if(missions.contains(m)) return false;
		for(Mission mi: missions) if(mi.equals(m))return false;
		missions.add(m);
		m.setSection(this);
		return true;
	}
	public Mission findMissionById(int id) {
		if(id<=0) return null;
		for(Mission mi: missions) if(mi.getId()==id)return  mi;
		return null;
	}
	public boolean updateMission(Mission m,int idUpdate) {
		if(idUpdate<=0 || idUpdate>missions.size()) return false;
		if(missions.contains(m)) return false;
		for(Mission mi: missions) {
			if(mi.getId()==idUpdate) {
				missions.set(idUpdate, m);
				return true;
			}
		}
		return false;
	}
	public boolean removeMission(Mission m) {
		if(missions.contains(m)) return missions.remove(m);
		return false;
	}

}
