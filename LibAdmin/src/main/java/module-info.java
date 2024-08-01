module com.example.libadmin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.libadmin to javafx.fxml;
    exports com.example.libadmin;
}