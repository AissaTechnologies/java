package com.aissa.aissatech.service;

import java.util.List;

import com.aissa.aissatech.pojo.Login;
import com.aissa.aissatech.pojo.Profilo;

/**
 * @author Camelia Boban
 *
 */

public interface LoginService {
	
	public Login utenteRegistrato(String username, String pwd) throws Exception;
	
	//public Login verificaIdentita(String username);
	
	public List<Login> listaUtenti(String username);
	
	//public List<Anagrafica> listaAnagrafiche(String cognome);
	
	public List<Login> listaUtenti();
	
	public List<Profilo> listaProfili();
	
	public Login ricercaPerId(int id);
	
	public void salva(Login utente);
	
	public void aggiorna(Login utente);
	
	public void cancella(int id);

}
