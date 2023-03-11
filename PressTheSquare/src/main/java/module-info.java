module com.example.pressthesquare {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pressthesquare.pressthesquare to javafx.fxml;
    exports com.example.pressthesquare;
}