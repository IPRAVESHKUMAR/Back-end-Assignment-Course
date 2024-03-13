package com.assignment.CourseAssignment.Pojo;

import org.springframework.stereotype.Component;

//POJO for the response to the student user role

@Component
public class StudentCourse {

	private String name;
	private String subject;
	private int chapters;
	private String type;
	private String learn_mode;
	public StudentCourse(String name, String subject, int chapters, String type, String learn_mode) {
		super();
		this.name = name;
		this.subject = subject;
		this.chapters = chapters;
		this.type = type;
		this.learn_mode = learn_mode;
	}
	public StudentCourse() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getChapters() {
		return chapters;
	}
	public void setChapters(int chapters) {
		this.chapters = chapters;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLearn_mode() {
		return learn_mode;
	}
	public void setLearn_mode(String learn_mode) {
		this.learn_mode = learn_mode;
	}
	
}
