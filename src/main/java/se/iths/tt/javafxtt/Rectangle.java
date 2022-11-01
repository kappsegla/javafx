package se.iths.tt.javafxtt;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape{
    public Rectangle(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getX()-10,getY()-10,20,20);
    }
}
