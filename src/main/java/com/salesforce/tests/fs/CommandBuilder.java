package com.salesforce.tests.fs;

public class CommandBuilder {
	
	private String name;
	private String[] parameter;
		
	
	public CommandBuilder() {
		
	}
	
	public CommandBuilder setName(String name) {
		this.name = name;
		return this;
	} 
	
	public CommandBuilder setParameters(String[] parameters) {
		this.parameter = parameters;
		return this;
	}
	
	
}
