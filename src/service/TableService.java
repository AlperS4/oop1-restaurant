package service;

import basis.Table;
import exeption.TableNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * Управлява масите
 */
public class TableService {

    private Map<Integer, Table> tables = new HashMap<>();

    /**
     * Добавя нова маса.
     *
     * @param number номер
     * @param seats места
     */
    public String addTable(int number, int seats) {

        if (tables.containsKey(number)) {
            return "Table already exists";
        }

        tables.put(number, new Table(number, seats));
        return "Table added";
    }

    /**
     * Премахва маса
     *
     * @param number номер
     */
    public String removeTable(int number) {
        if (!tables.containsKey(number)) {
            return "Table not found";
        }

        tables.remove(number);
        return  "Table removed";
    }

    /**
     * Връща маса по номер
     *
     * @param number номер на масата
     * @return намерената маса
     */
    public Table getTable(int number) {
        Table table = tables.get(number);
        if (table == null) {
            throw new TableNotFoundException("Table not found");
        }
        return table;
    }

    /**
     * Принтира всички маси
     */
    public String printTables() {
        if (tables.isEmpty()) {
            return "No tables";
        }

        for (Table t : tables.values()) {
            return "Table: " + t.getNumber() + "Seats: " + t.getSeats() + "Status: " + t.getStatus();
        }
        return "Tables printed";
    }
}