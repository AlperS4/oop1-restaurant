package basis;

import enums.Category;

/**
 * Представя артикул от менюто
 */
public class MenuItem {

    private int id;
    private String name;
    private Category category;
    private double price;
    private int stock;

    /**
     * Създава нов артикул
     *
     * @param id уникално ID
     * @param name име
     * @param category категория
     * @param price цена
     * @param stock наличност
     */
    public MenuItem(int id, String name, Category category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return  "id= " + id +
                " name = " + name +
                " category = " + category +
                " price = " + price +
                " stock = " + stock;
    }
}
