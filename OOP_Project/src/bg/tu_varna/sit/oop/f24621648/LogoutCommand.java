package bg.tu_varna.sit.oop.f24621648;

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
