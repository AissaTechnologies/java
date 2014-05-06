package com.aissa.aissatech.dao;


/**
 * @author Camelia Boban
 *
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.aissa.aissatech.pojo.Anagrafica;
import com.aissa.aissatech.pojo.Profilo;
import com.aissa.aissatech.service.AnagraficaService;

@Transactional				//spring, si è all'interno di una transazione
public class AnagraficaServiceImpl implements AnagraficaService {
	@PersistenceContext		//javax.persistence, gestione della persistenza
	private EntityManager em;
	private static Logger log = Logger.getLogger(AnagraficaServiceImpl.class);
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}	

	@SuppressWarnings("unchecked")
	//public List<Anagrafica> ricercaAnagrafica(String cognome, String matricola, Date dataScadenza) {
	public List<Anagrafica> ricercaAnagrafica(String cognome, String matricola) {
		String queryStr = "SELECT a FROM Anagrafica a ";
		log.debug("queryStr iniziale = " + queryStr);
		if(cognome != null && !cognome.equals("")) {
			queryStr += " WHERE cognome like '%" + cognome + "%' ";
			log.debug("queryStr cognome = " + queryStr);
			if(matricola != null && !matricola.equals("")) {
				queryStr += " AND matricola = '" + matricola + "' ";
				log.debug("queryStr matricola = " + queryStr);
//				if(dataScadenza != null) {
//					log.debug("queryStr dataScadenza = " + queryStr);
//					queryStr += " AND dataScadenza = " + dataScadenza;
//				}
			}
		}
		Query query = em.createQuery(queryStr);
		//log.debug("dao, ricerca = " + (Anagrafica)query.getSingleResult());
		
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Anagrafica> listaAnagrafiche() {		
		String queryStr = "SELECT a FROM Anagrafica a ORDER BY a.id ASC";//cognome
		Query query = getEntityManager().createQuery(queryStr);
		log.debug("dao, lista anagrafiche = " + query.getResultList().size());
		
		return query.getResultList();
	}

	/* METODI CRUD JPA */
	//ricerca per id
	public Anagrafica ricercaAnagPerId(int id) {
//		Anagrafica anag = em.find(Anagrafica.class, id);		
//		return anag;			
		return em.find(Anagrafica.class, id);	
	}

	//inserimento
	public void salvaAnag(Anagrafica anag) {
		em.persist(anag);
	}
	//aggiornamento
	public void aggiornaAnag(Anagrafica anag) {		
		em.merge(anag);
	}
	//cancellazione
	public void cancellaAnag(int id) {
		Anagrafica anag = em.find(Anagrafica.class, id);
		em.remove(anag);
	}

	public Anagrafica ricercaAnagPerMatricola(String matricola) {
		String queryStr = "SELECT a FROM Anagrafica a WHERE a.matricola like '%" + matricola + "%'";
		Query query = em.createQuery(queryStr);
		Anagrafica anag = (Anagrafica)query.getSingleResult();
		if(anag != null) {
			return (Anagrafica)query.getSingleResult();
		}
		else {			
			return null;
		}
	}
	//l'ultima matricola inserita
	public String maxMatricola() {
		String queryStr = "SELECT max(a.matricola) FROM Anagrafica a";
		Query query = em.createQuery(queryStr);
		
		return (String)query.getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<Profilo> listaProfilo() {
		String queryStr = "SELECT p FROM Profilo p";
		Query query = em.createQuery(queryStr);
		
		return query.getResultList();
	}
	
	public EntityManager getEntityManager() {
		return em;
	}

}
