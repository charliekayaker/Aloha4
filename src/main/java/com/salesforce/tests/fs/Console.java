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
	private static List<String> commands;

	private Scanner scanner = null;

	private Console() {
		init();

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

		System.out.println("Welcome to the Charlie Console :) . . . \nWrite a command . . .");
	}

	public static Console getInstance() {

		if (console == null) {

			console = new Console();
		}
		return console;
	}

	public final void execute() {
		
		String command = WITHOUTCOMMAND;
		command = scanner.nextLine();
				
		
		do {

			if (currentPath.equals(Constants.EMPTY)) {
				currentPath = initialPath;
			}
			

			String parameter = !command.equals(WITHOUTCOMMAND) && command.contains(PARAMETER_TOKEN)
					? Utils.getParameter(command)
					: Constants.EMPTY;

			if (!command.equals(Constants.QUIT))
				System.out.print(currentPath + "\t");
			String input = scanner.nextLine();

			if (input.contains(PARAMETER_TOKEN)) {
				parameter = Utils.getParameter(input);
				input = input.substring(0, input.indexOf(PARAMETER_TOKEN));
			}

			String[] arguments = { input, parameter };

			switch (command) {
			case Constants.QUIT: {
				quit();
				break;
			}
			case Constants.PWD: {
				pwd();
				break;
			}

			case Constants.LS: {
				ls();
				break;
			}

			case Constants.MKDIR: {
				mkdir(/*args[1]*/"");
				break;
			}

			case Constants.CD: {

				try {
					cd(/*args[0]*/"");
				} catch (IOException e) {

					e.printStackTrace();
				}
				break;
			}

			case Constants.TOUCH: {
				console.touch();
				break;
			}

			case WITHOUTCOMMAND: {
				System.out.println(
						"Debe ejecutar el programa con al menos un comando\nVuelva a intentarlo por favor . . .");
				break;
			}

			default:
				System.out.println("Unrecognized command . . . ");
			}

		} while (!(commands.equals(Constants.QUIT)));

		quit();
	}

	private final void init() {
		

		scanner = new Scanner(System.in);
	}

	private final void quit() {

		System.exit(0);
	}

	private final void pwd() {
		File file = new File("");
		String directoryName = file.getAbsoluteFile().toString();
		System.out.println(directoryName);
	}

	private final void ls() {
		File file = new File("C:\\Users\\charlie\\Desktop\\SourceForge\\950eddd4-0923-4f95-91f6-e47ffc0a5146");

		File[] listFiles = file.listFiles();
		for (int n = 0, i = listFiles.length; n < i; n++) {
			System.out.println(listFiles[n].getName());
		}
	}

	private final void ls(String param) {

	}

	private final void mkdir(String directoryName) {
		directoryName = directoryName.replace("-", "");
		File directory = new File(directoryName);
		directory.mkdir();

	}

	private final void cd(String directory) throws IOException {

		File file = new File(this.currentPath + directory);
		System.out.println(file.getAbsolutePath());
	}

	private final void touch() {

	}

	@Override
	public void finalize() {
		scanner.close();
	}

}
