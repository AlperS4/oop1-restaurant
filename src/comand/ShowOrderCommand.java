package comand;

import basis.Order;
import basis.OrderItem;

/**
 * Команда за показване на поръчка
 */
public class ShowOrderCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
        Order o = ctx.orderService.getOrder(Integer.parseInt(a[1]));

        if (o.getItems().isEmpty()) {
            return "Order is empty";
        }
        StringBuilder sb = new StringBuilder();
        for (OrderItem i : o.getItems()) {
            sb.append(i.getItem().getName()).append(" x ").append(i.getQuantity()).append("\n");
        }
        sb.append("Total: ").append(o.getTotal());
        return sb.toString();
    }
}