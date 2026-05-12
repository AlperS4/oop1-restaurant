package comand;

public class RemoveTableCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.tableService.removeTable(Integer.parseInt(a[1]));
    }
}