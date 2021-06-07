package com.salesforce.tests.fs;

public abstract class AbstractCommand implements IActionCommand{
	
	protected final String name;
	protected final String[] parameters;
	protected final Console console;
	
	public AbstractCommand(String paramName, String[] paramParams, Console console) {
		this.name = paramName;
		this.parameters = paramParams;
		this.console = console;
	}
	
	
	protected abstract void resfeshConsoleState();


	public String getName() {
		return name;
	}


	public String[] getParameters() {
		return parameters;
	}	
	
	

}
