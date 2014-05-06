package com.aissa.aissatech.action;

/**
 * @author Camelia Boban
 *
 */

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.aissa.aissatech.pojo.Anagrafica;
import com.aissa.aissatech.pojo.Profilo;
import com.aissa.aissatech.service.AnagraficaService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AnagraficaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(AnagraficaAction.class);
	
	private AnagraficaService service;
	private Integer id;
	private Anagrafica anagrafica;
	private List<Anagrafica> listaAnagrafica;
	private String nome;
	private String cognome;
	private String matricola;
	private String codiceFiscale;
	private Date dataValidita;
	private Date dataScadenza;
	private Byte flagTipoCollab;
	private Date validMod;
	private Date scadMod;
	private Byte tipoCollabMod;
	private List<Profilo> listaProfilo;

	
	//Spring IoC - Inversion Of Control (si inietta la dipendenza tramite il costruttore)
	public AnagraficaAction (AnagraficaService service) {
		this.service = service;
	}
	
	//METHODS
	public String presenta() {		
		return Action.SUCCESS;
	}
	
	public String ricerca() {
		clearErrorsAndMessages();	
		listaAnagrafica = service.ricercaAnagrafica(cognome, matricola);
		log.info("-------------- dati per la ricerca = " + cognome + ", " + matricola + " --------------");
		
		return Action.SUCCESS;
	}
	public String lista() {
		clearErrorsAndMessages();
		listaAnagrafica = service.listaAnagrafiche();
		log.info("-------------- lista delle anagrafiche = " + listaAnagrafica.size() + " --------------");
		
		return Action.SUCCESS;
	}
	
	public String ricercaPerId() {
		clearErrorsAndMessages();
		service.ricercaAnagPerId(id);
		
		return Action.SUCCESS;
	}
	
	public String inserisci() {
		listaProfilo = service.listaProfilo();
		log.debug("lista profilo = " + listaProfilo.size());
		
		return Action.SUCCESS;
	}	
	
	public String salva() {
		clearErrorsAndMessages();		
		try {
			//controllo se esiste già un'anagrafica
			Anagrafica anag = service.ricercaAnagPerId(id);	
			//assegnazione del prossimo numero di matricola
			String maxMatricola = service.maxMatricola();
			log.debug("maxMatricola = " + maxMatricola);
			String proxMatricola = maxMatricola.substring(0, 2) + (Integer.parseInt(maxMatricola.substring(3, 4)) + 1);
			
			if(anag == null) {				
				anagrafica = new Anagrafica();
				anagrafica.setNome(nome);
				anagrafica.setCognome(cognome);
				anagrafica.setCodiceFiscale(codiceFiscale);			
				anagrafica.setMatricola(proxMatricola);
				anagrafica.setDataValidita(dataValidita);
				anagrafica.setDataScadenza(dataScadenza);
				anagrafica.setFlagTipoCollab(flagTipoCollab);	
				
				service.salvaAnag(anagrafica);
				
				return lista();
			}
			else {
				addActionMessage("Anagrafica già esistente!");
				return Action.INPUT;
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			return Action.ERROR;
		}	
	}
	public String modifica() {
		clearErrorsAndMessages();
		anagrafica = service.ricercaAnagPerId(id);
		
		return Action.SUCCESS;
	}
	
	public String aggiorna() {		
		clearErrorsAndMessages();	
		try {
			anagrafica = service.ricercaAnagPerId(id);	
			if(anagrafica != null) {
				//set dataValidita modificata		
				if(validMod != null) {				
					anagrafica.setDataValidita(validMod);
				}
				else {
					anagrafica.setDataValidita(anagrafica.getDataValidita());
				}
				//set dataScadenza modificata		
				if(scadMod != null) {			
					anagrafica.setDataScadenza(scadMod);
				}
				else {
					anagrafica.setDataScadenza(anagrafica.getDataScadenza());
				}
				//set flagTipoCollab modificato
				anagrafica.setFlagTipoCollab(tipoCollabMod);
				
				service.aggiornaAnag(anagrafica);
				
				return lista();
			}
			else {
				addActionMessage("Anagrafica già esistente!");
				return Action.INPUT;
			}
		}
		catch (Exception ex) {
			ex.getStackTrace();
			
			return Action.ERROR;
		}
	}
	
	public String cancella() {
		clearErrorsAndMessages();
		service.cancellaAnag(id);
		
		return lista();
	}

	
	//GET & SET
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	public List<Anagrafica> getListaAnagrafica() {
		return listaAnagrafica;
	}

	public void setListaAnagrafica(List<Anagrafica> listaAnagrafica) {
		this.listaAnagrafica = listaAnagrafica;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}	

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataValidita() {
		return dataValidita;
	}

	public void setDataValidita(Date dataValidita) {
		this.dataValidita = dataValidita;
	}

	public Byte getFlagTipoCollab() {
		return flagTipoCollab;
	}

	public void setFlagTipoCollab(Byte flagTipoCollab) {
		this.flagTipoCollab = flagTipoCollab;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Date getValidMod() {
		return validMod;
	}

	public void setValidMod(Date validMod) {
		this.validMod = validMod;
	}

	public Date getScadMod() {
		return scadMod;
	}

	public void setScadMod(Date scadMod) {
		this.scadMod = scadMod;
	}

	public Byte getTipoCollabMod() {
		return tipoCollabMod;
	}

	public void setTipoCollabMod(Byte tipoCollabMod) {
		this.tipoCollabMod = tipoCollabMod;
	}

	public List<Profilo> getListaProfilo() {
		return listaProfilo;
	}

	public void setListaProfilo(List<Profilo> listaProfilo) {
		this.listaProfilo = listaProfilo;
	}	
}
