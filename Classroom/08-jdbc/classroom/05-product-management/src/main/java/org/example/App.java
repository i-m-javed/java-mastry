package main.java.org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        TASK task = new TASK();
        Scanner scanner = new Scanner(System.in);

        int choice;

        System.out.println("========== PRODUCT MANAGEMENT ==========");

        do {
            System.out.println("""
                    \n1. Add Product
                    2. View All Products
                    3. View Product By Id
                    4. Update Product Price
                    5. Update Product Stock
                    6. Delete Product
                    7. Search By Name
                    8. Search By Category
                    9. Low Stock Alert
                    10.Top Rated Products
                    11.Sort Products
                    12.Calculate Stock Value
                    13.Count Products
                    14.Category Wise Report
                    15. Exit
                    """);

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); //buffer clear

            switch (choice) {

                // ================= ADD =================
                case 1 -> {

                    System.out.print("Enter product id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter rating: ");
                    int rating = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    
                    

                    boolean inserted = task.addProduct(new Product(id, name, category, price, quantity, rating, manufacturer));
                    
                    if(inserted){
                        System.out.println("✅ Product added successfully");
                    }else{
                        System.out.println("❌ Fail to add");
                    }
                }

                // ================= VIEW ALL =================
                case 2 -> {
                    List<Product> products = task.viewAllProducts();

                    if (products == null || products.isEmpty()) {
                        System.out.println("⚠️ No products found");
                    } else {
                        printProducts(products);
                    }
                }

                // ================= VIEW BY ID =================
                case 3 -> {
                    System.out.print("Enter product id: ");
                    int id = scanner.nextInt();

                    Product p = task.viewProductById(id);

                    if (p == null) {
                        System.out.println("⚠️ Product not found");
                    } else {
                        printProduct(p);
                    }
                }

                // ================= UPDATE PRICE =================
                case 4 -> {
                    System.out.print("Enter product id: ");
                    int id = scanner.nextInt();

                    System.out.print("Enter new price: ");
                    double price = scanner.nextDouble();

                    if(task.updateProductPrice(id, price)){
                        System.out.println("✅ Price updated");
                    }else {
                        System.out.println("❌ failed to update.");
                    }
                }

                // ================= UPDATE STOCK =================
                case 5 -> {
                    System.out.print("Enter product id: ");
                    int id = scanner.nextInt();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    if(task.updateProductStock(id, quantity)) {
                        System.out.println("✅ Stock updated");
                    }else {
                        System.out.println("❌ failed to update.");
                    }
                }

                // ================= DELETE =================
                case 6 -> {
                    System.out.print("Enter product id: ");
                    int id = scanner.nextInt();

                    if(task.delete(id)) {
                        System.out.println("✅ Product deleted");
                    }else{
                        System.out.println("❌ failed to delete.");
                    }
                }

                // ================= SEARCH NAME =================
                case 7 -> {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    Product p = task.searchByName(name);

                    if (p == null) {
                        System.out.println("No product found");
                    } else {
                        printProduct(p);
                    }
                }

                // ================= SEARCH CATEGORY =================
                case 8 -> {
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    List<Product> products = task.searchByCategory(category);

                    if (products == null || products.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        printProducts(products);
                    }
                }

                // ================ LOW STOCK ALERT ====================
                case 9 -> {
                    System.out.print("Enter the Threshold: ");
                    int threshold = scanner.nextInt();
                    List<Product> products = task.lowStockAlert(threshold);

                    if(products == null || products.isEmpty()){
                        System.out.println("✅ Stock Levels are healthy");
                    }else {
                        System.out.println("Please maintain the stock of following items.");
                        printProducts(products);
                    }
                }

                // ================ TOP RATED PRODUCT ====================
                case 10 -> {
                    System.out.print("Enter the rating: ");
                    int rating = scanner.nextInt();
                    if(rating >= 1 && rating <= 5){
                        List<Product> products = task.topRatedProducts(rating);
                        if(products == null || products.isEmpty()){
                            System.out.println("⚠️ No product found");
                        }else {
                            printProducts(products);
                        }
                    }else {
                        System.out.println("⚠️ Invalid rating......try again");
                    }
                }

                // ================ SORT PRODUCT =======================
                case 11 -> {

                    System.out.println("""
                        1. Sort by Price
                        2. Sort by Name
                        3. Sort by Date
                        4. Sort by Rating
                        """);

                    System.out.print("Enter choice: ");

                    int c = scanner.nextInt();

                    System.out.println("""
                        1. Ascending
                        2. Descending
                        """);

                    System.out.print("Enter choice: ");

                    int s = scanner.nextInt();

                    String column;

                    switch (c) {
                        case 1 -> column = "price";
                        case 2 -> column = "product_name";
                        case 3 -> column = "created_at";
                        case 4 -> column = "rating";
                        default -> {
                            System.out.println("⚠️ Invalid sort field");
                            return;
                        }
                    }

                    String order = (s == 1) ? "asc" :
                            (s == 2) ? "desc" : null;

                    if (order == null) {
                        System.out.println("⚠️ Invalid order");
                        return;
                    }

                    List<Product> products = task.sortProduct(column, order);

                    if (products == null || products.isEmpty()) {
                        System.out.println("⚠️ No Data found.");
                    } else {
                        printProducts(products);
                    }
                }

                // ================= CALCULATE STOCK VALUE ==================
                case 12 -> {
                    int value = task.calculateStockValue();
                    if(value == -1){
                        System.out.println("⚠️ No data found.");
                    }else{
                        System.out.println("The inventory worth ₹"+value);
                    }
                }

                // ================ COUNT PRODUCTS ===================
                case 13 -> {
                    System.out.println("""
                            1. All products
                            2. Category wise products
                            3. Low stock products
                            """);
                    System.out.print("Enter choice:  ");
                    int c = scanner.nextInt();
                    if(c == 1){
                        int quantities = task.countAllProducts();
                        if(quantities == -1){
                            System.out.println("⚠️ No data found.");
                        }else {
                            System.out.println("Total quantities of products: "+quantities);
                        }
                    }else if( c== 2 || c== 3){
                        Map<String, Integer> items = task.countByCategoryOrLowStock(c);
                        if(items == null || items.isEmpty()){
                            System.out.println("⚠️ No data found.");
                        }else{
                            System.out.println("\n----------------------------------------------");
                            System.out.printf("%-12s %-8s%n",
                                    "Category", "Qty");
                            System.out.println("----------------------------------------------");

                            for(var v : items.entrySet()){
                                System.out.printf("%-12s %-8d%n", v.getKey(), v.getValue());
                            }
                        }
                    }else {
                        System.out.println("Invalid choice");
                    }
                }

                // ================ CATEGORY WISE REPORT ===================
                case 14 -> {
                    List<CategoryReport> list = task.categoryWiseReport();
                    if(list == null || list.isEmpty()){
                        System.out.println("⚠️ No data found.");
                    }else {
                        System.out.println("\n-----------------------------------------------------------");
                        System.out.printf("%-12s %-15s %-15s %-15s%n",
                                "Category", "Product count", "Average price", "Total Quantity");
                        System.out.println("------------------------------------------------------------");

                        for(CategoryReport c: list){
                            System.out.printf("%-12s %-15s %-15s %-15s%n",
                                    c.getCategory(),
                                    c.getProduct_count(),
                                    c.getAvg_price(),
                                    c.getTotal_quantity());
                        }
                    }
                }

                case 15 -> System.out.println("Exiting application...");

                default -> System.out.println("Invalid choice");
            }

        } while (choice != 15);
    }

    // ================= PRINT SINGLE =================
    static void printProduct(Product p) {

        System.out.println("\n----------------------------------");
        System.out.println("ID          : " + p.getProduct_id());
        System.out.println("Name        : " + p.getProduct_name());
        System.out.println("Category    : " + p.getCategory());
        System.out.println("Price       : " + p.getPrice());
        System.out.println("Quantity    : " + p.getQuantity());
        System.out.println("Rating      : " + p.getRating());
        System.out.println("Manufacturer: " + p.getManufacturer());
    }

    // ================= PRINT TABLE =================
    static void printProducts(List<Product> products) {

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-12s %-10s %-8s %-8s %-15s%n",
                "ID", "Name", "Category", "Price", "Qty", "Rating", "Manufacturer");
        System.out.println("--------------------------------------------------------------------------------");

        for (Product p : products) {
            System.out.printf("%-5d %-15s %-12s %-10.2f %-8d %-8d %-15s%n",
                    p.getProduct_id(),
                    p.getProduct_name(),
                    p.getCategory(),
                    p.getPrice(),
                    p.getQuantity(),
                    p.getRating(),
                    p.getManufacturer());
        }
    }
}