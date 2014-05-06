package com.aissa.aissatech.service;


/**
 * @author Camelia Boban
 *
 */

import java.util.List;

import com.aissa.aissatech.pojo.Anagrafica;
import com.aissa.aissatech.pojo.Profilo;

public interface AnagraficaService {
	
	//public List<Anagrafica> ricercaAnagrafica(String cognome, String matricola, Date dataScadenza);
	public List<Anagrafica> ricercaAnagrafica(String cognome, String matricola);
	
	public List<Anagrafica> listaAnagrafiche();
	
	public Anagrafica ricercaAnagPerId(int id);
	
	public void salvaAnag(Anagrafica anag);
	
	public void aggiornaAnag(Anagrafica anag);
	
	public void cancellaAnag(int id);
	
	public Anagrafica ricercaAnagPerMatricola(String matricola);
	
	public String maxMatricola();
	
	public List<Profilo> listaProfilo();
	
}
