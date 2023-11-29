package org.ncu.app.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Task {
	
	@NotNull(message = "Id cannot be null")
	private int id;
	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 30, message = "Name must be in between 3 to 25 characters")
	private String name;
	@NotNull(message = "Description cannot be null")
	private String desc;
	@NotNull(message = "Duration cannot be null")
	@Min(value = 1, message = "Duration cannot be less than 1 hour")
	@Max(value = 24, message = "Duration cannot be more than 24 hours")
	private int duration;
	
	
	public Task() {
		super();
	}
	public Task(int id, String name, String desc, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.duration = duration;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", desc=" + desc + ", duration=" + duration + "]";
	}
	
}
