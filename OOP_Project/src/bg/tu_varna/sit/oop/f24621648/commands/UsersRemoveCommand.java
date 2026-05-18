package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за премахване на потребител.
 */

import bg.tu_varna.sit.oop.f24621648.main.UserManager;

public class UsersRemoveCommand implements Command {

    private UserManager userManager;

    public UsersRemoveCommand(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * Премахва потребител.
     *
     * @param input входна команда
     */

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");

        if (parts.length < 3) {
            System.out.println("Usage: users remove <username>");
            return;
        }

        String username = parts[2];

        System.out.println(userManager.removeUser(username));
    }
}