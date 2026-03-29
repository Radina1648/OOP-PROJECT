package bg.tu_varna.sit.oop.f24621648;

public class CommandManager {

	private Command loginCommand;
	private Command logoutCommand;
	private Command booksAllCommand;

	public CommandManager(Command loginCommand,
						  Command logoutCommand,
						  Command booksAllCommand) {

		this.loginCommand = loginCommand;
		this.logoutCommand = logoutCommand;
		this.booksAllCommand = booksAllCommand;
	}

	public void execute(String input) {

		if (input.equals("login")) {
			loginCommand.execute(input);
		}
		else if (input.equals("logout")) {
			logoutCommand.execute(input);
		}
		else if (input.equals("books all")) {
			booksAllCommand.execute(input);
		}
		else {
			System.out.println("Unknown command.");
		}
	}
}