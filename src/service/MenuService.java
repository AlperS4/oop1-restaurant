package service;

import basis.MenuItem;
import exeption.ItemNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * Управлява менюто на ресторанта
 */
public class MenuService {

    private Map<Integer, MenuItem> menu;

    public MenuService() {
        menu = new HashMap<>();
    }

    /**
     * Добавя артикул в менюто
     *
     * @param item артикул
     */
    public String addItem(MenuItem item) {

        if (menu.containsKey(item.getId())) {
            return "Item already exists";
        }
        menu.put(item.getId(), item);

        return "Item added";
    }

    /**
     * Премахва артикул от менюто
     *
     * @param id ID на артикула
     */
    public String removeItem(int id) {

        if (!menu.containsKey(id)) {
            return "Item not found";
        }
        menu.remove(id);

        return "Item removed";
    }

    /**
     * Връща артикул по ID
     *
     * @param id ID на артикула
     * @return намерения артикул
     */
    public MenuItem getItem(int id) {

        MenuItem item = menu.get(id);
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }
        return item;
    }

    /**
     * Принтира всички артикули от менюто
     */
    public String printMenu() {
        if (menu.isEmpty()) {
            return "Menu is empty";
        }

        StringBuilder sb = new StringBuilder();
        for (MenuItem item : menu.values()) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}