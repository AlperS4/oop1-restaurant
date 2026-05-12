package comand;

public class HelpCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext ctx) {

        System.out.println("Supported command");

        System.out.println("open <file>");
        System.out.println("close");
        System.out.println("save");
        System.out.println("saveas <file>");

        System.out.println("additem <id> <name> <category> <price> <stock>");
        System.out.println("removeitem <id>");
        System.out.println("menu");

        System.out.println("addtable <number> <seats>");
        System.out.println("removetable <number>");
        System.out.println("tables");

        System.out.println("openorder <tableNumber>");
        System.out.println("addtoorder <orderId> <itemId> <quantity>");
        System.out.println("removefromorder <orderId> <itemId>");
        System.out.println("showorder <orderId>");
        System.out.println("closeorder <orderId>");
        System.out.println("cancelorder <orderId>");
        System.out.println("orders");

        System.out.println("report");
        System.out.println("topitems");

        System.out.println("help");
        System.out.println("exit");
    }
}