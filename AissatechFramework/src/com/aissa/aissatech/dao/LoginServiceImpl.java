package com.aissa.aissatech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.aissa.aissatech.pojo.Login;
import com.aissa.aissatech.pojo.Profilo;
import com.aissa.aissatech.service.LoginService;


/**
 * @author Camelia Boban
 *
 */
@Transactional
public class LoginServiceImpl implements LoginService {
	//@PersistenceContext
	//per evitare eccezioni di tipo lazy "org.hibernate.LazyInitializationException: could not initialize proxy - the owning Session was closed"; 
	//si può avere accesso alla proprietà lazy (em) dappertutto
	@PersistenceContext(type = PersistenceContextType.EXTENDED) 
	
	private EntityManager em;
	private static Logger log = Logger.getLogger(LoginServiceImpl.class);

	public EntityManager getEntityManager() {
		return em;
	}

	public Login utenteRegistrato(String user, String pwd) {		
		Login myLogin;
		
		try {
			String queryStr = "SELECT l FROM Login l WHERE username = '" + user + "' AND password = '" + pwd + "'";
			Query query = em.createQuery(queryStr);			
			log.debug("query = " + query);
			
			myLogin = (Login)query.getSingleResult();
		}
		catch(NoResultException nre) {
			//nre.printStackTrace();			
			myLogin = null;
		}
		
		return myLogin;

	}
//	public Login verificaIdentita(String username) {
//		String queryStr = "SELECT codice_fiscale FROM Anagrafica WHERE username= '" + username + "'";
//		Query query = em.createQuery(queryStr);
//		
//		return (Login)query.getSingleResult();
//	}
	
	@SuppressWarnings("unchecked")
	public List<Login> listaUtenti() {		
		String queryStr = "SELECT u FROM Login u ORDER BY id ASC";
		Query query = getEntityManager().createQuery(queryStr);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Profilo> listaProfili() {
		String queryStr = "SELECT p FROM Profilo p";
		Query query = em.createQuery(queryStr);
		
		return query.getResultList();
	}
	
	public void salva(Login utente) {		
		if(utente != null) {
			log.debug("dao, utente salvato = " + utente.getCodiceFiscale());
			em.persist(utente);
		}
		else {
			log.debug("utente = null");
		}
	}
	
	public void cancella(int id) {
		Login utente = ricercaPerId(id);
		
		if(utente != null) {
			em.remove(utente);		
		}
	}
	
	public void aggiorna(Login utente) {
		em.merge(utente);
	}
	
	public Login ricercaPerId(int id) {
		
		return em.find(Login.class, id);
	}

	@SuppressWarnings("unchecked")
	//ricerca utente per username
	public List<Login> listaUtenti(String username) {
		String queryStr = "SELECT l FROM Login l ";
		if(username != null && username.equals("")) {
			queryStr += " WHERE username = '" + username + "'";
		}
		Query query = em.createQuery(queryStr);
		
		return query.getResultList();
	}
	
//	public List<Anagrafica> listaAnagrafiche(String cognome) {
//		String query = "SELECT a FROM ";
//	}
}
