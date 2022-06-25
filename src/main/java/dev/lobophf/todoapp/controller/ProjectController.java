package dev.lobophf.todoapp.controller;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.lobophf.todoapp.model.Project;
import dev.lobophf.todoapp.util.ConnectionFactory;

public class ProjectController {

  public void save(Project project){

    Connection connection = null;
    PreparedStatement preparedStatement  = null;

    String sql = "INSERT INTO projects(" 
        + "name, " 
        + "description, " 
        + "createdAt, " 
        + "lastTimeUpdatedOn "  
        + ") VALUES (?, ?, ?, ?)";

    try{
      connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(sql); 
      preparedStatement.setString(1, project.getName());
      preparedStatement.setString(2, project.getDescription());
      preparedStatement.setTimestamp(3, new Timestamp(project.getCreatedAt().getTime()));
      preparedStatement.setTimestamp(4, new Timestamp(project.getLastTimeUpdatedOn().getTime()));
      preparedStatement.execute();
    }catch(Exception e){
      throw new RuntimeException("The project couldn't be saved.", e);
    }finally{
      ConnectionFactory.closeConnection(connection);
    }
  }

  public void update(int id, Project project){
  String sql = "UPDATE projects SET "
        + "name = ?,"
        + "description = ?,"
        + "createdAt = ?,"
        + "lastTimeUpdatedOn = ? WHERE id = ?";

    Connection connection = null;
    PreparedStatement preparedStatement  = null;

    try{
      connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, project.getName());
      preparedStatement.setString(2, project.getDescription());
      preparedStatement.setTimestamp(3, new Timestamp(project.getCreatedAt().getTime()));
      preparedStatement.setTimestamp(4, new Timestamp(project.getLastTimeUpdatedOn().getTime()));
      preparedStatement.setInt(5, id);
      preparedStatement.execute();
    }catch(Exception e){
      throw new RuntimeException("Project coudn't be updated", e);
    }finally{
      ConnectionFactory.closeConnection(connection);
    }
  }

 public List<Project> getAll(){
    String sql = "SELECT * FROM projects";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    List<Project> projects = new ArrayList<Project>();

    try{
      connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        Project project = new Project();
        project.setId(resultSet.getInt("id"));
        project.setName(resultSet.getString("name"));
        project.setDescription(resultSet.getString("description"));
        project.setCreatedAt(resultSet.getDate("createdAt"));
        project.setLastTimeUpdatedOn(resultSet.getDate("lastTimeUpdatedOn"));
        projects.add(project);
      }
    }catch(Exception e){
      throw new RuntimeException("Task couldn't be taken.", e);
    }finally{
      ConnectionFactory.closeConnection(connection);
    }
    return projects;
  }

  public void removeById(int id) throws SQLException{
    String sql = "DELETE FROM projects WHERE id = ?";

    Connection connection = null;
    PreparedStatement preparedStatement  = null;

    try{
      connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.execute();
    }catch(Exception e){
      throw new RuntimeException("Project couldn't be deleted.", e);
    }finally{
      ConnectionFactory.closeConnection(connection);
    }
  }

}
