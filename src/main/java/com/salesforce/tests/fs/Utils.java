package com.salesforce.tests.fs;

public class Utils {

	
	/**
	 * Podr�amos utilizar StringTokenizer si hubiese m�s de un par�metro
	 * y usar como token separador "-" sin embargo vamos a hacerlo sencillo
	 * a f�n de lo que se pide.
	 * 
	 * @author charlie_alfon
	 * */
	public static String getParameter(String s) {
		String result = s.substring(s.indexOf("-")+1,s.length());
		return result;
	}	

}
