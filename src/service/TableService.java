package service;

import basis.Table;
import exeption.TableNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class TableService {

    private Map<Integer, Table> tables = new HashMap<>();

    public void addTable(int number, int seats) {

        if (tables.containsKey(number)) {
            System.out.println("Table already exists");
            return;
        }

        tables.put(number, new Table(number, seats));
        System.out.println("Table added");
    }

    public void removeTable(int number) {

        if (!tables.containsKey(number)) {
            System.out.println("Table not found");
            return;
        }

        tables.remove(number);
        System.out.println("Table removed");
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
                    "Table: " + t.getNumber() +
                    "Seats:" + t.getSeats() +
                    "Status:" + t.getStatus());
        }
    }
}