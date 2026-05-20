package comand;

/**
 * Команда за записване в нов файл
 */
public class SaveAsCommand implements Command {
    @Override
    public String execute(String[] args, CommandContext ctx) {
       return ctx.fileManager.saveAs(args[1]);
    }
}