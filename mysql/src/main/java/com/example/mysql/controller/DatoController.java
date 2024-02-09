package com.example.mysql.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.Dato;
import com.example.mysql.service.DatoServiceI;
import com.example.mysql.utils.Validator;

@RestController
public class DatoController{

	@Autowired
	DatoServiceI service;
	
	@Autowired
	Validator validator;
	
	private <T> ResponseEntity<Map<String, Object>> defaultResponse(HttpStatus status, T message) {
		Map<String, Object> response = new HashMap<>();
		response.put("status", status.value());
		response.put("message", message);
		return ResponseEntity.status(status).body(response);
	}
	
		
	@GetMapping(value="datos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> getDatos(){
		List<Dato> datos = service.getAllDato();
		return !datos.isEmpty() ? defaultResponse(HttpStatus.OK, datos) : defaultResponse(HttpStatus.OK, "Sin registros");
	}
	
	@PostMapping(value="datos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>>  saveDato(@RequestBody Dato dato) {
		try {
			String validacion= validator.validateData(dato,false);
			if(validacion != null) {
				return defaultResponse(HttpStatus.BAD_REQUEST, validacion);
			}
			
			if (service.addDato(dato)) {
				return defaultResponse(HttpStatus.CREATED, dato); 
			}
			
			return defaultResponse(HttpStatus.BAD_REQUEST,"El correo: "+dato.getDatEmail() + " ya se encuentra registrado");
			
		} catch (Exception e) {
			System.out.println(e);
			return defaultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
		}
	}
	
	@PutMapping(value="upDato", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> updateDato(@RequestBody Dato dato) {
		try {
			String validacion= validator.validateData(dato,true);
			if(validacion != null) {
				return defaultResponse(HttpStatus.BAD_REQUEST, validacion);
			}
			
			Dato dataUp= service.updateDato(dato);
			return dataUp !=null ? defaultResponse(HttpStatus.OK, dataUp) : defaultResponse(HttpStatus.NOT_FOUND, "No se encontro el registro con id: "+dato.getDatId());
		} catch (Exception e) {
			System.out.println(e);
			return defaultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
		}
	}
	
	@DeleteMapping(value="deleteDato/{datId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> deleteDato(@PathVariable("datId") int id){
		try {
			if(!validator.idValidate(id)) {
				return defaultResponse(HttpStatus.BAD_REQUEST, "El id no es valido");
			}
			
			Boolean result=service.deleteDatoId(id);
			return result ? defaultResponse(HttpStatus.OK, "Registro eliminado") : defaultResponse(HttpStatus.NOT_FOUND, "El id: "+id+" No se encuentra en el sistema" );			
		}catch(Exception e) {
			System.out.println(e);
			return defaultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
		}
	}
	
	@GetMapping(value="searchById/{datId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> searchById(@PathVariable("datId") int id){
		try {
			if(!validator.idValidate(id)) {
				return defaultResponse(HttpStatus.BAD_REQUEST, "El id no es valido");
			}
			
			Dato result=service.searchDato(id);
			return result!=null ? defaultResponse(HttpStatus.OK, result) : defaultResponse(HttpStatus.NOT_FOUND, "El id: "+id+" No se encuentra en el sistema" );			
		}catch(Exception e) {
			System.out.println(e);
			return defaultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
		}
	}
	
	@GetMapping(value="searchByEmail/{datEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> searchByEmail(@PathVariable("datEmail") String email){
		try {
			if(!validator.emailValidate(email)) {
				return defaultResponse(HttpStatus.BAD_REQUEST, "El email no es valido");
			}
			
			Dato result=service.searchDato(email);
			return result!=null ? defaultResponse(HttpStatus.OK, result) : defaultResponse(HttpStatus.NOT_FOUND, "El email: "+email+" No se encuentra en el sistema" );			
		}catch(Exception e) {
			System.out.println(e);
			return defaultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
		}
	}

}