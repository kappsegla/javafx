package se.iths.tt.javafxtt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.iths.tt.javafxtt.controller.ProductViewController;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("product-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        ProductViewController controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage.setTitle("JavaFX Chat");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}