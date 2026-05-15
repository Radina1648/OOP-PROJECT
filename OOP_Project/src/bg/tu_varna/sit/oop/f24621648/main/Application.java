package bg.tu_varna.sit.oop.f24621648.main;

import bg.tu_varna.sit.oop.f24621648.commands.CommandManager;

import java.util.Scanner;

public class  Application {
    public static void main(String[] args) {

        Library library = new Library();
        UserManager userManager = new UserManager();

        CommandManager manager =
                new CommandManager(library, userManager);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("> ");

            String input = scanner.nextLine();

            manager.process(input);
        }
    }
}
