package comand;

/**
 * Команда за записване на файл
 */
public class SaveCommand implements Command {
    @Override
    public String execute(String[] args, CommandContext ctx) {
        return ctx.fileManager.save();
    }
}