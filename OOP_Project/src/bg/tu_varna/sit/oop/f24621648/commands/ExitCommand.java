package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Прекратява изпълнението на програмата.
 */

public class ExitCommand implements Command {
    /**
     * Прекратява изпълнението на програмата.
     *
     * @param input входна команда
     */

    @Override
    public void execute(String input) {

        System.out.println("Exiting program...");
        System.exit(0);
    }
}