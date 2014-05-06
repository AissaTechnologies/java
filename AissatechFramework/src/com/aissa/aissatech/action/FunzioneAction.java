package com.aissa.aissatech.action;

/**
 * @author Camelia Boban
 *
 */

import java.util.List;

import org.apache.log4j.Logger;

import com.aissa.aissatech.pojo.Funzione;
import com.aissa.aissatech.service.FunzioneService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FunzioneAction extends ActionSupport {
	private static final long serialVersionUID = -854229252892954826L;
	
	private FunzioneService service;
	private Integer id;
	private List<Funzione> listaFunzione;
	private List<Funzione> listaFunzioneRicerca;
	private Funzione funzione;
	private String codice;
	private String descrizione;
	private String path;
	private Boolean pathPresente = false;
	private Boolean pathModPresente = false;
	public Boolean aggiornato = false;
	private String codMod;
	private String descMod;
	private String pathMod;


	private static Logger log = Logger.getLogger(FunzioneAction.class);
	
	//Dependency Injection
	public FunzioneAction(FunzioneService service) {
		this.service = service;
	}
	
	//METHODS
	public String presenta() {		
		return Action.SUCCESS;
	}
	//lista funzioni con filtro - codice
	public String ricerca() {
		clearErrorsAndMessages();		
		listaFunzione = service.listaFunzioni(codice);
		
		return Action.SUCCESS;
	}
	//lista funzioni senza filtro
	public String lista() {
		clearErrorsAndMessages();
		listaFunzione = service.listaFunzioni();
		log.debug("lista funzione size = " + service.listaFunzioni().size());
		
		return Action.SUCCESS;
	}
	
	public String inserisci() {
		
		return Action.SUCCESS;
	}
	
	public String salva() {
		clearErrorsAndMessages();		
		try {
			pathPresente = service.pathPresente(path);
			addActionMessage("Path funzione già esistente");
			if(pathPresente) {
				addActionMessage("Modificare il path, funzione già presente!");
				return Action.INPUT;
			}		
			else {				
				funzione = new Funzione();
				funzione.setCodice(codice);
				funzione.setDescrizione(descrizione);
				funzione.setPath(path);
				service.salvaFunz(funzione);
				listaFunzione = service.listaFunzioni();
				
				return lista();
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			return Action.ERROR;
		}
	}
	
	public String modifica() {
		clearErrorsAndMessages();
		funzione = service.ricercaFunzPerId(id);
		
		return Action.SUCCESS;
	}
	
	public String aggiorna() {
		clearErrorsAndMessages();
		try {
			//recupero funzione in base all'id		
			funzione = service.ricercaFunzPerId(id);			
			if(funzione == null) {
				addActionMessage("Errore ricerca funzione per id");
				return Action.INPUT;				
			}
			else {				
				//settaggio dati modificati
				funzione.setCodice(codMod);
				funzione.setDescrizione(descMod);
				//verifica che non ci sia già inserito un path uguale al pathMod 
				pathModPresente = service.pathModPresente(funzione.getId());//(id)				
				if(pathModPresente) {
					addActionMessage("Path da modificare già esistente");
				}
				else {
					funzione.setPath(pathMod);	
				}
				service.aggiornaFunz(funzione);
				aggiornato = true;
				addActionMessage("Record aggiornato con successo!");
				log.debug("record aggiornato con successo!");

				return lista();
			}
			
		}		
		catch(Exception ex) {
			ex.printStackTrace();
			return Action.ERROR;
		}
	}
	public String cancella() {
		clearErrorsAndMessages();		
		service.cancellaFunz(id);
		
		return lista();
	}
	
	//GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Funzione> getListaFunzione() {
		return listaFunzione;
	}

	public void setListaFunzione(List<Funzione> listaFunzione) {
		this.listaFunzione = listaFunzione;
	}	

	public List<Funzione> getListaFunzioneRicerca() {
		return listaFunzioneRicerca;
	}

	public void setListaFunzioneRicerca(List<Funzione> listaFunzioneRicerca) {
		this.listaFunzioneRicerca = listaFunzioneRicerca;
	}

	public Funzione getFunzione() {
		return funzione;
	}

	public void setFunzione(Funzione funzione) {
		this.funzione = funzione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getPathPresente() {
		return pathPresente;
	}

	public void setPathPresente(Boolean pathPresente) {
		this.pathPresente = pathPresente;
	}

	public Boolean getPathModPresente() {
		return pathModPresente;
	}

	public void setPathModPresente(Boolean pathModPresente) {
		this.pathModPresente = pathModPresente;
	}

	public Boolean getAggiornato() {
		return aggiornato;
	}

	public void setAggiornato(Boolean aggiornato) {
		this.aggiornato = aggiornato;
	}

	public String getCodMod() {
		return codMod;
	}

	public void setCodMod(String codMod) {
		this.codMod = codMod;
	}

	public String getDescMod() {
		return descMod;
	}

	public void setDescMod(String descMod) {
		this.descMod = descMod;
	}

	public String getPathMod() {
		return pathMod;
	}

	public void setPathMod(String pathMod) {
		this.pathMod = pathMod;
	}
	
}
