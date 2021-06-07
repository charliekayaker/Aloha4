package com.salesforce.tests.fs;

public class Utils {

	
	/**
	 * Podríamos utilizar StringTokenizer si hubiese más de un parámetro
	 * y usar como token separador "-" sin embargo vamos a hacerlo sencillo
	 * a fín de lo que se pide.
	 * 
	 * @author charlie_alfon
	 * */
	public static String getParameter(String s) {
		String result = s.substring(s.indexOf("-")+1,s.length());
		return result;
	}	

}
