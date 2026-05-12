package comand;

public class TablesCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.tableService.printTables();
    }
}