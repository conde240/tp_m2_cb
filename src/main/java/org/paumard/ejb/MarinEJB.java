package org.paumard.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.paumard.model.Marin;

@Stateless
public class MarinEJB {

	@PersistenceContext(unitName="cloudbees-project")
	private EntityManager em ;
	
	public Long createMarin(Marin marin) {
		
		em.persist(marin) ;
		return marin.getId() ;
 	}
	
	public List<Marin> getAllMarin()
	{
		Query query=em.createNamedQuery("getAllMarin");
		@SuppressWarnings("unchecked")
		List<Marin> marins=(List<Marin>)query.getResultList();
		return marins;
		
	}

	public void removeMarin(Long id) {
		
		Marin m = em.find(Marin.class, id) ;
		em.remove(m) ;
	}

	public int updateMarin(Marin marin)
	{
		Query query=em.createNamedQuery("updateMarin");
		query.setParameter("id", marin.getId());
		query.setParameter("nom", marin.getNom());
		query.setParameter("prenom", marin.getPrenom());
		query.setParameter("age", marin.getAge());
		return query.executeUpdate();
	}
	public Marin getMarinById(Long id) {
		
		Marin m = em.find(Marin.class, id) ;
		return m;
		
	}
}
