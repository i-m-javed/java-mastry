package main.java.org.example;


import java.sql.*;
import java.util.*;

public class TASK {

    private final CONNECTION db = new CONNECTION();

    // ================= MAPPER =================
    private Product map(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getString("category"),
                rs.getDouble("price"),
                rs.getInt("quantity"),
                rs.getInt("rating"),
                rs.getString("manufacturer")
        );
    }

    // ================= ADD =================
    public boolean addProduct(Product product) {

        String sql = "INSERT INTO products(product_id, product_name, category, price, quantity, rating, manufacturer) VALUES (?,?,?,?,?,?,?)";

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, product.getProduct_id());
            ps.setString(2, product.getProduct_name());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setInt(6, product.getRating());
            ps.setString(7, product.getManufacturer());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // ================= VIEW ALL =================
    public List<Product> viewAllProducts() {

        String sql = "SELECT * FROM products";
        List<Product> list = new ArrayList<>();

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {
                list.add(map(rs));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // ================= VIEW BY ID =================
    public Product viewProductById(int id) {

        String sql = "SELECT * FROM products WHERE product_id=?";
        Product product = null;

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product = map(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    // ================= UPDATE PRICE =================
    public boolean updateProductPrice(int id, double price) {

        String sql = "UPDATE products SET price=? WHERE product_id=?";

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setDouble(1, price);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    // ================= UPDATE STOCK =================
    public boolean updateProductStock(int id, int quantity) {

        String sql = "UPDATE products SET quantity=? WHERE product_id=?";

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, quantity);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    // ================= DELETE =================
    public boolean delete(int id) {

        String sql = "DELETE FROM products WHERE product_id=?";

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    // ================= SEARCH NAME =================
    public Product searchByName(String name) {

        String sql = "SELECT * FROM products WHERE product_name LIKE ?";
        Product product = null;

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setString(1, "%" + name + "%");

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product = map(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    // ================= SEARCH CATEGORY =================
    public List<Product> searchByCategory(String category) {

        String sql = "SELECT * FROM products WHERE category=?";
        List<Product> list = new ArrayList<>();

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setString(1, category);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // ================= LOW STOCK ALERT ================

    public List<Product> lowStockAlert(int threshold){

        String sql = "select * from products where quantity < ?";
        List<Product> list = new ArrayList<>();

        try(
                Connection connection = db.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){

            preparedStatement.setInt(1, threshold);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {

                while(resultSet.next()){
                    list.add(map(resultSet));
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  list;
    }

    // ================ TOP RATED PRODUCT ====================
    public List<Product> topRatedProducts(int rating){

        String sql = "select * from products where rating >= ? order by rating desc";
        List<Product> list = new ArrayList<>();

        try(
                Connection connection = db.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ){

            preparedStatement.setInt(1, rating);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    list.add(map(resultSet));
                }
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    // ================ TOP RATED PRODUCT ====================
    public List<Product> sortProduct(String param, String order){

        String sql = String.format("select * from products order by %s %s", param, order);

        List<Product> list = new ArrayList<>();

        try(
                Connection connection = db.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()

                ){

                while (resultSet.next()){
                    list.add(map(resultSet));
                }
            }
        catch (SQLException e){

            System.out.println(e.getMessage());
        }

        return list;
    }

    // ================= CALCULATE STOCK VALUE ==================
    public int calculateStockValue(){
        String sql = "select SUM(price*quantity) as total_inventory from products";

        int value = -1;

        try(
                Connection connection = db.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                ){
            if(resultSet.next()){
                value = resultSet.getInt("total_inventory");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return  value;
    }

    // ================ COUNT PRODUCTS ===================
    public int countAllProducts(){
        String sql = "select sum(quantity) as quantities from products";
        int quantities = -1;

        try(
                Connection connection = db.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                ){
            if(resultSet.next()){
                quantities = resultSet.getInt("quantities");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  quantities;
    }

    public Map<String , Integer> countByCategoryOrLowStock(int choice){
        String sql = "";
        switch (choice){
            case 2 -> {sql = "select category, sum(quantity) as quantities from products group by category";}
            case 3 -> {sql = "select category, Sum(quantity) as quantities from products where quantity <= 10 group by category";}
        }

        Map<String, Integer> items = new HashMap<>();

        try (
                Connection connection = db.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                ){
            while(resultSet.next()){
                items.put(resultSet.getString("category"), resultSet.getInt("quantities"));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return items;
    }

    // ================ CATEGORY WISE REPORT ===================
    public List<CategoryReport> categoryWiseReport(){
        String sql = """
        SELECT category,
               COUNT(*) AS product_count,
               AVG(price) AS avg_price,
               SUM(quantity) AS total_quantity
        FROM products
        GROUP BY category
    """;

        List<CategoryReport> list = new ArrayList<>();

        try(
                Connection connection = db.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                ){
            while(resultSet.next()){
                CategoryReport c = new CategoryReport(resultSet.getString("category"),
                        resultSet.getInt("product_count"),
                        resultSet.getDouble("avg_price"),
                        resultSet.getInt("total_quantity"));

                list.add(c);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

}