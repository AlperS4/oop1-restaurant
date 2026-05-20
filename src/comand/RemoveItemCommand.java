package comand;

/**
 * Команда за премахване на артикул
 */
public class RemoveItemCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.menuService.removeItem(Integer.parseInt(a[1]));
    }
}