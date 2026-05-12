package comand;

public class CloseOrderCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.orderService.closeOrder(Integer.parseInt(a[1]));
    }
}