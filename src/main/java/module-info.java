module org.example.week3_assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.week3_assignment1 to javafx.fxml;
    exports org.example.week3_assignment1;
}