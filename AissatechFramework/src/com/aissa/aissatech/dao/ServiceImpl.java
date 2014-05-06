package com.aissa.aissatech.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.aissa.aissatech.service.Service;


/**
 * @author Camelia Boban
 *
 */
@Transactional
public class ServiceImpl implements Service {
	@PersistenceContext
	private EntityManager em;
	private static Logger log = Logger.getLogger(FunzioneServiceImpl.class);

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}		
	
	//ricerca
	public Object ricercaPerId(Class<?> clazz, int id) {
		
		return em.find(clazz, id);		
	}
	//lista
	public List<?> lista(Class<?> clazz) {
		String queryStr = "SELECT c FROM " + clazz.getName() + " c ORDER BY id ASC"; 		
		Query query = getEntityManager().createQuery(queryStr);
		log.debug("dao, lista " + clazz.getName() + " = " + query.getResultList().size());
			
		return query.getResultList();
	}
	//inserimento
	public void salva(Class<?> clazz) {
		em.persist(clazz);
	}
	//aggiornamento
	public void aggiorna(Class<?> clazz) {
		em.merge(clazz);
	}	
	//cancellazione
	public void cancella(Class<?> clazz, int id) {
		//Class<?> clazz = em.find(Class.class, id);
		//em.remove(clazz);
		em.remove(em.find(Class.class, id));
	}
	
	public Byte maxTipoProfilo() {
		String queryStr = "SELECT max(p.flagTipoProfilo) FROM Profilo p";
		Query query = em.createQuery(queryStr);
		
		return (Byte)query.getSingleResult();
	}
}

