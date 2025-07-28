module com.example.javafxscenebuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.javafxscenebuilder to javafx.fxml;
    exports com.example.javafxscenebuilder;
}