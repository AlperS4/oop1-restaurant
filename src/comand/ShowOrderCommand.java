package comand;

import basis.Order;

/**
 * Команда за показване на поръчка
 */
public class ShowOrderCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
        Order o = ctx.orderService.getOrder(Integer.parseInt(a[1]));

        StringBuilder sb = new StringBuilder();
        o.getItems().forEach(i -> sb.append(i.getItem().getName() + " x " + i.getQuantity()));
        sb.append(" Total: ").append(o.getTotal());
        return sb.toString();
    }
}