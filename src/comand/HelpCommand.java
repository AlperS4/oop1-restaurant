package comand;

/**
 * Команда за помощ
 */
public class HelpCommand implements Command {

    @Override
    public String execute(String[] args, CommandContext ctx) {
        return "Supported commands \n" +
                "open <file> \n" +
                "close \n" +
                "save \n" +
                "saveas <file> \n" +
                "additem <id> <name> <category> <price> <stock> \n" +
                "removeitem <id> \n" +
                "menu \n" +
                "addtable <number> <seats> \n" +
                "removetable <number> \n" +
                "tables \n" +
                "openorder <tableNumber> \n" +
                "addtoorder <orderId> <itemId> <quantity> \n" +
                "removefromorder <orderId> <itemId> \n" +
                "showorder <orderId> \n" +
                "closeorder <orderId> \n" +
                "cancelorder <orderId> \n" +
                "orders \n" +
                "report \n" +
                "topitems \n" +
                "help \n" +
                "exit";
    }
}