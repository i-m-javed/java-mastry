package main.java.org.example;


import java.time.Instant;

public class Product {
    private Integer product_id;
    private String product_name;
    private String category;
    private Double price;
    private Integer quantity;
    private Integer rating;
    private String manufacturer;
    private final Instant created_at;

    public Product(Integer product_id, String product_name, String category, Double price, Integer quantity, Integer rating, String manufacturer) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
        this.manufacturer = manufacturer;
        this.created_at = Instant.now();
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getRating() {
        return rating;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Instant getCreated_at() {
        return created_at;
    }
}
