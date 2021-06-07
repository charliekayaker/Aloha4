package com.salesforce.tests.fs;

import java.io.File;

public class MkdirCommand extends AbstractCommand {

	public MkdirCommand(String paramName, String[] paramParams, Console console) {
		super(paramName, paramParams, console);
		
	}

	@Override
	public void execute() {
		
		file = new File(parameters[0]);
		
		if(file.mkdir()) {
			System.out.println("Directory correctly created . . . ");
		}else {
			System.out.println("An error ocurred . . . ");
		}
	}

	@Override
	protected void refreshConsoleState() {
		//Nothing for to do.		
	}

}
