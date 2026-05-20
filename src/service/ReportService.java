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

        while (!count.isEmpty()) {
            String bestItem = null;
            int max = 0;

            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    bestItem = entry.getKey();
                }
            }
            return bestItem +  " sold: " + max;
        }
        return "All sold";
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