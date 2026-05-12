package comand;

public class MenuCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.menuService.printMenu();
    }
}