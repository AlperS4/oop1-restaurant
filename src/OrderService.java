import java.util.*;

public class OrderService {

    private Map<Integer, Order> orders = new HashMap<>();
    private int nextId = 1;

    private TableService tableService;

    public OrderService(TableService tableService) {
        this.tableService = tableService;
    }

    public Order openOrder(int tableNumber) {

        for (Order o : orders.values()) {
            if (o.getTableNumber() == tableNumber &&
                o.getStatus() == OrderStatus.OPEN) {

                System.out.println("Table already has active order");
                return null;
            }
        }

        Table table = tableService.getTable(tableNumber);

        if (table == null) {
            System.out.println("Table not found");
            return null;
        }

        table.setStatus(TableStatus.OCCUPIED);

        Order order = new Order(nextId++, tableNumber);
        orders.put(order.getId(), order);

        System.out.println("Order " + order.getId() + " opened");

        return order;
    }

    public Order getOrder(int id) {
        return orders.get(id);
    }

    public void closeOrder(int id) {

        Order order = orders.get(id);

        if (order == null) {
            System.out.println("Order not found");
            return;
        }

        order.close();

        Table table = tableService.getTable(order.getTableNumber());
        table.setStatus(TableStatus.FREE);

        System.out.println("Order closed");
    }

    public void cancelOrder(int id) {

        Order order = orders.get(id);

        if (order == null) {
            System.out.println("Order not found");
            return;
        }

        order.cancel();

        Table table = tableService.getTable(order.getTableNumber());
        table.setStatus(TableStatus.FREE);

        System.out.println("Order canceled");
    }

    public void printOrders() {

        if (orders.isEmpty()) {
            System.out.println("No orders");
            return;
        }

        for (Order o : orders.values()) {
            System.out.println(
                    "Order: " + o.getId() +
                    "Table:" + o.getTableNumber() +
                    "Status:" + o.getStatus()
            );
        }
    }
}