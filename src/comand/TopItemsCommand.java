package comand;

/**
 * Команда за най-продавани артикули
 */
public class TopItemsCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
      return ctx.reportService.topItems();
    }
}