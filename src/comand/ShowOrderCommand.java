package comand;

import basis.Order;

public class ShowOrderCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {

        Order o = ctx.orderService.getOrder(Integer.parseInt(a[1]));
        o.getItems().forEach(i -> System.out.println(i.getItem().getName() + " x " + i.getQuantity()));
        System.out.println("Total: " + o.getTotal());
    }
}