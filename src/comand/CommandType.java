package comand;

/**
 * Enum с всички поддържани команди
 */
public enum CommandType {

    OPEN,
    CLOSE,
    SAVE,
    SAVEAS,
    ADDITEM,
    REMOVEITEM,
    MENU,
    ADDTABLE,
    REMOVETABLE,
    TABLES,
    OPENORDER,
    ADDTOORDER,
    REMOVEFROMORDER,
    SHOWORDER,
    CLOSEORDER,
    CANCELORDER,
    ORDERS,
    REPORT,
    TOPITEMS,
    HELP,
    EXIT;

    /**
     * Преобразува текст в CommandType
     *
     * @param input въведена команда
     * @return съответния CommandType
     * @throws IllegalArgumentException при невалидна команда
     */
    public static CommandType fromString(String input) {
        return switch (input.toLowerCase()) {

            case "open" -> OPEN;
            case "close" -> CLOSE;
            case "save" -> SAVE;
            case "saveas" -> SAVEAS;

            case "additem" -> ADDITEM;
            case "removeitem" -> REMOVEITEM;
            case "menu" -> MENU;

            case "addtable" -> ADDTABLE;
            case "removetable" -> REMOVETABLE;
            case "tables" -> TABLES;

            case "openorder" -> OPENORDER;
            case "addtoorder" -> ADDTOORDER;
            case "removefromorder" -> REMOVEFROMORDER;
            case "showorder" -> SHOWORDER;
            case "closeorder" -> CLOSEORDER;
            case "cancelorder" -> CANCELORDER;
            case "orders" -> ORDERS;

            case "report" -> REPORT;
            case "topitems" -> TOPITEMS;

            case "help" -> HELP;
            case "exit" -> EXIT;

            default -> throw new IllegalArgumentException("Unknown command");
        };
    }
}