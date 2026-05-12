package comand;

public class OpenOrderCommand implements Command {

    @Override
    public void execute(String[] args, CommandContext ctx) {

        try {
            int tableNumber = Integer.parseInt(args[1]);
            ctx.orderService.openOrder(tableNumber);
            System.out.println("Order opened for table " + tableNumber);

        } catch (Exception e) {
            System.out.println("Invalid openorder command");
        }
    }
}