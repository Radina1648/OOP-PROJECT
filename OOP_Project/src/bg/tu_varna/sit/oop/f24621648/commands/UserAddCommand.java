package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.UserManager;

public class UserAddCommand implements Command {

    private UserManager userManager;

    public UserAddCommand(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");

        if (parts.length < 4) {
            System.out.println("Usage: user add <username> <password>");
            return;
        }

        String username = parts[2];
        String password = parts[3];

        System.out.println(userManager.addUser(username, password));
    }
}