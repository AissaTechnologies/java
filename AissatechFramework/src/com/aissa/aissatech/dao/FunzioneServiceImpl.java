package com.aissa.aissatech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.aissa.aissatech.pojo.Funzione;
import com.aissa.aissatech.service.FunzioneService;


/**
 * @author Camelia Boban
 *
 */
@Transactional
public class FunzioneServiceImpl implements FunzioneService {
	@PersistenceContext
	private EntityManager em;
	private static Logger log = Logger.getLogger(FunzioneServiceImpl.class);

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	/* METODI CRUD JPA */
		/*
		 	public void salva(Funzione funzione){
				if(funzione.getId() == null){
					//inserimento
					em.persist(funzione);
					System.out.println("sto inserendo una nuova funzione");			
				}
				else{
					//aggiornamento
					em.merge(funzione);
					System.out.println("sto aggiornando una funzione");			
				}
			}
		    public Funzione ricercaPerId(int id){
		    	return em.find(Funzione.class, id); 
		    }
		    
		    public void cancella(int id){
		    	Funzione funzione = ricercaPerId(id);
		    	if(funzione != null){
		    		em.remove(funzione);
		    	}
		    } 
		*/
	
	//ricerca
	public Funzione ricercaFunzPerId(int id) {
//		Funzione funz = em.find(Funzione.class, id);		
//		return funz;
		
		return em.find(Funzione.class, id);
	}
	//inserimento
	public void salvaFunz(Funzione funz) {
		em.persist(funz);
	}
	//aggiornamento
	public void aggiornaFunz(Funzione funz) {
		em.merge(funz);
	}	
	//cancellazione
	public void cancellaFunz(int id) {
		Funzione funz = em.find(Funzione.class, id);
		em.remove(funz);
	}

	@SuppressWarnings("unchecked")
	public List<Funzione> listaFunzioni(String codice) {
		String queryStr;
		if(codice == null || codice.equals("")) {
			queryStr = "SELECT f FROM Funzione f ORDER BY id ASC"; 
		}
		else {
			queryStr = "SELECT f FROM Funzione f WHERE f.codice like '%" + codice + "%' ORDER BY id ASC";
		}
		
		Query query = getEntityManager().createQuery(queryStr);
		log.debug("dao, lista funzioni = " + query.getResultList().size());
			
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funzione> listaFunzioni() {		
		String queryStr = "SELECT f FROM Funzione f ORDER BY id ASC";		
		Query query = getEntityManager().createQuery(queryStr);
		log.debug("dao, lista funzioni = " + query.getResultList().size());
			
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Boolean pathPresente(String path) {
		String queryStr = "SELECT f FROM Funzione f WHERE path = '" + path + "'";
		Query query = em.createQuery(queryStr);
		List<Funzione> lista = query.getResultList();
		if(lista.size() > 0 ) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	@SuppressWarnings("unchecked")
	public Boolean pathModPresente(int id) {
		String queryStr = "SELECT f.path FROM Funzione f WHERE id = " + id;
		Query query = em.createQuery(queryStr);
		List<Funzione> lista = query.getResultList();
		if(lista.size() > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
