module com.example.uidashboard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uidashboard to javafx.fxml;
    exports com.example.uidashboard;
}