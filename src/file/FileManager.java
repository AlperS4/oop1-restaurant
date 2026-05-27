package file;

import basis.MenuItem;
import basis.Order;
import basis.Table;
import enums.Category;
import enums.OrderStatus;
import service.MenuService;
import service.OrderService;
import service.TableService;

import java.io.*;

/**
 * Управлява работа с файлове
 */
public class FileManager {

    private FileData fileData;
    private MenuService menuService;
    private TableService tableService;
    private OrderService orderService;

    public FileManager(FileData fd, MenuService menuService, TableService tableService, OrderService orderService) {
        this.fileData = fd;
        this.menuService = menuService;
        this.tableService = tableService;
        this.orderService = orderService;
    }

    /**
     * Отваря файл
     * Ако файлът не съществува се създава нов
     *
     * @param path път към файла
     */
    public String open(String path) {

        try {

            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String section = "";
            String line;

            while ((line = br.readLine()) != null) {

                if (line.equals("MENU") || line.equals("TABLES") || line.equals("ORDERS")) {
                    section = line;
                    continue;
                }
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (section.equals("MENU")) {

                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    Category category = Category.valueOf(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    int stock = Integer.parseInt(parts[4]);

                    menuService.addItem(new MenuItem(id, name, category, price, stock));
                }

                else if (section.equals("TABLES")) {

                    int number = Integer.parseInt(parts[0]);
                    int seats = Integer.parseInt(parts[1]);

                    tableService.addTable(number, seats);
                }

                else if (section.equals("ORDERS")) {

                    int id = Integer.parseInt(parts[0]);
                    int tableNumber = Integer.parseInt(parts[1]);

                    OrderStatus status = OrderStatus.valueOf(parts[2]);

                    Order order = new Order(id, tableNumber);

                    if (status == OrderStatus.PAID) {
                        order.close();
                    }

                    if (status == OrderStatus.CANCELED) {
                        order.cancel();
                    }

                    orderService.getOrders().put(id, order);
                }
            }

            br.close();

            fileData.setFilePath(path);
            fileData.setLoaded(true);

            return "Successfully opened " + path;

        } catch (Exception e) {

            return "Error opening file";
        }
    }

    /**
     * Затваря текущия файл
     */
    public String close() {

        if (!fileData.isLoaded()) {
            return "No file is open";
        }

        fileData.clear();
        return "Successfully closed ";
    }

    /**
     * Записва текущия файл
     */
    public String save() {

        if (!fileData.isLoaded()) {
            return "No file opened";
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileData.getFilePath()))) {

            bw.write("MENU\n");
            for (MenuItem item : menuService.getMenu().values()) {
                bw.write(item.toFileString());
                bw.newLine();
            }

            bw.write("TABLES\n");
            for (Table table : tableService.getTables().values()) {

                bw.write(table.toFileString());
                bw.newLine();
            }

            bw.write("ORDERS\n");
            for (Order order : orderService.getOrders().values()) {

                bw.write(order.toFileString());
                bw.newLine();
            }
            return "Successfully saved";

        } catch (Exception e) {
            return "Error saving file";
        }
    }

    /**
     * Записва във нов файл
     *
     * @param path нов път
     */
    public String saveAs(String path) {

        if (!fileData.isLoaded()) {
            return "No file is open";
        }

        fileData.setFilePath(path);
        return "Successfully saved " + path;
    }
}