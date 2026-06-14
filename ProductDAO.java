package com.JDBC_Integration;

import java.sql.*;

public class ProductDAO {


    public void createTable() {

        String createQuery = """
            CREATE TABLE IF NOT EXISTS products(
                product_id INT PRIMARY KEY AUTO_INCREMENT,
                product_name VARCHAR(100) NOT NULL,
                category VARCHAR(50),
                price DECIMAL(10,2),
                quantity INT
            )
            """;

        try (
                Connection conn = DataBaseConnection.createConnection();
                Statement stmt = conn.createStatement()
        ) {

            stmt.executeUpdate(createQuery);
            System.out.println("Table Created SucessFully");

        } catch (SQLException e) {

            System.out.println("Error creating table: " + e.getMessage());

        }
    }

    public void insertProduct(Product product){

        String insertQuery = "INSERT INTO products\n" +
                "(product_name, category, price, quantity)\n" +
                "VALUES (?, ?, ?, ?)";


        try (
                Connection conn = DataBaseConnection.createConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
        ) {

            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getCategory());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting product: " + e.getMessage());
        }
    }

    public void getAllProducts(){

        String selectQuery = """
                SELECT * FROM products
        """;

        try (
                Connection conn = DataBaseConnection.createConnection();
                Statement stmt = conn.createStatement()
        ) {

            ResultSet resultSet=stmt.executeQuery(selectQuery);

            while(resultSet.next()){
                System.out.println("---------------------");
                System.out.println("ID : " + resultSet.getInt("product_id"));
                System.out.println("Name : " + resultSet.getString("product_name"));
                System.out.println("Category : " + resultSet.getString("category"));
                System.out.println("Price : " + resultSet.getDouble("price"));
                System.out.println("Quantity : " + resultSet.getInt("quantity"));
                System.out.println("---------------------");
            }


        } catch (SQLException e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }

    }

    public boolean updateProductPrice(double newPrice, int id) {

        String updateQuery = """
            UPDATE products
            SET price = ?
            WHERE product_id = ?
            """;

        try (
                Connection conn = DataBaseConnection.createConnection();
                PreparedStatement pstmt = conn.prepareStatement(updateQuery)
        ) {

            pstmt.setDouble(1, newPrice);
            pstmt.setInt(2, id);

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {

            System.out.println("Error updating product price: " + e.getMessage());
            return false;
        }
    }

    public boolean updateProductQuantity(int newQuantity, int id) {

        String updateQuery = """
            UPDATE products
            SET quantity = ?
            WHERE product_id = ?
            """;

        try (
                Connection conn = DataBaseConnection.createConnection();
                PreparedStatement pstmt = conn.prepareStatement(updateQuery)
        ) {

            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, id);

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {

            System.out.println("Error updating product Quantity: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteProduct(int id){

        String deleteQuery = """
            DELETE FROM products
            WHERE product_id = ?
            """;

        try (
                Connection conn = DataBaseConnection.createConnection();
                PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
        ) {

            pstmt.setInt(1, id);

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {

            System.out.println("Error deleting product: " + e.getMessage());
            return false;
        }
    }

    public Product searchProductById(int id){

        Product foundProduct=null;

        String searchQuery = """
                SELECT * FROM products 
                WHERE product_id = ?
        """;

        try (
                Connection conn = DataBaseConnection.createConnection();
                PreparedStatement pstmt = conn.prepareStatement(searchQuery);
        ) {
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                String category = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                foundProduct = new Product(productId, productName, category, price, quantity);
            }

        } catch (SQLException e) {

            System.out.println("Error searching product: " + e.getMessage());


        }
        return foundProduct;

    }
}
