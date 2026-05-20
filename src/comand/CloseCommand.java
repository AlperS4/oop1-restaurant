package comand;

/**
 * Команда за затваряне на файл
 */
public class CloseCommand implements Command {
    @Override
    public String execute(String[] args, CommandContext ctx) {
       return ctx.fileManager.close();

    }
}