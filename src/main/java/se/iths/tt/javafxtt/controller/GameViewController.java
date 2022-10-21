package se.iths.tt.javafxtt.controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import se.iths.tt.javafxtt.GameAnimation;
import se.iths.tt.javafxtt.model.SnakeModel;

public class GameViewController {

    public Canvas canvas;

    public GraphicsContext context;

    public SnakeModel snake = new SnakeModel();

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        gameAnimation.start();
    }

    //Todo: Keyboard input

    GameAnimation gameAnimation = new GameAnimation() {
        float time;

        @Override
        public void tick(float secondsSinceLastFrame) {
            time += secondsSinceLastFrame;
            if (time < 0.2)
                return;

            snake.update();
            render();
            time = 0.0f;
        }
    };


    public void render() {
        context.setFill(Color.web("#eddeaf"));
        context.fillRect(0, 0, 400, 400);
        context.setFill(Color.web("#004B87"));
        context.fillRect((snake.getPosition().x() * 10), (snake.getPosition().y() * 10), 10, 10);
    }

    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("Key pressed");
        switch (keyEvent.getCode()) {
            case UP -> snake.setUp();
            case DOWN -> snake.setDown();
            case LEFT -> snake.setLeft();
            case RIGHT -> snake.setRight();
        }
    }
}
