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
	private String currentFile = null;

	public CommandManager(Library library, UserManager userManager) {
		this.library = library;
		this.userManager = userManager;
		this.scanner = scanner;
		OpenCommand openCommand = new OpenCommand(library, this);
		commands.put("open", openCommand);
		CloseCommand closeCommand= new CloseCommand(library, this);
		commands.put("close", closeCommand);
		SaveCommand saveCommand= new SaveCommand(library, currentFile); //???
		commands.put("save", saveCommand);
		SaveAsCommand saveAsCommand= new SaveAsCommand(library, this);
		commands.put("saveas", saveAsCommand);
		HelpCommand helpCommand= new HelpCommand();
		commands.put("help", helpCommand);
		BooksInfoCommand booksInfoCommand=new BooksInfoCommand(library);
		commands.put("booksinfo",booksInfoCommand);
		BooksFindCommand booksFindCommand=new BooksFindCommand(library);
		commands.put("booksfind", booksFindCommand);
		BooksAllCommand booksAllCommand=new BooksAllCommand(library);
		commands.put("booksall", booksAllCommand);
		BooksSortCommand booksSortCommand=new BooksSortCommand(library);
		commands.put("bookssort", booksSortCommand);
		BooksAddCommand booksAddCommand=new BooksAddCommand(library, userManager, scanner);
		commands.put("booksaddcommand", booksAddCommand);
		BooksRemoveCommand booksRemoveCommand=new BooksRemoveCommand(library, userManager);
		commands.put("booksremove", booksRemoveCommand);
		LogoutCommand logoutCommand=new LogoutCommand(userManager);
		commands.put("login", logoutCommand);
		LoginCommand loginCommand=new LoginCommand(userManager, scanner);
		commands.put("login", loginCommand);
		UserAddCommand userAddCommand=new UserAddCommand(userManager);
		commands.put("useradd", userAddCommand);
		UserRemoveCommand userRemoveCommand=new UserRemoveCommand(userManager);
		commands.put("userremove", userRemoveCommand);
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

	public String getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(String currentFile) {
		this.currentFile = currentFile;
	}
}