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
	}

}
