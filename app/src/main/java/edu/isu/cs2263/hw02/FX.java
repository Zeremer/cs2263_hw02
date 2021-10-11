package edu.isu.cs2263.hw02;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FX extends Application {

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

    /**
     * Meat and potatoes of JavaFX UI
     * @param primaryStage Stage for this UI's main screen
     * @throws Exception
     */
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
        primaryStage.setWidth(500); // 500
        primaryStage.setHeight(485); // 485

        // Lists for students and courses
        ListView students = new ListView();
//    ObservableList<String> studs = FXCollections.observableArrayList (
//            bob.toString() , sally.toString()
//    );
//    students.setItems(studs);

        ListView courses = new ListView();

        HBox listAran = new HBox(students, courses);
        listAran.setLayoutY(20);
        listAran.setSpacing(10);

//        Button read = new Button("Read");
//        read.setOnAction(event -> {
//            int stuNum = students.getSelectionModel().getSelectedIndex();
//            Student currentStudent = studentList.get(stuNum);
//            ObservableList classes = courses.getItems();
//            courses.getItems().removeAll(classes);
//            for (Course courz : currentStudent.getCourses())
//                courses.getItems().addAll(courz.toString());
//        });

        students.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable,
                                Student oldValue, Student newValue) {
                if (!students.getSelectionModel().isEmpty()) {
                    int stuNum = students.getSelectionModel().getSelectedIndex();
                    Student currentStudent = studentList.get(stuNum);
                    ObservableList classes = courses.getItems();
                    courses.getItems().removeAll(classes);
                    for (Course courz : currentStudent.getCourses())
                        courses.getItems().addAll(courz.toString());
                }
            }
        });

        // Labels for lists
        Label studentLabls = new Label("Students");
        Label courseLabls = new Label("Courses");

        HBox listLabls = new HBox(studentLabls, courseLabls);
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


        // Clear lists
        Button clear = new Button("Clear");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent clickLoad) {
                students.getSelectionModel().clearSelection();
                ObservableList classes = courses.getItems();
                courses.getItems().removeAll(classes);
                ObservableList studs = students.getItems();
                students.getItems().removeAll(studs);
            }
        });

        HBox listButtons = new HBox(load, save, clear); // removed read from this
        listButtons.setLayoutY(420);


        // Pane to hold things
        Pane pane = new Pane();
        pane.getChildren().addAll(listAran, listLabls, listButtons);
        pane.setPrefSize(600, 400);

        Scene classesregd = new Scene(pane);
        primaryStage.setScene(classesregd);

        primaryStage.show();
    }

    static void classApp(String[] args) {
        launch(args);
    }
}
