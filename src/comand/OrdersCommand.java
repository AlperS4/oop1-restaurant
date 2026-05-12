package comand;

public class OrdersCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.orderService.printOrders();
    }
}