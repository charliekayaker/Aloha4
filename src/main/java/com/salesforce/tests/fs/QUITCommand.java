package com.salesforce.tests.fs;

@Deprecated
public class QUITCommand extends AbstractCommand {

	public QUITCommand(String paramName, String[] paramParams, Console console) {		
		super(paramName, paramParams, console);
		System.exit(0);
		
	}

	@Override
	public void execute() {
		
	}

	@Override
	protected void refreshConsoleState() {
		
		
	}
	

}
