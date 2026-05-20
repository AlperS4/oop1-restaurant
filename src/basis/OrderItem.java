package basis;

/**
 * Представя артикул в поръчка
 */
public class OrderItem {

    private MenuItem item;
    private int quantity;

    /**
     * Създава нов OrderItem
     *
     * @param item артикул
     * @param quantity количество
     */
    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return item.getPrice() * quantity;
    }

}