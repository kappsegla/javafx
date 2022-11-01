package se.iths.tt.javafxtt.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import se.iths.tt.javafxtt.Circle;
import se.iths.tt.javafxtt.Shape;
import se.iths.tt.javafxtt.ShapeType;

public class CanvasViewController {
    public Canvas canvas;
    public ChoiceBox<ShapeType> choiceBox;

    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());

    public void initialize(){
        choiceBox.setItems(shapeTypesList);
        choiceBox.setValue(ShapeType.CIRCLE);
    }
    public void canvasClicked(MouseEvent mouseEvent) {

        Shape shape = Shape.createShape(choiceBox.getValue(),mouseEvent.getX(), mouseEvent.getY());
        System.out.println(shape);
    }
}
