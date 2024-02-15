module org.emmakema47.todolistapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.emmakema47.todolistapp to javafx.fxml;
    exports org.emmakema47.todolistapp;
}