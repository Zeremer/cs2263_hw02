package edu.isu.cs2263.hw02;

/**
 * This is a class for making course objects for students to take.
 * @Author Hunter Chase
 * @Version %I%, %G%
 */
public class Course {

    // Class variables
    public int number;
    public String subject;
    public String title;


    // Class methods
    // Setters
    public void setNumber(int num){
        this.number = num;
    }
    public void setSubject(String subj) {
        this.subject = subj;
    }
    public void setTitle(String title){
        this.title = title;
    }

    // Class Getters
    public int getNumber(){return number;}
    public String getSubject(){return subject;}
    public String getTitle(){return title;}

    // Other Methods
    public String toString(){return subject + number + " " + title;}


    // Class Constructors

    /**
     * Empty constructor for Gson.
     */
    public Course(){}

    /**
     * Standard constructor for making course objects.
     * @param num specifies the courses number.
     * @param subj specifies the overall subject of the course.
     * @param title specifies the specific course title.
     */
    public Course(int num, String subj, String title){
        this.setNumber(num);
        this.setSubject(subj);
        this.setTitle(title);
    }
}
