package dev.lobophf.todoapp.model;

import java.util.Date;

public class Project {

	private int id;
	private String name;
	private String description;
	private Date createdAt;
	private Date lastTimeUpdatedOn;

	public Project(int id, String name, String description, Date createdAt, Date lastTimeUpdatedOn) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.lastTimeUpdatedOn = lastTimeUpdatedOn;
	}

	public Project() {
		this.createdAt = new java.util.Date();
		this.lastTimeUpdatedOn = this.createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Project [createdAt=" + createdAt + ", description=" + description + ", id=" + id + ", name="
				+ name
				+ ", lastTimeUpdatedOn=" + lastTimeUpdatedOn + "]";
	}

}
