package comand;

/**
 * Команда за излизане от програмата
 */
public class ExitCommand implements Command {
    @Override
    public String execute(String[] args, CommandContext ctx) {
        System.exit(0);
        return "";
    }
}