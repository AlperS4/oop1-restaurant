package comand;

public class SaveAsCommand implements Command {
    @Override
    public void execute(String[] args, CommandContext ctx) {
        ctx.fileManager.saveAs(args[1]);
    }
}