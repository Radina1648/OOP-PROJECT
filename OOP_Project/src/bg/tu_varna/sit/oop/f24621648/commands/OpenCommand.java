package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за отваряне на файл.
 */

import bg.tu_varna.sit.oop.f24621648.main.Library;

import java.io.File;
import java.io.IOException;

public class OpenCommand implements Command {

    private Library library;
    private CommandManager manager;

    public OpenCommand(Library library, CommandManager manager) {
        this.library = library;
        this.manager = manager;
    }

    /**
     * Отваря файл.
     *
     * @param input входна команда
     */

    @Override
    public void execute(String input) {

        String[] parts = input.split(" ");

        if (parts.length < 2) {
            System.out.println("Usage: open <file>");
            return;
        }

        String fileName = parts[1];

        try {

            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            library.loadFromFile(fileName);

            manager.setCurrentFile(fileName);

            System.out.println("Successfully opened " + fileName);

        } catch (IOException e) {

            System.out.println("Error opening file.");
        }
    }
}