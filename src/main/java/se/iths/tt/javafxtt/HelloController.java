package se.iths.tt.javafxtt;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Label welcomeText;

    public Button button1;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void labelClicked(MouseEvent mouseEvent) {
        if( mouseEvent.isControlDown())
            welcomeText.setBackground(Background.fill(Color.RED));
    }
}