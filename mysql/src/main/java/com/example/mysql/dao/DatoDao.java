package com.example.mysql.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mysql.model.Dato;

@Repository
public class DatoDao implements DatoDaoI{
	
	@Autowired
	DatoJPA datoJPA;

	@Override
	public Dato addDato(Dato dato) {
		return datoJPA.save(dato);
	}

	@Override
	public Dato updateDato(Dato dato) {
		return datoJPA.save(dato);
	}

	@Override
	public void deleteIdDato(int id) {
		datoJPA.deleteById(id);
	}

	@Override
	public Dato searchDato(int id) {
		return datoJPA.findById(id).orElse(null);
	}

	@Override
	public List<Dato> getAllDato() {
		return datoJPA.findAll();
	}

	@Override
	public Dato searchDato(String email) {
		return datoJPA.findByDatEmail(email);
	}

}
