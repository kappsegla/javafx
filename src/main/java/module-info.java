module se.iths.tt.javafxtt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;

    opens se.iths.tt.javafxtt to javafx.fxml;
    exports se.iths.tt.javafxtt;
}