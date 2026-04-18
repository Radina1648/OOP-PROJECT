package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.UserManager;

public class LogoutCommand implements Command {

	private UserManager userManager;

	public LogoutCommand(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public void execute(String input) {
		System.out.println(userManager.logout());
	}
}
