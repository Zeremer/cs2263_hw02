package edu.isu.cs2263.hw02;

public class Course {

    // Class variables
    private int number;
    private String subject;
    private String title;


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
    public String toString(){return title;}


    // Class Constructors
    public Course(){} //Empty constructor for Gson
    public Course(int num, String subj, String title){
        this.setNumber(num);
        this.setSubject(subj);
        this.setTitle(title);
    }
}
