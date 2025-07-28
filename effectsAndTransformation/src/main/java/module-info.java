module com.example.effectsandtransformation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.effectsandtransformation to javafx.fxml;
    exports com.example.effectsandtransformation;
}