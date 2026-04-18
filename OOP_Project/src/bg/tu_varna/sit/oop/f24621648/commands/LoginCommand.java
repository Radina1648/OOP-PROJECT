package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.UserManager;

import java.util.Scanner;

public class LoginCommand implements Command {

	private UserManager userManager;
	private Scanner scanner;

	public LoginCommand(UserManager userManager, Scanner scanner) {
		this.userManager = userManager;
		this.scanner = scanner;
	}

	@Override
	public void execute(String input) {

		if (userManager.getLoggedUser() != null) {
			System.out.println("You are already logged in.");
			return;
		}

		System.out.print("Username: ");
		String username = scanner.nextLine();

		System.out.print("Password: ");
		String password = scanner.nextLine();

		System.out.println("*".repeat(password.length()));

		System.out.println(userManager.login(username, password));
	}
}