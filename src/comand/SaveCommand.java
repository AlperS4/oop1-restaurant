package comand;

public class SaveCommand implements Command {
    @Override
    public void execute(String[] args, CommandContext ctx) {
        ctx.fileManager.save();
    }
}