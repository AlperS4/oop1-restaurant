package comand;

public class OpenCommand implements Command {
    @Override
    public void execute(String[] args, CommandContext ctx) {
        ctx.fileManager.open(args[1]);
    }
}