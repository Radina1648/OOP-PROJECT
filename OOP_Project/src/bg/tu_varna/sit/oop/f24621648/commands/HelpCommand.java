package bg.tu_varna.sit.oop.f24621648.commands;

public class HelpCommand implements Command {

    @Override
    public void execute(String input) {

        System.out.println("Supported commands:");
        System.out.println("open <file>");
        System.out.println("close");
        System.out.println("save");
        System.out.println("saveas <file>");
        System.out.println("login");
        System.out.println("logout");
        System.out.println("books all");
        System.out.println("books info <isbn>");
        System.out.println("books find <word>");
        System.out.println("books sort <option>");
        System.out.println("books add");
        System.out.println("books remove <isbn>");
        System.out.println("user add");
        System.out.println("user remove");
        System.out.println("exit");
    }
}