package comand;

/**
 * Команда за затваряне на поръчка
 */
public class CloseOrderCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
      return ctx.orderService.closeOrder(Integer.parseInt(a[1]));

    }
}