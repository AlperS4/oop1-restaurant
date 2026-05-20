package comand;

/**
 * Команда за добавяне на маса
 */
public class AddTableCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.tableService.addTable(Integer.parseInt(a[1]), Integer.parseInt(a[2]));
    }
}