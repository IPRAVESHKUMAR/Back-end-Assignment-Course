package com.assignment.CourseAssignment.Mapper;

import org.springframework.stereotype.Component;

import com.assignment.CourseAssignment.Model.Course;
import com.assignment.CourseAssignment.Pojo.StudentCourse;

@Component
public class StudentCourseMapping {

	// maps the fields on the StudentCourse object to be return as a response to the 
	// student role user for getting a course record
	
	
	
	public static StudentCourse mapData(Course course) {
		
		StudentCourse studentCourse = new StudentCourse(); 
		
		studentCourse.setName(course.getName());
		studentCourse.setSubject(course.getSubject());
		studentCourse.setChapters(course.getChapters());
		studentCourse.setType(course.getType());
		studentCourse.setLearn_mode(course.getLearn_mode());
		
		return studentCourse;
	}
}

