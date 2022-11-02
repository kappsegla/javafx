package se.iths.tt.javafxtt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.iths.tt.javafxtt.controller.CanvasViewController;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("canvas-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("JavaFX Chat");
        stage.setScene(scene);
        CanvasViewController controller = fxmlLoader.getController();
        controller.init(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}