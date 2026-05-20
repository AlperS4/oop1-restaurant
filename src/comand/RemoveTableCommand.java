package comand;

/**
 * Команда за премахване на маса
 */
public class RemoveTableCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.tableService.removeTable(Integer.parseInt(a[1]));
    }
}