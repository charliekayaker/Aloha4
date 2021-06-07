package com.salesforce.tests.fs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The entry point for the Test program
 * 
 * @author carlos alfonso
 * 
 * Project <b> hacker rank - ALOHA 4 <b>
 */
public class Main {

	private static Console console = null;
	

	public static void main(String[] args) {
	
		console = Console.getInstance();
				
		console.execute(args);
		
  }	
	



}
