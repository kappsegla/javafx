package se.iths.tt.javafxtt;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Model {

    ObjectProperty<ShapeType> currentShapeType = new SimpleObjectProperty<>(ShapeType.CIRCLE);

    ObservableList<ObsShape> shapes = FXCollections.observableArrayList(param -> new Observable[]{param.colorProperty() });

    public ShapeType getCurrentShapeType() {
        return currentShapeType.get();
    }

    public ObjectProperty<ShapeType> currentShapeTypeProperty() {
        return currentShapeType;
    }

    public void setCurrentShapeType(ShapeType currentShapeType) {
        this.currentShapeType.set(currentShapeType);
    }

    public ObservableList<? extends Shape> getShapes() {
        return shapes;
    }

    public Shape addShape(Shape shape){
        var oShape = new ObsShape(shape);
        shapes.add(oShape);
        return oShape;
    }
}

class ObsShape extends Shape {
    Shape shape;
    ObjectProperty<Color> color = new SimpleObjectProperty<>();

    public ObsShape(Shape shape){
        super(shape.getX(),shape.getY());
        this.shape = shape;
        color.set(shape.getColor());
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    @Override
    public Color getColor() {
        return color.get();
    }

    @Override
    public void setColor(Color color) {
        shape.setColor(color);
        this.color.set(color);
    }

    @Override
    public void draw(GraphicsContext context) {
        this.shape.draw(context);
    }
}