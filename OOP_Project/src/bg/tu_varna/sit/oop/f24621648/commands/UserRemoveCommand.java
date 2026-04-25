package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.UserManager;

public class UserRemoveCommand implements Command {

    private UserManager userManager;

    public UserRemoveCommand(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");

        if (parts.length < 3) {
            System.out.println("Usage: user remove <username>");
            return;
        }

        String username = parts[2];

        System.out.println(userManager.removeUser(username));
    }
}