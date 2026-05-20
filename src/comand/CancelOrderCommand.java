package comand;

/**
 * Команда за анулиране на поръчка
 */
public class CancelOrderCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.orderService.cancelOrder(Integer.parseInt(a[1]));
    }
}