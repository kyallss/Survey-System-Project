module org.example.surveysystem2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.surveysystem2 to javafx.fxml;
    exports org.example.surveysystem2;

}

