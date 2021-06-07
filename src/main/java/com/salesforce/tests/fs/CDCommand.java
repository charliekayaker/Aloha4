package com.salesforce.tests.fs;

public final class CDCommand extends AbstractCommand{

	public CDCommand(String paramName, String[] paramParams, Console console) {
		super(paramName, paramParams, console);		
	}

	@Override
	public void execute() {		
		System.out.println("TESTED");
	}

	@Override
	protected void resfeshConsoleState() {
			
	}

}
