package edu.isu.cs2263.hw02;
import java.util.List;
import com.google.gson.Gson;
import java.util.Collection;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOManager {
    // Class Variables
    Gson gson = new Gson();

    // Class Methods
    public Student[] readData(String file) throws FileNotFoundException {
        File read_file = new File(file);
        Scanner scanner = new Scanner(read_file);
        String json = scanner.nextLine();
        return gson.fromJson(json, Student[].class);
    }

    public void writeData(String file, List<Student> data){
        try {
            File write_file = this.createFile(file);
            if (write_file.isFile()) {
                FileWriter writer = new FileWriter(write_file, true);
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
    private File createFile(String file) {
        File write_file = new File(file);
        try {
            if (write_file.createNewFile()) {
                System.out.println("File create: " + write_file.getName());
            } else {
                System.out.println("Problem creating file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating a file.");
            e.printStackTrace();
        }
        return write_file;
        }
}
