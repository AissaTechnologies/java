package com.aissa.aissatech.pojo;

/**
 * @author Camelia Boban
 *
 */
// default package
// Generated 29-dic-2012 23.36.39 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Login generated by hbm2java
 */
@Entity
@Table(name = "login", catalog = "aissatech")
public class Login implements java.io.Serializable {
	private static final long serialVersionUID = 8482027674105910583L;
	
	private Integer id;
	private Profilo profilo;
	private String username;
	private String password;
	private String codiceFiscale;
	private String descrizione;

	public Login() {
	}

	public Login(Profilo profilo, String username, String password,
			String codiceFiscale, String descrizione) {
		this.profilo = profilo;
		this.username = username;
		this.password = password;
		this.codiceFiscale = codiceFiscale;
		this.descrizione = descrizione;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profilo")
	public Profilo getProfilo() {
		return this.profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	@Column(name = "username", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "codice_fiscale", length = 16)
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Column(name = "descrizione", length = 100)
	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}