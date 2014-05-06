package com.aissa.aissatech.service;

/**
 * @author Camelia Boban
 *
 */

import java.util.List;

import com.aissa.aissatech.pojo.Abilitazione;
import com.aissa.aissatech.pojo.Funzione;
import com.aissa.aissatech.pojo.Profilo;


public interface AbilitazioneService {
	
	public Abilitazione ricercaAbilPerId(int id);
	
	public void salvaAbil(Abilitazione abil);
	
	public void aggiornaAbil(Abilitazione abil);
	
	public void cancellaAbil(int id);	
	
	public List<Abilitazione> listaAbilitazioni(String abilitato);
		
	public List<Abilitazione> listaAbilitazioni();
	
	public List<Profilo> listaProfili();
	
	public Profilo ricercaProfiloPerId(int id);
	
	public List<Funzione> listaFunzioni();
	
	public Funzione ricercaFunzionePerId(int id);
	
	//public Boolean ricercaAbilEsistente(String path, Byte tipoProf, Byte abil);
	public Boolean ricercaAbilEsistente(String path, Byte tipoProf);
}
