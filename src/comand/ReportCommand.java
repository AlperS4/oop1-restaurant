package comand;

/**
 * Команда за отчет
 */
public class ReportCommand implements Command {
    @Override
    public String execute(String[] a, CommandContext ctx) {
       return ctx.reportService.report();
    }
}