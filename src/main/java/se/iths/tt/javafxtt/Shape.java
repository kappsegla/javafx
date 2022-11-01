package se.iths.tt.javafxtt;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private final double x;
    private final double y;

    private ObjectProperty<Color> color = new SimpleObjectProperty<>();


    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
        color.set(Color.BLACK);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color.get();
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public abstract void draw(GraphicsContext context);
    public static Shape createShape(ShapeType type, double x, double y){
        return switch (type) {
            case CIRCLE -> new Circle(x, y);
            case RECT -> new Rectangle(x, y);
        };
    }
}
