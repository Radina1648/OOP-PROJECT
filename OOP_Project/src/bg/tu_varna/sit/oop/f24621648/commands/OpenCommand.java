package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Library;

public class OpenCommand implements Command {

    private Library library;
    private CommandManager manager;

    public OpenCommand(Library library, CommandManager manager) {
        this.library = library;
        this.manager = manager;
    }

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");

        if (parts.length < 2) {
            System.out.println("Usage: open <file>");
            return;
        }

        String fileName = parts[1];

        library.loadFromFile(fileName);
        manager.setCurrentFile(fileName);

        System.out.println("Successfully opened " + fileName);
    }
}