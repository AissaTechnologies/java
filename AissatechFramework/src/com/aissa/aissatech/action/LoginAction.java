/**
 * 
 */
package com.aissa.aissatech.action;

/**
 * @author Camelia Boban
 *
 */

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.aissa.aissatech.pojo.Login;
import com.aissa.aissatech.service.LoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 8062268226636390259L;
	
	private LoginService service;
	private Login login;
	private String username;
	private String password;
	private String CF;
	
	
	private static Logger log = Logger.getLogger(LoginAction.class);	
	
	
	/*public String execute() {
		return Action.SUCCESS;
	}*/
	
	//Dependency Injection
	public LoginAction(LoginService service) {
		this.service = service;
	}
	
	public String validazioneInput() throws Exception {
		clearErrorsAndMessages();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		log.debug("request = " + request);
		
		//controllo frontend (inserimento dati nelle textfield)
		String user = request.getParameter("username");
		log.debug("request username = " + username);
		String pwd = request.getParameter("password");
		log.debug("request password = " + password);
		
		if(user == null || user.equalsIgnoreCase("")) {
			addActionError("Inserire username");
			
			return "input";
		}
		else {
			if(pwd == null || pwd.equalsIgnoreCase("")) {			
				addActionError("Inserire password");
				
				return "input";
			}			
		
			else {
				//controllo nel db (utente registrato)
				login = service.utenteRegistrato(user, pwd);
				//utente non esistente nel db
				if(login == null) {
					log.debug("utente non registrato"); 
					
					return "nonregistrato";
				}
				//utente registrato, mettiamo i dati dell'utente nella sessione
				else {
					request.getSession().setAttribute("username", user);
					request.getSession().setAttribute("password", pwd);
					request.getSession().setAttribute("tipoProfilo", login.getProfilo().getFlagTipoProfilo());
					
					return Action.SUCCESS;
				}	
				
			}
		}	
		
	}
	
	// HANNO I GET E SET SOLO LE VARIABILI CHE 'VIAGGIANO' TRA LE ACTION E LE JSP
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
