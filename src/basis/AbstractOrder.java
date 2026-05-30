package basis;

import enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактен клас за поръчки
 */
public abstract class AbstractOrder {

    private int id;
    private int tableNumber;
    private List<OrderItem> items;
    private OrderStatus status;

    public AbstractOrder(int id, int tableNumber) {

        this.id = id;
        this.tableNumber = tableNumber;
        items = new ArrayList<>();
        status = OrderStatus.OPEN;
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

    /**
     * Затваря поръчката
     */
    public void close() {
        status = OrderStatus.PAID;
    }

    /**
     * Анулира поръчката
     */
    public void cancel() {
        status = OrderStatus.CANCELED;
    }

    /**
     * Изчислява общата сума
     *
     * @return обща сума
     */
    public abstract double getTotal();
}