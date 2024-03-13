package com.assignment.CourseAssignment.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.CourseAssignment.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{

}
