package com.salesforce.tests.fs;

import java.io.File;

import org.junit.Test;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest {
	
	@Test
	public void testGetParameter() {
		
	/*	String result = Utils.getParameter("HOLA -ALGO");
		
		System.out.println(result);
		
		CommandBuilder builder = new CommandBuilder(Console.getInstance());
		builder.setName("quit");
		builder.setParameters(new String[] {""});
		try {
			IActionCommand quitCommand =  builder.build();
			if(quitCommand instanceof QUITCommand) {
				System.out.println("INSTANCE OF WORK");
			}
			quitCommand.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Main.main(new String[] {"cd -root"});
		
		File file = new File("root");
		System.out.println(file.getAbsolutePath());
	
	}

}
