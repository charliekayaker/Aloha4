package com.salesforce.tests.fs;

import org.junit.Test;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest {
	
	@Test
	public void testGetParameter() {
		
		String result = Utils.getParameter("HOLA -ALGO");
		
		System.out.println(result);
		
		CommandBuilder builder = new CommandBuilder(Console.getInstance());
		builder.setName("cd");
		builder.setParameters(new String[] {""});
		try {
			IActionCommand cdCommand =  builder.build();
			cdCommand.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
