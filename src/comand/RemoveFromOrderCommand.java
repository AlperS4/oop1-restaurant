package comand;

public class RemoveFromOrderCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.orderService.getOrder(Integer.parseInt(a[1])).removeItem(Integer.parseInt(a[2]));
    }
}