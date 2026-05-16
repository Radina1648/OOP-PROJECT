package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за вход в системата.
 */

import bg.tu_varna.sit.oop.f24621648.main.PasswordReader;
import bg.tu_varna.sit.oop.f24621648.main.UserManager;

import javax.swing.*;
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
			System.out.println("Already logged in.");
			return;
		}

		System.out.print("Username: ");
		String username = scanner.nextLine();

		System.out.print("Password: ");
		String password = PasswordReader.readPassword();

		scanner.nextLine();

		System.out.println(userManager.login(username, password));
	}
}