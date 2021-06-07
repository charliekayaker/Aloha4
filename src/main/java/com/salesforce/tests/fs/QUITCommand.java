package com.salesforce.tests.fs;

public class QUITCommand extends AbstractCommand {

	public QUITCommand(String paramName, String[] paramParams, Console console) {
		super(paramName, paramParams, console);
		
	}

	@Override
	public void execute() {
		System.exit(0);
	}

	@Override
	protected void refreshConsoleState() {
		
		
	}
	

}
