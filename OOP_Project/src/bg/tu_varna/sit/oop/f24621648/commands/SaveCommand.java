package bg.tu_varna.sit.oop.f24621648.commands;

import bg.tu_varna.sit.oop.f24621648.main.Library;

public class SaveCommand implements Command {

    private Library library;
    private String currentFile;

    public SaveCommand(Library library, String currentFile) {
        this.library = library;
        this.currentFile = currentFile;
    }

    @Override
    public void execute(String input) {

        if (currentFile == null) {
            System.out.println("No file opened.");
            return;
        }

        library.saveToFile(currentFile);

        System.out.println("Successfully saved.");
    }
}