package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService // manages Student objects and EnrolledCourse objects
{
    //1. Attributes
    private final HashMap<String, Student> students = new HashMap<>();

    //2. Constructor
    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
        //1. check if student already exists
        //2. if not, add student to the students hashmap
        //3. if yes, print out "Student already exists"

        if (students.containsKey(student.getId())) //using .containsKey (id) to check if student already exists
        {
            System.out.println("Student already exists");
        }
        else
        {
            students.put(student.getId(), student); //using .put to add new student to hashmap
        }

    }

    //3. Getters
    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        //1. check if student already exists
        //2. if yes, return the student
        //3. if no, return null

        if (students.containsKey(studentId)) //using .containsKey (id) to check if student already exists
        {
            return students.get(studentId); //using .get to get the student
        }
        else
        {
            return null; //if student does not exist, return null
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if not enroll student to the course
        //check if student already exists
        //if yes, enroll student to the course
        //otherwise, print out "Student is not yet registered"

        if(students.containsKey(studentId))
        {
            students.get(studentId).enrollToCourse(course); //using .get to get the student and .enrollToCourse to enroll student to course
        }
        else
        {
            System.out.println("Student is not yet registered");
        }

    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
//        for (Student student : students.values()) //using .values to loop through the students hashmap
//        {
//            System.out.println(student.toString()); //using .toString to print out the students' details
//        }

//        for (Map.Entry<String, Student> entry : students.entrySet()) //using .entrySet to loop through the hashmap
//        {
//            System.out.println(entry.getValue().toString());//using .getValue to get the value of the student
//            System.out.println(entry.getValue().getEnrolledCourses().toString()); //using .getEnrolledCourses to get the enrolled courses of the student
//        }
        for ( String key : students.keySet() ) //looping through the students hashmap for each key. keySet() returns a set of all the keys in the hashmap
        {
            System.out.println( students.get( key ) ); //printing out the student details
            System.out.println( students.get( key ).getEnrolledCourses() ); //printing out the student enrolled courses
        }

    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses
        //1. check is student has enrolled to any courses
        //2. if yes, return the enrolledCourses hashmap
        //3. else, return null
        if (student.getEnrolledCourses() != null)
        {
            return student.getEnrolledCourses(); // if not null, return the enrolled courses of the student
        }
        else
        {
            return null;
        }
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id
        //1. check if student has enrolled to course
        //2. if yes, return the course
        //3. if not then return null

        if (student.getEnrolledCourses() != null)
        {
            return student.getEnrolledCourses().get(courseId); // if not null, return the course of the enrolled course
        }
        else
        {
            return null;
        }

        //alternative
//        if (student.getEnrolledCourses().containsKey(courseId)) //using .containsKey (accessing code) to check if student has enrolled to course
//        {
//            return student.getEnrolledCourses().get(courseId); //using .get to get the course
//        }
//        else
//        {
//            return null;
//        }

    }


    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
