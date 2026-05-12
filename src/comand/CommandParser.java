package comand;

import java.util.*;

public class CommandParser {

    private Map<CommandType, Command> commands = new HashMap<>();
    private CommandContext ctx;

    public CommandParser(CommandContext ctx) {
        this.ctx = ctx;
        register();
    }

    private void register() {

        commands.put(CommandType.OPEN, new OpenCommand());
        commands.put(CommandType.CLOSE, new CloseCommand());
        commands.put(CommandType.SAVE, new SaveCommand());
        commands.put(CommandType.SAVEAS, new SaveAsCommand());

        commands.put(CommandType.ADDITEM, new AddItemCommand());
        commands.put(CommandType.REMOVEITEM, new RemoveItemCommand());
        commands.put(CommandType.MENU, new MenuCommand());

        commands.put(CommandType.ADDTABLE, new AddTableCommand());
        commands.put(CommandType.REMOVETABLE, new RemoveTableCommand());
        commands.put(CommandType.TABLES, new TablesCommand());

        commands.put(CommandType.OPENORDER, new OpenOrderCommand());
        commands.put(CommandType.ADDTOORDER, new AddToOrderCommand());
        commands.put(CommandType.REMOVEFROMORDER, new RemoveFromOrderCommand());
        commands.put(CommandType.SHOWORDER, new ShowOrderCommand());
        commands.put(CommandType.CLOSEORDER, new CloseOrderCommand());
        commands.put(CommandType.CANCELORDER, new CancelOrderCommand());
        commands.put(CommandType.ORDERS, new OrdersCommand());

        commands.put(CommandType.REPORT, new ReportCommand());
        commands.put(CommandType.TOPITEMS, new TopItemsCommand());

        commands.put(CommandType.HELP, new HelpCommand());
        commands.put(CommandType.EXIT, new ExitCommand());
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("> ");
            String input = sc.nextLine();

            String[] parts = input.split(" ");

            CommandType type;

            try {
                type = CommandType.fromString(parts[0]);
            } catch (Exception e) {
                System.out.println("Unknown command");
                continue;
            }

            if (!ctx.fileData.isLoaded()
                    && type != CommandType.OPEN
                    && type != CommandType.HELP
                    && type != CommandType.EXIT) {

                System.out.println("No file opened");
                continue;
            }

            try {
                commands.get(type).execute(parts, ctx);
            } catch (Exception e) {
                System.out.println("Error executing command");
            }
        }
    }
}