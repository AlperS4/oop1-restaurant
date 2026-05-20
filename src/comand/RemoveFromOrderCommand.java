package comand;

/**
 * Команда за премахване от поръчка
 */
public class RemoveFromOrderCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.orderService.getOrder(Integer.parseInt(a[1])).removeItem(Integer.parseInt(a[2]));
    }
}