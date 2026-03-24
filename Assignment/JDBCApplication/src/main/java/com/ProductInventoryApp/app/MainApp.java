package com.ProductInventoryApp.app;

import com.ProductInventoryApp.dao.ProductDAO;
import com.ProductInventoryApp.model.Product;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {

            System.out.println("\n===== PRODUCT INVENTORY MENU =====");

            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. View Product By ID");
            System.out.println("4. Update Product Price");
            System.out.println("5. Update Product Quantity");
            System.out.println("6. Delete Product");
            System.out.println("7. Search Product By Name");
            System.out.println("8. Show Low Stock Products");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter ID:");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Category:");
                    String cat = sc.nextLine();

                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();

                    System.out.println("Enter Quantity:");
                    int qty = sc.nextInt();

                    System.out.println("Enter Rating:");
                    double rating = sc.nextDouble();

                    Product p =
                            new Product(id, name, cat, price, qty, rating);

                    if (dao.addProduct(p))
                        System.out.println("Product added successfully!");
                    else
                        System.out.println("Insert failed");

                    break;

                case 2:

                    List<Product> list = dao.getAllProducts();

                    for (Product pr : list) {

                        System.out.println(
                                pr.getProductId()+" "+
                                        pr.getProductName()+" "+
                                        pr.getCategory()+" "+
                                        pr.getPrice()+" "+
                                        pr.getQuantity()+" "+
                                        pr.getRating()
                        );
                    }

                    break;

                case 3:

                    System.out.println("Enter ID:");
                    int pid = sc.nextInt();

                    Product pr = dao.getProductById(pid);

                    if (pr != null)
                        System.out.println(pr.getProductName()+" "+pr.getPrice());
                    else
                        System.out.println("Product not found");

                    break;

                case 4:

                    System.out.println("Enter ID:");
                    int uid = sc.nextInt();

                    System.out.println("Enter new price:");
                    double newPrice = sc.nextDouble();

                    if (dao.updatePrice(uid,newPrice))
                        System.out.println("Price updated");
                    else
                        System.out.println("Product not found");

                    break;

                case 5:

                    System.out.println("Enter ID:");
                    int qid = sc.nextInt();

                    System.out.println("Enter new quantity:");
                    int newQty = sc.nextInt();

                    if (dao.updateQuantity(qid,newQty))
                        System.out.println("Quantity updated");
                    else
                        System.out.println("Product not found");

                    break;

                case 6:

                    System.out.println("Enter ID:");
                    int did = sc.nextInt();

                    if (dao.deleteProduct(did))
                        System.out.println("Product deleted");
                    else
                        System.out.println("Product does not exist");

                    break;

                case 7:

                    sc.nextLine();

                    System.out.println("Enter keyword:");
                    String key = sc.nextLine();

                    List<Product> res =
                            dao.searchByName(key);

                    res.forEach(x ->
                            System.out.println(x.getProductName()));

                    break;

                case 8:

                    List<Product> low =
                            dao.lowStockProducts();

                    low.forEach(x ->
                            System.out.println(
                                    x.getProductId()+" "+
                                            x.getProductName()+" "+
                                            x.getQuantity()));

                    break;

                case 9:

                    System.exit(0);
            }
        }
    }
}