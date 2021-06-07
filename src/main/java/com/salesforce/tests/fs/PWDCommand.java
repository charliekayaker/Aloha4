package com.salesforce.tests.fs;

import java.io.File;

public class PWDCommand extends AbstractCommand {

	public PWDCommand(String paramName, String[] paramParams, Console console) {
		super(paramName, paramParams, console);		
		this.file = new File(console.getCurrentPath());
	}

	@Override
	public void execute() {
		
		String directoryName = file.getAbsoluteFile().toString();
		System.out.println(directoryName);
		
	}

	@Override
	protected void refreshConsoleState() {
		//nothing for to do . . .		
	}

}
