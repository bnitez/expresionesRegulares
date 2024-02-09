package com.example.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.Dato;
import com.example.mysql.service.DatoServiceI;
import com.example.mysql.utils.Validator;

@RestController
public class DatoController extends Validator{

	@Autowired
	DatoServiceI service;
	
	@GetMapping(value="datos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Dato> getDatos(){
		return service.getAllDato();
	}
	
	@PostMapping(value="datos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>  saveDato(@RequestBody Dato dato) {
	    try {
	        if (!emailValidate(dato.getDatEmail())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        if (!textValidate(dato.getDatNames())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        boolean datoSaved = service.addDato(dato);

	        if (datoSaved) {
	            return new ResponseEntity<>("Dato guardado exitosamente", HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>("No se pudo guardar el dato", HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping(value="upDato", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Dato updateDato(@RequestBody Dato dato) {
		return service.updateDato(dato);
	}
}
