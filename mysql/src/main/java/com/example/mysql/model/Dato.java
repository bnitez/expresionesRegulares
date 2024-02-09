package com.example.mysql.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the datos database table.
 * 
 */
@Entity
@Table(name="datos")
@NamedQuery(name="Dato.findAll", query="SELECT d FROM Dato d")
public class Dato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dat_id")
	private int datId;

	@Column(name="dat_document")
	private String datDocument;

	@Column(name="dat_email")
	private String datEmail;

	private String dat_lastNames;

	@Column(name="dat_names")
	private String datNames;

	@Column(name="dat_password")
	private String datPassword;

	public Dato() {
	}

	public int getDatId() {
		return this.datId;
	}

	public void setDatId(int datId) {
		this.datId = datId;
	}

	public String getDatDocument() {
		return this.datDocument;
	}

	public void setDatDocument(String datDocument) {
		this.datDocument = datDocument;
	}

	public String getDatEmail() {
		return this.datEmail;
	}

	public void setDatEmail(String datEmail) {
		this.datEmail = datEmail;
	}

	public String getDat_lastNames() {
		return this.dat_lastNames;
	}

	public void setDat_lastNames(String dat_lastNames) {
		this.dat_lastNames = dat_lastNames;
	}

	public String getDatNames() {
		return this.datNames;
	}

	public void setDatNames(String datNames) {
		this.datNames = datNames;
	}

	public String getDatPassword() {
		return this.datPassword;
	}

	public void setDatPassword(String datPassword) {
		this.datPassword = datPassword;
	}

}