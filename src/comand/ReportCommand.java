package comand;

public class ReportCommand implements Command {
    @Override
    public void execute(String[] a, CommandContext ctx) {
        ctx.reportService.report();
    }
}