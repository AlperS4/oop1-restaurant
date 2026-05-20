package comand;

/**
 * Команда за показване на менюто
 */
public class MenuCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.menuService.printMenu();
    }
}