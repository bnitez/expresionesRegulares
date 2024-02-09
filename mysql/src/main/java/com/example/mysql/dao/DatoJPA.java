package com.example.mysql.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysql.model.Dato;

public interface DatoJPA extends JpaRepository<Dato, Integer>{
	
	Dato findByDatEmail(String datEmail);
}
