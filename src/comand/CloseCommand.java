package comand;

public class CloseCommand implements Command {
    public void execute(String[] args, CommandContext ctx) {
        ctx.fileManager.close();
    }
}