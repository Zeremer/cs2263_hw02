package edu.isu.cs2263.hw02;

import java.util.ArrayList;
import java.util.List;

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
    public void removeCourse(Course course){
        if(course_list.contains(course)){
            course_list.remove(course);
        }
        else{
            System.out.println("Course not found");
        }
    }

    // Other methods
    public String toString(){return firstName + " " + lastName;}


    // Class Constructors
    public Student(){} // Empty constructor for Gson
    public Student(String first, String last){ // constructor for names
        this.firstName = first;
        this.lastName = last;
    }
}
