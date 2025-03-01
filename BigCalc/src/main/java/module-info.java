module com.example.bigcalc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.bigcalc to javafx.fxml;
    exports com.example.bigcalc;
}