package com.aissa.aissatech.action;

/**
 * @author Camelia Boban
 *
 */

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.aissa.aissatech.pojo.Anagrafica;
import com.aissa.aissatech.pojo.Login;
import com.aissa.aissatech.pojo.Profilo;
import com.aissa.aissatech.service.LoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UtenteAction extends ActionSupport {

	private static final long serialVersionUID = 1812701361345764130L;

	private static Logger log = Logger.getLogger(UtenteAction.class);
	
	private LoginService service;
	private Integer id;
	private Login utente;
	private List<Login> listaUtente;
	private List<Profilo> listaProfilo;
	private String user;
	private String pwd;
	public String cf;
	private Integer idProfilo;
	public String desc;
	private String newPwd;
	private String ripPwd;
	private Profilo profilo;
	private Anagrafica anagrafica;
	private String nome;
	private String cognome;
	private Date validita;
	private Date scadenza;
	
	//Spring Dependency Injection: IoC - Inversion Of Control (si inietta la dipendenza tramite il costruttore)
	public UtenteAction (LoginService service) {
		this.service = service;
	}
	
	public String ricerca() {
		//listaUtente = service.listaLogin(user);
		//listaUtente = service.listaUtenti(cognome);
		listaUtente = service.listaUtenti(user);
		
		return Action.SUCCESS;
	}
	
	public String lista() {
		clearErrorsAndMessages();
		this.listaUtente = service.listaUtenti();
		log.info("-------------- lista utente = " + listaUtente.size() + " --------------");
		
		return Action.SUCCESS;
	}
	
	public String inserisci() {
		clearErrorsAndMessages();
		listaProfilo = service.listaProfili();
		
		return Action.SUCCESS;
	}
	
	public String salva() {
		clearErrorsAndMessages();
//		log.debug("action, user = " + user);
//		log.debug("action, pwd = " + pwd);
//		log.debug("action, cf = " + cf);
//		log.debug("action, idProfilo = " + idProfilo);
//		log.debug("action, nome = " + nome);
//		log.debug("action, nome = " + cognome);
//		log.debug("action, nome = " + validita);
//		log.debug("action, nome = " + scadenza);
		
		try {
			if( (user != null && !user.equals("")) || (pwd != null && !pwd.equals("")) ) {
				//utente
				utente = new Login();			
				
				utente.setUsername(user);
				utente.setPassword(pwd);
				utente.setCodiceFiscale(cf);
				//profilo utente
				profilo = new Profilo();
				profilo.setId(idProfilo);
				utente.setProfilo(profilo);
				
				if(idProfilo == 1) {
					utente.setDescrizione("admin");
				}
				if(idProfilo == 2) {
					utente.setDescrizione("dip");				
				}
				if(idProfilo == 3) {
					utente.setDescrizione("collab");
				}						
//				//anagrafica
//				anagrafica = new Anagrafica();
//				anagrafica.setNome(nome);
//				anagrafica.setCognome(cognome);
//				anagrafica.setCodiceFiscale(cf);
//				anagrafica.setDataValidita(validita);
//				anagrafica.setDataScadenza(scadenza);
	
				service.salva(this.utente);
			
//				HttpServletRequest request = ServletActionContext.getRequest();
//				//request.getSession().setAttribute(user, utente);
//				request.getSession().setAttribute("username", user);
//				request.getSession().setAttribute("password", pwd);
//				request.getSession().setAttribute("tipoProfilo", idProfilo);
//				addActionMessage("utente inserito con successo");
				
				return Action.SUCCESS;
			}
			else {
				addActionMessage("I campi username e password sono abbligatori!");
				return Action.INPUT;
			}
		}
		catch (NullPointerException npe) {
			return "erroreReg";
		}
	}
	
	public String modPwd() {
		clearErrorsAndMessages();
//		if(ripPwd.equalsIgnoreCase(newPwd)) {
//			utente.setPassword(newPwd);
//			
//			return Action.SUCCESS;
//		}
//		
//		else {
//			return Action.INPUT;
//		}	
		try {
			//prendo l'utente dalla sessione
			HttpServletRequest request = ServletActionContext.getRequest();
			String userSession = (String) request.getSession().getAttribute("username");
			String pwdSession = (String) request.getSession().getAttribute("password");
			log.info("user session = " + userSession);
			log.info("pwd session = " + pwdSession);
			newPwd = request.getParameter("newPwd");
			ripPwd = request.getParameter("ripPwd");
			log.info("request newPwd = " + newPwd);
			log.info("request ripPwd = " + ripPwd);
			//utente = service.utenteRegistrato(user, pwd);
			if(newPwd != null && !newPwd.equals("")) {
				if(!pwdSession.equalsIgnoreCase(newPwd)) {
					if(ripPwd != null && !ripPwd.equals("")) {
						if(newPwd.equalsIgnoreCase(ripPwd)) {
							Login utenteMod = service.utenteRegistrato(userSession, pwdSession);
							utenteMod.setPassword(newPwd);
							service.aggiorna(utenteMod);
							return Action.SUCCESS;
						}
						else {
							addActionMessage("Le due password sono differenti!");
							return Action.INPUT;
						}
					}
					else {
						addActionMessage("Ripetere nuovamente la password!");
						return Action.INPUT;
					}
				}
				else {
					addActionMessage("La vecchia e la nuova password coincidono!");
					return Action.INPUT;
				}
			}
			else {
				addActionMessage("Inserire la nuova password!");
				return Action.INPUT;
			}		
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return Action.INPUT;
		}
	}

	public Integer getId() {
		return id;
		
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public Login getUtente() {
		return utente;
	}

	public void setUtente(Login utente) {
		this.utente = utente;
	}	

	public List<Login> getListaUtente() {
		return listaUtente;
	}

	public void setListaUtente(List<Login> listaUtente) {
		this.listaUtente = listaUtente;
	}	
	
	public String getUser() {
		return user;
	}

	public List<Profilo> getListaProfilo() {
		return listaProfilo;
	}

	public void setListaProfilo(List<Profilo> listaProfilo) {
		this.listaProfilo = listaProfilo;
	}

	public Integer getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(Integer idProfilo) {
		this.idProfilo = idProfilo;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getRipPwd() {
		return ripPwd;
	}

	public void setRipPwd(String ripPwd) {
		this.ripPwd = ripPwd;
	}

	public Profilo getProfilo() {
		return profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getValidita() {
		return validita;
	}

	public void setValidita(Date validita) {
		this.validita = validita;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}	
	
}
