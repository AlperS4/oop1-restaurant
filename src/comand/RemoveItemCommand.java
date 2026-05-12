package comand;

public class RemoveItemCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.menuService.removeItem(Integer.parseInt(a[1]));
    }
}