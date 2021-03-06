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
 * Abilitazione generated by hbm2java
 */

@Entity
@Table(name = "abilitazione", catalog = "aissatech")
public class Abilitazione implements java.io.Serializable {
	private static final long serialVersionUID = -3146427662233050789L;
	
	private Integer id;
	private Funzione funzione;
	private Profilo profilo;
	private Byte abilitato;

	public Abilitazione() {
	}

	public Abilitazione(Funzione funzione, Profilo profilo, Byte abilitato) {
		this.funzione = funzione;
		this.profilo = profilo;
		this.abilitato = abilitato;
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
	@JoinColumn(name = "id_funzione")
	public Funzione getFunzione() {
		return this.funzione;
	}

	public void setFunzione(Funzione funzione) {
		this.funzione = funzione;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profilo")
	public Profilo getProfilo() {
		return this.profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	@Column(name = "abilitato")
	public Byte getAbilitato() {
		return this.abilitato;
	}

	public void setAbilitato(Byte abilitato) {
		this.abilitato = abilitato;
	}

}
