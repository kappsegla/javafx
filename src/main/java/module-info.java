module se.iths.tt.javafxtt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;

    opens se.iths.tt.javafxtt to javafx.fxml;
    exports se.iths.tt.javafxtt;
    exports se.iths.tt.javafxtt.model;
    opens se.iths.tt.javafxtt.model to javafx.fxml;
    exports se.iths.tt.javafxtt.controller;
    opens se.iths.tt.javafxtt.controller to javafx.fxml;
}