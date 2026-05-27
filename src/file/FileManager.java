package file;

import basis.MenuItem;
import basis.Order;
import basis.Table;
import service.MenuService;
import service.OrderService;
import service.TableService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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