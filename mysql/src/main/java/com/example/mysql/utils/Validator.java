package com.example.mysql.utils;

public class Validator {

	public static boolean emailValidate(String email) {
		return email.matches("^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+/[\\w-]+$");
	}
	
	public static boolean textValidate(String text) {
		return text.matches("^([A-Za-zÑñÁáÉéÍíÓóÚú]{3,}+$");
	}
}
