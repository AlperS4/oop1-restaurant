package basis;

/**
 * Представя поръчка
 */
public class Order extends AbstractOrder {

    public Order(int id, int tableNumber) {
        super(id, tableNumber);
    }

    public String toFileString() {
        return getId() + ", " + getTableNumber() + ", " + getStatus();
    }

    /**
     * Премахва артикул от поръчката
     *
     * @param itemId ID на артикула
     * @return резултат
     */
    public String removeItem(int itemId) {
        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getItem().getId() == itemId) {
                getItems().remove(i);
                return "Item removed";
            }
        }
        return "Item not found";
    }

    /**
     * Добавя артикул към поръчката
     *
     * @param item артикул
     * @param quantity количество
     * @return резултат
     */
    public String addItem(MenuItem item, int quantity) {
        if (item == null) {
            return "Item not found";
        }
        getItems().add(new OrderItem(item, quantity));

        return "Item added";
    }

    /**
     * Изчислява общата сума
     *
     * @return обща сума
     */
    @Override
    public double getTotal() {
        double total = 0;

        for (OrderItem item : getItems()) {
            total += item.getTotal();
        }
        return total;
    }
}