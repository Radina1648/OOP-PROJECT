package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за затваряне на файл.
 */

import bg.tu_varna.sit.oop.f24621648.main.Library;

public class CloseCommand implements Command {

    private Library library;
    private CommandManager manager;

    public CloseCommand(Library library, CommandManager manager) {
        this.library = library;
        this.manager = manager;
    }

    @Override
    public void execute(String input) {

        if (manager.getCurrentFile() == null) {
            System.out.println("No file opened.");
            return;
        }

        library.clear();
        manager.setCurrentFile(null);

        System.out.println("Successfully closed file.");
    }
}
