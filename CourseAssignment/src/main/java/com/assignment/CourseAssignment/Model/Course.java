package com.assignment.CourseAssignment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// POJO
@Entity
@Table(name="Course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String subject;
	private int chapters;
	private int no_of_classes;
	private String type;
	private String learn_mode;
	public Course(Long id, String name, String subject, int chapters, int no_of_classes, String type,
			String learn_mode) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.chapters = chapters;
		this.no_of_classes = no_of_classes;
		this.type = type;
		this.learn_mode = learn_mode;
	}
	public Course (){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getNo_of_classes() {
		return no_of_classes;
	}
	public void setNo_of_classes(int no_of_classes) {
		this.no_of_classes = no_of_classes;
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", subject=" + subject + ", chapters=" + chapters
				+ ", no_of_classes=" + no_of_classes + ", type=" + type + ", learn_mode=" + learn_mode + "]";
	}
	

}

