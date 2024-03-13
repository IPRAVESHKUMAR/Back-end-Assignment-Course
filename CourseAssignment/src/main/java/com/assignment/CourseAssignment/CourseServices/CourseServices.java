package com.assignment.CourseAssignment.CourseServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.CourseAssignment.Checkfields.CheckFields;
import com.assignment.CourseAssignment.Dao.CourseRepository;
import com.assignment.CourseAssignment.Mapper.StudentCourseMapping;
import com.assignment.CourseAssignment.Model.Course;
import com.assignment.CourseAssignment.Pojo.StudentCourse;

@Service
public class CourseServices {
	
	@Autowired
	private CourseRepository courseRepo;
	

	public Object createCourse(Course course, String role) {
		
		try {
			
			if(role.equalsIgnoreCase("creator")) { // create course if uuser role is creator
				
				courseRepo.save(course);
				
				
				return new ResponseEntity<>("Course Created",HttpStatus.OK); 
			}
		
			else // response for a non creator role user
				return new ResponseEntity<>("You are not authorized for this action",HttpStatus.BAD_REQUEST);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	public Object updateCourse(Course course, String role, Long id) {
		
		try {
			Optional<Course> findCourseObj = courseRepo.findById(id);
			
			Course updateCourse = findCourseObj.get();

		if(findCourseObj.isPresent()) { // check if record is present in the database
				
	 	  if(role.equalsIgnoreCase("creator")) {	// update course if role is creator
										            // can update all fields

					updateCourse.setName(course.getName());
					updateCourse.setSubject(course.getSubject());
					updateCourse.setChapters(course.getChapters());
					updateCourse.setNo_of_classes(course.getNo_of_classes());
					
					if(CheckFields.check(course.getType(),course.getLearn_mode())) { // allowed type = "Personalised" , "Group"		
					                                                                 // allowed learn mode = "assisted" , "self learning"
					updateCourse.setType(course.getType());
					updateCourse.setLearn_mode(course.getLearn_mode());
					
					}
					else // response if course type or learn mode is inputed incorrect
						return new ResponseEntity<>("Invalid course type or learn mode",HttpStatus.BAD_REQUEST);
					
					courseRepo.save(updateCourse); // updating course
					
					return new ResponseEntity<>("Course Updated Successfully",HttpStatus.OK); // successful updation of record response

				}
	 	  
	 	  
			else if(role.equalsIgnoreCase("teacher")){	// update course if role is teacher but with limited updating actions
	                                                    // can update some specific fields fields	

				    updateCourse.setChapters(course.getChapters());
					updateCourse.setNo_of_classes(course.getNo_of_classes());
					
					if(CheckFields.check(course.getType(),course.getLearn_mode())) {	// condition check for type and learn mode					
						
						updateCourse.setType(course.getType());
						updateCourse.setLearn_mode(course.getLearn_mode());
						
						}
						else // response for invalid type or learn mode
							return new ResponseEntity<>("Invalid inputs",HttpStatus.BAD_REQUEST);
					
                     courseRepo.save(updateCourse); // saving update
					
					return new ResponseEntity<>("Course Updated Successfully",HttpStatus.OK); // response for successful updation

				}
			else // response when user role is neither creator nor teacher
				return new ResponseEntity<>("You are not authorised for this action",HttpStatus.NOT_FOUND);
	 	  
			}
			
		// response if record is not present
			return new ResponseEntity<>("Record not Found",HttpStatus.NOT_FOUND);
				
		}
		catch(Exception e) {
			return new ResponseEntity<>("Record not Found",HttpStatus.NOT_FOUND);
		}
		

	}

	public Object getCourse(String role, Long id) {
		
		try {
			
			Optional<Course> courseData = courseRepo.findById(id);
			
			if(courseData.isPresent()) {	// check if required data is present or not
			
				Course course = courseData.get();
				
			    if(role.equalsIgnoreCase("creator")) {		// if role is creator return all data of that record
							
				   return new ResponseEntity<>(course,HttpStatus.OK);			
			    }
			
			
			
			    else if(role.equalsIgnoreCase("student")) {	 // if role is student return specific data	of that record
				
				   StudentCourse studentCourse = StudentCourseMapping.mapData(course);
				
				   return new ResponseEntity<>(studentCourse,HttpStatus.OK);
			    }
			
			
			}
			return new ResponseEntity<>("Record not found",HttpStatus.NOT_FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	}

	
	public Object getAllCourses(String role) {
		
		try {
			
			if(role.equalsIgnoreCase("creator")) {  // if role is creator then return all the records
				
			List<Course> courseList = new ArrayList<>();
			
			courseRepo.findAll().forEach(courseList::add);
			
			    if(courseList.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		
			} // when user role is not creator 
			return new ResponseEntity<>("Invalid User Role",HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
