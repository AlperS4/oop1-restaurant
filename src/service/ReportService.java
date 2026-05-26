package service;

import basis.Order;
import basis.OrderItem;
import enums.OrderStatus;

import java.util.*;

/**
 * Генерира отчети за ресторанта
 */
public class ReportService {

    private OrderService orderService;

    public ReportService(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Показва най-продаваните артикули
     */
    public String topItems() {
        Map<String, Integer> count = new HashMap<>();

        for (Order order : orderService.getAllOrders()) {
            for (OrderItem item : order.getItems()) {
                String name = item.getItem().getName();
                if (!count.containsKey(name)) {
                    count.put(name, item.getQuantity());
                } else {
                    int current = count.get(name);
                    count.put(name, current + item.getQuantity());
                }
            }
        }
        if (count.isEmpty()) {
            return "No sales yet";
        }

        String bestItem = null;
        int max = 0;

        for (String name : count.keySet()) {
            int quantity = count.get(name);

            if (quantity > max) {
                max = quantity;
                bestItem = name;
            }
        }

        if (bestItem == null) {
            return "No sales yet";
        }

        return bestItem + " sold: " + max;
    }

    /**
     * Генерира отчет за общия приход
     */
    public String report() {

        double total = 0;
        for (Order order : orderService.getAllOrders()) {
            if (order.getStatus() == OrderStatus.PAID) {
                total += order.getTotal();
            }
        }
        return "Total revenue: " + total;
    }
}