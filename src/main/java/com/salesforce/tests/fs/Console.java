package com.salesforce.tests.fs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class has marked like final for security reason.
 * 
 * On the future we are not thinking inheritance it.
 */
public final class Console {

	
	private static final String PARAMETER_TOKEN = "-";

	private static final String initialPath = System.getProperty("user.home");

	private static final String WITHOUTCOMMAND = "withoutcommand";

	private String currentPath = "";
	private static Console console = null;
	private String commandName = "";

	private Scanner scanner = null;

	private Console() {
		init();
		System.out.println("Welcome to the Charlie Console :) . . . \nWrite a command . . .");
	}
	
	private final void init() {
		currentPath = initialPath;	
		scanner = new Scanner(System.in);
		addFinalizeHook();
	}


	//Console is singleton instance
	public static Console getInstance() {

		if (console == null) {

			console = new Console();
		}
		return console;
	}
	
	

	public final void execute(String ...strings)  {		
				
		commandName = WITHOUTCOMMAND;
		commandName = strings[0];
				
		String parameter = !commandName.equals(WITHOUTCOMMAND) && commandName.contains(PARAMETER_TOKEN)
				? Utils.getParameter(commandName)
				: Constants.EMPTY;
		
		if(!parameter.equals(Constants.EMPTY)) 
			commandName = commandName.substring(0, commandName.indexOf(PARAMETER_TOKEN)-1);
		
		CommandBuilder builder = new CommandBuilder(this);
		
		builder.setName(commandName);		
		builder.setParameters(new String[] {parameter});
		
		IActionCommand command = null;
		try {
			command = builder.build();
		} catch (Exception e1) {			
			if(e1 instanceof ClassNotFoundException)
				System.out.println("Unrecognized command");
			else
				e1.printStackTrace();			
		}
		command.execute();
		
		commandName = scanner.nextLine();
		
		this.execute(new String[] {commandName});
	}



	@Override
	public void finalize() {
		scanner.close();
	}
	
	private final void addFinalizeHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Thank you for see my code . . . Regards. Charlie A Alfonso");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}


}
