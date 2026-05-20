package comand;

/**
 * Команда за показване на всички поръчки
 */
public class OrdersCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.orderService.printOrders();
    }
}