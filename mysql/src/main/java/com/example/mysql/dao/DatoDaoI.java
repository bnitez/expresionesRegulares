package com.example.mysql.dao;

import java.util.List;

import com.example.mysql.model.Dato;

public interface DatoDaoI {
	Dato addDato(Dato dato);
	Dato updateDato(Dato dato);
	void deleteIdDato(int id);
	Dato searchDato(int id);
	List<Dato> getAllDato();
	Dato searchDato(String email);
}
