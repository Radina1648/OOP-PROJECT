package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Показва всички налични команди.
 */

public class HelpCommand implements Command {
    /**
     * Извежда всички поддържани команди.
     *
     * @param input входна команда
     */

    @Override
    public void execute(String input) {

        StringBuilder help = new StringBuilder();

        help.append("Supported commands:\n");
        help.append("open <file>\n");
        help.append("close\n");
        help.append("save\n");
        help.append("saveas <file>\n");
        help.append("login\n");
        help.append("logout\n");
        help.append("books all\n");
        help.append("books info <isbn>\n");
        help.append("books find <option> <value>\n");
        help.append("books sort <option>\n");
        help.append("books add\n");
        help.append("books remove <isbn>\n");
        help.append("user add <username> <password>\n");
        help.append("user remove <username>\n");
        help.append("exit\n");

        System.out.println(help);
    }
}