/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs2263.hw02;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This App is used to provide a GUI that looks at students and the courses that they have.
 * @Author Hunter Chase
 * @Version %I%, %G%
 */
public class App extends Application{

//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//
//        stage.setTitle("JavaFX and Gradle");
//        stage.setScene(scene);
//        stage.show();
//    }

@Override
public void start(Stage primaryStage) throws Exception {
    // Variables used to create a load file
//    Course cs1181 = new Course(1181, "CS", "Intro to Computer Science");
//    Course cs2222 = new Course(2222, "CS", "Advanced Computer Science");
//    Course cs3030 = new Course(3030, "CS", "Extreme Computer Science");
//    Course math1010 = new Course(1010, "MATH", "Intro to Math");
//    Course math2121 = new Course(2121, "MATH", "Advanced Math");
//    Course math3210 = new Course(3210, "MATH", "Extreme Math");
//
//    Student bob = new Student("bob", "guy");
//    bob.addCourse(cs1181);
//    bob.addCourse(cs2222);
//    bob.addCourse(cs3030);
//
//    Student sally = new Student("sally", "gal");
//    sally.addCourse(math1010);
//    sally.addCourse(math2121);
//    sally.addCourse(math3210);

    ArrayList<Student> studentList = new ArrayList<>();
//    studentList.add(bob);
//    studentList.add(sally);


    // Stage Settings
    primaryStage.setTitle("Course View");
    primaryStage.setWidth(800); // 500
    primaryStage.setHeight(600); // 485

    // Lists for students and courses
    ListView students = new ListView();
//    ObservableList<String> studs = FXCollections.observableArrayList (
//            bob.toString() , sally.toString()
//    );
//    students.setItems(studs);

    ListView courses = new ListView();

    HBox listAran = new HBox(students, courses);
//    listAran.setAlignment(Pos.BASELINE_CENTER);
    listAran.setLayoutY(20);
    listAran.setSpacing(10);

    Button read = new Button("Read");
    read.setOnAction(event -> {
        int stuNum = students.getSelectionModel().getSelectedIndex();
        Student currentStudent = studentList.get(stuNum);
        ObservableList classes = courses.getItems();
            courses.getItems().removeAll(classes);
        for (Course courz : currentStudent.getCourses())
            courses.getItems().addAll(courz.toString());
        });

    //Maybe selection change to eliminate read button?
//    students.getSelectionModel().selectedItemProperty().addListener(
//            (ChangeListener<String>) (ov, old_val, new_val) -> {
//    int stuNum = students.getSelectionModel().getSelectedIndex();
//    Student currentStudent = studentList.get(stuNum);
//    ObservableList classes = courses.getItems();
//    courses.getItems().removeAll(classes);
//    for (Course courz : currentStudent.getCourses())
//        courses.getItems().addAll(courz.toString());
//            });

    // Labels for lists
    Label studentLabls = new Label("Students");
    Label courseLabls = new Label("Courses");

    HBox listLabls = new HBox(studentLabls, courseLabls);
//    listLabls.setAlignment(Pos.TOP_CENTER);
    listLabls.setSpacing(210);

    //Loading in new file
    Button load = new Button("Load");
    load.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent clickLoad) {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            IOManager manag = new IOManager();
            try {
                ArrayList<Student> temp;
                temp = manag.readData(selectedFile.getAbsoluteFile());
                studentList.addAll(temp);
                for(Student peeps : studentList) {
                    students.getItems().add(peeps);
                }
            } catch (IOException e){
                e.printStackTrace();
                System.out.println("Problem reading file");
            }
        }
    });

    // Save items to new file
    Button save = new Button("Save");
    save.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent clickLoad) {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedFile = directoryChooser.showDialog(primaryStage);
            IOManager manag = new IOManager();
            manag.writeData(selectedFile.getAbsoluteFile(), "studs", studentList);
        }
    });


    // Clear lists | Does not work yet
    Button clear = new Button("Clear");
    clear.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent clickLoad) {
            students.getItems().removeAll(students.getSelectionModel().getSelectedItems());
            courses.getItems().removeAll(courses.getSelectionModel().getSelectedItems());
        }
    });

    HBox listButtons = new HBox(load, read, save, clear);
//    listButtons.setAlignment(Pos.BOTTOM_CENTER);
    listButtons.setLayoutY(420);


    // Pane to hold things
    Pane pane = new Pane();
    pane.getChildren().addAll(listAran, listLabls, listButtons);
    pane.setPrefSize(600, 400);

    Scene classesregd = new Scene(pane);
    primaryStage.setScene(classesregd);

    primaryStage.show();
}

    public static void main(String[] args) {
        launch(args);

    }
}
