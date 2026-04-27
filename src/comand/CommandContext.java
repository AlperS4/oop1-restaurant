package comand;

import service.*;
import file.*;

public class CommandContext {

    public MenuService menuService;
    public TableService tableService;
    public OrderService orderService;
    public ReportService reportService;
    public FileManager fileManager;
    public FileData fileData;

    public CommandContext(MenuService ms, TableService ts, OrderService os, ReportService rs, FileManager fm, FileData fd) {

        this.menuService = ms;
        this.tableService = ts;
        this.orderService = os;
        this.reportService = rs;
        this.fileManager = fm;
        this.fileData = fd;
    }
}