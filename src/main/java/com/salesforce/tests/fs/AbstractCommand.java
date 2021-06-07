package com.salesforce.tests.fs;

import java.io.File;

public abstract class AbstractCommand implements IActionCommand{
	
	protected final String name;
	protected final String[] parameters;
	protected final Console console;
	protected File file;
	
	public AbstractCommand(String paramName, String[] paramParams, Console console) {
		this.name = paramName;
		this.parameters = paramParams;
		this.console = console;
	}
	
	
	protected abstract void refreshConsoleState();


	public String getName() {
		return name;
	}


	public String[] getParameters() {
		return parameters;
	}	
	
	

}
