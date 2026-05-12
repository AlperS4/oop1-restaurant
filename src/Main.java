
import comand.CommandContext;
import comand.CommandParser;
import service.*;
import file.*;

public class Main {
    public static void main(String[] args) {

        MenuService ms = new MenuService();
        TableService ts = new TableService();
        OrderService os = new OrderService(ts);
        ReportService rs = new ReportService(os);
        FileData fd = new FileData();
        FileManager fm = new FileManager(fd);

        CommandContext ctx = new CommandContext(ms, ts, os, rs, fm, fd);

        new CommandParser(ctx).start();
    }
}