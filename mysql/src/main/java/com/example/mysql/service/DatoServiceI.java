package com.example.mysql.service;

import java.util.List;

import com.example.mysql.model.Dato;

public interface DatoServiceI {
	boolean addDato(Dato dato);
	List<Dato> getAllDato();
	Dato updateDato(Dato dato);
	boolean deleteDatoId(int idDato);
	Dato searchDato(int id);
	Dato searchDato(String email);
}
