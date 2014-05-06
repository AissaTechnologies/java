package com.aissa.aissatech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.aissa.aissatech.pojo.Profilo;
import com.aissa.aissatech.service.ProfiloService;


/**
 * @author Camelia Boban
 *
 */
@Transactional
public class ProfiloServiceImpl implements ProfiloService {
	@PersistenceContext
	private EntityManager em;
	private static Logger log = Logger.getLogger(ProfiloServiceImpl.class);

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}	
	
	/* METODI CRUD JPA */	
	//ricerca
	public Profilo ricercaProfPerId(int id) {
		Profilo prof = em.find(Profilo.class, id);		
		return prof;
	}
	//inserimento
	public void salvaProf(Profilo prof) {
		em.persist(prof);
	}
	//aggiornamento
	public void aggiornaProf(Profilo prof) {		
		em.merge(prof);
	}	
	//cancellazione
	public void cancellaProf(int id) {
		Profilo prof = em.find(Profilo.class, id);
		em.remove(prof);
	}
	
	@SuppressWarnings("unchecked")
	public List<Profilo> listaProfili() {	
		
		String queryStr = "SELECT p FROM Profilo p ORDER BY p.id ASC";
		Query query = getEntityManager().createQuery(queryStr);
		log.debug("dao, lista profili = " + query.getResultList().size());
			
		return query.getResultList();
	}
	
	public Byte maxTipoProfilo() {
		String queryStr = "SELECT max(p.flagTipoProfilo) FROM Profilo p";
		Query query = em.createQuery(queryStr);
		
		return (Byte)query.getSingleResult();
	}
}
