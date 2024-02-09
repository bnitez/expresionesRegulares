package com.example.mysql.utils;

import org.springframework.stereotype.Component;

import com.example.mysql.model.Dato;


@Component
public class Validator {
	
	public String validateData(Dato dato, Boolean up){
		try {
			
			if(up && !idValidate(dato.getDatId())) {
				return("Id no valido");
			}
			
			if (!emailValidate(dato.getDatEmail())) {
				return ("Email no válido");
			}
			
			if (!textValidate(dato.getDatNames())) {
				return ("Nombre no válido");
			}
			
			if(!textValidate(dato.getDat_lastNames())) {
				return ("Apellidos no validos");
			}
			
			if(!documentoValidate(dato.getDatDocument())) {
				return ("Número de documento no valido");
			}
			
			if(!passwordValidate(dato.getDatPassword())) {
				return ("La contraseña debe tener minimo 8 caracteres y maximo 25"
						+ ", una letra mayúscula"
						+ ", una letra minuscula"
						+ ", un dígito"
						+ " y no debe tener espacios");
			}
			
			return null;
		}catch(Exception e) {
			return ("Parametros incompletos");
		}
	}

	public static boolean emailValidate(String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	private static boolean textValidate(String text) {
		return text.matches("^([A-Za-záéíóúÁÉÍÓÚA][\\s]{0,1}){3,150}$");
	}
	
	private static boolean documentoValidate(String documento) {
		return documento.matches("^([0-9]{5,15})$");
	}
	
	private static boolean passwordValidate(String password) {
		return password.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,25}$");
	}
	
	public static boolean idValidate(int id) {
		return Integer.toString(id).matches("^[1-9]\\d{0,10}$");
	}
}
