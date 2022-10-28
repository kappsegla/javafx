package se.iths.tt.javafxtt.factory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import se.iths.tt.javafxtt.HelloApplication;
import se.iths.tt.javafxtt.controller.ProductCellViewController;
import se.iths.tt.javafxtt.controller.ProductViewController;
import se.iths.tt.javafxtt.inventory.Product;

import java.io.IOException;

public class ProductCell extends ListCell<Product> {

    Parent root;
    ProductCellViewController controller;

    public ProductCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(ProductCell.class.getResource("product-cell-view.fxml"));
        try {
            root = fxmlLoader.load();
            controller = fxmlLoader.getController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if( empty || item == null ){
            setGraphic(null);
        }
        else
        {
            controller.setProduct(item);
            setGraphic(root);
        }
    }
}
