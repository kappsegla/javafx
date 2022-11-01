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

    ObservableList<Shape> shapes = FXCollections.observableArrayList(param -> new Observable[]{param.colorProperty() });

    public ShapeType getCurrentShapeType() {
        return currentShapeType.get();
    }

    public ObjectProperty<ShapeType> currentShapeTypeProperty() {
        return currentShapeType;
    }

    public void setCurrentShapeType(ShapeType currentShapeType) {
        this.currentShapeType.set(currentShapeType);
    }

    public ObservableList<Shape> getShapes() {
        return shapes;
    }

    public Shape addShape(Shape shape){
        //var oShape = new ObservableShape(shape);
        shapes.add(shape);
        return shape;
    }
}


