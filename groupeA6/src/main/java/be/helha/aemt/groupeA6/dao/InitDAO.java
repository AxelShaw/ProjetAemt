package be.helha.aemt.groupeA6.dao;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@LocalBean
public class InitDAO {

	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public void init() {
		
		em.createQuery("create table if not exists utilisateur (\r\n"
				+ "	id int not null,\r\n"
				+ "	nom varchar(50) not null,\r\n"
				+ "	prenom varchar(50) not null,\r\n"
				+ "	email varchar(100) not null,\r\n"
				+ "	password varchar(100) not null,\r\n"
				+ "	departement varchar(20) not null,\r\n"
				+ "	role varchar(20) not null,\r\n"
				+ "	primary key(id)\r\n"
				+ ")").executeUpdate();
		
		em.createQuery("create table if not exists enseignant (\r\n"
				+ "	id int not null,\r\n"
				+ "	nom varchar(50) not null,\r\n"
				+ "	prenom varchar(50) not null,\r\n"
				+ "	email varchar(100) not null,\r\n"
				+ "	remarque varchar(100) not null,\r\n"
				+ "	attribution varchar(100) not null,\r\n"
				+ "	primary key(id)\r\n"
				+ ")").executeUpdate();
		
		em.createQuery("create table if not exists departement (\r\n"
				+ "	id int not null,\r\n"
				+ "	nom varchar(50) not null,\r\n"
				+ "	sections varchar(100) not null,\r\n"
				+ "	missions varchar(100) not null,\r\n"
				+ "	primary key(id)\r\n"
				+ ")").executeUpdate();
		
		em.createQuery("create table if not exists section (\r\n"
				+ "	id int not null,\r\n"
				+ "	departement varchar(20) not null,\r\n"
				+ "	nom varchar(50) not null,\r\n"
				+ "	missions varchar(100) not null,\r\n"
				+ "	primary key(id)\r\n"
				+ ")").executeUpdate();
		
		em.createQuery("create table if not exists ue (\r\n"
				+ "	id int not null,\r\n"
				+ "	anneeAcademique int not null,\r\n"
				+ "	departement varchar(50) not null,\r\n"
				+ "	section varchar(100) not null,\r\n"
				+ "	bloc varchar(100) not null,\r\n"
				+ "	code varchar(20) not null,\r\n"
				+ "	intitule varchar(20) not null,\r\n"
				+ "	credit varchar(20) not null,\r\n"
				+ "	aas varchar(20) not null,\r\n"
				+ "	primary key(id)\r\n"
				+ ")").executeUpdate();
		
		em.createQuery("create table if not exists aa (\r\n"
				+ "	id int not null,\r\n"
				+ "	anneeAcademique int not null,\r\n"
				+ "	code varchar(50) not null,\r\n"
				+ "	intitule varchar(100) not null,\r\n"
				+ "	credit varchar(100) not null,\r\n"
				+ "	heure varchar(20) not null,\r\n"
				+ "	heureQ1 varchar(20) not null,\r\n"
				+ "	heureQ2 varchar(20) not null,\r\n"
				+ "	nombreGroupe varchar(20) not null,\r\n"
				+ "	nombreEtudiant varchar(20) not null,\r\n"
				+ "	fraction varchar(20) not null,\r\n"
				+ "	primary key(id)\r\n"
				+ ")").executeUpdate();
		
		em.createQuery("create table if not exists mission (\r\n"
				+ "	id int not null,\r\n"
				+ "	anneeAcademique varchar(50) not null,\r\n"
				+ "	intitule varchar(100) not null,\r\n"
				+ "	heures varchar(100) not null,\r\n"
				+ "	primary key(id)\r\n"
				+ ")").executeUpdate();
		
		em.createQuery("create table if not exists attribution (\r\n"
				+ "	id int not null,\r\n"
				+ "	anneeAcademique varchar(50) not null,\r\n"
				+ "	aas varchar(100) not null,\r\n"
				+ "	missions varchar(100) not null,\r\n"
				+ "	primary key(id)\r\n"
				+ ")").executeUpdate();
	}
	
	public String showTables() {
		return em.createQuery("show tables").getResultList().toString();
	}
}
