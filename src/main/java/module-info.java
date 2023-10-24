module com.example.personne {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.personne to javafx.fxml;
    exports com.example.personne;
    exports com.example.personne.Controller;
    opens com.example.personne.Controller to javafx.fxml;
}