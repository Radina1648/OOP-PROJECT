package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Library;
import bg.tu_varna.sit.oop.f24621648.main.UserManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {
	private Map<String, Command> commands = new HashMap<>();
	private Library library;
	private UserManager userManager;
	private Scanner scanner;

	public CommandManager(Library library, UserManager userManager) {
		this.library = library;
		this.userManager = userManager;
		this.scanner = scanner;
		BooksInfoCommand booksInfoCommand=new BooksInfoCommand(library);
		commands.put("booksinfo",booksInfoCommand);
		BooksFindCommand booksFindCommand=new BooksFindCommand(library);
		commands.put("booksfind", booksFindCommand);
		BooksAllCommand booksAllCommand=new BooksAllCommand(library);
		commands.put("booksall", booksAllCommand);
		LogoutCommand logoutCommand=new LogoutCommand(userManager);
		commands.put("login", logoutCommand);
		LoginCommand loginCommand=new LoginCommand(userManager, scanner);
		commands.put("login", loginCommand);
	}
	public void process(String input)
	{
		String[] parts = input.split(" ");
		String commandName=parts[0];
		Command command = commands.get(commandName);

		if (command != null) {
			command.execute(input);
		} else {
			System.out.println("Unknown command!");
		}
	}
}