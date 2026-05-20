package comand;

import basis.MenuItem;
import enums.Category;

/**
 * Команда за добавяне на артикул
 */
public class AddItemCommand implements Command {

    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.menuService.addItem(new MenuItem(
                Integer.parseInt(a[1]), a[2],
                Category.valueOf(a[3].toUpperCase()),
                Double.parseDouble(a[4]),
                Integer.parseInt(a[5])));
    }
}