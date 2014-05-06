package com.aissa.aissatech.service;

/**
 * @author Camelia Boban
 *
 */

import java.util.List;
import com.aissa.aissatech.pojo.Profilo;


public interface ProfiloService {
	
	public Profilo ricercaProfPerId(int id);
	
	public void salvaProf(Profilo prof);
	
	public void aggiornaProf(Profilo prof);
	
	public void cancellaProf(int id);
	
	public List<Profilo> listaProfili();
	
	public Byte maxTipoProfilo();
	
}