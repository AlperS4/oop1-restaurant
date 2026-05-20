package basis;

import enums.TableStatus;


/**
 * Представя маса в ресторантаx
 */
public class Table {

    private int number;
    private int seats;
    private TableStatus status;

    /**
     * Създава нова маса
     *
     * @param number номер на масата
     * @param seats брой места
     */
    public Table(int number, int seats) {
        this.number = number;
        this.seats = seats;
        this.status = TableStatus.FREE;
    }

    public int getNumber() {
        return number;
    }

    public int getSeats() {
        return seats;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }
}
