package comand;

public class AddTableCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.tableService.addTable(Integer.parseInt(a[1]), Integer.parseInt(a[2]));
    }
}