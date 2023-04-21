package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person //--student 'is a' person -- inherits from person (inheritance)
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();

    //constructor -- calls the constructor of the parent class -- using parameters from the parent class

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        //false if student has already enrolled to the course, otherwise, true
        //this is to check if student is alr enrolled in the course using the key-value pair (code) and if the key is alr in the enrolledCourses hashmap
        //if not yet enrolled, to add student to enrolledCourses hashmap
        if (enrolledCourses.containsKey(course.getCode()))
        {
            return false;
        }
        else
        {
            enrolledCourses.put(course.getCode(), new EnrolledCourse(course));
            return true;
        }

         /*alternative
            EnrolledCourse enrolledCourse = new EnrolledCourse(course);
            enrolledCourses.put(course.getCode(), enrolledCourse);
            return true;
             */

    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        //check if student has enrolled to any courses
        //if yes, return the enrolledCourses hashmap
        //if no, return null
        if (enrolledCourses.isEmpty())
        {
            System.out.println("Student has not enrolled to any courses");
            return null;
        }
        else
        {
            return enrolledCourses;
        }

    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course
        //1. check if the student has enrolled to any courses in the enrolledCourses hashmap
        //2. if the student has enrolled to any courses, set the grade for the enrolled course
        //3. if the student has not enrolled to any courses, print "Student is not enrolled to any courses"
        //4. prompt set grade for the enrolled course again
        if (enrolledCourses.containsKey(courseCode)) {
            enrolledCourses.get(courseCode).setGrade(grade);
        } else {
            System.out.println("Student is not enrolled to any courses");
        }
    }

    public Course findCourseById( String courseId ) {
        //TODO return a Course from the course Id
        //1. check if the student alr enrolled to any courses in the enrolledCourses hashmap
        //2. if yes, return the course from the enrolledCourses hashmap
        //3. if not then to return null
        if (enrolledCourses.containsKey(courseId)) {
            return enrolledCourses.get(courseId);
        } else {
            return null;
        }
    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade
        //1. check if student is alr enrolled to any courses in the enrolledCourses hashmap
        //2. if yes, check enrolled courses grade against passing grade, if not then to return null
        //3. if grade is greater than or equal to passing grade, add course to passedCourses hashmap and return passedCourses hashmap
        //if never pass, dont add to passedCourses hashmap

        HashMap<String, EnrolledCourse> passedCourses = new HashMap<>();
        if ( enrolledCourses.isEmpty() ) //isEmpty checks if the hashmap is empty
        {
            System.out.println("Student has not enrolled to any courses");
            return null;
        }
        else
        {
            for ( String courseCode : enrolledCourses.keySet() ) //keySet returns all the keys in the hashmap
            {
                if ( enrolledCourses.get( courseCode ).getGrade() >= PASS_MIN_GRADE )
                {
                    passedCourses.put( courseCode, enrolledCourses.get( courseCode ) ); //.put adds a new key-value pair to the passedCourses hashmap
                }
            }
            return passedCourses;
        }

    }

    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
