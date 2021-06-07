package com.salesforce.tests.fs;

import java.lang.reflect.Constructor;

public class CommandBuilder {
	
	private String name;
	private String[] parameters;
	private Console console = null;	
	private final static String COMMAND = "Command";
	
	public CommandBuilder(Console console) {
		this.console = console;
	}
	
	public CommandBuilder setName(String name) {
		this.name = name;
		return this;
	} 
	
	public CommandBuilder setParameters(String[] parameters) {
		this.parameters = parameters;
		return this;
	}
	
	public IActionCommand build() throws Exception {
		
		if(name==null || name.equals(Constants.EMPTY)) {
			throw new Exception("IncompleteArguments");
		}
		
		IActionCommand command = null;
		
		String sClass = this.getClass().getCanonicalName().replace(this.getClass().getSimpleName(), name.toUpperCase()+COMMAND);
		Class clazz = Class.forName(sClass);
		
		Class[] pTypesCtor = {String.class, String[].class, Console.class};
		
		Object[] pValuesCtor = {name, parameters, console};
		Constructor<AbstractCommand> ctor = clazz.getConstructor(pTypesCtor);
		
		Object obj = ctor.newInstance(pValuesCtor);
		
		command = (AbstractCommand) obj;
		
		return command;
	}
	
	
}
