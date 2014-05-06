package com.aissa.aissatech.service;

/**
 * @author Camelia Boban
 *
 */

import java.util.List;
import com.aissa.aissatech.pojo.Funzione;


public interface FunzioneService {
	
	public Funzione ricercaFunzPerId(int id);
	
	public void salvaFunz(Funzione funz);
	
	public void aggiornaFunz(Funzione funz);
	
	public void cancellaFunz(int id);
	
	public List<Funzione> listaFunzioni();
	
	public List<Funzione> listaFunzioni(String codice);

	public Boolean pathPresente(String path);
	
	public Boolean pathModPresente(int id);
	
}