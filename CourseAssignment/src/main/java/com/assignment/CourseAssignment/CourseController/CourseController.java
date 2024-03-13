package com.assignment.CourseAssignment.CourseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.CourseAssignment.CourseServices.CourseServices;
import com.assignment.CourseAssignment.Model.Course;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseServices courseServices;

	@PostMapping("/create/{role}") // course creation end point mapping
	public Object createCourse(@RequestBody Course course,@PathVariable String role) {
		return courseServices.createCourse(course,role);
	}
	
	@PostMapping("update/{role}/{id}")  // course updation end point mapping
	public Object updateCourse(@RequestBody Course course,@PathVariable String role,@PathVariable Long id) {
		return courseServices.updateCourse(course,role,id);
	}
	
	@GetMapping("/get/{role}/{id}")  // course get end point mapping
	public Object getCourse(@PathVariable String role, @PathVariable Long id) {
		return courseServices.getCourse(role,id);
	}
	
	@GetMapping("/get/{role}")  // course get end point mapping
	public Object getAllCourses(@PathVariable String role) {
		return courseServices.getAllCourses(role);
	}
	
}
