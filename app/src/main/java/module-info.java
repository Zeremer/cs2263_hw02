module cs2263_hw02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens edu.isu.cs2263.hw02 to javafx.fxml;
    exports edu.isu.cs2263.hw02;
}
