module com.example.fruitapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fruitapp to javafx.fxml;
    exports com.example.fruitapp;
}