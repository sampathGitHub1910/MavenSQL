package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class App {
    
    public static void main(String[] args) {
        
     
            /*try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wipro", "root", "Sampath@1910");
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                
                String sql = "select * from test";

                ResultSet resultSet = preparedStatement.executeQuery();
     
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int salary = resultSet.getInt("sal");
     
                    System.out.println(name + ", " + salary);
                }
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }*/

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wipro", "root", "Sampath@1910")) {
                String selectQuery = "SELECT * FROM test WHERE id = ?";
                
                // Using PreparedStatement to parameterize the query
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                preparedStatement.setInt(1, 6); // Set the value for the parameter
    
                ResultSet resultSet = preparedStatement.executeQuery();
    
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String salary = resultSet.getString("sal");
    
                    System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
