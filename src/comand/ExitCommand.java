package comand;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] args, CommandContext ctx) {
        System.exit(0);
    }
}