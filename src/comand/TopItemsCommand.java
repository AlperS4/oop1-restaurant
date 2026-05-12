package comand;

public class TopItemsCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.reportService.topItems();
    }
}