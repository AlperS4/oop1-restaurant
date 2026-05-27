import comand.CommandContext;
import comand.CommandParser;
import service.*;
import file.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MenuService ms = new MenuService();
        TableService ts = new TableService();
        OrderService os = new OrderService(ts);
        ReportService rs = new ReportService(os);

        FileData fd = new FileData();
        FileManager fm = new FileManager(fd, ms, ts, os);

        CommandContext ctx = new CommandContext(ms, ts, os, rs, fm, fd);

        Scanner sc = new Scanner(System.in);
        CommandParser parser = new CommandParser(ctx);

        while (true) {
            System.out.print("> ");

            String input = sc.nextLine();
            String result = parser.start(input);

            System.out.println(result);
        }
    }
}