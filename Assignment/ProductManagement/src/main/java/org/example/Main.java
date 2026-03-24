package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner sc= new Scanner(System.in);
    static Statement statement;
    public static void main(String[] args) throws SQLException {
        Driver driver=new org.postgresql.Driver();
        DriverManager.registerDriver(driver);
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/capPlayer"
                ,"postgres","1");
        statement=connection.createStatement();
//        Scanner sc= new Scanner(System.in);
//        while(true){
//            System.out.println("Enter 1 to add Product");
//            System.out.println("Enter 2 to view all Product");
//            System.out.println("Enter 3 to view Product by id");
//            System.out.println("Enter 4 to update product price");
//            System.out.println("Enter 5 to update product stock");
//            System.out.println("Enter 6 to delete product");
//            System.out.println("Enter 7 to search by name");
//            System.out.println("Enter 8 to search by category");
//            System.out.println("Enter 9 to low the stock");
//            System.out.println("Enter 10 to top rated products");
//            System.out.println("Enter 11 to sort products");
//            System.out.println("Enter 12 to Calculate stock value");
//            System.out.println("Enter 13 to count products");
//            System.out.println("Enter 14 to category wise report");
//            System.out.println("Enter 15 to pagination view");
//            System.out.println("Enter 16 to exit");
//        }
//       addProduct();
//        viewAllProducts();
//        viewProductById();
//        updateProductPrice();
//        updateProductPrice();
//        deleteProduct();
        searchByName();
        connection.close();

    }
    public static void addProduct() throws SQLException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter id");
        int id1=sc.nextInt();
        System.out.println("Enter Product name");
        String product_name1=sc.next();
        System.out.println("Enter Category");
        String category1=sc.next();
        System.out.println("Enter Price");
        double price1=sc.nextDouble();
        System.out.println("Enter quantity");
        int quantity1=sc.nextInt();
        System.out.println("Enter rating");
        double rating1=sc.nextDouble();
        System.out.println("Enter manufacturer");
        String manufacturer1=sc.next();
        if(price1<=0) System.out.println("Enter price greater then 0");
        if(quantity1<0) System.out.println("Quantity can't be zero");
        if(rating1<0||rating1>5) System.out.println("Rating must be between 1 to 5");
        ResultSet rows=statement.executeQuery("Select * from products where product_id ="+id1);
        if(rows.next()) {
            System.out.println("Id already exist");
            return;
        }
        String query="INSERT INTO products VALUES (" + id1 + ", '" + product_name1 + "', '" + category1 + "', " + price1 + ", " +
                quantity1 + ", " + rating1 + ", '" + manufacturer1 + "')";

        int rowInserted=statement.executeUpdate(query);
        if(rowInserted>0) System.out.println("Inserting successfull");
        else System.out.println("Insertion failed");
    }
    public static void viewAllProducts() throws SQLException{
        ResultSet rs=statement.executeQuery("Select * from products");
        System.out.println("PRODUCT ID | PRODUCT NAME | CATEGORY | PRICE | QUANTITY | RATING | MANUFACTURER");
        while(rs.next()){
            int id= rs.getInt("product_id");
            String product_name=rs.getString("product_name");
            String category= rs.getString("category");
            double price=rs.getDouble("price");
            int quantity=rs.getInt("quantity");
            double rating=rs.getDouble("rating");
            String manf=rs.getString("manufacturer");
            System.out.println(id+" | "+product_name+" |"+category+" |"+price+" |"+quantity+" |"+rating+" |"+manf);
        }
    }
    public static void viewProductById() throws SQLException {
        System.out.println("Enter product id");
       int id=sc.nextInt();
        ResultSet rs=statement.executeQuery("Select * from products where product_id ="+id);
        if(rs.next()) {
            String product_name=rs.getString("product_name");
            String category= rs.getString("category");
            double price=rs.getDouble("price");
            int quantity=rs.getInt("quantity");
            double rating=rs.getDouble("rating");
            String manf=rs.getString("manufacturer");
            System.out.println(id+" | "+product_name+" |"+category+" |"+price+" |"+quantity+" |"+rating+" |"+manf);
        }else{
            System.out.println("Id does not exist");
        }
    }
    public static void updateProductPrice() throws SQLException {
        System.out.println("Enter product id");
        int id=sc.nextInt();
        ResultSet rs=statement.executeQuery("Select * from products where product_id ="+id);
        if(!rs.next()) {
            System.out.println("Id not exist");
            return;
        }
        System.out.println("Current price"+rs.getDouble("price"));
        System.out.println("Enter new price");
        double newPrice=sc.nextDouble();
        int rows=statement.executeUpdate("Update products set price="+newPrice+" where product_id="+id);
        System.out.println(rows+" affected");
    }
    public static void updateProductStock() throws SQLException {
        System.out.println("Enter product id");
        int id=sc.nextInt();
        ResultSet rs=statement.executeQuery("Select * from products where product_id ="+id);
        if(!rs.next()) {
            System.out.println("Id not exist");
            return;
        }
        int current=rs.getInt("quantity");
        System.out.println("Current stock"+current);
        System.out.println("Enter 1 to increase and 2 to decrease");
        int n= sc.nextInt();
        System.out.println("Enter quantity to update");
        int change= sc.nextInt();
        if(n==2){
            change=-change;
            if(current+change<0){
                System.out.println("Less availabe stock");
                return;
            }
        }
        int updated=change+current;
        int rows=statement.executeUpdate("Update products set quantity="+updated+" where product_id="+id);
        System.out.println("Updated stock "+updated);
    }
    public static void deleteProduct() throws SQLException {
        System.out.println("Enter product id");
        int id=sc.nextInt();
        ResultSet rs=statement.executeQuery("Select * from products where product_id ="+id);
        if(!rs.next()) {
            System.out.println("Id not exist");
            return;
        }
        System.out.println("Enter 1 to delete and 2 to abort");
        int confirm=sc.nextInt();
        if(confirm==2){
            System.out.println("Deletion cancelled");
            return;
        }
        int rows=statement.executeUpdate("delete from products where product_id="+id);
        System.out.println(rows+" affected");
    }
    public static void searchByName() throws SQLException{
        System.out.println("Enter product name keyword");
        String name=sc.next();
        ResultSet rs=statement.executeQuery("Select * from products where product_name like '%"+name+"%'");
//        if(!rs.next()){
//            System.out.println("No match found");
//            return;
//        }
        System.out.println("PRODUCT ID | PRODUCT NAME | CATEGORY | PRICE | QUANTITY | RATING | MANUFACTURER");
        while(rs.next()){
            int id= rs.getInt("product_id");
            String product_name=rs.getString("product_name");
            String category= rs.getString("category");
            double price=rs.getDouble("price");
            int quantity=rs.getInt("quantity");
            double rating=rs.getDouble("rating");
            String manf=rs.getString("manufacturer");
            System.out.println(id+" | "+product_name+" |"+category+" |"+price+" |"+quantity+" |"+rating+" |"+manf);
        }

    }
}
