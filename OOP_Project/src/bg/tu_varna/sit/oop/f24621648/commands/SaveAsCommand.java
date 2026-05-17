package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за запис в нов файл.
 */

import bg.tu_varna.sit.oop.f24621648.main.Library;

public class SaveAsCommand implements Command {

    private Library library;
    private CommandManager manager;

    public SaveAsCommand(Library library, CommandManager manager) {
        this.library = library;
        this.manager = manager;
    }

    /**
     * Записва информацията в нов файл.
     *
     * @param input входна команда
     */

    @Override
    public void execute(String input) {
        if (manager.getCurrentFile() == null) { System.out.println("No file opened."); return; }

        String[] parts = input.split(" ");

        if (parts.length < 3) {
            System.out.println("Usage: save as <file>");
            return;
        }

        String fileName = parts[2];

        library.saveToFile(fileName);
        manager.setCurrentFile(fileName);

        System.out.println("Successfully saved " + fileName);
    }
}
