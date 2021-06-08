package com.salesforce.tests.fs;

import java.io.File;

public final class CDCommand extends AbstractCommand{
		
	public CDCommand(String paramName, String[] paramParams, Console console) {
		super(paramName, paramParams, console);		
	}

	@Override
	public void execute() {		
		
		this.file = new File(console.getCurrentPath() + Constants.DIRSEPARATOR +this.parameters[0]);
		
		System.out.println(file.getAbsolutePath()+"\t");
		
		refreshConsoleState();
	}

	@Override
	protected void refreshConsoleState() {
		
	    console.setCurrentPath(file.getAbsolutePath());
	}

}
