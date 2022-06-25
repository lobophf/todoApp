package dev.lobophf.todoapp.model;

import java.util.Date;

public class Task {
  private int id;
  private int projectId;
  private String name;
  private String description;
  private String notes;
  private boolean isDone;
  private Date deadline;
  private Date createdAt;
  private Date lastTimeUpdatedOn;

  public Task(int id, int projectId, String name, String description, String notes, boolean isDone, Date deadline,
      Date createdAt, Date lastTimeUpdatedOn) {
    this.id = id;
    this.projectId = projectId;
    this.name = name;
    this.description = description;
    this.notes = notes;
    this.isDone = isDone;
    this.deadline = deadline;
    this.createdAt = createdAt;
    this.lastTimeUpdatedOn = lastTimeUpdatedOn;
  }

  public Task(){
	this.createdAt = new java.util.Date();
	this.lastTimeUpdatedOn = this.createdAt;
	this.deadline = this.createdAt;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdProject() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public boolean isDone() {
    return isDone;
  }

  public void setIsDone(boolean isDone) {
    this.isDone = isDone;
  }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
//    this.deadline = deadline;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getLastTimeUpdatedOn() {
    return lastTimeUpdatedOn;
  }

  public void setLastTimeUpdatedOn(Date lastTimeUpdatedOn) {
    this.lastTimeUpdatedOn = lastTimeUpdatedOn;
  }

  @Override
  public String toString() {
    return "Task [createdAt=" + createdAt + ", deadline=" + deadline + ", description=" + description + ", id=" + id
        + ", idProject=" + projectId + ", lastTimeUpdatedOn=" + isDone + ", name=" + name + ", notes=" + notes
        + ", lastTimeUpdatedOn=" + lastTimeUpdatedOn + "]";

  }
}
