package service;

import basis.MenuItem;
import exeption.ItemNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class MenuService {

    private Map<Integer, MenuItem> menu;

    public MenuService() {
        menu = new HashMap<>();
    }

    public void addItem(MenuItem item) {

        if (menu.containsKey(item.getId())) {
            System.out.println("Item already exists");
            return;
        }
        menu.put(item.getId(), item);
        System.out.println("Item added");
    }

    public void removeItem(int id) {

        if (!menu.containsKey(id)) {
            System.out.println("Item not found");
            return;
        }
        menu.remove(id);
        System.out.println("Item removed");
    }

    public MenuItem getItem(int id) {

        MenuItem item = menu.get(id);
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }
        return item;
    }

    public void printMenu() {

        if (menu.isEmpty()) {
            System.out.println("Menu is empty");
            return;
        }

        for (MenuItem item : menu.values()) {
            System.out.println(item);
        }
    }
}