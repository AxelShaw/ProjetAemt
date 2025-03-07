package be.helha.aemt.groupeA6.dao;

import java.util.List;

import be.helha.aemt.groupeA6.entities.Mission;
import be.helha.aemt.groupeA6.entities.Utilisateur;
import be.helha.aemt.groupeA6.exceptions.EmailDuplicateException;
import be.helha.aemt.groupeA6.exceptions.NotFoundException;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class UtilisateurDAO {
	
	private Role role;
	
	@PersistenceContext(unitName = "groupeA6-JTA")
	private EntityManager em;
	
	public UtilisateurDAO() {

	}
	
	public List<Utilisateur> findAll(String name) {
		if (name == null) {
			return em.createQuery("Select u from Utilisateur u", Utilisateur.class).getResultList();
		}
		return em.createQuery("Select m from Utilisateur m where m.nom LIKE Concat('%',?1,'%')", Utilisateur.class).setParameter(1, name).getResultList();
	}

	public Utilisateur add(Utilisateur u) throws NotFoundException, EmailDuplicateException{
		if (u==null) {
			throw new NotFoundException();
		}
        try {
            Query checkQuery = em.createQuery("SELECT COUNT(u) FROM Utilisateur u WHERE u.email = ?1");
            checkQuery.setParameter(1, u.getEmail());
            long count = (long) checkQuery.getSingleResult();

            if (count > 0) {
                throw new EmailDuplicateException("L'adresse e-mail est déjà utilisée par un autre utilisateur.");
            }

            em.persist(u);

            return u;
        } catch (NoResultException ex) {
            // Pas de doublon, procéder à l'ajout
            em.persist(u);
            return u;
        }
	}
	
	public Utilisateur remove(Utilisateur u) throws NotFoundException{
		if (u==null) {
			throw new NotFoundException();
		}
		
		Query query = em.createQuery("delete from Utilisateur where id = ?1");	
		query.setParameter(1, u.getId()).executeUpdate();
		em.detach(u);
		return u;
	}

	public Utilisateur find(Utilisateur u) {
		em.contains(u);
		return u;
	}

	public Utilisateur findById(Integer id) throws NotFoundException{
		if (id == null) {
			throw new NotFoundException();
		}
		Utilisateur res = em.find(Utilisateur.class, id);	
		em.detach(res);
		return res;
	}
	
	public Utilisateur update(Utilisateur u) throws NotFoundException, EmailDuplicateException{
		if (u==null) {
			throw new NotFoundException();
		}
		

        try {
            Query checkQuery = em.createQuery("SELECT COUNT(u) FROM Utilisateur u WHERE u.email = ?1 AND u.id <> ?2");
            checkQuery.setParameter(1, u.getEmail());
            checkQuery.setParameter(2, u.getId());
            long count = (long) checkQuery.getSingleResult();

            if (count > 0) {
                throw new EmailDuplicateException("L'adresse e-mail est déjà utilisée par un autre utilisateur.");
            }

            Query updateQuery = em.createQuery("UPDATE Utilisateur SET nom = ?1, prenom = ?2, email = ?3, password = ?4, departement = ?5, role = ?6 WHERE id = ?7");
            updateQuery.setParameter(1, u.getNom());
            updateQuery.setParameter(2, u.getPrenom());
            updateQuery.setParameter(3, u.getEmail());
            updateQuery.setParameter(4, u.getPassword());
            updateQuery.setParameter(5, u.getDepartement());
            updateQuery.setParameter(6, u.getRole());
            updateQuery.setParameter(7, u.getId()).executeUpdate();

        }
    	catch (NonUniqueResultException ex) {
    		throw new EmailDuplicateException("Plusieurs utilisateurs ont la même adresse e-mail.");
        }
        em.detach(u);
        return u;
	}
	
	public String getUsername(String email) throws NotFoundException{
		if (email == null) {
			throw new NotFoundException();
		}
		
		String strQuery = "Select u from Utilisateur u where u.email = ?1";
		TypedQuery<Utilisateur> query = em.createQuery(strQuery, Utilisateur.class).setParameter(1, email);
		Utilisateur res = query.getResultList().get(0);
		return res.getNom() + " " + res.getPrenom();
	}

	public int getRole(String email) {
		if (email == null) {
			return 0;
		}
				
		String strQuery = "Select u from Utilisateur u where u.email = ?1";
		TypedQuery<Utilisateur> query = em.createQuery(strQuery, Utilisateur.class).setParameter(1, email);
		Utilisateur user = query.getResultList().get(0);
		
		return user.getPerm();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
