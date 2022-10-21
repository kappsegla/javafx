package se.iths.tt.javafxtt;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class GameViewController {

    public Canvas canvas;

    public GraphicsContext context;

    public void initialize(){
        context = canvas.getGraphicsContext2D();
    }

    //Todo: Snake data ie. Model for Snake
    //Todo: Keyboard input
    //Todo: Animation, automatic movement of snake and rendering. Game loop


    public void onCanvasClicked(MouseEvent mouseEvent) {
        context.setFill(Color.web("#eddeaf"));
        context.fillRect(0,0,400,400);
        context.setFill(Color.BLUE);
        context.fillRect(mouseEvent.getX()-(2.5), mouseEvent.getY()-(2.5), 5,5);
    }
}
