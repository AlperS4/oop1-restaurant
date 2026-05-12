package comand;

public class CancelOrderCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.orderService.cancelOrder(Integer.parseInt(a[1]));
    }
}