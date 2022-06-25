package dev.lobophf.todoapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  
  public static Connection getConnection(){
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/todoApp", "todoAppAdminUser", "secret");
    } catch (Exception e) {
      throw new RuntimeException("Connection with database refused.", e);
    }
  }

  public static void closeConnection(Connection connection){
      try {
        if(connection != null){
          connection.close();
        }
    } catch (SQLException e) {
      throw new RuntimeException("Connection with database couldn't be closed.", e);
    }
  }

}
