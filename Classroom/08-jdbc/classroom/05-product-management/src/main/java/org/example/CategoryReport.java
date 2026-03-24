package main.java.org.example;

public class CategoryReport {
    private String category;
    private int product_count;
    private double avg_price;
    private int total_quantity;

    public CategoryReport(String category, int product_count, double avg_price, int total_quantity) {
        this.category = category;
        this.product_count = product_count;
        this.avg_price = avg_price;
        this.total_quantity = total_quantity;
    }

    public String getCategory() {
        return category;
    }

    public int getProduct_count() {
        return product_count;
    }

    public double getAvg_price() {
        return avg_price;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }
}