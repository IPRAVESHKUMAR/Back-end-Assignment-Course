# Back-end-Assignment-Course
A back-end spring boot API to create, update and get the courses from a database.


END POINTS INFORMATION

   1. The create end point can only be used by the craetor. Upon entering the user role as "creator" the user will be able to create a course, otherwise the user will not be able to create a course.

   2. The update end point can be used by creator and by the teacher user role. But the creator can edit and upate all the fields (excluding Id) of course.
      But the teacher user role can only edit and update the following fields: course chapters, number of classes, type of course (personalised or group), learn mode (assisted or self learning).

   3. The get end point can be used by the creator and by the student user role.
       The creator can get all the fields of the course record specified by its "id", or all the records of couses be provided to the creator if ther is not "id" in the end point.
       The student can get only the course record by its specific "id". Also not all fields of the asked course are provided to the student user role. Only necessary fields are provided to the student user role.
                
       

END POINTS  (Base end point : http://localhost:8080/course

   1. For creation of course : /create/{role}
       role = creator
       Full endpoint:                                                          http://localhost:8080/course/create/creator

   2. For updation of course : /update/{role}/{id}
        role = creator, teacher
        Full endpoints: for creator:                                           http://localhost:8080/course/update/creator/1
                        for teacher:                                           http://localhost:8080/course/update/teacher/1
         here we have taken id = 1 as an example
    
   3. For getting course : /get/{role}/{id}
   
      3.1. For creator when all course records are required : /get/{role}
                      end point:                                               http://localhost:8080/course/get/creator
           For creator when specific records according to id are required : /get/{role}/{id}
                      end point:                                               http://localhost:8080/course/get/creator/1
            here we have taken id = 1 as an example
   
      3.2.  For student get works only with specific course id : /get/{role}/{id}
                      end point:                                               http://localhost:8080/course/get/student/1
             here we have taken id = 1 as an example

   
        if role = creator then endpoint are:                                   http://localhost:8080/course/get/creator               ( for getting full course record )
                                                                               http://localhost:8080/course/get/creator/1             ( for getting specific course record, here id = 1 as an example )
     


FIELDs INFORMATION

   1. The course fields should be of correct type as described below:
        name = String
        subject = String
        chapters = Integer
        no_of_classes = Integer
        type = String
        learn_mode = String

  2. There can only be two course "type" as : "personalised" or "group"
       "type" is not case sensitive.
  
  3. There can only be two course "learn_mode" as : "assisted" or "self learning"
       "learn_mode" is not case sensitive.


PROJECT STRUCTURE

 Packages: 

     1. Main class package: com.assignment.CourseAssignment
        main class: CourseAssignmentApplication - contains main method

     2. Controller layer package: com.assignment.CourseAssignment.CourseController
        controller class: CourseController - contains endpoints 

     3. Service layer package: com.assignment.CourseAssignment.CourseServices
        service class: CourseServices - services of validation

     4. Data access object layer (DAO): com.assignment.CourseAssignment.Dao
        Repository: CourseRepository - access and operate course data and objects

     5. Entity layer package: com.assignment.CourseAssignment.Model
        Model object class: Course - course object
        
     6. Extra packages-->  com.assignment.CourseAssignment.Checkfields
                           CheckFields: class to check inputed type and learn mode are of corret type.

                           com.assignment.CourseAssignment.Mapper
                           StudentCourseMapping: maps a StudentCourse object to be returned upon student role user request to get cours,

                           com.assignment.CourseAssignment.Pojo
                           StudentCourse: object to be retured upon student role user request to get course
        


DEPENDENCIES

    - H2 Database Sql
    - Spring Web
    - lombok
    - spring data jpa

FOR TESTING AND DEBUGGING

   1. Postman
   2. Internet Browser


DATABASE INFORMATION
   - To enable and use H2 database console use this url :        http://localhost:8080/h2-console
   - Default Password =
   - Default User Name =sa
   - Driver Class =org.h2.Driver
   - JDBC URL =jdbc:h2:mem:testdb
