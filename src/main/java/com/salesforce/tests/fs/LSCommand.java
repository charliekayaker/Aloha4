package com.salesforce.tests.fs;

import java.io.File;

public class LSCommand extends AbstractCommand {

	public LSCommand(String paramName, String[] paramParams, Console console) {
		super(paramName, paramParams, console);
		
	}

	@Override
	public void execute() {
		file = new File(console.getCurrentPath());

		File[] listFiles = file.listFiles();
		for (int n = 0, i = listFiles.length; n < i; n++) {
			System.out.println(listFiles[n].getName());
		}
		
		System.out.println(listFiles.length + "\tDirectorios listados . . .");
	}

	@Override
	protected void refreshConsoleState() {
		
	}

}
