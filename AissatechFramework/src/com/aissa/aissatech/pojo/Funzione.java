package com.aissa.aissatech.pojo;

/**
 * @author Camelia Boban
 *
 */
// default package
// Generated 29-dic-2012 23.36.39 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Funzione generated by hbm2java
 */
@Entity
@Table(name = "funzione", catalog = "aissatech")
public class Funzione implements java.io.Serializable {
	private static final long serialVersionUID = 8829445852674110687L;
	
	private Integer id;
	private String codice;
	private String descrizione;
	private String path;
	private Set<Abilitazione> abilitaziones = new HashSet<Abilitazione>(0);	

	public Funzione() {
	}

	public Funzione(String codice, String descrizione, String path,
			Set<Abilitazione> abilitaziones) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.path = path;
		this.abilitaziones = abilitaziones;
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

	@Column(name = "codice", length = 8)
	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Column(name = "descrizione", length = 45)
	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Column(name = "path", length = 45)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funzione")
	public Set<Abilitazione> getAbilitaziones() {
		return this.abilitaziones;
	}

	public void setAbilitaziones(Set<Abilitazione> abilitaziones) {
		this.abilitaziones = abilitaziones;
	}

}
