package com.mftplus.da;

import com.mftplus.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDataAccess {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java123";

    public void save(Product product) {
        String sql = "INSERT INTO products (id, name, brand, price) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setDouble(4, product.getPrice());

            preparedStatement.executeUpdate();
            System.out.println("محصول با موفقیت در دیتابیس ذخیره شد.");
        } catch (SQLException e) {
            System.out.println("خطا در ذخیره محصول: " + e.getMessage());
        }
    }

    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, brand = ?, price = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setLong(4, product.getId());

            preparedStatement.executeUpdate();
            System.out.println("محصول با موفقیت ویرایش شد.");
        } catch (SQLException e) {
            System.out.println("خطا در ویرایش محصول: " + e.getMessage());
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            System.out.println("محصول با موفقیت حذف شد.");
        } catch (SQLException e) {
            System.out.println("خطا در حذف محصول: " + e.getMessage());
        }
    }
}