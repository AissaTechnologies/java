package com.aissa.aissatech.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.aissa.aissatech.pojo.Profilo;
import com.aissa.aissatech.service.ProfiloService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ProfiloAction extends ActionSupport {
	private static final long serialVersionUID = -854229252892954826L;
	
	private ProfiloService service;
	private Integer id;
	private List<Profilo> listaProfilo;
	private Profilo profilo;
	private String descProfilo;
	private String descMod;

	private static Logger log = Logger.getLogger(ProfiloAction.class);

	//Dependency Injection
	public ProfiloAction(ProfiloService service) {
		this.service = service;
	}
	
	//METHODS
	public String lista() {
		clearErrorsAndMessages();
		
		listaProfilo = service.listaProfili();
		log.debug("lista profilo size = " + service.listaProfili().size());
		
		return Action.SUCCESS;
	}	
	
	public String inserisci() {
		clearErrorsAndMessages();
		return Action.SUCCESS;
	}
	
	public String ricercaPerId() {
		clearErrorsAndMessages();
		service.ricercaProfPerId(id);
		
		return Action.SUCCESS;
	}
	
	public String salva() {
		clearErrorsAndMessages();
		try {
			Integer nextTipo = service.maxTipoProfilo().intValue() + 1;	
			if(descProfilo != null && !descProfilo.equals("")) {
				profilo = new Profilo();
				profilo.setDescrizione(descProfilo);
				profilo.setFlagTipoProfilo(nextTipo.byteValue());		
				service.salvaProf(profilo);
				listaProfilo = service.listaProfili();
				
				return lista();
			}
			else {
				addActionMessage("Inserire una descrizione!");
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
		profilo = service.ricercaProfPerId(id);
		
		return Action.SUCCESS;
	}
	
	public String aggiorna() {
		clearErrorsAndMessages();
		try {
			profilo = service.ricercaProfPerId(id);			
			if(descMod != null && !"".equals(descMod)) {
				profilo.setDescrizione(descMod);
				service.aggiornaProf(profilo);
				
				return lista();
			}
			else {
				addActionMessage("Inserire una descrizione!");
				return Action.INPUT;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			return Action.ERROR;
		}
	}
	
	public String cancella() {	
		clearErrorsAndMessages();
		this.service.cancellaProf(id);
		
		return lista();
	}

	
	//GET & SET
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDescProfilo() {
		return descProfilo;
	}

	public void setDescProfilo(String descProfilo) {
		this.descProfilo = descProfilo;
	}

	public String getDescMod() {
		return descMod;
	}

	public void setDescMod(String descMod) {
		this.descMod = descMod;
	}
	
}
