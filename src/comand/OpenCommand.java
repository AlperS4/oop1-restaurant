package comand;

/**
 * Команда за отваряне на файл
 */
public class OpenCommand implements Command {
    @Override
    public String execute(String[] args, CommandContext ctx) {
        return ctx.fileManager.open(args[1]);
    }
}