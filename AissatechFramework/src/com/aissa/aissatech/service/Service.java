/**
 * 
 */
package com.aissa.aissatech.service;

import java.util.List;

/**
 * @author Camelia Boban
 *
 */

public interface Service {
	
	//metodi comuni a tutte le classi
	
	//public Class<?> ricercaPerId(int id);
	public Object ricercaPerId(Class<?> clazz, int id);
	
	public List<?> lista(Class<?> clazz);
	
	public void salva(Class<?> clazz);
	
	public void aggiorna(Class<?> clazz);
	
	//public void cancella(int id);
	public void cancella(Class<?> clazz, int id);
	
	//metodi personalizzati
	
	public Byte maxTipoProfilo();
}
