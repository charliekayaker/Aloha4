package com.salesforce.tests.fs;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class has marked like final for security reason.
 * 
 * On the future we are not thinking inheritance it.
 */
public final class Console {

	private static final String PARAMETER_TOKEN = "-";

	private static final String initialPath = "root";// System.getProperty("user.home");

	private String currentPath = "";
	private static Console console = null;
	private String commandName = "";

	private Scanner scanner = null;

	private Console() {
		init();

		// System.out.println("Welcome to the Console . . . ");
	}

	private final void init() {
		currentPath = initialPath;
		scanner = new Scanner(System.in);
		addFinalizeHook();
	}

	// Console is singleton instance
	public static Console getInstance() {

		if (console == null) {

			console = new Console();
		}
		return console;
	}

	private IActionCommand command = null;
	private String parameter = "";

	public final void execute(String[] args) {

		commandName = getLine();
		if (commandName.toLowerCase().equals(Constants.QUIT)) {				
			System.exit(0);
			return;
		}
				
		try {

			 parameter = commandName.contains(PARAMETER_TOKEN) ? Utils.getParameter(commandName)
					: Constants.EMPTY;

			if (!parameter.equals(Constants.EMPTY))
				commandName = commandName.substring(0, commandName.indexOf(PARAMETER_TOKEN) - 1);

			CommandBuilder builder = new CommandBuilder(this);
			
			builder.setName(commandName);
			builder.setParameters(new String[] { parameter });

			command = builder.build();
			command.execute();

			this.execute(new String[0]);

		} catch (Exception e1) {
			if (e1 instanceof ClassNotFoundException)
				System.out.println("Unrecognized command");
			else if(e1.getMessage().equals("IncompleteArguments")) {
			    e1.printStackTrace();
			}
			else
				e1.printStackTrace();
		}

	}

	private String getLine() {
		String result = "";

		try {
			result = scanner.nextLine();
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void finalize() {
		scanner.close();
	}

	private final void addFinalizeHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (scanner != null)
					scanner.close();
				  System.out.println("Finalizando\n\n\n");
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
