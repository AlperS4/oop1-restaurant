package comand;

/**
 * Интерфейс за всички команди
 */
public interface Command {

    /**
     * Изпълнява команда
     *
     * @param args аргументи
     * @param ctx  command context
     * @return
     */
    String execute(String[] args, CommandContext ctx);
}