package com.aissa.aissatech.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.aissa.aissatech.pojo.Abilitazione;
import com.aissa.aissatech.pojo.Funzione;
import com.aissa.aissatech.pojo.Profilo;
import com.aissa.aissatech.service.AbilitazioneService;

/**
 * @author Camelia Boban
 *
 */
@Transactional
public class AbilitazioneServiceImpl implements AbilitazioneService {
	//@PersistenceContext //eccezioni "org.hibernate.LazyInitializationException"
	@PersistenceContext(type = PersistenceContextType.EXTENDED) 
	private EntityManager em;
	private static Logger log = Logger.getLogger(AbilitazioneServiceImpl.class);

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	/* METODI CRUD JPA */	
	//ricerca
	public Abilitazione ricercaAbilPerId(int id) {
		return em.find(Abilitazione.class, id);
	}
	//inserimento
	public void salvaAbil(Abilitazione abil) {
		em.persist(abil);
	}
	//aggiornamento
	public void aggiornaAbil(Abilitazione abil) {		
		em.merge(abil);
	}	
	//cancellazione
	public void cancellaAbil(int id) {
		Abilitazione abil = em.find(Abilitazione.class, id);
		em.remove(abil);
	}

	@SuppressWarnings("unchecked")
	public List<Abilitazione> listaAbilitazioni(String abilitato) {			
		String queryStr = "SELECT a.id, a.abilitato, a.funzione.codice, a.funzione.descrizione, a.funzione.path, " + 
				"a.profilo.descrizione FROM Abilitazione a ";
		if(abilitato != null && !abilitato.equals("")) {
			queryStr += "WHERE a.abilitato = " + Byte.valueOf(abilitato);
		}
		queryStr += " ORDER BY a.id";
		log.debug("dao, queryStr = " + queryStr);
		Query query = getEntityManager().createQuery(queryStr);
		log.debug("dao, size lista dalla query = " + query.getResultList().size() + ", nome classe = " + query.getResultList().getClass().getCanonicalName());

		List<Object[]> listaArray = query.getResultList();
		List<Abilitazione> listaAbil = new ArrayList<Abilitazione>();
		for(Object[] arrayOgg : listaArray) {
			Abilitazione abil = new Abilitazione();
			abil.setId((Integer) arrayOgg[0]);//abilitazione.id
			abil.setAbilitato((Byte) arrayOgg[1]);//abilitazione.abilitato
			Funzione funzione = new Funzione();
			funzione.setCodice((String)arrayOgg[2]);//abilitazione.funzione.codice
			funzione.setDescrizione((String)arrayOgg[3]);//abilitazione.funzione.descrizione
			funzione.setPath((String)arrayOgg[4]);//abilitazione.funzione.path
			abil.setFunzione(funzione);			
			Profilo profilo = new Profilo();
			profilo.setDescrizione((String)arrayOgg[5]);//abilitazione.profilo.descrizione
			abil.setProfilo(profilo);
			
			listaAbil.add(abil);
		}

		return listaAbil;
		 
	}
	
	@SuppressWarnings("unchecked")
	public List<Abilitazione> listaAbilitazioni() {			
		/*SELECT * FROM abilitazione a, funzione f, profilo p  
			WHERE a.id_funzione = f.id AND a.id_profilo = p.id ORDER BY a.id;*/
		String queryStr = "SELECT a, f, p FROM Abilitazione a, Funzione f, Profilo p " +
							"WHERE a.funzione.id = f.id AND a.profilo.id = p.id ORDER BY a.id";
		Query query = getEntityManager().createQuery(queryStr);
		log.debug("dao, lista abilitazioni = " + query.getResultList().size());
		List<Object[]> listaArray = query.getResultList();
		List<Abilitazione> listaAbil = new ArrayList<Abilitazione>();
		for(Object[] arrayOgg : listaArray) {
			Abilitazione abil = new Abilitazione();
			abil.setId((Integer) arrayOgg[0]);//abilitazione.id
			abil.setAbilitato((Byte) arrayOgg[1]);//abilitazione.abilitato
			Funzione funzione = new Funzione();
			funzione.setId((Integer)arrayOgg[2]);//abilitazione.funzione.id
			funzione.setCodice((String)arrayOgg[3]);//abilitazione.funzione.codice
			funzione.setDescrizione((String)arrayOgg[4]);//abilitazione.funzione.descrizione
			funzione.setPath((String)arrayOgg[5]);//abilitazione.funzione.path
			abil.setFunzione(funzione);			
			Profilo profilo = new Profilo();
			profilo.setId((Integer)arrayOgg[6]);//abilitazione.profilo.id
			profilo.setDescrizione((String)arrayOgg[7]);//abilitazione.profilo.descrizione
			profilo.setFlagTipoProfilo((Byte)arrayOgg[8]);//abilitazione.profilo.flagTipoProfilo
			abil.setProfilo(profilo);
			
			listaAbil.add(abil);
		}

		return listaAbil;
	}
	@SuppressWarnings("unchecked")
	//controllo abilitazione per funzione e profilo
//	public Boolean ricercaAbilEsistente(String path, Byte tipoProf, Byte abil) {
	public Boolean ricercaAbilEsistente(String path, Byte tipoProf) {
//		log.debug("dao, ricevo path: " + path + ", tipoProf: " + tipoProf + ", abil: " + abil);
		log.debug("dao, ricevo path: " + path + ", tipoProf: " + tipoProf);
//		String queryStr = "SELECT a FROM Abilitazione a WHERE a.funzione.path = '" + path + "' " + 
//							"AND a.profilo.flagTipoProfilo = " + tipoProf + " AND a.abilitato = " + abil;
		String queryStr = "SELECT a FROM Abilitazione a WHERE a.funzione.path = '" + path + "' " + 
				"AND a.profilo.flagTipoProfilo = " + tipoProf;
		Query query = em.createQuery(queryStr);		
		List<Object[]> array = query.getResultList();
		log.debug("dao, array: " + array + ", array size = " + array.size());
//		if(array != null && array.size() > 0) {
//			return true;
//		}
//		else {
//			return false;
//		}
		if(array.size() == 0) {
			log.debug("dao, array size = " + array.size() + ", return = " + false);
			return false;
		}
		else {
			log.debug("dao, array size = " + array.size() + ", return = " + true);
			return true;
		}
	}

	@SuppressWarnings("unchecked")	
	public List<Funzione> listaFunzioni() {		
		String queryStr = "SELECT f FROM Funzione f";
		Query query = em.createQuery(queryStr);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Profilo> listaProfili() {
		String queryStr = "SELECT p FROM Profilo p";
		Query query = em.createQuery(queryStr);		
		
		return query.getResultList();
	}
	
	public Profilo ricercaProfiloPerId(int id) {
		return em.find(Profilo.class, id);
	}
	
	public Funzione ricercaFunzionePerId(int id) {
		return em.find(Funzione.class, id);
	}
}
