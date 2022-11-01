package se.iths.tt.javafxtt.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.tt.javafxtt.Model;
import se.iths.tt.javafxtt.Shape;
import se.iths.tt.javafxtt.ShapeType;

public class CanvasViewController {
    public Canvas canvas;
    public ChoiceBox<ShapeType> choiceBox;

    Model model = new Model();
    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());

    public void initialize() {
        choiceBox.setItems(shapeTypesList);
        choiceBox.valueProperty().bindBidirectional(model.currentShapeTypeProperty());
        model.getShapes().addListener(this::listChanged);
//        canvas.getScene().addEventFilter(KeyEvent.KEY_PRESSED,
//                new EventHandler<KeyEvent>() {
//                    final KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z,
//                            KeyCombination.CONTROL_DOWN);
//                    final KeyCombination ctrlShiftZ = new KeyCodeCombination(KeyCode.Z,
//                            KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);
//
//                    public void handle(KeyEvent ke) {
//                        if (ctrlZ.match(ke)) {
//                            //Undo
//                            System.out.println("Undo");
//                            ke.consume(); // <-- stops passing the event to next node
//                        } else if (ctrlShiftZ.match(ke)) {
//                            //Redo
//                            System.out.println("Redo");
//                            ke.consume();
//                        }
//                    }
//                });
    }

    private void listChanged(Observable observable) {
        var context = canvas.getGraphicsContext2D();
        for (Shape s : model.getShapes()) {
            s.draw(context);
        }
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        if( mouseEvent.isControlDown()){
            model.getShapes().stream().reduce((first,second)-> second).ifPresent(shape -> shape.setColor(Color.RED));
            return;
        }

        //Create shape
        Shape shape = Shape.createShape(model.getCurrentShapeType(), mouseEvent.getX(), mouseEvent.getY());
        //Add shape to models list of shapes
        model.addShape(shape);

        //Render all shapes
//        var context = canvas.getGraphicsContext2D();
//        for (Shape s: model.getShapes()) {
//            s.draw(context);
//        }
    }


}
