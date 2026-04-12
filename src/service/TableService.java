package service;

import basis.Table;
import exeption.TableNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class TableService {

    private Map<Integer, Table> tables = new HashMap<>();

    public void addTable(int number, int seats) {
        tables.put(number, new Table(number, seats));
    }

    public void removeTable(int number) {

        if (!tables.containsKey(number)) {
            System.out.println("basis.Table not found");
            return;
        }

        tables.remove(number);
    }

    public Table getTable(int number) {

        Table table = tables.get(number);
        if (table == null) {
            throw new TableNotFoundException("Table not found");
        }
        return table;
    }

    public void printTables() {

        if (tables.isEmpty()) {
            System.out.println("No tables");
            return;
        }

        for (Table t : tables.values()) {
            System.out.println(
                    "basis.Table: " + t.getNumber() +
                    "Seats:" + t.getSeats() +
                    "Status:" + t.getStatus()
            );
        }
    }
}