package bg.tu_varna.sit.oop.f24621648.commands;

public class HelpCommand implements Command {

    @Override
    public void execute(String input) {
        System.out.println("Supported commands:");
        System.out.println("open <file>");
        System.out.println("close");
        System.out.println("saveas <file>");
        System.out.println("booksadd");
        System.out.println("booksremove");
        System.out.println("booksall");
        System.out.println("exit");
    }
}