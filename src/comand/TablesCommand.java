package comand;

/**
 * Команда за показване на масите
 */
public class TablesCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.tableService.printTables();
    }
}