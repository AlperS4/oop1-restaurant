package comand;

public interface Command {
    void execute(String[] args, CommandContext ctx);
}