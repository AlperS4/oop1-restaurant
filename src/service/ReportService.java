package service;

import basis.Order;
import basis.OrderItem;
import enums.OrderStatus;

import java.util.*;

public class ReportService {

    private OrderService orderService;

    public ReportService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void topItems() {

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
            System.out.println("No sales yet");
            return;
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

            System.out.println(bestItem + " sold: " + max);

            count.remove(bestItem);
        }
    }

    public void report() {

        double total = 0;

        for (Order order : orderService.getAllOrders()) {

            if (order.getStatus() == OrderStatus.PAID) {
                total += order.getTotal();
            }
        }

        System.out.println("Total revenue: " + total);
    }
}