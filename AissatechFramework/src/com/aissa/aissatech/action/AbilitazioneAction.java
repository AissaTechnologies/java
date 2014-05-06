package com.aissa.aissatech.action;

/**
 * @author Camelia Boban
 *
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.aissa.aissatech.pojo.Abilitazione;
import com.aissa.aissatech.pojo.Funzione;
import com.aissa.aissatech.pojo.Profilo;
import com.aissa.aissatech.service.AbilitazioneService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AbilitazioneAction extends ActionSupport {
	private static final long serialVersionUID = -854229252892954826L;
	
	private AbilitazioneService service;
	private Integer id;
	private List<Abilitazione> listaAbilitazione;
	private Abilitazione abilitazione;
	private String abilitato;
	private List<Funzione> listaFunzione;
	private Funzione funzione;
	private List<Profilo> listaProfilo;
	private Profilo profilo;
	private String pathMod;

	private static Logger log = Logger.getLogger(AbilitazioneAction.class);
	
	/*public String execute() {
		return Action.SUCCESS;
	}*/
	
	//Dependency Injection
	public AbilitazioneAction(AbilitazioneService service) {
		this.service = service;
	}
	
	//METHODS
	public String presenta() {
		clearErrorsAndMessages();
		return Action.SUCCESS;
	}
	
	//lista abilitazione con filtro(abilitato)
	public String ricerca() {
		clearErrorsAndMessages();		
		listaAbilitazione = service.listaAbilitazioni(abilitato);		
		log.debug("action, listaAbilitazione dalla ricerca = " + listaAbilitazione.size());
		
		return Action.SUCCESS;
	}
	
	//lista abilitazione senza filtro
	public String lista() {
		clearErrorsAndMessages();
		listaAbilitazione = service.listaAbilitazioni();
		log.debug("action, listaAbilitazione size = " + listaAbilitazione.size());
		
		return Action.SUCCESS;
	}
	
	public String ricercaPerId() {
		clearErrorsAndMessages();
		service.ricercaAbilPerId(id);
		
		return Action.SUCCESS;
	}
	
	public String inserisci() {
		clearErrorsAndMessages();
		listaFunzione = service.listaFunzioni();	
		listaProfilo = service.listaProfili();
		
		return Action.SUCCESS;
	}
	
	public String salva() {
		clearErrorsAndMessages();		
		//i valori delle combo sono solo l'id
		Funzione funz = service.ricercaFunzionePerId(funzione.getId());
		Profilo prof = service.ricercaProfiloPerId(profilo.getId());
		
		try {			
			//ricerca abilitazione già esistente
			Boolean esistente = service.ricercaAbilEsistente(funz.getPath(), prof.getFlagTipoProfilo());	
			//esiste un'altra abilitazione tra la funzione ed il profilo
			if(esistente) {				
				addActionMessage("Abilitazione tra la funzione " + funz.getCodice() + " ed il profilo " + prof.getDescrizione() + 
						" già esistente! La funzione si può solo modificare.");				
				listaFunzione = service.listaFunzioni();	
				listaProfilo = service.listaProfili();
				return Action.INPUT;
			}
			// non esiste un'altra abilitazione tra la funzione ed il profilo
			else {				
				if(!funz.getCodice().substring(0, 4).equals("LIST") || !funz.getCodice().substring(0, 3).equals("RIC")) { 						
					if(!prof.getFlagTipoProfilo().equals(1)) {
						if(abilitato.equals("1")) {
							clearErrorsAndMessages();
							addActionMessage("Utenti diversi dall admin sono abilitati solo alla ricerca e alla visualizzazione delle liste!");
							listaFunzione = service.listaFunzioni();	
							listaProfilo = service.listaProfili();
							return Action.INPUT;
						}
						else {
							abilitazione = new Abilitazione();		
							abilitazione.setFunzione(funzione);
							abilitazione.setProfilo(profilo);
							abilitazione.setAbilitato(Byte.valueOf(abilitato));
							
							service.salvaAbil(abilitazione);
							
							return ricerca();
						}
					} 
					else {
						abilitazione = new Abilitazione();		
						abilitazione.setFunzione(funzione);
						abilitazione.setProfilo(profilo);
						abilitazione.setAbilitato(Byte.valueOf(abilitato));
						
						service.salvaAbil(abilitazione);
						
						return ricerca();
					}
				}
				else {
					abilitazione = new Abilitazione();		
					abilitazione.setFunzione(funzione);
					abilitazione.setProfilo(profilo);
					abilitazione.setAbilitato(Byte.valueOf(abilitato));
					
					service.salvaAbil(abilitazione);
					
					return ricerca();
				}
			}
			
		}		
		catch(Exception ex) {
			ex.printStackTrace();
			
			return Action.ERROR;
		}		
	}
	public String modifica() {
		clearErrorsAndMessages();		
		listaProfilo = service.listaProfili();
		abilitazione = service.ricercaAbilPerId(id);
		log.debug("action, id abilitazione selezionata dalla displaytag = " + abilitazione.getId() + ", codice = " + abilitazione.getFunzione().getCodice());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listaProf", listaProfilo);
		request.setAttribute("abil", abilitazione);	
		
		return Action.SUCCESS;
	}
	
	public String aggiorna() {
		clearErrorsAndMessages();
		abilitazione = service.ricercaAbilPerId(id);
		log.debug("action, aggiorna, abilitazione da mod = " + abilitazione.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		log.debug("action, request: pathMod = " + request.getParameter("pathMod") + ", selProf = " + request.getParameter("selProf") + ", selAbil = " + request.getParameter("selAbil"));	
		
		profilo = service.ricercaProfiloPerId(Integer.valueOf(request.getParameter("selProf")));
		//è stata modificata la desc profilo, si setta il profilo con il nuovo dato
		if(request.getParameter("selProf") != null && !request.getParameter("selProf").equals("")) {				
			profilo.setFlagTipoProfilo(Byte.valueOf(request.getParameter("selProf")));				
			log.debug("action, dopo la mod (if)  = " + abilitazione.getProfilo().getDescrizione());
		}
		//non è stata modificata la desc profilo, il profilo rimane quello esistente
		abilitazione.setProfilo(profilo);				
		log.debug("action, dopo la mod (else) = " + abilitazione.getProfilo().getDescrizione());

		log.debug("action, new abilMod  = " + Byte.valueOf(request.getParameter("selAbil")));
		abilitazione.setAbilitato(Byte.valueOf(request.getParameter("selAbil")));
		
		service.aggiornaAbil(abilitazione);

		return ricerca();
		
//		clearErrorsAndMessages();	
//		HttpServletRequest request = ServletActionContext.getRequest();	
//		//log.debug("action, aggiorna, request: profilo = " + request.getParameter("selProf") + ", abilitato = " + request.getParameter("selAbil"));
//		abilitazione = service.ricercaAbilPerId(id);			
//		//profilo = service.ricercaProfiloPerId(Integer.parseInt(request.getParameter("selProf")));
//		profilo = service.ricercaProfiloPerId(profilo.getId());
//		try {
//			
//			log.debug("action, aggiorna, abilitazione ricerca per id = " + abilitazione.getId() + ", profilo ricerca per id = " + profilo.getId());
//			Boolean esistente = service.ricercaAbilEsistente(abilitazione.getFunzione().getPath(), profilo.getFlagTipoProfilo());
//			log.debug("action, aggiorna, esistente = " + esistente);
//			//esiste un'altra abilitazione tra la funzione ed il profilo
//			if(esistente) {
//				clearErrorsAndMessages();
//				log.debug("action, aggiorna, esistente (if) = " + esistente);
//				addActionMessage("Abilitazione tra la funzione " + abilitazione.getFunzione().getCodice() + " ed il profilo " + 
//						profilo.getDescrizione() + " già esistente!");				
////				listaProfilo = service.listaProfili();
////				//abilitazione = service.ricercaAbilPerId(id);				
////				request.setAttribute("listaProf", listaProfilo);
////				request.setAttribute("abil", abilitazione);	
//				
//				return Action.INPUT;
//			}
//			else {
//				log.debug("action, aggiorna, esistente (else) = " + esistente);
//				//la funzione non inizia per LIST o RIC
//				if(!abilitazione.getFunzione().getCodice().substring(0, 5).startsWith("LIST") || !abilitazione.getFunzione().getCodice().substring(0, 4).startsWith("RIC")) {
//					//il profilo non è quello dell'admin
//					if(!profilo.getFlagTipoProfilo().equals(1)) {
//						//l'abilitazione è SI
//						if(abilitazione.getAbilitato().equals(1)) {
//							log.debug("action, aggiorna, abilitazione SI = " + abilitazione.getAbilitato());
//							clearErrorsAndMessages();
//							addActionMessage("Utenti diversi dall admin sono abilitati solo alla ricerca e alla visualizzazione delle liste!");
//							listaProfilo = service.listaProfili();
//							//abilitazione = service.ricercaAbilPerId(id);				
//							request.setAttribute("listaProf", listaProfilo);
//							request.setAttribute("abil", abilitazione);	
//							
//							//return modifica();
//							return Action.INPUT;
//						}
////						//abilitato = NO
////						else {
////							log.debug("action, aggiorna, no abilitato = " + abilitazione.getAbilitato());
////							profilo.setFlagTipoProfilo(Byte.valueOf(request.getParameter("selProf")));
////							abilitazione.setProfilo(profilo);
////							abilitazione.setAbilitato(Byte.valueOf(request.getParameter("selAbil")));
////							service.aggiornaAbil(abilitazione);
////	
////							return ricerca();
////						}
//					}
////					//profilo admin
////					else {
////						log.debug("action, aggiorna, profilo admin = " + profilo.getFlagTipoProfilo());
////						profilo.setFlagTipoProfilo(Byte.valueOf(request.getParameter("selProf")));
////						abilitazione.setProfilo(profilo);
////						abilitazione.setAbilitato(Byte.valueOf(request.getParameter("selAbil")));
////						service.aggiornaAbil(abilitazione);
////	
////						return ricerca();
////					}
//					
//				}
////				//funzione che inizia per LIST o RIC
////				else {
////					profilo.setFlagTipoProfilo(Byte.valueOf(request.getParameter("selProf")));
////					abilitazione.setProfilo(profilo);
////					abilitazione.setAbilitato(Byte.valueOf(request.getParameter("selAbil")));
////					service.aggiornaAbil(abilitazione);
////	
////					return ricerca();
////				}
//			}
//			profilo.setFlagTipoProfilo(Byte.valueOf(request.getParameter("selProf")));
//			abilitazione.setProfilo(profilo);
//			abilitazione.setAbilitato(Byte.valueOf(request.getParameter("selAbil")));
//			service.aggiornaAbil(abilitazione);
//
//			return ricerca();
////			//è stata modificata la desc profilo, si setta il profilo con il nuovo dato
////			//if(request.getParameter("selProf") != null && !request.getParameter("selProf").equals("")) {				
////				profilo.setFlagTipoProfilo(Byte.valueOf(request.getParameter("selProf")));				
////				log.debug("action, dopo la mod (if)  = " + abilitazione.getProfilo().getDescrizione());
////			//}
////			//non è stata modificata la desc profilo, il profilo rimane quello esistente
////			abilitazione.setProfilo(profilo);				
////			log.debug("action, dopo la mod (else) = " + abilitazione.getProfilo().getDescrizione());
////
////			log.debug("action, new abilMod  = " + Byte.valueOf(request.getParameter("selAbil")));
////			abilitazione.setAbilitato(Byte.valueOf(request.getParameter("selAbil")));
////			
////			service.aggiornaAbil(abilitazione);
////
////			return ricerca();
//			
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//			
//			return Action.ERROR;
//		}
//		
	}
	
	public String cancella() {
		clearErrorsAndMessages();
		service.cancellaAbil(id);
		
		return ricerca();
	}
	
	//GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Abilitazione> getListaAbilitazione() {
		return listaAbilitazione;
	}

	public void setListaAbilitazione(List<Abilitazione> listaAbilitazione) {
		this.listaAbilitazione = listaAbilitazione;
	}

	public Abilitazione getAbilitazione() {
		return abilitazione;
	}

	public void setAbilitazione(Abilitazione abilitazione) {
		this.abilitazione = abilitazione;
	}

	public String getAbilitato() {
		return abilitato;
	}

	public void setAbilitato(String abilitato) {
		this.abilitato = abilitato;
	}

	public List<Funzione> getListaFunzione() {
		return listaFunzione;
	}

	public void setListaFunzione(List<Funzione> listaFunzione) {
		this.listaFunzione = listaFunzione;
	}

	public Funzione getFunzione() {
		return funzione;
	}

	public void setFunzione(Funzione funzione) {
		this.funzione = funzione;
	}

	public List<Profilo> getListaProfilo() {
		return listaProfilo;
	}

	public void setListaProfilo(List<Profilo> listaProfilo) {
		this.listaProfilo = listaProfilo;
	}

	public Profilo getProfilo() {
		return profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	public AbilitazioneService getService() {
		return service;
	}

	public void setService(AbilitazioneService service) {
		this.service = service;
	}

	public String getPathMod() {
		return pathMod;
	}

	public void setPathMod(String pathMod) {
		this.pathMod = pathMod;
	}
	
	
}
