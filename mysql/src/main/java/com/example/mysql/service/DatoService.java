package com.example.mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.dao.DatoDaoI;
import com.example.mysql.model.Dato;

@Service
public class DatoService implements DatoServiceI {

	@Autowired
	DatoDaoI dao;
	
	@Override
	public boolean addDato(Dato dato) {
		if(dao.searchDato(dato.getDatEmail()) == null ) {
			dao.addDato(dato);
			return true;
		}
		return false;
	}

	@Override
	public List<Dato> getAllDato() {
		return dao.getAllDato();
	}

	@Override
	public Dato updateDato(Dato dato) {
		return dao.searchDato(dato.getDatId()) != null ? dao.updateDato(dato) : null;  
	}

	@Override
	public boolean deleteDatoId(int idDato) {
		if(dao.searchDato(idDato) != null ) {
			dao.deleteIdDato(idDato);
			return true;
		}
		return false;
	}

	@Override
	public Dato searchDato(int id) {
		return dao.searchDato(id);
	}

	@Override
	public Dato searchDato(String email) {
		return dao.searchDato(email);
	}

}
