package comand;

/**
 * Команда за отваряне на поръчка
 */
public class OpenOrderCommand implements Command {

    @Override
    public String execute(String[] args, CommandContext ctx) {

        try {
            int tableNumber = Integer.parseInt(args[1]);
            return ctx.orderService.openOrder(tableNumber);
        } catch (Exception e) {
            return "Invalid openorder command";
        }
    }
}