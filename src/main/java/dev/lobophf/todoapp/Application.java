package dev.lobophf.todoapp;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import dev.lobophf.todoapp.controller.ProjectController;
import dev.lobophf.todoapp.controller.TaskController;
import dev.lobophf.todoapp.model.Project;
import dev.lobophf.todoapp.model.Task;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//          ProjectController projectController = new ProjectController();
//          Project project = new Project();
//          project.setName("C");
//          project.setDescription("My description");
//          projectController.save(project);
//
//          ProjectController projectController = new ProjectController();
//          Project project = new Project();
//          project.setName("Updated Project");
//          project.setDescription("My new description");
//          projectController.update(1, project);
//
//          List<Project> projects = projectController.getAll();
//          System.out.println(projects);

          TaskController taskController = new TaskController();
          Task task = new Task();

          task.setName("turn the faucet off");
          task.setProjectId(2);
          task.setDescription("description"); 
          task.setIsDone(false);
          task.setNotes("Can't be fixed.");
          task.setDeadline(new Date());
          taskController.save(task);

	}
}
