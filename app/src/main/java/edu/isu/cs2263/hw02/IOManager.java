package edu.isu.cs2263.hw02;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import java.util.Collection;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * IOManager is a utility class that writes to and reads from files in gson.
 * @Author Hunter Chase
 * @Version %I%, %G%
 */
public class IOManager {
    // Class Variables
    Gson gson = new Gson();

    // Class Methods

    /**
     * readData takes a file's absolute path as a string.
     * It is expecting the contents to be student objects stored as Json.
     * The Json is parsed line by line and stored in a student array.
     * It is recommended to use the overloaded readData method that takes a file.
     * @param file this is a string of the absolute file path to be read from
     * @return a student array
     * @throws FileNotFoundException file may not be found
     */
    public Student[] readData(String file) throws FileNotFoundException {
        File read_file = new File(file);
        Scanner scanner = new Scanner(read_file);
        String json = scanner.nextLine();
        return gson.fromJson(json, Student[].class);
    }

    /**
     * readData takes a file's absolute path as a file Object.
     * It is expecting the contents to be student objects stored as Json.
     * The Json is parsed line by line and builds student objects through Gson and stores them in an ArrayList.
     * @param file is a file object with the absolute path of the file to be read.
     * @return An generic ArrayList with students.
     * @throws FileNotFoundException file may not be found
     */
    public ArrayList<Student> readData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Student> studentBox = new ArrayList<Student>();
        while(scanner.hasNext()){
            String json = scanner.nextLine();
           Student nextStud = gson.fromJson(json, Student.class);
           studentBox.add(nextStud);
        }
        scanner.close();
        return studentBox;
    }

    /**
     * writeData takes a String with the absolute file path to write to
     * then stores a list of students in that file with gson.
     * Use the version that takes an ArrayList instead of this on.
     * @param file is a String with an absolute file path.
     * @param data this is a generic list with student objects.
     */
    public void writeData(String file, List<Student> data){
        try {
            File write_file = this.createFile(file);
            if (write_file.isFile()) {
                FileWriter writer = new FileWriter(write_file, false);
                String Json = gson.toJson(data);
                writer.write(Json);
                writer.write("\n");
            }
            else {
                System.out.println("Problem writing to file.");
            }
        }
        catch (IOException e){
            System.out.println("An error occurred writing to file.");
            e.printStackTrace();
        }
    }

    /**
     * write data stores an ArrayList of students at the specified file.
     * The data is converted to Json by Gson for long-term storage.
     * @param file is the directory of where the file with fileName is to be saved.
     * @param fileName is the name of the file to store the list of students.
     * @param data is a generic ArrayList with student objects.
     */
    public void writeData(File file, String fileName, ArrayList<Student> data){
        try {
            if (file.isDirectory()) {
                file = this.createFile(file + "/" + fileName);
                FileWriter writer = new FileWriter(file, true);
                for (Student stud : data){
                    String json = gson.toJson(stud);
                    writer.write(json);
                    writer.write("\n");
                    System.out.println("Wrote to file: " + file);
                }
                writer.close();
            }
            else {
                System.out.println("Problem writing to file.");
            }
        }
        catch (IOException e){
            System.out.println("An error occurred writing to file.");
            e.printStackTrace();
        }
    }

    /**
     * This is a utility method used by the other methods that may need to create a file.
     * @param file this is the absolute file path of the file to be made.
     * @return the file's absolute path.
     */
    private File createFile(String file) {
        File write_file = new File(file);
        try {
            if (write_file.createNewFile()) {
                System.out.println("File create: " + write_file.getName());
            } else {
                System.out.println("File may already exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating a file.");
            e.printStackTrace();
        }
        return write_file;
        }
}
