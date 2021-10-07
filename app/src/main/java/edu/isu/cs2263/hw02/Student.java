package edu.isu.cs2263.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * Student Class for creating student objects to be used in the basic App.
 * Students can contain a list of courses to be referenced.
 * @Author Hunter Chase
 * @Version %I%, %G%
 */
public class Student {

    // Class variables
    public String firstName = "";
    public String lastName = "";
    public ArrayList<Course> course_list = new ArrayList<Course>();

    // Class methods
    // Setters
    public void setFirstName(String name){
        this.firstName = name;
    }
    public void setLastName(String name){
        this.lastName = name;
    }

    // Getters
    public String getFirstName(){return this.firstName;}
    public String getLastName(){return this.lastName;}
    public ArrayList<Course> getCourses(){return course_list;}

    // Course methods
    /**
     * This method is used to add a course to a students course list.
     * @param course is a class containing variables for containing a classes subject, number, and title.
     */
    public void addCourse(Course course){
        if(course_list == null){
            this.course_list.add(course);
        }
        else if(course_list.contains(course)){
            System.out.println("Student already has this course.");
        }
        else{
            this.course_list.add(course);
        }
    }

    /**
     * This method is used to remove a course from a student's course list.
     * @param course is a class containing variables for containing a classes subject, number, and title.
     */
    public void removeCourse(Course course){
        if(course_list.contains(course)){
            course_list.remove(course);
        }
        else{
            System.out.println("Course not found");
        }
    }

    // Other methods

    /**
     * This method is used to get a string representation of the particular student.
     * @return String returned is the student's first then last name.
     */
    public String toString(){return firstName + " " + lastName;}


    // Class Constructors

    /**
     * This constructor is intentionally left empty for the use of google's gson.
     */
    public Student(){}

    /**
     * This is the normal constructor for a student.
     * They should be given a first and last name.
     * Courses are added later with the addCourse method.
     * @param first The students first name.
     * @param last The students last name.
     */
    public Student(String first, String last){ // constructor for names
        this.firstName = first;
        this.lastName = last;
    }
}
