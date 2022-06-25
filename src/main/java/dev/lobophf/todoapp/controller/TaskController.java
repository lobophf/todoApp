package dev.lobophf.todoapp.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.lobophf.todoapp.model.Task;
import dev.lobophf.todoapp.util.ConnectionFactory;

public class TaskController{

  public void save(Task task){

    Connection connection = null;
    PreparedStatement preparedStatement  = null;

    String sql = "INSERT INTO tasks ("
        + "project_id," 
        + "name,"
        + "description,"
        + "isDone,"
        + "notes,"
        + "deadline,"
        + "createdAt,"
        + "lastTimeUpdatedOn"
        + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try{
      connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, task.getIdProject());
      preparedStatement.setString(2, task.getName());
      preparedStatement.setString(3, task.getDescription());
      preparedStatement.setBoolean(4, task.isDone());
      preparedStatement.setString(5, task.getNotes());
      preparedStatement.setDate(6, new Date(task.getDeadline().getTime()));
      preparedStatement.setDate(7, new Date(task.getCreatedAt().getTime()));
      preparedStatement.setDate(8, new Date(task.getLastTimeUpdatedOn().getTime()));
      preparedStatement.execute();
    }catch(Exception e){
      throw new RuntimeException("The task couldn't be saved.", e);
    }finally{
      ConnectionFactory.closeConnection(connection);
    }
  }

  public void update(Task task){
  String sql = "UPDATE tasks SET "
        + "project_id = ?," 
        + "name = ?,"
        + "description = ?,"
        + "isDone = ?,"
        + "notes = ?,"
        + "deadline = ?,"
        + "createdAt = ?,"
        + "lastTimeUpdatedOn = ? WHERE id = ?";

    Connection connection = null;
    PreparedStatement preparedStatement  = null;

    try{
      connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, task.getIdProject());
      preparedStatement.setString(2, task.getName());
      preparedStatement.setString(3, task.getDescription());
      preparedStatement.setBoolean(4, task.isDone());
      preparedStatement.setString(5, task.getNotes());
      preparedStatement.setDate(6, new Date(task.getDeadline().getTime()));
      preparedStatement.setDate(7, new Date(task.getCreatedAt().getTime()));
      preparedStatement.setDate(8, new Date(task.getLastTimeUpdatedOn().getTime()));
      preparedStatement.setInt(9, task.getId());
//      preparedStatement.execute();
    }catch(Exception e){
      throw new RuntimeException("Task couldn't be updated", e);
    }finally{
      ConnectionFactory.closeConnection(connection);
    }
  }

  public void removeById(int id) throws SQLException{
    String sql = "DELETE FROM tasks WHERE id = ?";

    Connection connection = null;
    PreparedStatement preparedStatement  = null;

    try{
      connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.execute();
    }catch(Exception e){
      throw new RuntimeException("Task couldn't be deleted.", e);
    }finally{
      ConnectionFactory.closeConnection(connection);
    }
  }
  
  public List<Task> getAllTasks(int id){
    String sql = "SELECT * FROM tasks WHERE project_id = ?";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    List<Task> tasks = new ArrayList<Task>();

    try{
      connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setProjectId(resultSet.getInt("project_id"));
        task.setName(resultSet.getString("name"));
        task.setDescription(resultSet.getString("description"));
        task.setNotes(resultSet.getString("notes"));
        task.setIsDone(resultSet.getBoolean("isDone"));
        task.setDeadline(resultSet.getDate("deadline"));
        task.setCreatedAt(resultSet.getDate("createdAt"));
        task.setLastTimeUpdatedOn(resultSet.getDate("lastTimeUpdatedOn"));
        tasks.add(task);
      }
    }catch(Exception e){
      throw new RuntimeException("Task couldn't be taken.", e);
    }finally{
      ConnectionFactory.closeConnection(connection);
    }
    return tasks;
  }

}
