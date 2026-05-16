package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Прекратява изпълнението на програмата.
 */

public class ExitCommand implements Command {

    @Override
    public void execute(String input) {

        System.out.println("Exiting program...");
        System.exit(0);
    }
}