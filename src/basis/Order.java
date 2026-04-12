package basis;

import enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private int tableNumber;
    private List<OrderItem> items;
    private OrderStatus status;

    public Order(int id, int tableNumber) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.items = new ArrayList<>();
        this.status = OrderStatus.OPEN;

    }

    public int getId() {
        return id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(MenuItem item, int quantity) {

        if (item == null) {
            System.out.println("Item not found");
            return;
        }

        items.add(new OrderItem(item, quantity));
    }

    public void close() {
        status = OrderStatus.PAID;
    }

    public void cancel() {
        status = OrderStatus.CANCELED;
    }

    public double getTotal() {

        double total = 0;
        for (OrderItem item : items) {

            total += item.getTotal();

        }
        return total;
    }
}