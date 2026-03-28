import java.util.HashMap;
import java.util.Map;

public class TableService {

    private Map<Integer, Table> tables = new HashMap<>();

    public void addTable(int number, int seats) {
        tables.put(number, new Table(number, seats));
    }

    public void removeTable(int number) {

        if (!tables.containsKey(number)) {
            System.out.println("Table not found");
            return;
        }

        tables.remove(number);
    }

    public Table getTable(int number) {
        return tables.get(number);
    }

    public void printTables() {

        if (tables.isEmpty()) {
            System.out.println("No tables");
            return;
        }

        for (Table t : tables.values()) {
            System.out.println(
                    "Table " + t.getNumber() +
                    "Seats:" + t.getSeats() +
                    "Status:" + t.getStatus()
            );
        }
    }
}