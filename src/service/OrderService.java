package service;
import basis.Order;
import basis.Table;
import enums.OrderStatus;
import enums.TableStatus;
import exeption.OrderNotFoundException;
import java.util.*;

/**
 * Управлява поръчките
 */
public class OrderService {

    private Map<Integer, Order> orders = new HashMap<>();
    private int nextId = 1;
    private TableService tableService;


    public OrderService(TableService tableService) {
        this.tableService = tableService;
    }

    /**
     * Отваря нова поръчка
     *
     * @param tableNumber номер на масата
     * @return нова поръчка
     */
    public String openOrder(int tableNumber) {
        for (Order o : orders.values()) {
            if (o.getTableNumber() == tableNumber
                    && o.getStatus() == OrderStatus.OPEN) {
                return "Table already has active order";
            }
        }

        Table table = tableService.getTable(tableNumber);
        if (table == null) {
            return "Table not found";
        }

        table.setStatus(TableStatus.OCCUPIED);

        Order order = new Order(nextId++, tableNumber);
        orders.put(order.getId(), order);

        return "Order " + order.getId() + " opened";
    }

    /**
     * Връща поръчка по ID
     *
     * @param id ID на поръчката
     * @return намерената поръчка
     */
    public Order getOrder(int id) {

        Order order = orders.get(id);
        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }
        return order;
    }

    /**
     * Затваря поръчка
     *
     * @param id ID на поръчката
     */
    public String closeOrder(int id) {

        Order order = orders.get(id);
        if (order == null) {
            return"Order not found";
        }

        if (order.getStatus() != OrderStatus.OPEN) {
            return "Order is not active";
        }
        order.close();

        Table table = tableService.getTable(order.getTableNumber());
        if (table != null) {
            table.setStatus(TableStatus.FREE);
        }
        return "Order closed";
    }

    /**
     * Анулира поръчка
     *
     * @param id ID на поръчката
     */
    public String cancelOrder(int id) {

        Order order = orders.get(id);
        if (order == null) {
            return "Order not found";
        }

        if (order.getStatus() != OrderStatus.OPEN) {
            return "Order is not active";
        }
        order.cancel();

        Table table = tableService.getTable(order.getTableNumber());
        if (table != null) {
            table.setStatus(TableStatus.FREE);
        }
        return "Order canceled";
    }

    /**
     * Принтира всички поръчки
     */
    public String printOrders() {
        if (orders.isEmpty()) {
            return "No orders";
        }

        StringBuilder sb = new StringBuilder();
        for (Order o : orders.values()) {
            sb.append("Order ID: ").append(o.getId()).append(" Table: ").append(o.getTableNumber())
                    .append(" Status: ").append(o.getStatus()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Връща всички поръчки
     *
     * @return колекция с всички поръчки
     */
    public Collection<Order> getAllOrders() {
        return orders.values();
    }
}