package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Команда за запис на файл.
 */

import bg.tu_varna.sit.oop.f24621648.main.Library;

public class SaveCommand implements Command {

    private Library library;
    private CommandManager manager;

    public SaveCommand(Library library, CommandManager manager) {
        this.library = library;
        this.manager = manager;
    }

    /**
     * Записва информацията във файла.
     *
     * @param input входна команда
     */

    @Override
    public void execute(String input) {

        if (manager.getCurrentFile() == null) {
            System.out.println("No file opened.");
            return;
        }

        library.saveToFile(manager.getCurrentFile());

        System.out.println("Successfully saved.");
    }
}