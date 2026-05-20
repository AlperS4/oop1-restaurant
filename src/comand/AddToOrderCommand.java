package comand;

import basis.MenuItem;
import basis.Order;

/**
 * Команда за добавяне към поръчка
 */
public class AddToOrderCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
        Order o = ctx.orderService.getOrder(Integer.parseInt(a[1]));
        MenuItem item = ctx.menuService.getItem(Integer.parseInt(a[2]));
        o.addItem(item, Integer.parseInt(a[3]));

        return "Successfully added ";
    }
}