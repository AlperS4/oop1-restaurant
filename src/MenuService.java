import java.util.HashMap;
import java.util.Map;

public class MenuService {

    private Map<Integer, MenuItem> menu;

    public MenuService() {
        menu = new HashMap<>();
    }

    public void addItem(MenuItem item) {
        menu.put(item.getId(), item);
    }

    public void removeItem(int id) {

        if (!menu.containsKey(id)) {
            System.out.println("Item not found");
            return;
        }

        menu.remove(id);
    }

    public MenuItem getItem(int id) {
        return menu.get(id);
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